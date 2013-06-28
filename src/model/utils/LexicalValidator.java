package model.utils;

import model.analyzers.LexicalAnalyzer;
import model.analyzers.Token;

/**
 * @author Camila Maia and Maicon
 * @date 06.27.2013
 */
public class LexicalValidator {

	public static boolean lexicallyCorrect(String text){
		try{
			LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(text);
			Token t = null;
			while ( (t = lexicalAnalyzer.nextToken()) != null )
			{
				t.getLexeme();
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}	
}
