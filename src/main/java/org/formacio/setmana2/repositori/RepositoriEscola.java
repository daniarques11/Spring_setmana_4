package org.formacio.setmana2.repositori;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Repository
public class RepositoriEscola {

	@PersistenceContext
	EntityManager em;
	
	public Curs carregaCurs(String nom) {
		return em.find(Curs.class, nom);
	}
	
	public Alumne carregaAlumne(String nom) {
		return em.find(Alumne.class, nom);
	}
	
	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {
		Alumne alumneCarregat = carregaAlumne(alumne);
		Curs cursCarregat = carregaCurs(curs);
		Matricula matriculaCreada = new Matricula();
		matriculaCreada.setAlumne(alumneCarregat);
		matriculaCreada.setCurs(cursCarregat);
		em.persist(matriculaCreada);
	    return matriculaCreada;	
	}
	
	
}
