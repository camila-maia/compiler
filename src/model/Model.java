package model;

import java.io.File;
import java.io.IOException;

import control.Controller;


/**
 * @author Camila Maia
 * @date 06.23.2013
 */
public class Model {

	private Controller controller;
	private FileManager fileManager; 

	public Model(Controller controller){
		this.controller = controller;
		this.fileManager = new FileManager();
	}
	
	public void saveFile(File file, String[] text) throws IOException {
		this.fileManager.saveFile(file, text);
	}

}
