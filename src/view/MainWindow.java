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
 * @author Camila Maia e Maicon Lima
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
		String program = 
				"programa exemplo; \n" +
						"# ex decl constantes \n" +
						"inteiro n = 10; \n" +
						"caracter car = 'x'; \n" +
						"booleano achou = falso; \n" +
						"real z = 2.5; \n" +
						"cadeia [ 30 ] nome = 'meu nome'; \n" +
						"# ex decl variaveis \n" +
						"inteiro i,j,k ; \n" +
						"inteiro [ 10 ] x, y; \n" +
						"booleano achou; \n" +
						"caracter car, kar; \n" +
						"cadeia [20] nome; \n" +
						"real a,b; \n"+
						"caracter [ n ] vet_car; \n" +
						"# ex declaracao de metodos \n" +
						"metodo maior (ref i:inteiro; val j:real):real ; \n" +
						"{ \n" +
						"x[ i ] := - ( i * j); \n" + 
						"se i > j \n"+
						"entao retorne i * x [j] \n" +
						"senao retorne j; \n" +
						"}; \n"+
						"metodo proc (ref a,b:real; val c,d:inteiro); \n"+
						"{ \n"+
						"c:= maior (d, a * z); \n"+
						"achou := nao (achou e perdeu); \n"+
						"}; \n"+
						" /* programa principal */ \n"+
						"{ \n"+
						"leia (x,b,z); \n" +
						"enquanto i <= 10 faca \n"+
						"{ \n"+
						"se (z > x) e nao achou \n"+
						"entao enquanto b > z faca \n" +
						"{ \n"+
						"x:= y + 1; \n"+
						"z:= 0; \n"+
						"cad := 'um literal qquer'; \n"+
						"} \n"+
						"senao enquanto b ou c faca \n"+
						"{ \n"+
						"maior:= maior( i, j+k) > 'm'; \n"+
						"z:=z + 1; \n"+
						"mat [j + 1] := inter - 1; \n"+
						"}; \n"+
						"i:= i+1; \n"+
						"}; \n"+
						"vet[x+y] := vet[k*l + 1 * vet[1]]; \n"+
						"proc (y[x[1]] , i, j+k, maior ( x[i], x[i+1])); \n"+
						"vetcar['a']:= maior (x,y-1,7); \n"+
						"escreva ('este programa nao faz nada', data[dia], b); \n"+
						"}. \n";
		String minimunProgram = "programa exemplo; inteiro n = 10;\n metodo meumetodo(ref i:inteiro);"+
				"inteiro n = 5;" +"{};{}.";
		this.programTextArea = new JTextArea(minimunProgram);
		this.programScrollPane = new JScrollPane(this.programTextArea);
		this.programScrollPane.getViewport().setPreferredSize(new Dimension(485,420));
		this.add(this.programScrollPane);
	}

	private void initConsoleLabel(){
		this.consoleLabel = new JLabel("Console");
		this.add(this.consoleLabel);
	}

	private void initConsolePanes(){
		this.consoleTextArea = new JTextArea("");
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
