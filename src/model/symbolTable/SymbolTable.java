package model.symbolTable;

import java.util.HashMap;

import model.analyzers.SemanticError;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class SymbolTable {

	private int currentLevel;
	private int shift;		
	private HashMap<String, Identifier> rows;

	public SymbolTable(){
		this.currentLevel = 0;
		this.shift = 0;
		this.rows = new HashMap<String, Identifier>();
	}

	public void addIdentifier(Identifier id) throws SemanticError {
		String key = id.getName()+""+this.currentLevel;
		if(!this.isThereSameKey(key))
			this.rows.put(key, id);
		else{
			throw new SemanticError("Identificador já declarado");
		}
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
}
