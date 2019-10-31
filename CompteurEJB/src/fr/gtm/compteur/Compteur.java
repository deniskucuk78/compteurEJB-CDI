package fr.gtm.compteur;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;




//on enleve : @Stateful
//on enleve :  @StatefulTimeout(unit = TimeUnit.MINUTES, value = 10)
//On remplace le tout par @SessionScoped et on ajoute Serializable (car en EJB simple cela fonctionnait meme sans le @Serializable) :

@SessionScoped
public class Compteur {
	private int value;
	private static final Logger LOG = Logger.getLogger("demo");
	
	public Compteur() {
		LOG.info("Compteur - Constructeur");
	}
	
	
	@PostConstruct
	public void postConstruct() {
		LOG.info("Compteur - @PostConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		LOG.info("Compteur - @PostDestroy");
	}
	
	@Remove
	public void remove() {
		LOG.info("Compteur - remove() : "+this);
	}
	
	
	public int getValue()
	{
		return value;
	}
	
	public void incrementer() {
		value++;
	}

}
