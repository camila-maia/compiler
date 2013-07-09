package model.utils;
import java.util.Stack;

public class Pointer {

	private String tipoAtual;
	private String valorAtual;
	private int deslocamento;
	private String contextoLID;
	private String mppAtual;
	private int posicaoDoID;
	private int nivelID;
	private String tipoExpr;
	private String tipoLadoEsquerdo;
	private String tipoFator;
	private String tipoExpressao;
	private String tipoTermo;
	private String tipoExpressaoSimples;
	private String operadorAtual;
	private int nDimensoes;
	private int dimensao1;
	private int dimensao2;
	private String tipoElementoAtual;
	private boolean operadorUnario;
	private String tipoVarEXPR;
	private Stack contextoExpressao;
	private Stack npf;
	private Stack numeroIndice;
	private Stack posicaoIDIndex;
	private Stack nivelIDIndex;
	private Stack metodoAtual;

	/**
	 * Creates a new instance of Ponteiro
	 */
	 public Pointer() {
		this.tipoAtual = null;
		this.valorAtual = null;
		this.deslocamento = 0;
		this.contextoLID = null;
		this.npf = new Stack();
		this.posicaoDoID = 0;
		this.nivelID = 0;
		this.mppAtual = null;
		this.metodoAtual = new Stack();
		this.tipoExpr = null;
		this.tipoLadoEsquerdo = null;
		this.tipoFator = null;
		this.tipoExpressao = null;
		this.tipoTermo = null;
		this.tipoExpressaoSimples = null;
		this.operadorAtual = null;
		this.nDimensoes = 0;
		this.dimensao1 = 0;
		this.dimensao2 = 0;
		this.tipoElementoAtual = null;
		this.contextoExpressao = new Stack();
		this.numeroIndice = new Stack();
		this.operadorUnario = false;
		this.tipoVarEXPR = null;
		this.posicaoIDIndex = new Stack();
		this.nivelIDIndex = new Stack();
	 }

	 public String getTipoAtual() {
		 return tipoAtual;
	 }

	 public void setTipoAtual(String tipoAtual) {
		 this.tipoAtual = tipoAtual;
	 }

	 public String getValorAtual() {
		 return valorAtual;
	 }

	 public void setValorAtual(String valorAtual) {
		 this.valorAtual = valorAtual;
	 }

	 public int getDeslocamento() {
		 return deslocamento;
	 }

	 public void setDeslocamento(int deslocamento) {
		 this.deslocamento = deslocamento;
	 }

	 public String getContextoLID() {
		 return contextoLID;
	 }

	 public void setContextoLID(String contextoLID) {
		 this.contextoLID = contextoLID;
	 }

	 public String getMppAtual() {
		 return mppAtual;
	 }

	 public void setMppAtual(String mppAtual) {
		 this.mppAtual = mppAtual;
	 }

	 public int getPosicaoDoID() {
		 return posicaoDoID;
	 }

	 public void setPosicaoDoID(int posicaoDoID) {
		 this.posicaoDoID = posicaoDoID;
	 }

	 public int getNivelID() {
		 return nivelID;
	 }

	 public void setNivelID(int nivelID) {
		 this.nivelID = nivelID;
	 }

	 public String getTipoExpr() {
		 return tipoExpr;
	 }

	 public void setTipoExpr(String tipoExpr) {
		 this.tipoExpr = tipoExpr;
	 }

	 public String getTipoLadoEsquerdo() {
		 return tipoLadoEsquerdo;
	 }

	 public void setTipoLadoEsquerdo(String tipoLadoEsquerdo) {
		 this.tipoLadoEsquerdo = tipoLadoEsquerdo;
	 }

	 public String getTipoFator() {
		 return tipoFator;
	 }

	 public void setTipoFator(String tipoFator) {
		 this.tipoFator = tipoFator;
	 }

	 public String getTipoExpressao() {
		 return tipoExpressao;
	 }

	 public void setTipoExpressao(String tipoExpressao) {
		 this.tipoExpressao = tipoExpressao;
	 }

	 public String getTipoTermo() {
		 return tipoTermo;
	 }

	 public void setTipoTermo(String tipoTermo) {
		 this.tipoTermo = tipoTermo;
	 }

	 public String getTipoExpressaoSimples() {
		 return tipoExpressaoSimples;
	 }

	 public void setTipoExpressaoSimples(String tipoExpressaoSimples) {
		 this.tipoExpressaoSimples = tipoExpressaoSimples;
	 }

	 public String getOperadorAtual() {
		 return operadorAtual;
	 }

	 public void setOperadorAtual(String operadorAtual) {
		 this.operadorAtual = operadorAtual;
	 }

	 public int getnDimensoes() {
		 return nDimensoes;
	 }

	 public void setnDimensoes(int nDimensoes) {
		 this.nDimensoes = nDimensoes;
	 }

	 public int getDimensao1() {
		 return dimensao1;
	 }

	 public void setDimensao1(int dimensao1) {
		 this.dimensao1 = dimensao1;
	 }

	 public int getDimensao2() {
		 return dimensao2;
	 }

	 public void setDimensao2(int dimensao2) {
		 this.dimensao2 = dimensao2;
	 }

	 public String getTipoElementoAtual() {
		 return tipoElementoAtual;
	 }

	 public void setTipoElementoAtual(String tipoElementoAtual) {
		 this.tipoElementoAtual = tipoElementoAtual;
	 }

	 public boolean isOperadorUnario() {
		 return operadorUnario;
	 }

	 public void setOperadorUnario(boolean operadorUnario) {
		 this.operadorUnario = operadorUnario;
	 }

	 public String getTipoVarEXPR() {
		 return tipoVarEXPR;
	 }

	 public void setTipoVarEXPR(String tipoVarEXPR) {
		 this.tipoVarEXPR = tipoVarEXPR;
	 }

	 public Stack getContextoExpressao() {
		 return contextoExpressao;
	 }

	 public void setContextoExpressao(Stack contextoExpressao) {
		 this.contextoExpressao = contextoExpressao;
	 }

	 public Stack getNpf() {
		 return npf;
	 }

	 public void setNpf(Stack npf) {
		 this.npf = npf;
	 }

	 public Stack getNumeroIndice() {
		 return numeroIndice;
	 }

	 public void setNumeroIndice(Stack numeroIndice) {
		 this.numeroIndice = numeroIndice;
	 }

	 public Stack getPosicaoIDIndex() {
		 return posicaoIDIndex;
	 }

	 public void setPosicaoIDIndex(Stack posicaoIDIndex) {
		 this.posicaoIDIndex = posicaoIDIndex;
	 }

	 public Stack getNivelIDIndex() {
		 return nivelIDIndex;
	 }

	 public void setNivelIDIndex(Stack nivelIDIndex) {
		 this.nivelIDIndex = nivelIDIndex;
	 }

	 public Stack getMetodoAtual() {
		 return metodoAtual;
	 }

	 public void setMetodoAtual(Stack metodoAtual) {
		 this.metodoAtual = metodoAtual;
	 }
}
