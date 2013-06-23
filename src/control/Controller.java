package control;

import java.io.File;
import java.io.IOException;

import model.Model;
import view.View;

/**
 * @author Camila Maia
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
	
}
