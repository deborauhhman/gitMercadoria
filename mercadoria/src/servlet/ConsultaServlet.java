package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperacaoDAO;
import to.OperacaoTO;

public class ConsultaServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8087258929231352398L;
	private ArrayList<OperacaoTO> listaOperacoes;
	
	protected void controleChamada(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			listaOperacoes = new ArrayList<OperacaoTO>();
			obterListaOperacoes();
			request.setAttribute("listaOperacoes", listaOperacoes);
			request.getRequestDispatcher("../operacoes.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro", "erro");
			request.getRequestDispatcher("../operacoes.jsp").forward(request, response);
		}
	}
	
	protected void obterListaOperacoes(){
		try{
			OperacaoDAO dao = new OperacaoDAO();
			listaOperacoes = dao.listar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	controleChamada(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	controleChamada(request, response);
    }
	
}
