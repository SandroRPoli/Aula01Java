package br.aula.teste;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;
import br.aula.model.Livro;

public class IncluindoLivro {
	
	public static void main(String[] args) {
		
		Session s = HibernateFactory
						.configureSessionFactory()
						.openSession();
		
		//pega o autor =>			nome , linha
		Autor autor = (Autor) s.get(Autor.class, 2l);
		
		Livro livro = new Livro();
		livro.setTitulo("Livro Teste 04");
		livro.setAutor(autor); // adiciona o id do autor
		livro.setFoto("");
		livro.setQuantidade(1);

		Transaction t = s.beginTransaction();
		s.save(livro);		
		t.commit();
	}
}