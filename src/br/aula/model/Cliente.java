package br.aula.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="CAD_CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue
	@Column(name = "cli_id")
	private Long idCliente;
	
	@Column(name = "cli_nome", nullable = true, length = 100)
	private String nome;
	
	@Column(name = "cli_endereco", nullable = true, length = 200)
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "cli_data", nullable = true)
	private Date dataNascimento;
	
	@Transient
	private int idade;
	
	@Lob
	@Column(name = "cli_conteudo", nullable = true)
	private String conteudo;
	
	@Column(name = "cli_email", nullable = true, length = 200)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
