package tests.lexical;

import static org.junit.Assert.*;

import model.utils.LexicalValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class RealNumbers {

	@Test
	public void verifyIntegerPeriod(){
		String number = "35.";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodInteger(){
		String number = "55.05";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyPeriodInteger(){
		String number = ".1";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodWithExponentialWithPlus(){
		String number = "77.e+10";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodIntegerWithExponentialWithPlus(){
		String number = "56.15e+3";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyPeriodIntegerWithExponentialWithPlus(){
		String number = ".00001e+6";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}

	@Test
	public void verifyIntegerPeriodWithExponentialWithMinus(){
		String number = "5.e-10";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodIntegerWithExponentialWithMinus(){
		String number = "505.05e-3";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyPeriodIntegerWithExponentialWithMinus(){
		String number = ".100e-9";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodWithExponentialWithoutSignal(){
		String number = "35555555.e10";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyIntegerPeriodIntegerWithExponentialWithoutSignal(){
		String number = "27.05e3";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
	@Test
	public void verifyPeriodIntegerWithExponentialWithoutSignal(){
		String number = ".77e5";
		boolean ok = LexicalValidator.lexicallyCorrect(number);
		assertTrue (ok);
	}
	
}
