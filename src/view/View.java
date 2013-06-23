package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import control.Controller;

/**
 * @author Camila Maia
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
	
}
