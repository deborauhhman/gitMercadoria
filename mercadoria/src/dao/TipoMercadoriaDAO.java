package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.TipoMercadoriaTO;

public class TipoMercadoriaDAO {
	
	public ArrayList<TipoMercadoriaTO> listar(){
		ArrayList<TipoMercadoriaTO> lista = new ArrayList<TipoMercadoriaTO>();
		String sql = "SELECT * FROM tipo_mercadoria;";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()){
					TipoMercadoriaTO to = new TipoMercadoriaTO();
					to.setIdTipoMercadoria(rs.getInt("idTipo"));
					to.setDsTipoMercadoria(rs.getString("dsTipo"));
					lista.add(to);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
}
