package model.symbolTable;

import java.util.ArrayList;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.07.2013
 */
public class Method extends Identifier{

	//Falta completar atributos!!!
	private int level;
	private ArrayList<Parameter> parameters;
	
	public Method(String name, int level, ArrayList<Parameter> parameters) {
		super(name);
		this.level = level;
		this.parameters = parameters;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}		
}
