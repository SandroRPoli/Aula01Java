package br.aula.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "username", nullable = true, length = 45)
	private String username;
	
	@Column(name = "cli_email", nullable = true, length = 200)
	private String email;
	
	@Column(name = "passaword", nullable = true, length = 45)
	private String password;
	
	
	// relacionamento com o campo id_usuario
	@OneToMany(mappedBy = "usuario")
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Emprestimo> emprestimo = new ArrayList<>();
	

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}