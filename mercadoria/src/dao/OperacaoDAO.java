package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.OperacaoTO;

public class OperacaoDAO {
	
	public void criarOp (OperacaoTO to){
		String sql = "INSERT INTO operacao (idTipoNegocio, idMercadoria, qntMercadoria, dataeHora, vl_total) VALUES (?,?,?,?,?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
					ps.setInt(1, to.getIdTipoNegocio());
					ps.setInt(2, to.getIdMercadoria());
					ps.setInt(3, to.getQntMercadoria());
					ps.setString(4, to.getData());
					ps.setDouble(5, to.getVl_total());
					ps.execute();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public ArrayList<OperacaoTO> listar(){
		ArrayList<OperacaoTO> lista = new ArrayList<OperacaoTO>();
		String sql = "SELECT * FROM operacao o INNER JOIN mercadoria m ON o.idMercadoria = m.idMercadoria INNER JOIN tipo_negocio n ON o.idTipoNegocio = n.idTipoNegocio";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()){
					OperacaoTO to = new OperacaoTO();
					to.setIdOperacao(rs.getInt("idOperacao"));
					to.setDsTipoNegocio(rs.getString("idTipoNegocio"));
					to.setIdMercadoria(rs.getInt("idMercadoria"));
					to.setQntMercadoria(rs.getInt("qntMercadoria"));
					to.setData(rs.getString("dataeHora"));
					to.setVl_total(rs.getDouble("vl_total"));
					to.setNomeMercadoria("nomeMercadoria");
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
