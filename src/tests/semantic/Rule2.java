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
}
