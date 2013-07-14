package model.symbolTable;

import javax.lang.model.util.Types;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.06.2013
 */
public class Constant extends Identifier {

	private IdType type;
	private Object value;
	
	public Constant(String name, int level, IdType type, Object value) {
		super(name);
		this.setLevel(level);
		this.type = type;
		this.value = value;	
		
	}

	public IdType getType() {
		return type;
	}

	public void setType(IdType type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}	
}
