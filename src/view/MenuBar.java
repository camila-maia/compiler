package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * @author Camila Maia
 * @date 06.23.2013
 */
public class MenuBar extends JMenuBar implements ActionListener{

	private MainWindow parentWindow;

	private JMenu fileMenu;
	private JMenu analysisMenu;
	private JMenu codeMenu;
	private JMenu aboutMenu;

	private JMenuItem openProgramMenuItem;
	private JMenuItem saveProgramMenuItem;	

	private JMenuItem lexicalMenuItem;
	private JMenuItem syntacticMenuItem;
	private JMenuItem semanticMenuItem;



	public MenuBar(MainWindow parentWindow){
		super();
		this.parentWindow = parentWindow;

		this.initComponents();
	}


	private void initComponents() {
		this.createAndAddMenus();
		this.createAndAddMenuItems();
		this.addActionsListeners();		
	}

	private void createAndAddMenus() {
		this.createMenus();
		this.addMenus();
	}


	private void createMenus(){
		this.fileMenu = new JMenu("Arquivo");
		this.analysisMenu = new JMenu("Análises");
		this.codeMenu = new JMenu("Código");
		this.aboutMenu = new JMenu("Sobre");
	}


	private void addMenus(){
		this.add(this.fileMenu);
		this.add(this.analysisMenu);
		this.add(this.codeMenu);
		this.add(this.aboutMenu);
	}

	private void createAndAddMenuItems(){
		this.createMenuItems();
		this.addMenuItems();
	}

	private void createMenuItems() {
		this.openProgramMenuItem = new JMenuItem("Abrir Programa");
		this.saveProgramMenuItem = new JMenuItem("Salvar Programa");

		this.lexicalMenuItem = new JMenuItem("Léxica");
		this.syntacticMenuItem = new JMenuItem("Sintática");
		this.semanticMenuItem = new JMenuItem("Semântica");		
	}

	private void addMenuItems() {
		this.fileMenu.add(openProgramMenuItem);
		this.fileMenu.add(saveProgramMenuItem);

		this.analysisMenu.add(this.lexicalMenuItem);
		this.analysisMenu.add(this.syntacticMenuItem);
		this.analysisMenu.add(this.semanticMenuItem	);
	}

	private void addActionsListeners(){
		this.openProgramMenuItem.addActionListener(this);
		this.saveProgramMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.openProgramMenuItem){

		}
		else if (e.getSource() == this.saveProgramMenuItem){
			this.saveProgramMenuItemAction();	
		}		
	}

	private void saveProgramMenuItemAction(){
		String text = this.parentWindow.getProgramtextAreaContent();
		String[] splittedText = text.split("\n");

		JFileChooser fileChooser = createJFileChooser();
		FileNameExtensionFilter lsiFilter = new FileNameExtensionFilter("LSI FILES", "lsi", "lsi");
		int returnValue = fileChooser.showSaveDialog(this);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().toString());

			if(!(fileChooser.getFileFilter().accept(file) || lsiFilter.accept(file))){
				JOptionPane.showMessageDialog(this.parentWindow,
						"O arquivo deve ter extensão .txt ou .lsi",
						"Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
			}
			else{
				this.saveFile(file, splittedText);
			}
		}		
	}

	private JFileChooser createJFileChooser(){
		JFileChooser fileChooser = new JFileChooser("/home/camila/AAteste");
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");		
		fileChooser.setFileFilter(txtFilter);

		return fileChooser;
	}

	private void saveFile(File file, String[] text){
		try {
			this.parentWindow.getView().saveFile(file, text);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.parentWindow,
					"Erro ao salvar arquivo \n " + e,
					"Erro", JOptionPane.ERROR_MESSAGE);			
		}
	}
}

