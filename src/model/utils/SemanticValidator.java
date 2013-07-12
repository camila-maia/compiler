package model.utils;

import model.analyzers.LexicalAnalyzer;
import model.analyzers.SemanticAnalyzer;
import model.analyzers.SyntaticAnalyzer;

public class SemanticValidator {

	public static boolean semanticValidator(String text){
		try{
			LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(text);
			SyntaticAnalyzer syntacticAnalyzer = new SyntaticAnalyzer();
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			syntacticAnalyzer.parse(lexicalAnalyzer, semanticAnalyzer);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
