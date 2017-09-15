package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class CompraServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8087258929231352398L;
	
	private String acao = null;
	private ArrayList<MercadoriaTO> listaMercadorias;
	
	protected void controleChamada(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			listaMercadorias = new ArrayList<MercadoriaTO>();
			acao = request.getParameter("acao");
			if(acao.equalsIgnoreCase("") || acao == null){
				try{
					obterListaMercadoria();
					request.setAttribute("listaMercadorias", listaMercadorias);
					request.getRequestDispatcher("../compra.jsp").forward(request, response);
				}catch(Exception e){
					request.setAttribute("erro", "erro");
					request.getRequestDispatcher("../compra.jsp").forward(request, response);
				}
			}
			else if(acao.equalsIgnoreCase("fimCompra")){
					request.setAttribute("erro", "erro");
					request.getRequestDispatcher("../compra.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro", "erro");
			request.getRequestDispatcher("../compra.jsp").forward(request, response);
		}
	}
	
	protected void obterListaMercadoria(){
		MercadoriaDAO dao = new MercadoriaDAO();
		listaMercadorias = dao.listarMercadoriasVenda();
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
