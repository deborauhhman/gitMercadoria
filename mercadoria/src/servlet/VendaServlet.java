package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoMercadoriaDAO;
import service.MercadoriaService;
import service.OperacaoService;
import to.MercadoriaTO;
import to.OperacaoTO;
import to.TipoMercadoriaTO;

public class VendaServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8087258929231352398L;
	
	private String acao = null;
	private ArrayList<TipoMercadoriaTO> listaTiposMercadoria;
	
	protected void controleChamada(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			listaTiposMercadoria = new ArrayList<TipoMercadoriaTO>();
			acao = request.getParameter("acao");
			if(acao.equalsIgnoreCase("") || acao == null){
				try{
					obterListaTipoMercadoria();
					request.setAttribute("listaTiposMercadoria", listaTiposMercadoria);
					request.getRequestDispatcher("../venda.jsp").forward(request, response);
				}catch(Exception e){
					request.setAttribute("erro", "erro");
					request.getRequestDispatcher("../venda.jsp").forward(request, response);
				}
			}
			else if(acao.equalsIgnoreCase("fimVenda")){
				try{
					OperacaoService os = new OperacaoService();
					OperacaoTO ot = new OperacaoTO();
					MercadoriaTO mt = new MercadoriaTO();
					MercadoriaService ms = new MercadoriaService();
					mt.setNome((String)request.getAttribute("inMercadoria"));
					mt.setIdTipo((Integer)(request.getAttribute("tipoMercadoria")));
					mt.setQnt((Integer)request.getAttribute("inQuantidade"));
					mt.setPreco((Double)request.getAttribute("inPreco"));
					ms.criar(mt);
					request.setAttribute("sucesso", "sucesso");
					request.getRequestDispatcher("../venda.jsp").forward(request, response);
				}catch(Exception e){
					request.setAttribute("erro", "erro");
					request.getRequestDispatcher("../venda.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro", "erro");
			request.getRequestDispatcher("../venda.jsp").forward(request, response);
		}
	}
	
	protected void obterListaTipoMercadoria(){
		TipoMercadoriaDAO dao = new TipoMercadoriaDAO();
		listaTiposMercadoria = dao.listar();
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
