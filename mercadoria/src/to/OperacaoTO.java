package to;

public class OperacaoTO {
	private int idOperacao;
	private int idTipoNegocio;
	private String dsTipoNegocio;
	private int idMercadoria;
	private int qntMercadoria;
	private String data;
	private String nomeMercadoria;
	private double vl_total;
	
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
	public String getNomeMercadoria() {
		return nomeMercadoria;
	}
	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}
}
