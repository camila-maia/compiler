package tests.lexical;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import model.utils.LexicalValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class Integers {

	@Test
	public void verifyIntegerWithoutExponential(){
		String integer = "355";
		boolean ok = LexicalValidator.lexicallyCorrect(integer);
		assertTrue (ok);
	}

	@Test
	public void verifyIntegerWithExponentialWithPlus(){
		String integer = "355e+10";
		boolean ok = LexicalValidator.lexicallyCorrect(integer);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerWithExponentialWithMinus(){
		String integer = "355e-10";
		boolean ok = LexicalValidator.lexicallyCorrect(integer);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerWithExponentialWithoutSignal(){
		String integer = "355e10";
		boolean ok = LexicalValidator.lexicallyCorrect(integer);
		assertTrue (ok);
	}
	
}
