package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import model.analyzers.LexicalError;
import model.analyzers.SemanticError;
import model.analyzers.SyntaticError;
import view.View;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class Controller {
	
	private View view;
	private Model model;
	
	public Controller(){
		this.view = new View(this);
		this.model = new Model(this);		
	}
	
	public void initSystem(){
		this.view.createAndOpenMainWindow();
	}

	public void saveFile(File file, String[] text) throws IOException {
		this.model.saveFile(file, text);
		
	}

	public String openFile(File file) throws FileNotFoundException {
		return this.model.openFile(file);		
	}

	public void lexicalAnalysis(String text) throws LexicalError{
		this.model.lexicalAnalysis(text);
		
	}

	public void syntacticAnalysis(String text) throws LexicalError, SyntaticError, SemanticError{
		this.model.syntacticAnalysis(text);
		
	}
	
}
