package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.analyzers.LexicalError;
import model.analyzers.SemanticError;
import model.analyzers.SyntaticError;

import control.Controller;

/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class View {

	private Controller controller;
	private MainWindow mainWindow;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	public void createAndOpenMainWindow(){
		this.mainWindow = new MainWindow(this);
		this.mainWindow.setVisible(true);
	}
	
	public void saveFile(File file, String[] text) throws IOException{
		this.controller.saveFile(file, text);
	}

	public String openFile(File file) throws FileNotFoundException {
		return this.controller.openFile(file);		
	}

	public void lexicalAnalysis(String text) throws LexicalError {
		this.controller.lexicalAnalysis(text);
		
	}

	public void syntacticAnalysis(String text) throws LexicalError, SyntaticError, SemanticError {
		this.controller.syntacticAnalysis(text);
	}
	
}
