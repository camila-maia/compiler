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
	
	private boolean isSimpleVariable;
	private boolean isString;
	private boolean isVector;
	
	//Simple Variable
	public Variable(String name, int level, int shift, PrimitiveTypes type) {
		super(name);
		this.level = level;
		this.shift = shift;
		this.type = type;
		this.isSimpleVariable = true;
	}
	
	//String
	public Variable(String name, int level, int shift, int length) {
		super(name);
		this.level = level;
		this.shift = shift;
		this.length = length;
		this.isString = true;
	}

	//Vector
	public Variable(String name, int level, int shift, int length, PrimitiveTypes elementsType) {
		super(name);
		this.level = level;
		this.shift = shift;
		this.length = length;
		this.isVector = true;
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

	public boolean isSimpleVariable() {
		return isSimpleVariable;
	}

	public void setSimpleVariable(boolean isSimpleVariable) {
		this.isSimpleVariable = isSimpleVariable;
	}

	public boolean isString() {
		return isString;
	}

	public void setString(boolean isString) {
		this.isString = isString;
	}

	public boolean isVector() {
		return isVector;
	}

	public void setVector(boolean isVector) {
		this.isVector = isVector;
	}
	
	
	
}
