
package model.analyzers;

import java.lang.reflect.Method;
public class SemanticAnalyzer implements Constants
{
	
	 private Token token;
//    private TblSimbolos tbl;
//    private Registro registro;
//    private ArrayList<Identificador> listaPar;
	
	
    public void executeAction(int action, Token token)	throws SemanticError
    {
    	
        System.out.println("Ação #"+action+", Token: "+token);
        
        //Codigo abaixo copiado de outro compilador
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
    
    public void action_101() throws SemanticError {
    	System.out.println("Passou por aqui");
    }

}
