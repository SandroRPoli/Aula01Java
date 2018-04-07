package br.aula.teste;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

import br.aula.db.HibernateFactory;
import br.aula.model.Livro;
import br.aula.model.Autor;

public class ListandoLivros {
	
	public static void main(String[] args) {
		
		Session s = HibernateFactory
						.configureSessionFactory()
						.openSession();
		
		// Listar os livros do autor
		// 							nome , linha
		Autor autor = (Autor) s.get(Autor.class, 1l);		
		List<Livro> livros01 = autor.getLivros();
		for (Livro livro : livros01) {
			System.out.println("Livro: " + livro.getTitulo());
		}
		
		
		// Listar todos os livros por Query
		Query query01 = s.createQuery("from Livro");
		List<Livro> livros02 = query01.list();
		for (Livro livro : livros02) {
			System.out.println("Livro: " + livro.getTitulo());
		}
		
		
		// Listar todos os livros do autor por Query
		Query query02 = s.createQuery("from Livro l where l.autor.id  = :id");
		query02.setLong("id", 2l);
		List<Livro> livros03 = query02.list();
		for (Livro livro : livros03) {
			System.out.println("Livro: " + livro.getTitulo());
		}
		
		
		// Listar todos os livros com o titulo por Query
		Query query03 = s.createQuery("from Livro l where upper(l.titulo) like upper(:busca)");
		query03.setString("busca","%01%");
		List<Livro> livros04 = query03.list();
		for (Livro livro : livros04) {
			System.out.println("Livro: " + livro.getTitulo());
		}
	
	}
}