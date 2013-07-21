package model.utils;
import java.util.ArrayList;
import java.util.Stack;

import model.symbolTable.IdType;
import model.symbolTable.Identifier;
import model.symbolTable.Methood;
import model.symbolTable.Parameter;

public class ControlVariables {

	//decl, par-formal, leitura, 
	public static String contextoLID;
	public static IdType tipoAtual;  
	public static IdType tipoVar;  
	public static IdType tipoConst;
	public static Object valConst;
	public static IdType subCategoria;
	//constante, variavel, 
	public static String categoriaAtual;  
	public static String programName;
	//valores inteiros
	public static int primeiraPosicaoListaAux;
	public static int ultimaPosicaoListaAux;
	//lista de chaves
	public static ArrayList<Identifier> LID;
	public static IdType tipoLadoEsquerdo;
	public static IdType tipoFator;
	public static IdType tipoTermo;
	public static IdType tipoExpSimples;
	public static IdType tipoExpr;
	public static Stack<Integer> npf = new Stack<Integer>();
	public static Stack<Methood> methods = new Stack<Methood>();
	//valor,referencia
	public static String mpp;
    public static ArrayList<Parameter> parametersList;
    public static IdType tipoVarIndexada;
    public static int numElementos;
    public static Identifier currentIdentifier;
    public static Stack<String> operadores = new Stack<String>();
    public static Stack<Boolean> operadorUnario = new Stack<>();
    public static Stack<Boolean> operadorNega = new Stack<>();
	
	
//	public static String valorAtual;
//	public static int deslocamento;
//	public static int posicaoDoID;
//	public static int nivelID;
//	public static String tipoExpressao;
//	public static int nDimensoes;
//	public static int dimensao1;
//	public static int dimensao2;
//	public static String tipoElementoAtual;
//	public static String tipoVarEXPR;
//	public static Stack contextoExpressao;
//	public static Stack numeroIndice;
//	public static Stack posicaoIDIndex;
//	public static Stack nivelIDIndex;
//	public static Stack metodoAtual;
	
	public static void cleanAll(){
		contextoLID = null;
		tipoAtual = null;
		tipoVar = null;
		tipoConst = null;
		valConst = null;
		subCategoria = null;
		categoriaAtual = null;
		programName = null;
		primeiraPosicaoListaAux = 0;
		ultimaPosicaoListaAux = 0;
		LID = null;
		tipoLadoEsquerdo = null;
		tipoFator = null;
		tipoTermo = null;
		tipoExpSimples = null;
		tipoExpr = null;
		npf = new Stack<Integer>();
		methods = new Stack<Methood>();
		mpp = null;
	    parametersList = null;
	    tipoVarIndexada = null;
	    numElementos = 0;
	    currentIdentifier = null;
	    operadores = new Stack<String>();
	    operadorUnario = new Stack<>();
	    operadorNega = new Stack<>();
	}
	
	
	
	public static void printAttributes(){
		System.out.println("contextoLID = "+contextoLID);
		System.out.println("tipoAtual = " + tipoAtual);
		System.out.println("tipoConst = " + tipoConst);
		System.out.println("valConst = "+ valConst);
		System.out.println("subCategoria = "+subCategoria);
		System.out.println("categoriaAtual = "+ categoriaAtual);
		System.out.println("programName = "+programName);
		System.out.println("Primeira Pos Lista = "+ primeiraPosicaoListaAux);
		System.out.println("Ultima Pos Lista = "+ultimaPosicaoListaAux);
	}
	
	public static Methood getCurrentMethod(){
		return methods.peek();
	}
	
	public static String getCurrentOperator(){
		return operadores.peek();
	}
}
