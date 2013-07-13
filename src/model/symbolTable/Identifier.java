package model.symbolTable;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class Identifier {
	
	private String name;
	private int rowInSymbolTable;
	private int level;

	public Identifier(String name){
		this.name = name;
	}

	public Identifier(String name, int rowInSymbolTable, int level){
		this.name = name;
		this.rowInSymbolTable = rowInSymbolTable;
		this.level = level;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRowInSymbolTable() {
		return rowInSymbolTable;
	}


	public void setRowInSymbolTable(int rowInSymbolTable) {
		this.rowInSymbolTable = rowInSymbolTable;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
