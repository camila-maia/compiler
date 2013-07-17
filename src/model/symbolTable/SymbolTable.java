package model.symbolTable;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import model.analyzers.SemanticError;
import model.utils.ControlVariables;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class SymbolTable {

	private int currentLevel;
	private int shift;	
	private HashMap<String, Identifier> rows;

	public SymbolTable(){
		ControlVariables.cleanAll();
		this.currentLevel = 0;
		this.shift = 0;
		this.rows = new HashMap<String, Identifier>();
	}

	public int getCurrentPosition(){
		return this.rows.size();
	}
	
	public Identifier getIdentifier(String name, int nivel){
		String key = name + "" + nivel;
		return this.rows.get(key);
	}
	
	public void addIdentifier(Identifier id) throws SemanticError {
		if(id.getName().equals(ControlVariables.programName))
			throw new SemanticError("Não é permitido usar um identificador igual ao do programa");
		else{
			if(id instanceof Program)
				ControlVariables.programName = id.getName();
			String key = id.getName()+""+this.currentLevel;
			if(!this.isThereSameKey(key))
				this.rows.put(key, id);
			else{
				throw new SemanticError("Identificador já declarado");
			}
		}
	}
	
	public void updateIdentifier(Identifier identifier, Identifier newIdentifier){
		String key = identifier.getName() + identifier.getLevel();
		this.rows.put(key, newIdentifier);
	}

	private boolean isThereSameKey(String key){
		return this.rows.containsKey(key);
	}
	
	
	
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public HashMap<String, Identifier> getRows() {
		return rows;
	}

	public void setRows(HashMap<String, Identifier> rows) {
		this.rows = rows;
	}
	
	public boolean wasDeclaredPreviowsLevel(String nome, int actualLevel){
		for(int i = 0; i <= actualLevel; i++ ){
			if(this.rows.containsKey(nome + "" + actualLevel))
				return true;
		}
		return false;
	}
	
	public Identifier getIdentifierPreviouslyDeclared(String nome, int actualLevel){
		for(int i = actualLevel; i >= 0; i--){
			if(this.rows.containsKey(nome + i))
				return this.rows.get(nome + i);
		}
		return null;
	}
	
	public void print(){
		System.out.println("TB : tamanho(posAtual)= " + this.rows.size());
		System.out.println("TB : currentLevel= " + this.currentLevel);
		System.out.println("TB : shift= " + this.shift);
		rows.toString();
	}
	
	public void removeElementsFromLevel(int level){
		ArrayList<String> keysToRemove = new ArrayList<String>(); 
		for(Identifier id : this.rows.values()){
			keysToRemove.add(id.getName()+""+level);
		}
		for(String key : keysToRemove){
			this.rows.remove(key);
		}
	}
}
