
package model.analyzers;

import java.lang.reflect.Method;

import model.symbolTable.Program;
import model.symbolTable.SymbolTable;
public class SemanticAnalyzer implements Constants
{
	
	 private Token token;
     private SymbolTable symbolTable = new SymbolTable();
//    private Registro registro;
//    private ArrayList<Identificador> listaPar;
	
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
    	
        System.out.println("Ação #"+action+", Token: "+token);
        
        this.token = token;
        try {
            Method method = this.getClass().getMethod("action_" + 101, (Class[]) null);  // Reflexão para pegar método da ação que está sendo referenciada
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
    
    
    /**
     * Inicializa com zero nível atual (NA) e  deslocamento 
     * Insere id na TS juntamente com seus atributos,
     * categoria (id-programa) e nível ( NA ) 
     */
    
    public void action_101() throws SemanticError {
    	Program program = new Program(this.token.getLexeme());
    	this.symbolTable.addIdentifier(program);
    }

}
