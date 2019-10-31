package fr.gtm.compteur;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	private static final Logger LOG = Logger.getLogger("demo");
    /**
     * Default constructor. 
     */
    public SessionListener() {
       
    	
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         session.setMaxInactiveInterval(60*1);
         LOG.info(">>> création de la session : "+session.getId());
         
         try {
			InitialContext ctx = new InitialContext();
			Compteur compteur = (Compteur) ctx.lookup("java:app/CompteurEJB/Compteur");
			session.setAttribute("compteur", compteur);
		} catch (NamingException e) {
			LOG.log(Level.SEVERE, "Erreur de création de session",e);
		}
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session =  se.getSession();
    	LOG.info(">>> destruction de la session : "+session.getId());
    	Compteur compteur = (Compteur) session.getAttribute("compteur");
    	if(compteur != null) {
    		compteur.remove();
    	}
    }
	
}
