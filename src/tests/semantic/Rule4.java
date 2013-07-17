package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * Os identificadores só terão validade no escopo (nível) onde foram
 * declarados e nos escopos (níveis) internos a ele
 */
public class Rule4 {
	
	
//	/**
//	 * Declaração e utilização da variável no mesmo nível
//	 */
//	@Test
//	public void test1(){
//		String program = "programa exemplo; inteiro n; {n := 3;}.";
//		boolean ok = SemanticValidator.semanticValidator(program);
//		assertTrue (ok);
//	}
	
	/**
	 * Declaração de variável em nível 'n' e utilização em nível 'n+1'
	 */
	@Test
	public void test2(){
		String program = "programa exemplo; inteiro n; metodo meumetodo;"+
				 "{n := 5;};{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok); 
	}
	
	/**
	 * Declaração de variável em nível 'n-1' e utilização em nível 'n'
	 */
//	@Test
//	public void test3(){
//		String program = "programa exemplo; metodo meumetodo;"+
//				 "inteiro n; {};{n := 5;}.";
//		boolean ok = SemanticValidator.semanticValidator(program);
//		assertFalse (ok); 
//	}
}
