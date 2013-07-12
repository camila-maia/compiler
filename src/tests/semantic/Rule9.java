package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

public class Rule9 {
	/**
	 * Variáveis do tipo Vetor só podem ser usados de forma indexada e o índice deve ser uma expressão inteira;
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

}
