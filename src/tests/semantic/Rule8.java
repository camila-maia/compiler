package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;
public class Rule8 { //TODO
	
	/**
	 * @author Camila Maia and Maicon Lima
	 * @date 07.11.2013
	 * 
	 * Identificadores devem ser usados de acordo com a categoria na qual foram declarados, ex.:
	 * id de variável só pode ser usado em contextos que aceitem variáveis,
	 * Id de constante não pode ser usado no lado esquerdo de uma atribuição nem em comandos de leitura
	 * Id de método sem tipo só pode ser usado em contextos que aceitem comandos 
	 * Id de método com tipo só pode ser usado em contextos que aceitem uma expressão	 
	 */
	
	/**
	 * 
	 */
	@Test
	public void test1(){
		String program = "";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	/**
	 * 
	 */
	@Test
	public void test2(){
		String program = "";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	/**
	 * 
	 */
	@Test
	public void test3(){
		String program = "";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}

}
