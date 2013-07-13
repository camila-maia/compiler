package model.symbolTable;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.06.2013
 */
public class Constant extends Identifier {

	private PrimitiveTypes type;
	private Object value;
	
	public Constant(String name, int level, PrimitiveTypes type, Object value) {
		super(name);
		this.setLevel(level);
		this.type = type;
		this.value = value;	
		
	}

	public PrimitiveTypes getType() {
		return type;
	}

	public void setType(PrimitiveTypes type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}	
}
