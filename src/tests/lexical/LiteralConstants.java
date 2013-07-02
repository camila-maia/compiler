package tests.lexical;

import static org.junit.Assert.*;


import model.utils.LexicalValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class LiteralConstants {

	@Test
	public void verifyStartAndFinishWithSingleQuotes(){
		String literalConstant = "'word'";
		boolean ok = LexicalValidator.lexicallyCorrect(literalConstant);
		assertTrue (ok);
	}
	
	@Test
	public void verifyThreeSingleQuotes(){
		String literalConstant = "'wo'rd'";
		boolean ok = LexicalValidator.lexicallyCorrect(literalConstant);
		assertFalse (ok);
	}
	
	@Test
	public void verifyNotClosedWithSingleQuotes(){
		String literalConstant = "'word";
		boolean ok = LexicalValidator.lexicallyCorrect(literalConstant);
		assertFalse (ok);
	}
	
	@Test
	public void verifyWithInvalidCharacteres(){
		String literalConstant = "'?@@@#$%#%'";
		boolean ok = LexicalValidator.lexicallyCorrect(literalConstant);
		assertTrue (ok);
	}
	
	@Test
	public void verifyWithBreakLine(){
		String literalConstant = "'constant \n literal'";
		boolean ok = LexicalValidator.lexicallyCorrect(literalConstant);
		assertTrue (ok);
	}

}
