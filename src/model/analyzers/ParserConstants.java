package model.analyzers;

public interface ParserConstants
{
	int START_SYMBOL = 56;

	int FIRST_NON_TERMINAL    = 56;
	int FIRST_SEMANTIC_ACTION = 89;

	int[][] PARSER_TABLE =
		{
			{ -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1,  1,  1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1,  2,  2, -1, -1,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  2, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1 },
			{ -1, -1, -1, -1, -1, -1,  7,  8, -1, -1,  4,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, 12, -1, -1, -1, -1, -1, 13, -1, 13, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1 },
			{ -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, 37, 34, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, 36, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, 37, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, 41, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, 43, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 46, 46, 46, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, 46, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, -1, 48, 47, 47, 47, -1, 48, -1, -1, -1, -1, -1, -1, -1, 47, 47, -1, 48, 47 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 50, 51, 49, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, 54, -1, -1, 52 },
			{ -1, 55, 55, 55, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, 55, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, -1, -1, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, 57, -1, -1, 56, -1, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, -1, -1, 57, 57, -1, -1, 57, 57, 57, 57, -1, 57, 56, 56, -1, -1, -1, -1, -1, 57, 57, -1, 57, 57 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, 59, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 61, 61, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, -1, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 63, -1, -1, 63, 62, -1, -1, -1, -1, 63, -1, -1, -1, -1, -1, -1, 62, -1, 63, 63, -1, -1, 63, 63, 63, 63, -1, 63, 63, 63, 62, 62, -1, -1, -1, 63, 63, -1, 63, 63 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 67, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, 65, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 71, 72, 72, 72, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 68, 72, 72, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, -1, -1, 69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 75, 75, -1, -1, 75, 75, -1, -1, -1, -1, 75, -1, -1, -1, -1, -1, -1, 75, -1, 75, 75, -1, 74, 75, 75, 75, 75, 73, 75, 75, 75, 75, 75, -1, -1, -1, 75, 75, -1, 75, 75 },
			{ -1, 76, 77, 77, 77, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 77, 77, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, 78, 79, 82, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 80, 81, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
		};

	int[][] PRODUCTIONS = 
		{
			{   6,   2, 190,  34,  57,  36 },
			{  58,  64,  70 },
			{  59,  60, 191,  61, 192,  63, 193,  34,  58 },
			{   0 },
			{  11, 194 },
			{  26, 195 },
			{  12, 196 },
			{   7, 197 },
			{   8,  37,  87, 198,  38 },
			{ 199,  37,  87,  38, 268 },
			{ 200 },
			{   2, 201,  62 },
			{  35,  61 },
			{   0 },
			{ 202,  41,  87, 269 },
			{ 203 },
			{  65,  34,  64 },
			{   0 },
			{  29,   2, 204,  67, 205,  66, 206,  34,  57, 207 },
			{  42,  69, 208,  61, 209,  48,  59, 210,  68,  43 },
			{   0 },
			{  34,  69, 208,  61, 209,  48,  59, 210,  68 },
			{   0 },
			{  48,  59, 211 },
			{ 212 },
			{  30, 213 },
			{  33, 214 },
			{  53,  72,  71,  54 },
			{  34,  72,  71 },
			{   0 },
			{   2, 215,  74 },
			{  70 },
			{  14,  76, 216,  15,  72,  73 },
			{  28,  76, 216,  25,  72 },
			{  17,  42, 217,  61,  43 },
			{  18,  42,  76, 218,  75,  43 },
			{  31,  76, 219 },
			{   0 },
			{  16,  72 },
			{   0 },
			{ 220,  49,  76, 221 },
			{  37, 222,  76, 223,  38,  49,  76, 221 },
			{  42, 224,  76, 225,  75,  43, 226 },
			{ 227 },
			{  35,  76, 228,  75 },
			{   0 },
			{  79, 229,  77 },
			{  78,  79, 230 },
			{   0 },
			{  41, 231 },
			{  39, 232 },
			{  40, 233 },
			{  55, 234 },
			{  51, 235 },
			{  52, 236 },
			{  82, 237,  80 },
			{  81, 238,  82, 239,  80 },
			{   0 },
			{  44, 240 },
			{  45, 241 },
			{  19, 242 },
			{  85, 243,  83 },
			{  84, 244,  85, 245,  83 },
			{   0 },
			{  46, 246 },
			{  47, 247 },
			{  20, 248 },
			{  32, 249 },
			{  21, 250,  85, 251 },
			{  45, 252,  85, 253 },
			{  42, 254,  76,  43, 255 },
			{   2, 215,  86, 256 },
			{  88, 257 },
			{  42, 258,  76, 225,  75,  43, 259 },
			{  37, 222,  76, 260,  38 },
			{ 261 },
			{   2, 262 },
			{  88 },
			{   3, 263 },
			{   4, 264 },
			{  22, 265 },
			{  23, 266 },
			{   5, 267 }
		};

	String[] PARSER_ERROR =
		{
			"",
			"Era esperado fim de programa",
			"Era esperado id",
			"Era esperado constanteInteira",
			"Era esperado constanteReal",
			"Era esperado constanteLiteral",
			"Era esperado programa",
			"Era esperado caracter",
			"Era esperado cadeia",
			"Era esperado procedimento",
			"Era esperado inicio",
			"Era esperado inteiro",
			"Era esperado booleano",
			"Era esperado funcao",
			"Era esperado se",
			"Era esperado entao",
			"Era esperado senao",
			"Era esperado leia",
			"Era esperado escreva",
			"Era esperado ou",
			"Era esperado e",
			"Era esperado nao",
			"Era esperado falso",
			"Era esperado verdadeiro",
			"Era esperado de",
			"Era esperado faca",
			"Era esperado real",
			"Era esperado vetor",
			"Era esperado enquanto",
			"Era esperado metodo",
			"Era esperado ref",
			"Era esperado retorne",
			"Era esperado div",
			"Era esperado val",
			"Era esperado \";\"",
			"Era esperado \",\"",
			"Era esperado \".\"",
			"Era esperado \"[\"",
			"Era esperado \"]\"",
			"Era esperado \"<\"",
			"Era esperado \">\"",
			"Era esperado \"=\"",
			"Era esperado \"(\"",
			"Era esperado \")\"",
			"Era esperado \"+\"",
			"Era esperado \"-\"",
			"Era esperado \"*\"",
			"Era esperado \"/\"",
			"Era esperado \":\"",
			"Era esperado \":=\"",
			"Era esperado \"..\"",
			"Era esperado \"<=\"",
			"Era esperado \"<>\"",
			"Era esperado \"{\"",
			"Era esperado \"}\"",
			"Era esperado \">=\"",
			"Um programa deve ser declarado da seguinte forma: \n 'programa'  +  'id'  + ';' + 'bloco' ", //<programa>
			"Um bloco deve ser escrito da seguinte forma:\n 'declaracao  de metodos' + 'declaracao de constantes ' + 'comando composto'", //<bloco>
			"Declaracao de constante invalida",//<dcl_var_const>
			"Esperava-se 'inteiro' ou 'real' ou 'booleano' ou  'caracter' \n ou 'cadeia' ou '[' <constante> ']'", //"<tipo> invalido",
			"Esperava-se uma constante entre colchetes []",//"<dimensao> invalido",
			"Esperava-se 'id'",//"<lid> invalido",
			"Verifique se os identificadores estao separados entre virgulas.",//"<rep_lid> invalido",
			"Esperava-se '=' + 'constante'",//<fator_const> invalido",
			"Esperava-se um ; para separar os metodos",//"<dcl_metodos> invalido",
			"Declaracao de metodo invalida", //"<dcl_metodo> invalido",
			"Esperava-se ':' juntamente com o tipo do metodo",//"<tipo_metodo> invalido",
			"Esperava-se uma referencia ou valor, juntamente com pelo menos um id, \n o operador ':' e um tipo. Tudo entre parenteses",//"<par_formais> invalido",
			"Esperava-se uma referencia ou valor, juntamente com pelo menos um id, \n o operador ':' e um tipo",//"<rep_par> invalido",
			"Esperava-se uma referencia ou um valor",//"<mp_par> invalido",
			"Em conjunto de comandos devem estar entre chaves: {}",//"<com_composto> invalido",
			"Esperava-se um ';' para separar os comandos ", //"<replistacomando> invalido",
			"Comando invalido: ",//"<comando> invalido",
			"Esperava-se 'senao' juntamente com um comando",//"<senaoparte> invalido",
			"Esperava-se uma ou mais expressoes entre () ou [] juntamente com uma atribui��o ':=' ", //"<rcomid> invalido",
			"Verifique se as expressoes estao separadas por virgula",//"<rep_lexpr> invalido",
			"Expressao invalida",//"<expressao> invalido",
			"Esperava-se um operador '=', '<', '>', '<=', '>=' ou '<>' juntamente com uma express�o",//"<resto_expressao> invalido",
			"Esperava-se um operador do tipo: '=', '<', '>', '<=', '>=' ou '<>'",//"<oprel> invalido",
			"Esperava-se pelo menos uma expressao simples; soma ou subtracao de dois ou mais termos",//"<expsimp> invalido",
			"Esperava-se pelo menos um operador de adicao ou subtracao juntamente com um fator",//"<rep_expsimp> invalido",
			"Esperava-se um operador de soma ou de subtra��o ou operacao OU",//"<op_add> invalido",
			"Esperava-se um fator com pelo menos mais um operador e um outro fator",//"<termo> invalido",
			"Esperava-se um operador de multiplica��o, divis�o ou exponencial, \n juntamente com um fator",//"<rep_termo> invalido",
			"Esperava-se um operador (multiplica��o, divis�o ou exponencial)",//"<op_mult> invalido",
			"Esperava-se um fator, como por exemplo, uma constante expl�cita ou uma expressao",//"<fator> invalido",
			"Variavel invalida",//"<rvar> invalido",
			"Esperava-se um id ou numero inteiro ou real, ou valor booleano ou literal.",
			"Esperava-se numero inteiro ou real, ou valor booleano ou literal."
		};
}
