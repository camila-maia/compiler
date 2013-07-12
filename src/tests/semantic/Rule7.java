package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * A constante usada na inicialização de um identificador deve ser do mesmo tipo da declaração
 * 
 */

public class Rule7 {
	
	/*
	 * a constante 10 é do mesmo tipo de n, logo deve passar
	 */
	@Test
	public void test1(){
		String program = "programa exemplo; inteiro n = 10 {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	/*
	 * a constante 'asd' é diferente do tipo n, logo não deve passar
	 */
	@Test
	public void test2(){
		String program = "programa exemplo; inteiro n = 'asd' {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	
	/*
	 * a constante 'asd' é diferente do tipo n, logo não deve passar. Declaração em um nivel e atribuição em outro nivel
	 */
	@Test
	public void test3(){
		String program = "programa exemplo; inteiro n; metodo meumetodo;{n:='asd';}; {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}

}
