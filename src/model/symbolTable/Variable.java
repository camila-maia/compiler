package model.symbolTable;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.04.2013
 */
public class Variable extends Identifier{

	private int level;
	private int shift; 
	
	private PrimitiveTypes type;
	private int length;
	private PrimitiveTypes elementsType;
	
	private VariablesCategories subCategory;
	

	public Variable(String name, int level, int shift) {
		super(name);
		this.level = level;
		this.shift = shift;	
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public PrimitiveTypes getType() {
		return type;
	}

	public void setType(PrimitiveTypes type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public PrimitiveTypes getElementsType() {
		return elementsType;
	}

	public void setElementsType(PrimitiveTypes elementsType) {
		this.elementsType = elementsType;
	}

	public VariablesCategories getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(VariablesCategories subCategory) {
		this.subCategory = subCategory;
	}

	
	
	
}
