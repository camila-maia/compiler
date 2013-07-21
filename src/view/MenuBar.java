package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.analyzers.LexicalError;
import model.analyzers.SemanticError;
import model.analyzers.SyntaticError;


/**
 * @author Camila Maia and Maicon Lima
 * @date 06.23.2013
 */
public class MenuBar extends JMenuBar implements ActionListener{

	private MainWindow parentWindow;

	private JMenu fileMenu;
	private JMenu analysisMenu;
	private JMenu codeMenu;
	
	private JMenuItem openProgramMenuItem;
	private JMenuItem saveProgramMenuItem;	
	private JMenuItem aboutMenuItem;
	
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
		this.analysisMenu = new JMenu("Analises");
		this.codeMenu = new JMenu("Codigo");
	}

	private void addMenus(){
		this.add(this.fileMenu);
		this.add(this.analysisMenu);
		this.add(this.codeMenu);
	}

	private void createAndAddMenuItems(){
		this.createMenuItems();
		this.addMenuItems();
	}

	private void createMenuItems() {
		this.openProgramMenuItem = new JMenuItem("Abrir Programa");
		this.saveProgramMenuItem = new JMenuItem("Salvar Programa");
		this.aboutMenuItem = new JMenuItem("Sobre");


		this.lexicalMenuItem = new JMenuItem("Lexica");
		this.syntacticMenuItem = new JMenuItem("Sintatica");
		this.semanticMenuItem = new JMenuItem("Semantica");		
	}

	private void addMenuItems() {
		this.fileMenu.add(openProgramMenuItem);
		this.fileMenu.add(saveProgramMenuItem);
		this.fileMenu.add(aboutMenuItem);

		this.analysisMenu.add(this.lexicalMenuItem);
		this.analysisMenu.add(this.syntacticMenuItem);
		this.analysisMenu.add(this.semanticMenuItem	);
	}

	private void addActionsListeners(){
		this.openProgramMenuItem.addActionListener(this);
		this.saveProgramMenuItem.addActionListener(this);
		this.lexicalMenuItem.addActionListener(this);
		this.syntacticMenuItem.addActionListener(this);
		this.semanticMenuItem.addActionListener(this);
		this.aboutMenuItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.openProgramMenuItem){
			this.openProgramMenuItemAction();
		}
		else if (e.getSource() == this.saveProgramMenuItem){
			this.saveProgramMenuItemAction();	
		}else if(e.getSource() == this.lexicalMenuItem){
			this.lexicalMenuItemAction();
		}else if(e.getSource() == this.syntacticMenuItem){
			this.syntacticMenuItemAction();
		}else if(e.getSource() == this.semanticMenuItem){
			this.semanticMenuItemAction();
		}else if(e.getSource() == this.aboutMenuItem){
			AboutDialog aboutDialog = new AboutDialog();
			aboutDialog.setVisible(true);
		}
	}

	private void syntacticMenuItemAction() {
		this.parentWindow.getConsoleTextArea().setText("");
		try{
			String text = this.parentWindow.getProgramtextAreaContent();
			this.parentWindow.getView().syntacticAnalysis(text);
			JOptionPane.showMessageDialog(this.parentWindow, "Programa lexicamente e sintaticamente correto");
		}catch ( LexicalError e )
		{
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
		}
		catch (SyntaticError e){
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
			
		}catch(SemanticError e){
			
		}
		
	}
	
	private void semanticMenuItemAction() {
		this.parentWindow.getConsoleTextArea().setText("");
		try{
			String text = this.parentWindow.getProgramtextAreaContent();
			this.parentWindow.getView().semanticAnalysis(text);
			JOptionPane.showMessageDialog(this.parentWindow, "Programa lexicamente, sintaticamente e semanticamente correto");
		}catch ( LexicalError e )
		{
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
		}
		catch (SyntaticError e){
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
			
		}catch(SemanticError e){
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
		}
		
	}


	private void lexicalMenuItemAction() {
		this.parentWindow.getConsoleTextArea().setText("");
		try{
			String text = this.parentWindow.getProgramtextAreaContent();
			this.parentWindow.getView().lexicalAnalysis(text);
			JOptionPane.showMessageDialog(this.parentWindow, "Programa lexicamente correto");
		}catch ( LexicalError e )
		{
			this.parentWindow.getProgramTextArea().setCaretPosition(e.getPosition());
			this.parentWindow.getConsoleTextArea().setText(e.getMessage());			
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

			if(fileChooser.getFileFilter().accept(file) || lsiFilter.accept(file)){
				this.saveFile(file, splittedText);
			}
			else{
				JOptionPane.showMessageDialog(this.parentWindow,
						"O arquivo deve possuir extensão .txt ou .lsi",
						"Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

	private void openProgramMenuItemAction(){
		JFileChooser fileChooser = createJFileChooser();
		FileNameExtensionFilter lsiFilter = new FileNameExtensionFilter("LSI FILES", "lsi", "lsi");
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");		
		int returnVal = fileChooser.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().toString());

			if(txtFilter.accept(file) || lsiFilter.accept(file)){
				this.openFile(file);
			}else{
				JOptionPane.showMessageDialog(this.parentWindow,
						"O arquivo deve possuir extensão .txt ou .lsi",
						"Erro ao Abrir", JOptionPane.ERROR_MESSAGE);
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

	private void openFile(File file){
		try {
			String text = this.parentWindow.getView().openFile(file);
			this.parentWindow.setProgramtextAreaContent(text);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this.parentWindow,
					"Erro ao abrir o arquivo \n " + e,
					"Erro", JOptionPane.ERROR_MESSAGE);	
		}    
	}
}

