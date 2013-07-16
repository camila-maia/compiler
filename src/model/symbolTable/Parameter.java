package model.symbolTable;


/**
 * @author Camila Maia and Maicon Lima
 * @date 07.07.2013
 */
public class Parameter extends Identifier{

	private int shift;
	private String passingMechanism;
	private IdType type;

	public Parameter(String name, int level, int shift, 
			String passingMechanism, IdType type) {
		super(name);

		this.setLevel(level);
		this.shift = shift;
		this.passingMechanism = passingMechanism;
		this.type = type;
		
	}
	public Parameter(String name, int level) {
		super(name);
		this.setLevel(level);		
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

	public IdType getType() {
		return type;
	}

	public void setType(IdType type) {
		this.type = type;
	}
	
	
	
	

}
