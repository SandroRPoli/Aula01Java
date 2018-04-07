package br.aula.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.aula.db.HibernateFactory;
import br.aula.model.Cliente;

public class IncluindoCliente {

	public static void main(String[] args) {
		
		Session s = HibernateFactory
						.configureSessionFactory()
						.openSession();

		Cliente cliente = new Cliente();
		cliente.setNome("napoleao bonaparte");
		cliente.setDataNascimento(new Date());
		cliente.setEndereco("bauru");
		cliente.setEmail("teste@teste");

		Transaction t = s.beginTransaction();
		s.save(cliente);
		t.commit();
	}
}
