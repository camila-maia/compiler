package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * Todos os identificadores usados no programa devem ser previamente declarados.
 */
public class Rule2 {

	/**
	 * Identificador já declarado. True.
	 */
	@Test
	public void test1(){
		String program = "programa exemplo; inteiro i;{i := 0;}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	/**
	 * Identificador usado sem estar declarado. False.
	 */
	@Test
	public void test2(){
		String program = "programa exemplo; {i := 0;}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	
	//Declaração errada.
	@Test
	public void test3(){
		String program = "programa exemplo; inteiro n, x = 10;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	
	
	@Test
	public void test4(){
		String program = "programa exemplo; cadeia [5] n, x;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test5(){
		String program = "programa exemplo; cadeia [300] x;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse(ok);
	}
	
	@Test
	public void test6(){
		String program = "programa exemplo; caracter n = 'c';{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test7(){
		String program = "programa exemplo; cadeia [10.5] x;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test8(){
		String program = "programa exemplo; booleano n = verdadeiro;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test9(){
		String program = "programa exemplo; real n = 10.5;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test10(){
		String program = "programa exemplo; cadeia [10] x;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test11(){
		String program = "programa exemplo; real n = 10.5;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}
	
	@Test
	public void test12(){
		String program = "programa exemplo; inteiro [10] n;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue(ok);
	}	
	
	@Test
	public void test13(){
		String program = "programa exemplo; cadeia[10][2] n;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse(ok);
	}
	
	@Test
	public void test14(){
		String program = "programa exemplo; inteiro n = 10;{ leia (n) }.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse(ok);
	}
	
	
	
}
