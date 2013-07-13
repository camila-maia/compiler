package model.symbolTable;

import java.util.ArrayList;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.07.2013
 */
public class Method extends Identifier{

	//Falta completar atributos!!!
	private ArrayList<Parameter> parameters;
	
	public Method(String name, int level, ArrayList<Parameter> parameters) {
		super(name);
		this.setLevel(level);
		this.parameters = parameters;
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}		
}
