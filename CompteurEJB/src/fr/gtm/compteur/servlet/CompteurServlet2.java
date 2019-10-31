package fr.gtm.compteur.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.compteur.Compteur;

/**
 * Servlet implementation class CompteurServlet
 */
@WebServlet("/CompteurServlet2")
public class CompteurServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private Compteur compteur;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		compteur.incrementer();
		//On remet le setAttribute
		request.getSession().setAttribute("compteur", compteur);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
