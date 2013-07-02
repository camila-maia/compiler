package model.analyzers;
/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class LexicalError extends AnalysisError
{
    public LexicalError(String msg, int position)
	 {
        super(msg, position);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
}
