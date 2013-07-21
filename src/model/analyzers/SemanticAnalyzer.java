
package model.analyzers;

import java.lang.reflect.Method;
import java.util.ArrayList;

import model.symbolTable.Constant;
import model.symbolTable.IdType;
import model.symbolTable.Identifier;
import model.symbolTable.Parameter;
import model.symbolTable.Program;
import model.symbolTable.SymbolTable;
import model.symbolTable.Variable;
import model.symbolTable.Methood;
import model.utils.ControlVariables;

public class SemanticAnalyzer implements Constants {

	private ArrayList<Integer> implementedActions = new ArrayList<Integer>();
	private Token token;
	private SymbolTable symbolTable;

	public SemanticAnalyzer(){		
		this.implementedActions.add(101);
		this.implementedActions.add(102);
		this.implementedActions.add(103);		
		this.implementedActions.add(104);
		this.implementedActions.add(105);
		this.implementedActions.add(106);
		this.implementedActions.add(107);
		this.implementedActions.add(108);
		this.implementedActions.add(109);
		this.implementedActions.add(110);	
		this.implementedActions.add(111);
		this.implementedActions.add(112); // fazer o resto
		this.implementedActions.add(113);
		this.implementedActions.add(114);
		this.implementedActions.add(115);
		this.implementedActions.add(116);
		this.implementedActions.add(117);
		this.implementedActions.add(118);
		this.implementedActions.add(119);
		this.implementedActions.add(120);
		this.implementedActions.add(121);
		this.implementedActions.add(122);
		this.implementedActions.add(123);
		this.implementedActions.add(124);
		this.implementedActions.add(125);
		this.implementedActions.add(126);
		this.implementedActions.add(130);
		this.implementedActions.add(131);
		this.implementedActions.add(132);
		this.implementedActions.add(133);
		this.implementedActions.add(134);
		this.implementedActions.add(140);
		this.implementedActions.add(148);
		this.implementedActions.add(149);
		this.implementedActions.add(150);
		this.implementedActions.add(151);
		this.implementedActions.add(152);
		this.implementedActions.add(153);
		this.implementedActions.add(154);
		this.implementedActions.add(155);
		this.implementedActions.add(157);
		this.implementedActions.add(158);
		this.implementedActions.add(159);
		this.implementedActions.add(160);
		this.implementedActions.add(163);
		this.implementedActions.add(165);
		this.implementedActions.add(167);
		this.implementedActions.add(168);
		this.implementedActions.add(169);
		this.implementedActions.add(172);
		this.implementedActions.add(174);
		this.implementedActions.add(175);
		this.implementedActions.add(176);
		this.implementedActions.add(177);
		this.implementedActions.add(178);
		this.implementedActions.add(179);
		this.implementedActions.add(180);
	}

	public void executeAction(int action, Token token)	throws SemanticError{

		System.out.println("Ação #"+action+", Token: "+token);

		if(implementedActions.contains(action)){
			this.token = token;
			try {
				Method method = this.getClass().getMethod("action_" + action, (Class[]) null);  // Reflexão para pegar método da ação que está sendo referenciada
				method.invoke(this, (Object[]) null); 
			} catch (Exception ex) {
				try {
					SemanticError erro = (SemanticError) ex.getCause();
					throw new SemanticError(erro.getMessage(), token.getPosition());
				} catch (ClassCastException e) {
					e.printStackTrace();
					throw new SemanticError("Erro na acao " + action + ": " + e.getMessage(), token.getPosition());
				}
			}
		}
		else
			System.out.println("Ação não implementada " + action);
	}	


	/**
	 * Inicializa com zero nível atual (NA) e  deslocamento 
	 * Insere id na TS juntamente com seus atributos,
	 * categoria (id-programa) e nível ( NA ) 
	 */    
	public void action_101() throws SemanticError {
		//Camila Aproves
		this.symbolTable = new SymbolTable();
		Program program = new Program(this.token.getLexeme());
		this.symbolTable.addIdentifier(program);		
	}

	/**
	 * Seta contextoLID para "decl"  
	 * Guarda pos. na TS do primeiro id da lista
	 */
	public void action_102() throws SemanticError {
		//Camila Aproves
		ControlVariables.LID = new ArrayList<Identifier>();
		ControlVariables.contextoLID = "decl";
		ControlVariables.primeiraPosicaoListaAux = this.symbolTable.getCurrentPosition();

	}

	/**
	 * #103 – Guarda pos. na TS do último id da lista
	 */
	public void action_103() throws SemanticError {
		//Camila Aproves
		ControlVariables.ultimaPosicaoListaAux = this.symbolTable.getCurrentPosition();
	}

	/**
	 * #104 – Atualiza atributos dos id de <lid> de acordo 
		 com a CategoriaAtual e com a SubCategoria. 
		 Para cálculo do Deslocamento de variáveis, 
		 considere que toda variável ocupa 1 célula de 
		 memória (exceto vetor que ocupa 1 célula para 
		 cada elemento) 
	 */
	public void action_104() throws SemanticError {
		String category = ControlVariables.categoriaAtual;
		for(Identifier identifier : ControlVariables.LID){
			switch(category){
			case "constante":
				Constant constant = new Constant(identifier.getName(),
						identifier.getLevel(),
						ControlVariables.tipoConst,
						ControlVariables.valConst
						);	
				this.symbolTable.updateIdentifier(identifier, constant);
				break;
			case "variavel":
				Variable variable = new Variable(identifier.getName(),identifier.getLevel());
				variable.setRowInSymbolTable(identifier.getRowInSymbolTable());
				variable.setType(ControlVariables.subCategoria);

				if (variable.getType().equals(IdType.VECTOR)){
					//					variavel.setDeslocamento(tabela_simbolos.getDeslocamento());
					//					variavel.setTamanho(tabela_simbolos.getNum_elementos());
					//					tabela_simbolos.inrementarDeslocamento(variavel.getTamanho());
					variable.setVectorType(ControlVariables.tipoAtual);
				} else if (variable.getType().equals(IdType.CADEIA)){
					//TODO
				}

				this.symbolTable.updateIdentifier(identifier, variable);
				break;
			}
		}
	}

	public void action_105() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = IdType.INTEIRO;
	}

	public void action_106() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = IdType.REAL;
	}

	public void action_107() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = IdType.BOOLEANO;
	}

	public void action_108() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = IdType.CARACTER;
	}

	/**
	 *109 – Se TipoConst <> “inteiro” 
	 então ERRO(“esperava-se uma const. inteira”) 
	 senão se ValConst > 256 
	 então ERRO(“cadeia > que o permitido”) 
	 senão TipoAtual := “cadeia” 
	 */
	public void action_109() throws SemanticError {
		//Camila Aproves
		if (!ControlVariables.tipoConst.toString().equals("INTEIRO"))
			throw new SemanticError("esperava-se uma const. inteira");
		int a = Integer.valueOf((String) ControlVariables.valConst);
		if( a > 256)
			throw new SemanticError("cadeia > que o permitido");
		else
			ControlVariables.tipoAtual = IdType.CADEIA;			
	}

	/**
	 * #110 – Se TipoAtual = “cadeia” 
	 * Então ERRO(“Vetor do tipo cadeia não é 
	 * permitido”) Senão SubCategoria := “vetor” 
	 */
	public void action_110() throws SemanticError {
		//Camila Aproves
		if(ControlVariables.tipoAtual.toString().equals("CADEIA"))
			throw new SemanticError("Vetor do tipo cadeia não é permitido");
		else{
			ControlVariables.subCategoria = IdType.VECTOR;
		}
	}

	/**
	 * #111 – Se TipoAtual = “cadeia” 
	 *  Então SubCategoria := “cadeia” 
	 *  Senão SubCategoria := “primitivo” 
	 */
	public void action_111() throws SemanticError {
		//Camila Aproves
		if(ControlVariables.tipoAtual.toString().equals("CADEIA"))
			ControlVariables.subCategoria = IdType.CADEIA;
		else{
			ControlVariables.subCategoria = IdType.PRIMITIVES;
		}
	}	

	/**Se contextoLID = “decl”
			entao se id já declarado no NA
			então ERRO(“Id já declarado”)
			senão insere id na TS
			- Se contextoLID = “par-formal”
			entao se id já declarado no NA
			então ERRO (“Id de parâmetro repetido”)
			senão incrementa NPF; insere id na TS
			- Se contextoLID = “leitura”
			Então se id não declarado
			então ERRO (“Id não declarado”)
			senão se categoria ou tipo invalid
			paraleitura
			então ERRO(“Tipo inv. p/ leitura”)
			senão (* Gera Cód. para leitura *)*/

	public void action_112() throws SemanticError {
		if(ControlVariables.contextoLID.equals("decl")){
			// Verificar se currentPosition não é +1
			Identifier identifier = new Identifier(this.token.getLexeme(),
					this.symbolTable.getCurrentPosition(),
					this.symbolTable.getCurrentLevel());
			this.symbolTable.addIdentifier(identifier);
			identifier.setRowInSymbolTable(this.symbolTable.getCurrentPosition()-1);
			ControlVariables.LID.add(identifier);
		}else if(ControlVariables.contextoLID.equals("par-formal")){
			Parameter parameter = new Parameter(this.token.getLexeme(),
					this.symbolTable.getCurrentLevel());
			this.symbolTable.addIdentifier(parameter);
			parameter.setRowInSymbolTable(this.symbolTable.getCurrentPosition()-1);
		}else if(ControlVariables.contextoLID.equals("leitura")){
			//TODO
		}
	}

	/**	Se SubCategoria = “cadeia” ou “vetor” 
	Então ERRO (“Apenas id de tipo pré-def podem 
	ser declarados como constante”) 
	senão CategoriaAtual := “constante”
	 */
	public void action_113() throws SemanticError {
		//Camila Aproves
		if(ControlVariables.subCategoria == IdType.VECTOR
				|| ControlVariables.subCategoria == IdType.CADEIA){
			throw new SemanticError("Apenas id de tipo pré-def podem ser declarados como constante");
		}
		else
			ControlVariables.categoriaAtual = "constante";

	}

	/**
	 * CategoriaAtual := “variavel”	 
	 */
	public void action_114() throws SemanticError {
		//Camila Aproves
		ControlVariables.categoriaAtual="variavel";
	}

	/**
	 * #115 Se id já est á declarado no NA,
	 * então ERRO(“Id já declarado”) senão 
	 * insere id na TS, junto com seus atrib. zera número de parâmetros Formais (NPF)
	 * incrementa nível atual (NA := NA + 1)
	 */
	public void action_115()throws SemanticError{//TODO		
		String nome = this.token.getLexeme();
		int level = symbolTable.getCurrentLevel();

		Methood method = new Methood(nome, level);
		this.symbolTable.getRows().put(nome + "" + level, method);
		ControlVariables.methods.push(method);        		

		ControlVariables.npf.push(0);
		ControlVariables.parametersList = new ArrayList<Parameter>();

		this.symbolTable.setCurrentLevel(level+1);
	}


	/**Atualiza num. de par. Formais (NPF) na TS*/
	public void action_116() throws SemanticError{
		//Averiguar se deve-se utilizar peek ou pop
		Methood method = (Methood)(ControlVariables.getCurrentMethod());
		method.setNpf(ControlVariables.npf.peek());
		method.setParameters(ControlVariables.parametersList);
		ControlVariables.parametersList = null;
	}

	/**#117 – Atualiza tipo do método na TS*/
	public void action_117() throws SemanticError{

	}

	/**#118 - Retira da TS as variáveis decl. localmente
	Atualiza nível atual ( NA := NA – 1 )*/
	public void action_118() throws SemanticError{
		this.symbolTable.removeElementsFromLevel
		(this.symbolTable.getCurrentLevel());
		this.symbolTable.setCurrentLevel(this.symbolTable.getCurrentLevel()-1);
	}

	/**#119 - Seta contextoLID para “par-formal”
		Marca pos.na TS do primeiro id da lista
	 */
	public void action_119() throws SemanticError{
		ControlVariables.LID = new ArrayList<Identifier>();
		ControlVariables.contextoLID = "par-formal";
		ControlVariables.primeiraPosicaoListaAux = this.symbolTable.getCurrentPosition();
	}

	/**#120 – Marca pos. na TS do último id da lista*/
	public void action_120() throws SemanticError{		
		ControlVariables.ultimaPosicaoListaAux = this.symbolTable.getCurrentPosition();
	}

	/**
	#121 – Se TipoAtual diferente de “primitivo”
	Então ERRO (“Par devem ser de tipo pré-def.”)
	Senão Atualiza atributos dos id’s de <lid> :
	Cat. (“Parâmetro”), TipoAtual e MPP.
	Insere os par em uma lista auxiliar
	(ListaPar) a ser usada na chamada do
	método.*/
	public void action_121() throws SemanticError{	
		if(ControlVariables.tipoAtual.isDifferent(IdType.PRIMITIVES)){
			throw new SemanticError("Erro na ação 121: \nPar devem ser de tipo pré-def");
		}
		else{
			for(Identifier identifier : ControlVariables.LID){
				Parameter param = new Parameter(identifier.getName(),
						identifier.getLevel());
				param.setType(ControlVariables.tipoAtual);
				param.setPassingMechanism(ControlVariables.mpp);
			}
		}
	}

	/**#122- Se TipoAtual = “cadeia”
			 Então ERRO (“Métodos devem ser de tipo pré-def.”)
			 Senão Seta tipo do método para TipoAtual
	 */
	public void action_122() throws SemanticError{
		if(ControlVariables.tipoAtual.isEqual(IdType.CADEIA)){
			throw new SemanticError("Métodos devem ser de tipo pré-def.");
		}
		ControlVariables.getCurrentMethod().setResultType(ControlVariables.tipoAtual);
	}

	/**#123 - Seta tipo do método para “nulo”*/
	public void action_123() throws SemanticError{
		Methood methood = ControlVariables.methods.peek();
		methood.setResultType(IdType.NULL);
	}

	/**#124 – Seta MPP para “referência”*/
	public void action_124() throws SemanticError{
		ControlVariables.mpp = "referencia";
	}

	/**#125 – Seta MPP para "valor"*/
	public void action_125() throws SemanticError{
		ControlVariables.mpp = "valor";
	}

	/**Se id não está declarado (não esta na TS)
	então ERRO(“Identificador não declarado”)
	senão guarda pos ocup por id na TS em POSID*/
	public void action_126() throws SemanticError{
		String name = this.token.getLexeme();
		Identifier identifier =	this.symbolTable.getIdentifierPreviouslyDeclared
				(name,this.symbolTable.getCurrentLevel());

		if (identifier == null)
			throw new SemanticError("Erro na ação 126 \nIdentificador não declarado");

		ControlVariables.currentIdentifier = identifier;
	}

	/** Se está fora do escopo de um método com tipo
		Então ERRO (“Retorne” só pode ser usado em função”)
		Senão se TipoExpr <> tipo do método
			então ERRO(“Tipo de exp inválido”)
			senao (* ação de Geração de Código *)
	 */
	public void action_130() throws SemanticError {
		Methood method = ControlVariables.getCurrentMethod();
		if (method.getResultType().isEqual(IdType.NULL)){
			throw new SemanticError("'Retorne' só pode ser usado em função");
		}
		if(ControlVariables.tipoExpr.isDifferent(method.getResultType())){
			throw new SemanticError("Tipo de exp inválido");
		}
		/* Geração de Código :)~ */
	}

	/**131- Se categ. de id = “Variável” ou “Parâmetro”
				então se tipo de id = “vetor”
					então ERRO (“id. Deveria ser indexado”)
					senão TipoLadoEsq := tipo de id
			senão ERRO (“id. deveria ser var ou par”)*/
	public void action_131() throws SemanticError {		
		int nivelAtual = this.symbolTable.getCurrentLevel();
		Identifier id = this.symbolTable.getIdentifierPreviouslyDeclared(this.token.getLexeme(), nivelAtual);
		if (id != null){
			String className = id.getClass().getSimpleName().toString();

			if(className.equals("Variable")){
				Variable variable = (Variable)id;
				if(variable.getType().toString().toLowerCase().equals("vetor") )
					throw new SemanticError("Erro na ação 131 \nNão pode ser Vetor");				
				else{
					ControlVariables.tipoLadoEsquerdo = variable.getType();
				}
			}
			else if (className.equals("Parameter")){
				Parameter parameter = (Parameter)id;
				ControlVariables.tipoLadoEsquerdo = parameter.getType();
			}
			else{
				throw new SemanticError("Erro na ação 131 \nEsperáva-se variável ou parâmetro");
			}
		}
		else{
			throw new SemanticError("id. não declarado");
		}		
	}

	/** se TipoExpr não compatível com tipoLadoesq
	 *  então ERRO (“tipos incompatíveis”)
	 *  senão (* G. Código *)
	 */
	public void action_132() throws SemanticError {
		if(ControlVariables.tipoExpr.isDifferent(ControlVariables.tipoLadoEsquerdo)){
			throw new SemanticError("tipos incompatíveis: " + 
					ControlVariables.tipoExpr + "<>" + ControlVariables.tipoLadoEsquerdo);
		}
	}

	/**133- se categoria de id <> “variável”
			então ERRO (“esperava-se uma variável”)
			senao se tipo de id <> vetor e <> de cadeia
				então ERRO(“apenas vetores e cadeias podem ser indexados”)
				senão TipoVarIndexada = tipo de id*/

	public void action_133() throws SemanticError {
		Identifier id = ControlVariables.currentIdentifier;

		if(!id.getClass().getSimpleName().toString().equals("Variable")){
			throw new SemanticError("esperava-se uma variável");
		}
		else{
			Variable variable = (Variable) id;
			if (variable.getType().isDifferent(IdType.VECTOR)
					&& variable.getType().isDifferent(IdType.CADEIA)){
				throw new SemanticError("apenas vetores e cadeias podem ser indexados");
			}
			else{
				ControlVariables.tipoVarIndexada = variable.getType();
			}
		}
	}

	/**134-	se TipoExpr <> “inteiro”
			threntão ERRO(“índice deveria ser inteiro")
			senão se TipoVarIndexada = cadeia
				então TipoLadoEsq := “caracter”
				senao TipoLadoEsq := TipoElementos do vetor”)
	 */
	public void action_134() throws SemanticError {
		Identifier id = ControlVariables.currentIdentifier;
		Variable variable = (Variable)id;

		if (ControlVariables.tipoExpr.isDifferent(IdType.INTEIRO))
			throw new SemanticError("índice deveria ser inteiro");
		else{
			if(ControlVariables.tipoVarIndexada.isEqual(IdType.CADEIA))
				ControlVariables.tipoLadoEsquerdo = IdType.CARACTER;
			else
				ControlVariables.tipoLadoEsquerdo =  variable.getVectorType();
		}	
	}

	/** TipoExpr := TipoExpSimples	 */
	public void action_140() throws SemanticError {
		ControlVariables.tipoExpr = ControlVariables.tipoExpSimples;
	}

	/** TipoExpSimples := TipoTermo	 */
	public void action_148() throws SemanticError {
		ControlVariables.tipoExpSimples = ControlVariables.tipoTermo;
	}

	/**#149 Se operador não se aplica a TipoExpSimples
			então ERRO(“Op. e Operando incompatíveis”)
	 */
	public void action_149() throws SemanticError {
		String tipoExprSimples = ControlVariables.tipoExpSimples.toString();
		String operator = ControlVariables.getCurrentOperator();

		if (operator.equals("ou") && !tipoExprSimples.equals("BOOLEANO"))
			throw new SemanticError("Operador e operando incompatíveis");
		else if (!tipoExprSimples.equals("INTEIRO") && !tipoExprSimples.equals("REAL"))
			throw new SemanticError("Operador e operando incompatíveis");
	}

	/**#150-Se TipoTermo incompatível com TipoExpSimples
			então ERRO (“Operandos incompatíveis”)
			senão TipoExpSimples := tipo do resultado da operação
			(* Gera Código de acordo com oppad *)
	 */
	public void action_150() throws SemanticError {
		//TODO
	}

	/**#151- guarda operador para futura G. código */
	public void action_151() throws SemanticError {
		ControlVariables.operadores.push("+");
	}

	/**#152- guarda operador para futura G. código */
	public void action_152() throws SemanticError {
		ControlVariables.operadores.push("-");
	}

	/**#153- guarda operador para futura G. código */
	public void action_153() throws SemanticError {
		ControlVariables.operadores.push("ou");
	}

	/** TipoTermo := TipoFator */
	public void action_154() throws SemanticError {
		ControlVariables.tipoTermo = ControlVariables.tipoFator; 
	}

	/**#155– Se operador não se aplica a TipoTermo
			 então ERRO(“Op. e Operando incompatíveis”)
	 */
	public void action_155() throws SemanticError {
		String tipoTermo = ControlVariables.tipoTermo.toString();
		String operator = ControlVariables.getCurrentOperator();

		//Não dá para dividir reais???
		if (operator.equals("div") && !tipoTermo.equals("INTEIRO"))
			throw new SemanticError("Operador e operando incompatíveis");
		else if (operator.equals("e") && !tipoTermo.equals("BOOLEANO"))
			throw new SemanticError("Operador e operando incompatíveis");
		else if (!tipoTermo.equals("INTEIRO") && !tipoTermo.equals("REAL"))
			throw new SemanticError("Operador e operando incompatíveis");
	}

	/**#157 guarda operador para futura G. código */
	public void action_157() throws SemanticError {
		ControlVariables.operadores.push("*");
	}

	/**#158 guarda operador para futura G. código */
	public void action_158() throws SemanticError {
		ControlVariables.operadores.push("/");
	}

	/**#159 guarda operador para futura G. código */
	public void action_159() throws SemanticError {
		ControlVariables.operadores.push("e");
	}

	/**#160 guarda operador para futura G. código */
	public void action_160() throws SemanticError {
		ControlVariables.operadores.push("div");
	}

	/**#163 se OpUnario
			então ERRO(“Op. “unário” repetido ”)
			Senão OpUnario := true
	 */
	public void action_163() throws SemanticError {
		if (ControlVariables.operadorUnario.peek() != null)
			throw new SemanticError("Op. 'unário' repetido");
		else
			ControlVariables.operadorUnario.push(true);
	}

	/**#165 OpNega := OpUnario := false */
	public void action_165() throws SemanticError {
		ControlVariables.operadorUnario.push(false);
		ControlVariables.operadorNega.push(false);
	}

	/** #167 – TipoFator := TipoVar */
	public void action_167() throws SemanticError {
		ControlVariables.tipoFator = ControlVariables.tipoVar; 
	}

	/**TipoFator := TipoCte */
	public void action_168() throws SemanticError {
		ControlVariables.tipoFator = ControlVariables.tipoConst; 
	}

	/**#169–se categoria de id <> método 
	  		então ERRO(“id deveria ser um método”)
			senão se tipo método = “nulo”
				então ERRO(“esperava-se mét. com tipo”)
	 */
	public void action_169() throws SemanticError {
		Identifier id = ControlVariables.currentIdentifier;
		if (!id.getClass().getSimpleName().equals("Methood")){
			throw new SemanticError("id deveria ser um método");
		}
		Methood method = (Methood) id;
		if(method.getResultType().isEqual(IdType.NULL)){
			throw new SemanticError("esperava-se mét. com tipo");
		}
	}

	/**#172-se categoria de id = “variável” ou “Parâmetro”
			então se tipo de id = “vetor”
				então ERRO(“vetor deve ser indexado”)
				senão TipoVar := Tipo de id
			senão se categoria de id = método
				então se tipo método = “nulo”
					então ERRO(“Esperava-se método com tipo”)
					senão se NPF <> 0
						então ERRO(“Erro na quant. de parâmetros”)
						senão TipoVar:=Tipo resultado (* Gera Código *)
			senão se categoria de id = “constante”
					então TipoVar:= TipoConst
					Senão ERRO(“esperava-se var, id-método ou constante”)
	 */
	public void action_172() throws SemanticError {
		Identifier id = this.symbolTable.getIdentifier(token.getLexeme(),
				this.symbolTable.getCurrentLevel());
		String idClassName = id.getClass().getSimpleName();

		switch(idClassName){
		case "Variable":
			Variable variable = (Variable) id;
			if (variable.getType().isEqual(IdType.VECTOR))
				throw new SemanticError("vetor deve ser indexado");
			ControlVariables.tipoVar = variable.getType();
			break;
		case "Parameter":
			break;
		case "Methood":
			Methood method = (Methood) id;
			if (method.getResultType().isEqual(IdType.NULL))
				throw new SemanticError("Esperava-se método com tipo");
			if(method.getNpf() != 0)
				throw new SemanticError("Erro na quant. de parâmetros");
			ControlVariables.tipoVar = method.getResultType();
			/* Geração de  Código */
			break;
		case "Constant":
			ControlVariables.tipoVar = ControlVariables.tipoConst; 
			break;
		default:
			throw new SemanticError("esperava-se var, id-método ou constante");
		}
	}

	/**TipoConst := tipo da constante
			ValConst := valor da constante*/
	public void action_174() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = IdType.INTEIRO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_175() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = IdType.REAL;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_176() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = IdType.BOOLEANO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_177() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = IdType.BOOLEANO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_178() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = IdType.CARACTER;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**#179 – Se TipoConst <> inteiro
		Então ERRO (“A dim.deve ser uma constante inteira”)
		Senão Seta NumElementos para ValConst
	 */
	public void action_179() throws SemanticError {
		if(ControlVariables.tipoConst.isDifferent(IdType.INTEIRO)){
			throw new SemanticError("Erro na ação 179, A dim.deve ser uma constante 	inteira");
		}else{
			ControlVariables.numElementos = Integer.valueOf((String) ControlVariables.valConst);
		}
	}

	/** #180
    Se TipoConst diferente TipoAtual
     	Então exceção (Tipo da constante inválido)
	 */
	public void action_180() throws SemanticError {
		//Camila Aproves		 
		if(!(ControlVariables.tipoConst).equals(ControlVariables.tipoAtual))
			throw new SemanticError("Erro na ação 180 \nTipo da constante inválido");
	}
}
