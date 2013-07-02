package model.analyzers;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class SemanticAnalyzer implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
    }	
}
