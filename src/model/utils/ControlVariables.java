package model.utils;
import java.util.Stack;

import model.symbolTable.VariablesCategories;

public class ControlVariables {

	public static String contextoLID;
	public static String tipoAtual;
	public static String tipoConst;
	public static Object valConst;
	public static VariablesCategories subCategoria;
	public static String categoriaAtual;
	public static String programName;
	
	public static String valorAtual;
	public static int deslocamento;
	public static String mppAtual;
	public static int posicaoDoID;
	public static int nivelID;
	public static String tipoExpr;
	public static String tipoLadoEsquerdo;
	public static String tipoFator;
	public static String tipoExpressao;
	public static String tipoTermo;
	public static String tipoExpressaoSimples;
	public static String operadorAtual;
	public static int nDimensoes;
	public static int dimensao1;
	public static int dimensao2;
	public static String tipoElementoAtual;
	public static boolean operadorUnario;
	public static String tipoVarEXPR;
	public static Stack contextoExpressao;
	public static Stack npf;
	public static Stack numeroIndice;
	public static Stack posicaoIDIndex;
	public static Stack nivelIDIndex;
	public static Stack metodoAtual;
	
	public static void cleanAll(){
		contextoLID = null;
		tipoAtual= null;
		tipoConst= null;
		valConst= null;
		subCategoria= null;
		categoriaAtual= null;
		programName= null;
	}
	
	public static void printAttributes(){
		System.out.println("contextoLID = "+contextoLID);
		System.out.println("tipoAtual = " + tipoAtual);
		System.out.println("tipoConst = " + tipoConst);
		System.out.println("valConst = "+ valConst);
		System.out.println("subCategoria = "+subCategoria);
		System.out.println("categoriaAtual = "+ categoriaAtual);
		System.out.println("programName = "+programName);
	}
	
}
