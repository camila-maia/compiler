
package model.analyzers;

import java.lang.reflect.Method;
import java.util.ArrayList;

import model.symbolTable.Constant;
import model.symbolTable.Identifier;
import model.symbolTable.Parameter;
import model.symbolTable.PrimitiveTypes;
import model.symbolTable.Program;
import model.symbolTable.SymbolTable;
import model.symbolTable.Variable;
import model.symbolTable.VariablesCategories;
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
		this.implementedActions.add(108);
		this.implementedActions.add(109);
		this.implementedActions.add(110);	
		this.implementedActions.add(111);
		this.implementedActions.add(112); // fazer o resto
		this.implementedActions.add(113);
		this.implementedActions.add(114);
		this.implementedActions.add(115);
		this.implementedActions.add(126);
		this.implementedActions.add(131);
		this.implementedActions.add(168);
		this.implementedActions.add(174);
		this.implementedActions.add(175);
		this.implementedActions.add(176);
		this.implementedActions.add(177);
		this.implementedActions.add(178);
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
//				Variable variable= new Variable(identifier.getName(), 
//						identifier.getLevel(), shift);				
//				this.symbolTable.updateIdentifier(identifier, constant);
				break;
			}
		}
		ControlVariables.printAttributes();//TODO
		this.symbolTable.print();
	}

	public void action_105() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = "inteiro";
	}

	public void action_106() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = "real";
	}

	public void action_107() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = "booleano";
	}

	public void action_108() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoAtual = "caracter";
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
		int a = Integer.valueOf((String) ControlVariables.valConst);
		if (!ControlVariables.tipoConst.equals("inteiro"))
			throw new SemanticError("esperava-se uma const. inteira");
		else if( a > 256)
			throw new SemanticError("cadeia > que o permitido");
		else
			ControlVariables.tipoAtual = "cadeia";			
	}

	/**
	 * #110 – Se TipoAtual = “cadeia” 
	 * Então ERRO(“Vetor do tipo cadeia não é 
	 * permitido”) Senão SubCategoria := “vetor” 
	 */
	public void action_110() throws SemanticError {
		//Camila Aproves
		if(ControlVariables.tipoAtual.equals("cadeia"))
			throw new SemanticError("Vetor do tipo cadeia não é permitido");
		else{
			ControlVariables.subCategoria = VariablesCategories.VECTOR;
		}
	}

	/**
	 * #111 – Se TipoAtual = “cadeia” 
	 *  Então SubCategoria := “cadeia” 
	 *  Senão SubCategoria := “pré-definido” 
	 */
	public void action_111() throws SemanticError {
		//Camila Aproves
		if(ControlVariables.tipoAtual.equals("cadeia"))
			ControlVariables.subCategoria = VariablesCategories.STRING;
		else{
			ControlVariables.subCategoria = VariablesCategories.PRIMITIVES;
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
			ControlVariables.LID = new ArrayList<Identifier>();
			this.symbolTable.addIdentifier(identifier);
			ControlVariables.LID.add(identifier);
		}else if(ControlVariables.contextoLID.equals("par-formal")){
			//TODO
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
		if(ControlVariables.subCategoria == VariablesCategories.VECTOR
				|| ControlVariables.subCategoria == VariablesCategories.STRING){
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
		/**
		 * dois exemplos
		 * programa exemplo; inteiro n = 10; metodo meumetodo;inteiro n = 5;{};{}.
		 * programa exemplo; cadeia [20] nome; metodo meumetodo;inteiro n = 5;" +"{};{}.
		 */
		ControlVariables.printAttributes();
		switch(ControlVariables.categoriaAtual){
		case "constante":{
			//Constants identifier = new Constants(String name, int level, PrimitiveTypes type, Object value);
			//this.symbolTable.addIdentifier(identifier);
			break;
		}
		default:{
			System.out.println("ferrou");
		}
		}
		//this.symbolTable.addIdentifier(this.token.getId());
	}

	/**Se id não está declarado (não esta na TS)
	então ERRO(“Identificador não declarado”)
	senão guarda pos ocup por id na TS em POSID*/
	public void action_126() throws SemanticError{
		String name = this.token.getLexeme();
		Identifier identifier = null;
		for(int i = 0; i <= this.symbolTable.getCurrentLevel(); i++){
			if(this.symbolTable.getRows().containsKey(
					name+""+i)){
				identifier = this.symbolTable.getRows().get(name+""+i);
			}
		}
		if (identifier == null)
			throw new SemanticError("Identificador não declarado");
		ControlVariables.posid = identifier.getRowInSymbolTable();
	}

	/**Se categ. de id = “Variável” ou “Parâmetro”
			então 
				se tipo de id = “vetor”
				então ERRO (“id. Deveria ser indexado”)
			senão TipoLadoEsq := tipo de id
		senão ERRO (“id. deveria ser var ou par”)*/
	public void action_131() throws SemanticError {		
		int nivelAtual = this.symbolTable.getCurrentLevel();
		String key = this.token.getLexeme() + "" + nivelAtual;
		Identifier id = this.symbolTable.getRows().get(key);
		String className = id.getClass().getSimpleName().toString();

		if(className.equals("Variable")){
			Variable variable = (Variable)id;
			if(variable.getElementsType().toString().toLowerCase().equals("vetor") )
				throw new SemanticError("Não pode ser Vetor");				
			else{
				ControlVariables.tipoLadoEsquerdo = variable.getSubCategory();
			}
		}
		else if (className.equals("Parameter")){
			Parameter parameter = (Parameter)id;
			ControlVariables.tipoLadoEsquerdo = parameter.getType();
		}
		else{
			throw new SemanticError("Esperáva-se variável ou parâmetro");
		}
	}

	public void action_168() throws SemanticError {

	}
	/**TipoConst := tipo da constante
			ValConst := valor da constante*/
	public void action_174() throws SemanticError {
		ControlVariables.tipoConst = PrimitiveTypes.INTEIRO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_175() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = PrimitiveTypes.REAL;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_176() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = PrimitiveTypes.BOOLEANO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_177() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = PrimitiveTypes.BOOLEANO;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/**TipoConst := tipo da constante
	ValConst := valor da constante*/
	public void action_178() throws SemanticError {
		//Camila Aproves
		ControlVariables.tipoConst = PrimitiveTypes.CARACTER;
		ControlVariables.valConst = this.token.getLexeme();
	}

	/** #180
    Se TipoConst diferente TipoAtual
     	Então exceção (Tipo da constante inválido)
	 */
	public void action_180() throws SemanticError {
		//Camila Aproves
		String tipoConst = ControlVariables.tipoConst.toString().toLowerCase();
		if(!tipoConst.equals(ControlVariables.tipoAtual))
			throw new SemanticError("Tipo da constante inválido");
	}


}
