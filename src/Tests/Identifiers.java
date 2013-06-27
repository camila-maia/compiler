package Tests;

import static org.junit.Assert.*;
import model.analyzers.LexicalAnalyzer;
import model.analyzers.Token;

import org.junit.Test;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.27.2013
 */
public class Identifiers {

	@Test
	public void verifyBeginWithArroba(){
		String identifier = "@@";
		boolean ok = false;
		try{
			LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(identifier);
			Token t = null;
			while ( (t = lexicalAnalyzer.nextToken()) != null )
			{
				t.getLexeme();
			}
			ok = true;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		assertTrue (ok);
	}
}
