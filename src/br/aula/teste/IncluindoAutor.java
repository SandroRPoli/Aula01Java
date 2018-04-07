package br.aula.teste;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;

public class IncluindoAutor {

	public static void main(String[] args) throws ParseException {
		
		Session s = HibernateFactory
						.configureSessionFactory()
						.openSession();

		Autor autor = new Autor();
		autor.setNome("Autor 01");		

		Transaction t = s.beginTransaction();
		s.save(autor);		
		t.commit();
	}
}