package br.aula.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.aula.db.HibernateFactory;
import br.aula.model.Usuario;
import br.aula.model.Review;
import br.aula.model.Autor;
import br.aula.model.Livro;
import br.aula.model.Emprestimo;

public class TesteIncluirTabela {

	public static void main(String[] args) throws ParseException {
		
		Session s = HibernateFactory
						.configureSessionFactory()
						.openSession();
		
		Usuario usuario = new Usuario();
		usuario.setUsername("Sandro rocha");
		usuario.setEmail("teste@teste");
		usuario.setPassword("1234");
		
		Review review = new Review();
		review.setAvaliacao(1);
		review.setComentario("teste 01");
		
		Autor autor = new Autor();
		autor.setNome("Autor 01");		
		
		Livro livro = new Livro();
		livro.setTitulo("Livro Teste 01");
		livro.setFoto("");
		livro.setQuantidade(1);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");		
		Date dias = format.parse("09/04/2018");

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDataEmprestimo(new Date());
		emprestimo.setDataDevolucao( dias );

		Transaction t = s.beginTransaction();
		
		s.save(usuario);
		s.save(review);
		s.save(autor);
		s.save(livro);
		s.save(emprestimo);
		
		t.commit();
	}
}
