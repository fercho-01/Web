package co.udea.edu.iw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;

/**
 * Este servlet muestra en una tabla atravez de un navegador web la lista de clientes registrados en el sistema
 * @author LUIS FERNANDO OROZCO
 * @version 28/04/2016
 */
@WebServlet("/CtrlListaUsuarios")
public class CtrlListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteService clienteService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlListaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> lista = null;
		PrintWriter out = response.getWriter();
		try {
			out.print("<table border='1'>");
			out.print("<tr>"); //agregar una fila a la tabla
			out.print("<th>Cedula</th>"); //agregar una celda de header
			out.print("<th>Nombre completo</th>");
			out.print("<th>Correo</th>");
			out.print("</tr>");
			
			lista=clienteService.obtener();
			for(Cliente cliente:lista){
				out.print("<tr>");
				out.print("<td>"+cliente.getCedula()+"</td>");
				out.print("<td>"+cliente.getNombres()+"</td>");
				out.print("<td>"+cliente.getCorreoElectronico()+"</td>");
				out.print("</tr>");
			}
			out.println("</table>");
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		clienteService = (ClienteService)ac.getBean("clienteService");
	}
}
