package model.symbolTable;

import java.util.HashMap;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class SymbolTable {

	private int currentLevel;
	private int shift;	
	private int initialPosition;
	private int endPosition;
	private HashMap<String, Identifier> rows;

	public SymbolTable(){
		this.currentLevel = 0;
		this.shift = 0;
		this.initialPosition = 0;
		this.endPosition = 0;
		this.rows = new HashMap<String, Identifier>();
	}

	public void addIdentifier(Identifier id){
		this.rows.put(id.getName()+""+this.currentLevel, id);
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

	public int getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(int initialPosition) {
		this.initialPosition = initialPosition;
	}

	public int getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}

	public HashMap<String, Identifier> getRows() {
		return rows;
	}

	public void setRows(HashMap<String, Identifier> rows) {
		this.rows = rows;
	}
}
