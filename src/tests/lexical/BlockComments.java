package tests.lexical;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class BlockComments {

	@Test
	public void verifyBarStarCommentStarBar(){
		String comment = "/*comment*/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyCommentNotClosed(){
		String comment = "/*comment";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertFalse (ok);
	}
	
	@Test
	public void verifyWithInvalidCharacters(){
		String comment = "/*as%#$k@@@a???*/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyBreakLine(){
		String comment = "/*comment\n??*/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyCommentWithStars(){
		String comment = "/***********/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyCommentWithBars(){
		String comment = "/*///////*/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
	
	@Test
	public void verifyEmptyComment(){
		String comment = "/**/";
		boolean ok = LexicalValidator.lexicallyCorrect(comment);
		assertTrue (ok);
	}
}
