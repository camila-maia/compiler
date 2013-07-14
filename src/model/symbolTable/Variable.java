package model.symbolTable;

import javax.lang.model.util.Types;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class Variable extends Identifier{

	private int shift;	
	private IdType type;
	private int length;
	private IdType vectorType;

	public Variable(String name, int level) {
		super(name);
		this.setLevel(level);
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public IdType getType() {
		return type;
	}

	public void setType(IdType type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public IdType getVectorType() {
		return vectorType;
	}

	public void setVectorType(IdType vectorType) {
		this.vectorType = vectorType;
	}

	
	
	
}
