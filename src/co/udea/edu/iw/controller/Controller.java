package co.udea.edu.iw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 * @author LUIS FERNANDO OROZCO
 * @version 26/04/2016
 */
@WebServlet("/Controller")//url a la cual responde el servlet
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out;
		out = response.getWriter();
		out.append("<h1>hola mundo</h1>"); //se ve en el navegador, se manda codigo html
		System.out.println("Hola mundo"); //se ve en la consola pero no en el navegador
		
	}

}
