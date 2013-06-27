package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.analyzers.*;
import model.utils.FileManager;

import control.Controller;


/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class Model {

	private Controller controller;
	private FileManager fileManager;
	private LexicalAnalyzer lexicalAnalyzer;
	private SyntacticAnalyzer syntaticAnalyzer;
	private SemanticAnalyzer semanticAnalyzer;

	public Model(Controller controller){
		this.controller = controller;
		this.fileManager = new FileManager();
		this.lexicalAnalyzer = new LexicalAnalyzer();
		this.syntaticAnalyzer = new SyntacticAnalyzer();
		this.semanticAnalyzer = new SemanticAnalyzer();

	}

	public void saveFile(File file, String[] text) throws IOException {
		this.fileManager.saveFile(file, text);
	}

	public String openFile(File file) throws FileNotFoundException {
		return this.fileManager.openFile(file);
	}

	public void lexicalAnalysis(String text) throws LexicalError 
	{	
		this.lexicalAnalyzer.setInput(text);
		Token t = null;
		while ( (t = lexicalAnalyzer.nextToken()) != null )
		{
			System.out.println(t.getLexeme());
		}
	}

	public void syntacticAnalysis(String text)  throws LexicalError, SyntaticError, SemanticError{
		this.lexicalAnalyzer.setInput(text);
		this.syntaticAnalyzer.parse(this.lexicalAnalyzer, this.semanticAnalyzer);
	}

}
