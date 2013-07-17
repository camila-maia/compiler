package model.symbolTable;

import java.util.ArrayList;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.07.2013
 */
public class Methood extends Identifier{

	//Falta completar atributos!!!
	private ArrayList<Parameter> parameters;
	private IdType resultType;
	private int npf;
	
	public IdType getResultType() {
		return resultType;
	}

	public void setResultType(IdType resultType) {
		this.resultType = resultType;
	}

	public Methood(String name, int level) {
		super(name, level);		
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}

	public int getNpf() {
		return npf;
	}

	public void setNpf(int npf) {
		this.npf = npf;
	}
}
