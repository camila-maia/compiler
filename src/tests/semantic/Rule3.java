package tests.semantic;

import static org.junit.Assert.*;
import model.utils.LexicalValidator;
import model.utils.SemanticValidator;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 07.11.2013
 * 
 * Identificadores não podem ser declarados mais de uma vez no mesmo
 * nível (independentemente de sua categoria).
 */
public class Rule3 {
	
	@Test
	public void verifyNoRepeatedIdentifiers(){
		String program = "programa exemplo; inteiro n = 10;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	@Test
	public void verifyRepeatedIdentifiersSameCategory(){
		String program = "programa exemplo; inteiro n = 10; inteiro n = 5;{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}

	@Test
	public void verifyRepeatedIdentifiersDiferentCategory(){
		String program = "programa exemplo; inteiro n = 10; caracter n; {}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertFalse (ok);
	}
	
	@Test
	/*
	 * Quando implementarmos o incremento de níveis na troca de contexto, este
	 * teste deve funfar.
	 */
	public void verifyRepeatedIdentifiersInDiferentContexts(){
		String program = "programa exemplo; inteiro n = 10; metodo meumetodo;"+
				"inteiro n = 5;" +"{};{}.";
		boolean ok = SemanticValidator.semanticValidator(program);
		assertTrue (ok);
	}
	
	
	
}
