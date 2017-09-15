package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.MercadoriaTO;

public class MercadoriaDAO {
	
	public void criar(MercadoriaTO to){
		String sql = "INSERT INTO mercadoria (nomeMercadoria, tipoMercadoria, qntMercadoria, precoMercadoria, tipoNegocio) VALUES (?,?,?,?,?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, to.getNome());
			ps.setInt(2, to.getIdTipo());
			ps.setInt(3, to.getQnt());
			ps.setDouble(4, to.getPreco());
			ps.setInt(5, to.getTipoNegocio());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<MercadoriaTO> listar(){
		String sql = "SELECT * FROM mercadoria INNER JOIN tipo_mercadoria WHERE idTipo = tipoMercadoria";
		ArrayList<MercadoriaTO> lista = new ArrayList<MercadoriaTO>();
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()){
					MercadoriaTO to = new MercadoriaTO();
					to.setCodigo(rs.getInt("idMercadoria"));
					to.setIdTipo(rs.getInt("tipoMercadoria"));
					to.setDsTipo(rs.getString("dsTipo"));
					to.setNome(rs.getString("nomeMercadoria"));
					to.setQnt(rs.getInt("qntMercadoria"));
					to.setPreco(rs.getDouble("precoMercadoria"));
					to.setTipoNegocio(rs.getInt("tipoNegocio"));
					lista.add(to);
				}
			}catch(Exception e){
			e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	public ArrayList<MercadoriaTO> listarMercadoriasVenda(){
		String sql = "SELECT * FROM mercadoria WHERE tipoNegocio = 2";
		ArrayList<MercadoriaTO> lista = new ArrayList<MercadoriaTO>();
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()){
					MercadoriaTO to = new MercadoriaTO();
					to.setCodigo(rs.getInt("idMercadoria"));
					to.setNome(rs.getString("nomeMercadoria"));
					to.setIdTipo(rs.getInt("tipoMercadoria"));
					to.setQnt(rs.getInt("qntMercadoria"));
					to.setPreco(rs.getDouble("precoMercadoria"));
					to.setTipoNegocio(rs.getInt("tipoNegocio"));
					lista.add(to);
				}
			}catch(Exception e){
			e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
}