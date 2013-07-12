
package model.analyzers;

import java.lang.reflect.Method;
import java.util.ArrayList;

import model.symbolTable.Identifier;
import model.symbolTable.Program;
import model.symbolTable.SymbolTable;
import model.symbolTable.VariablesCategories;
import model.utils.ControlVariables;

public class SemanticAnalyzer implements Constants {

	private ArrayList<Integer> implementedActions = new ArrayList<Integer>();
	private Token token;
	private SymbolTable symbolTable;

	public SemanticAnalyzer(){		
		this.implementedActions.add(101);
		this.implementedActions.add(102);
		this.implementedActions.add(103);		
		//this.implementedActions.add(104);
		this.implementedActions.add(105);
		this.implementedActions.add(109);
		this.implementedActions.add(110);	
		this.implementedActions.add(111);
		this.implementedActions.add(112); // fazer o resto
		this.implementedActions.add(113);
		this.implementedActions.add(174);
		this.implementedActions.add(175);
		this.implementedActions.add(176);
		this.implementedActions.add(177);
		this.implementedActions.add(178);
	}

	public void executeAction(int action, Token token)	throws SemanticError{

		System.out.println("Ação #"+action+", Token: "+token);

		if(implementedActions.contains(action)){
			this.token = token;
			try {
				Method method = this.getClass().getMethod("action_" + action, (Class[]) null);  // Reflexão para pegar método da ação que está sendo referenciada
				method.invoke(this, (Object[]) null); 
			} catch (Exception ex) {
				try {
					SemanticError erro = (SemanticError) ex.getCause();
					throw new SemanticError(erro.getMessage(), token.getPosition());
				} catch (ClassCastException e) {
					e.printStackTrace();
					throw new SemanticError("Erro na acao " + action + ": " + e.getMessage(), token.getPosition());
				}
			}
		}
		else
			System.out.println("Ação não implementada " + action);
	}	


	/**
	 * Inicializa com zero nível atual (NA) e  deslocamento 
	 * Insere id na TS juntamente com seus atributos,
	 * categoria (id-programa) e nível ( NA ) 
	 */    
	public void action_101() throws SemanticError {
		this.symbolTable = new SymbolTable();
		Program program = new Program(this.token.getLexeme());
		this.symbolTable.addIdentifier(program);
		//TODO 
	}

	/**
	 * Seta contextoLID para "decl"  
	 * Guarda pos. na TS do primeiro id da lista
	 */
	public void action_102() throws SemanticError {
		/*
		 * Nossa ts não sequencial e não precisa guardar posições.
		 */	
		ControlVariables.contextoLID = "decl";
	}

	/**
	 * #103 – Guarda pos. na TS do último id da lista
	 */
	public void action_103() throws SemanticError {
		this.token = token;
		/*
		 * Nossa ts não sequencial e não precisa guardar posições.
		 */
	}

	/**
	 * #104 – Atualiza atributos dos id de <lid> de acordo 
		 com a CategoriaAtual e com a SubCategoria. 
		 Para cálculo do Deslocamento de variáveis, 
		 considere que toda variável ocupa 1 célula de 
		 memória (exceto vetor que ocupa 1 célula para 
		 cada elemento) 
	 */
	public void action_104() throws SemanticError {
		this.token = this.token;
	}

	public void action_105() throws SemanticError {
		ControlVariables.tipoAtual = "inteiro";
	}

	public void action_106() throws SemanticError {
		ControlVariables.tipoAtual = "real";
	}

	public void action_107() throws SemanticError {
		ControlVariables.tipoAtual = "booleano";
	}

	public void action_108() throws SemanticError {
		ControlVariables.tipoAtual = "caracter";
	}

	/**
	 *109 – Se TipoConst <> “inteiro” 
	 então ERRO(“esperava-se uma const. inteira”) 
	 senão se ValConst > 256 
	 então ERRO(“cadeia > que o permitido”) 
	 senão TipoAtual := “cadeia” 
	 */
	public void action_109() throws SemanticError {
		int a = Integer.valueOf((String) ControlVariables.valConst);
		
		if (!ControlVariables.tipoConst.equals("inteiro"))
			throw new SemanticError("esperava-se uma const. inteira");
		else if( a > 256)
			throw new SemanticError("cadeia > que o permitido");
		else
			ControlVariables.tipoAtual = "cadeia";			
	}

	/**
	 * #110 – Se TipoAtual = “cadeia” 
	 * Então ERRO(“Vetor do tipo cadeia não é 
	 * permitido”) Senão SubCategoria := “vetor” 
	 */
	public void action_110() throws SemanticError {
		if(ControlVariables.tipoAtual.equals("cadeia"))
			throw new SemanticError("Vetor do tipo cadeia não é permitido");
		else{
			ControlVariables.subCategoria = VariablesCategories.VECTOR;
		}
	}

	/**
	 * #111 – Se TipoAtual = “cadeia” 
	 *  Então SubCategoria := “cadeia” 
	 *  Senão SubCategoria := “pré-definido” 
	 */
	public void action_111() throws SemanticError {
		if(ControlVariables.tipoAtual.equals("cadeia"))
			ControlVariables.subCategoria = VariablesCategories.STRING;
		else{
			ControlVariables.subCategoria = VariablesCategories.PRIMITIVES;
		}
	}

	public void action_112() throws SemanticError {
		if(ControlVariables.contextoLID.equals("decl")){
			Identifier identifier = new Identifier(this.token.getLexeme());
			this.symbolTable.addIdentifier(identifier);
		}
		//TODO
	}

	/**	Se SubCategoria = “cadeia” ou “vetor” 
	Então ERRO (“Apenas id de tipo pré-def podem 
	ser declarados como constante”) 
	senão CategoriaAtual := “constante”
	 */
	public void action_113() throws SemanticError {
		if(ControlVariables.subCategoria == VariablesCategories.VECTOR
				|| ControlVariables.subCategoria == VariablesCategories.STRING){
			throw new SemanticError("Apenas id de tipo pré-def podem ser declarados como constante");
		}
		else
			ControlVariables.categoriaAtual = "constante";

	}

	public void action_174() throws SemanticError {
		ControlVariables.tipoConst = "inteiro";
		ControlVariables.valConst = this.token.getLexeme();
	}

	public void action_175() throws SemanticError {
		ControlVariables.tipoConst = "real";
		ControlVariables.valConst = this.token.getLexeme();
	}

	public void action_176() throws SemanticError {
		ControlVariables.tipoConst = "falso";
		ControlVariables.valConst = this.token.getLexeme();
	}

	public void action_177() throws SemanticError {
		ControlVariables.tipoConst = "verdadeiro";
		ControlVariables.valConst = this.token.getLexeme();
	}

	public void action_178() throws SemanticError {
		ControlVariables.tipoConst = "literal";
		ControlVariables.valConst = this.token.getLexeme();
	}


}
