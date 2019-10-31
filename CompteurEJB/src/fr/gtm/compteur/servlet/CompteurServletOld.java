///*package fr.gtm.compteur.servlet;
//
//import java.io.IOException;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import fr.gtm.compteur.Compteur;



//Code avant le SessionListener !!!!!!!!!!!

//
///**
// * Servlet implementation class CompteurServlet
// */
//@WebServlet("/CompteurServlet")
//public class CompteurServletOld extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Compteur compteur = (Compteur) session.getAttribute("compteur");
//		
//		if(compteur== null)
//		{
//			try {
//				//Initial context => contexte JNDI du serveur
//				InitialContext ctx = new InitialContext();
//				//recherche de l'ejb par le nom donné par le serveur
//				//=> declenche la construction de l'EJB
//				compteur = (Compteur) ctx.lookup("java:app/CompteurEJB/Compteur");
//				session.setAttribute("compteur", compteur);
//			} catch (NamingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//		compteur.incrementer();
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
//		rd.forward(request, response);	
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
