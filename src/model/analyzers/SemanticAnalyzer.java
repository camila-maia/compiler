
package model.analyzers;

import java.lang.reflect.Method;
import java.util.ArrayList;

import model.symbolTable.Program;
import model.symbolTable.SymbolTable;
import model.utils.ControlVariables;

public class SemanticAnalyzer implements Constants {

	private ArrayList<Integer> implementedActions = new ArrayList<Integer>();
	private Token token;
	private SymbolTable symbolTable;	

	public SemanticAnalyzer(){		
		this.implementedActions.add(101);
		this.implementedActions.add(102);
		this.implementedActions.add(103);
		this.implementedActions.add(104);
	}

	public void executeAction(int action, Token token)	throws SemanticError{

		//        System.out.println("Ação #"+action+", Token: "+token);

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
	}

	/**
	 * Seta contextoLID para "decl"  
	 * Guarda pos. na TS do primeiro id da lista
	 */
	public void action_102() throws SemanticError {
		/*
		 * Nossa ts não sequencial e não precisa guardar posições.
		 */
		this.token = token;
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
}
