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
		this.setResizable(false);
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
		this.programTextArea = new JTextArea(getTestProgram());
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		this.programTextArea.setFont(font);
		
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
//		this.consoleTextArea.setForeground(Color.red);
		
		Font font = new Font("Verdana", Font.BOLD, 14);
		this.consoleTextArea.setFont(font);
		this.consoleTextArea.setForeground(Color.RED);
		
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

	public String getTestProgram(){
		String program =
				"programa semantico_correto;\n"+
						"\n#Declaração de Constantes\n" +
						"inteiro m1 = 10;\n" +
						"booleano achou= falso;\n"+
						"caracter car = 'x';\n" +
						"real re = 12.5E-10;\n" +

						"\n#Declaração de Variáveis\n" +						
						"inteiro i,j,k,n ;\n" +
						"real a,b,c ;\n" + 
						"booleano b1,b2;\n" +
						"caracter car1,car2,car3 ;\n" +
						"cadeia [30] cad1;\n" +
						"inteiro [10] x ;\n" +
						"caracter[20]  y ;\n" +
						"booleano[10] vb;\n" +

		"\n#Declaração de Métodos\n" +
		"metodo f (val b,v1:inteiro; ref d: booleano): booleano;\n" +
		"caracter [15]  a,b1;\n" +
		"{\n" +
		"\tleia (b,c, car1);\n" + 
		"\tretorne b > v1;\n" +
		"\tenquanto i <= 10  \n" +
		"\tfaca {x[i]:=0;\n" + 
		"\t\tb1[x[i]]:=a[1];\n" +
		"\t\tretorne f( x[i+1], m1, vb[ x[ x [ i ] ] ])}\n" +
		"};\n" +

		"metodo proc1 (ref b : inteiro; val x1 : caracter; ref x3:real);\n" + 
		"real a;\n" +
		"inteiro c;\n" +
		"{\n" +
		"\tenquanto i <= 10 faca\n" +
		"\t{\n" +
		"\t\ti:=i+ 1;\n" +
		"\t\tse f(c,i+j,b1)\n" + 
		"\t\tentao x[i+1]:= x[i+1] * 2\n" +
		"\t\tsenao x[i+1] := 0;\n" +
		"\t}\n" +

	"};\n" +
	"{\n" +
	"\tproc1(x[1],'a', b);\n" +

		"\tproc1(k, cad1[5*j], c);\n" +

		"\tproc1(m1, car1, x[10*(x[1]*2)]);\n" +

		"\tx[i + 1]:= i* x[ j * (x[k*5] + x[(k-1)*5])];\n" +

		"\tescreva ( 4.5, cad1, y[i], x [ x[i * (j + 1)]  * m1 ], 'x'  );\n" +

		"\tenquanto car < 'z' faca\n" +
		"\t{\n" +
		"\t\ty[i]:= cad1[k];\n" +
		"\t\tcar3:= y[i];\n" +
		"\t\tvb[ i - 9]:= f (x[1], 100, b1) e (y[i+1] > cad1 [ x [ j ] ] );\n" +
		"\t};\n" +
		"\tcar2:=cad1[i*j];\n" +
		"\tcad1:=car2;\n" +
		"\tse (i>j) ou (a<>c) e (car1 = car2)\n" +
		"\tentao i:= j div x[9]\n" +
		"\t	senao a:= (i + 1) / .57e-10;\n" +
		"}.";

		String program2 = "programa exemplo;\n" +
				"real x;\n" +
				"inteiro [25] y;\n" +
				"inteiro h = 1;\n" +
				"metodo func (val k : real) : inteiro;\n" +
				"{\n" +
				"\tretorne 10;\n" +
				"};\n" +
				"{\n" +
				"\tx := func(y[5*(3+h)+4]+3);\n" +
				"}.";
		
		String programWithErrors = "programa exemplo;\n" +
				"real x;\n" +
				"inteiro [25] y;\n" +
				"inteiro h = 1;\n" +
				"metodo func (val k : booleano) : inteiro;\n" +
				"{\n" +
				"\tretorne k;\n" +
				"};\n" +
				"{\n" +
				"\tx := func(y[5*(3+h)+4]+3);\n" +
				"}.";

		String program3 = "programa exemplo;\n" +

"\n# ex decl constantes\n" +
"inteiro n, inter = 10;\n" +  
"caracter car = 'x';\n" +
"booleano achou = falso;\n" +
"real z = 2.5;\n" +

"\n# ex decl variaveis\n" +  
"inteiro i,j,k ;\n" + 
"real [ 10 ]  x, y, mat, vet;\n" +
"inteiro [ 10 ] r,u;\n" +
"booleano achou;\n" +
"booleano perdeu;\n" +
"caracter car, kar;\n" +
"cadeia [20] nome;\n" +
"real a,b;\n" +
"caracter [ n ] vet_car;\n" + 
"cadeia [ n ] cad;\n" +

"\n# ex declaracao de metodos\n" + 
"metodo maior (ref m:inteiro; val p:real):real  ;\n" + 
"{\n" +
"\tx[ m ] := - ( m * p);\n" + 
"\tse m > p\n" +
"\tentao retorne m * x [i]\n" + 
"\tsenao retorne j;\n" +
"};\n" +

"\nmetodo proc (ref s,t:real;  val c,d:inteiro);\n" + 
"{\n" +
"\ts:= maior(d, s * z);\n" + 
"\tachou := nao (achou e perdeu);\n" + 
"};\n" +

"\n/* programa principal */\n" + 
"{\n" +
"leia (nome,b);\n" + 
"enquanto i <= 10 faca\n" +  
"{\n" +
"\tse (z > x[1]) e nao achou\n" + 
"\tentao enquanto b > z faca\n" +
"\t{\n" +
"\t\tx[1]:= y[i] + 1;\n" + 
"\t\ta:=  0;\n" +
"\t\tcad := 'um literal qquer';\n" + 
"\t}\n" +
"\tsenao enquanto  achou ou perdeu faca\n" + 
"\t{\n" +
"\t\ta:= maior( i, j+k) ;\n" + 
"\t\ta :=z +  1;\n" +
"\t\tmat [j + 1] := inter - 1;\n" + 
"\t};\n" +
"\ti:= i+1;\n" +
"} ;\n" +
"y[j] := 1.1;\n" +     
"vet[r[i]+u[j]] := vet[j + 1 * r[r[i]]];\n" + 
"proc (a , i, j+k, k+1);\n" +
"y[u[1]] := maior ( i, x[i+1]);\n" + 
"y[u[1]] := vet[j + 1 * r[r[i]]];\n" +

	"\nescreva ('este programa nao faz nada', b);\n" +
	"}.";

		String minimunProgram = "programa exemplo; cadeia [10.5] x;{}.";

		return program2;
	}
}
