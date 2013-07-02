package tests.lexical;

import static org.junit.Assert.*;
import model.analyzers.LexicalAnalyzer;
import model.analyzers.Token;
import model.utils.LexicalValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class Identifiers {

	@Test
	public void verifyBeginWithArroba(){
		String identifier = "@id";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertTrue (ok);
	}
	
	@Test
	public void verifyBeginWithLetter(){
		String identifier = "id";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertTrue (ok);
	}
	
	@Test
	public void verifyNotBeginWithArrobaOrLetter(){
		String identifier = "?id";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}	
	
	@Test
	public void verifyNotEndWithArrobaOrUnderline(){
		String identifier = "id";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertTrue (ok);
	}
	
	@Test
	public void verifyEndWithUnderline(){
		String identifier = "id_";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
	
	@Test
	public void verifyEndWithArroba(){
		String identifier = "id@";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
	
	@Test
	public void verifyTwoUnderlinesFollowed(){
		String identifier = "i__d";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
	
	@Test
	public void verifyTwoArrobasFollowed(){
		String identifier = "i@@d";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
	
	@Test
	public void verifyArrobaUnderlineFollowed(){
		String identifier = "i@_d";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
	
	@Test
	public void verifyUnderlineArrobaFollowed(){
		String identifier = "i_@d";
		boolean ok = LexicalValidator.lexicallyCorrect(identifier);
		assertFalse (ok);
	}
}
