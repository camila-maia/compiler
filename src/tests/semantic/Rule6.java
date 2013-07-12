package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * Vetores e cadeias não podem ter valor inicial
 */
public class Rule6 {
	
	/**
	 * TODO 
	 * verificar também para o tipo vetor
	 */
	
	
	/**
	 * Apenas declara uma variavel do tipo cadeia e não atribui valor a ela
	 */
	@Test
	public void test1(){
		String program = "programa exemplo; cadeia [ 30 ] nome; {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	/**
	 * Apenas declara uma variavel do tipo cadeia e atribui um valor a ela
	 */
	@Test
	public void test2(){
		String program = "programa exemplo; cadeia [ 30 ] nome = 'meu nome'; {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}

}
