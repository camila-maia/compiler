package model.symbolTable;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.07.2013
 */
public class Parameter extends Identifier{

	private int shift;
	private String passingMechanism;
	private PrimitiveTypes type;

	public Parameter(String name, int level, int shift, 
			String passingMechanism, PrimitiveTypes type) {
		super(name);

		this.setLevel(level);
		this.shift = shift;
		this.passingMechanism = passingMechanism;
		this.type = type;
		
	}
	

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public String getPassingMechanism() {
		return passingMechanism;
	}

	public void setPassingMechanism(String passingMechanism) {
		this.passingMechanism = passingMechanism;
	}

	public PrimitiveTypes getType() {
		return type;
	}

	public void setType(PrimitiveTypes type) {
		this.type = type;
	}
	
	
	
	

}
