package tests.lexical;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class LineComments {

	@Test
	public void verifyStartWithHashTag(){
		String comment = "#comment";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyCommentWithInvalidCharacters(){
		String comment = "#c@@o$mm__ent";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyBreakLine(){
		String comment = "#comment\n??";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertFalse (ok);
	}
}
