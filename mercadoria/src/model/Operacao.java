package model;

import dao.OperacaoDAO;
import to.OperacaoTO;

public class Operacao {
	private int idOperacao;
	private int idTipoNegocio;
	private String dsTipoNegocio;
	private int idMercadoria;
	private int qntMercadoria;
	private String data;
	private double vl_total;
	
	public Operacao(int tn, String ds, int idMercadoria, int qntMercadoria, String data, double v){
		setIdTipoNegocio(tn);
		setDsTipoNegocio(ds);
		setIdMercadoria(idMercadoria);
		setQntMercadoria(qntMercadoria);
		setData(data);
		setVl_total(v);
	}
	public Operacao(){
	
	}
	
	public int getIdOperacao() {
		return idOperacao;
	}
	public void setIdOperacao(int idOperacao) {
		this.idOperacao = idOperacao;
	}	
	public int getIdTipoNegocio() {
		return idTipoNegocio;
	}
	public void setIdTipoNegocio(int idTipoNegocio) {
		this.idTipoNegocio = idTipoNegocio;
	}
	public String getDsTipoNegocio() {
		return dsTipoNegocio;
	}
	public void setDsTipoNegocio(String dsTipoNegocio) {
		this.dsTipoNegocio = dsTipoNegocio;
	}
	
	public int getIdMercadoria() {
		return idMercadoria;
	}
	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	public int getQntMercadoria() {
		return qntMercadoria;
	}
	public void setQntMercadoria(int qntMercadoria) {
		this.qntMercadoria = qntMercadoria;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getVl_total() {
		return vl_total;
	}
	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}
	
	public void criarOp(){
		OperacaoDAO dao = new OperacaoDAO();
		OperacaoTO to = new OperacaoTO();
		to.setIdOperacao(idOperacao);
		to.setIdMercadoria(idMercadoria);
		to.setIdTipoNegocio(idTipoNegocio);
		to.setQntMercadoria(qntMercadoria);
		to.setData(data);
		to.setVl_total(vl_total);
		dao.criarOp(to);
	}
	
}
