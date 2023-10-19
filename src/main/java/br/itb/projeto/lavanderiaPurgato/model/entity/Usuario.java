package br.itb.projeto.lavanderiaPurgato.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String email;
	@Column
	private String senha;
	@Column
	private String nivel_acesso;
	@Column
	private String status_Func;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf; 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivel_acesso() {
		return nivel_acesso;
	}
	public void setNivel_acesso(String nivel_Acesso) {
		this.nivel_acesso = nivel_Acesso;
	
	}
	public String getStatus_Func() {
		return status_Func;
	}
	public void setStatus_Func(String status_Func) {
		this.status_Func = status_Func;
	}
	

}
