package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * O identificador do programa não poderá ter nenhum outro uso.
 */
public class Rule1 {
	
	@Test
	public void verifyWithNoRepeatedProgramId(){
		String program = "programa exemplo; inteiro n = 10;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	@Test
	public void verifySameIdInTheSameContext(){
		String program = "programa exemplo; inteiro n = 10; inteiro exemplo = 10;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	
	@Test
	public void verifySameIdInDiferentsContexts(){
		String program = "programa exemplo; inteiro n = 10; metodo meumetodo;"+
					"inteiro exemplo = 10;" +"{};{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	@Test
	public void test3(){
		String program = "programa nome; {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
}
