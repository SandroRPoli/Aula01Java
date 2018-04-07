package br.aula.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "titulo", nullable = true, length = 45)
	private String titulo;
	
	@Column(name = "foto", nullable = true, length = 200)
	private String foto;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	// relacionamento com o campo id da tabela autor
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	
	// relacionamento com o campo id_autor
	@OneToMany(mappedBy = "livro")
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> emprestimo = new ArrayList<>();
	

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}