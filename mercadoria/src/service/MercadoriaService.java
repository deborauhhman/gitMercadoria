package service;

import java.util.ArrayList;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class MercadoriaService {
	
	public void criar(MercadoriaTO to){
		MercadoriaDAO dao = new MercadoriaDAO();
		dao.criar(to);
	}
	
	public ArrayList<MercadoriaTO> listar(){
		ArrayList<MercadoriaTO> lista = new ArrayList<MercadoriaTO>();
		MercadoriaDAO dao = new MercadoriaDAO();
		lista = dao.listar();
		return lista;
	}
}
