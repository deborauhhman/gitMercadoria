package service;

import java.util.ArrayList;

import dao.OperacaoDAO;
import to.OperacaoTO;

public class OperacaoService {
	
	public void criar(OperacaoTO to){
		OperacaoDAO o = new OperacaoDAO();
		o.criarOp(to);
	}
	
	public ArrayList<OperacaoTO> listar(){
		ArrayList<OperacaoTO> lista = new ArrayList<OperacaoTO>();
		OperacaoDAO dao = new OperacaoDAO();
		lista = dao.listar();
		return lista;
	}
}
