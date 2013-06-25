package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Camila Maia
 * @date 06.23.2013
 */
public class MainWindow extends JFrame{

	private View view;
	
	private MenuBar menuBar;
	private JLabel programLabel;
	private JScrollPane programScrollPane;
	private JTextArea programTextArea;
	private JLabel consoleLabel;
	private JScrollPane consoleScrollPane;
	private JTextArea consoleTextArea;
	
	public MainWindow(View view){
		super("Compiler");
		this.view = view;		
		this.setProperties();
		this.setComponents();
	}
	
	private void setProperties(){
		this.setSize(500, 630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());       
		this.setLocationRelativeTo(null);
	}

	private void setComponents() {
		this.initMenubar();
		this.initProgramLabel();
		this.initPanes();		
	}

	private void initMenubar(){
		this.menuBar = new MenuBar(this);
		this.setJMenuBar(this.menuBar);
	}
	
	private void initProgramLabel(){
		this.programLabel = new JLabel("Programa");
		this.add(programLabel);
	}
	
	private void initPanes() {
		this.initProgramPanes();
		this.initConsoleLabel();
		this.initConsolePanes();
	}
	
	private void initProgramPanes(){
		this.programTextArea = new JTextArea("Aloha, Maicon!");
		this.programScrollPane = new JScrollPane(this.programTextArea);
		this.programScrollPane.getViewport().setPreferredSize(new Dimension(485,420));
		this.add(this.programScrollPane);
	}
	
	private void initConsoleLabel(){
		this.consoleLabel = new JLabel("Console");
		this.add(this.consoleLabel);
	}
	
	private void initConsolePanes(){
		this.consoleTextArea = new JTextArea("Errou, Maicon!");
		this.consoleTextArea.setEditable(false);
		this.consoleTextArea.setForeground(Color.red);
		this.consoleScrollPane = new JScrollPane(this.consoleTextArea);
		this.consoleScrollPane.getViewport().setPreferredSize(new Dimension(485,100));
		this.add(this.consoleScrollPane);
	}

	
	public String getProgramtextAreaContent() {
		return this.programTextArea.getText();
	}
	

	public void setProgramtextAreaContent(String text) {
		this.programTextArea.setText(text);
	}
	
	public View getView(){
		return this.view;
	}

	public JTextArea getProgramTextArea() {
		return this.programTextArea;
	}

	public JTextArea getConsoleTextArea() {
		return this.consoleTextArea;
	}
}
