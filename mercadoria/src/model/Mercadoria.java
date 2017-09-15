package model;

import java.io.Serializable;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class Mercadoria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2401288558623919312L;
	
	private int codigo;
	private int idTipo;
	private String dsTipo;
	private String nome;
	private int qnt;
	private double preco;
	private int tipoNegocio;
	
	public Mercadoria(int c, String n, int q, double p, int tn){
		setCodigo(c);
		setNome(n);
		setQnt(q);
		setPreco(p);
		setTipoNegocio(tn);
	}
	
	public Mercadoria(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDsTipo() {
		return dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(int tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	
	public void criar(){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCodigo(codigo);
		to.setIdTipo(idTipo);
		to.setDsTipo(dsTipo);
		to.setNome(nome);
		to.setQnt(qnt);
		to.setPreco(preco);
		to.setTipoNegocio(tipoNegocio);
		dao.criar(to);
	}
}
