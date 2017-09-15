package model;

import java.io.Serializable;

public class TipoMercadoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8237358286518961445L;
	
	private int idTipoMercadoria;
	private String dsTipoMercadoria;
	
	public int getIdTipoMercadoria() {
		return idTipoMercadoria;
	}
	public void setIdTipoMercadoria(int idTipoMercadoria) {
		this.idTipoMercadoria = idTipoMercadoria;
	}
	public String getDsTipoMercadoria() {
		return dsTipoMercadoria;
	}
	public void setDsTipoMercadoria(String dsTipoMercadoria) {
		this.dsTipoMercadoria = dsTipoMercadoria;
	}

}
