package model.symbolTable;

import java.util.HashMap;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class SymbolTable {
	
	private int currentLevel;
	private int shift;	
	private  HashMap<String, Identifier> rows;

	public SymbolTable(){
		this.currentLevel = 0;
		this.shift = 0;
		this.rows = new HashMap<String, Identifier>();
	}
	
	public void addIdentifier(Identifier id){
		this.rows.put(id.getName()+""+this.currentLevel, id);
	}
	
	
}
