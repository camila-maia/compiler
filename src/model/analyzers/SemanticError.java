package model.analyzers;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class SemanticError extends AnalysisError
{
    public SemanticError(String msg, int position)
	 {
        super(msg, position);
    }

    public SemanticError(String msg)
    {
        super(msg);
    }
}
