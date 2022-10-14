package br.com.sp.senai.findjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cadastroDeVagas")
public class CadastroDeVagas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descricao")
	private String descricao;
	@Column(name="exigencia")
	private String exigencia;
	@Column(name="desejavel")
	private String desejavel;
	@Column(name="telefone")
	private String telefone;
	@Column(name ="email")
	private String email;
	@Column (name="areaVaga")
	private String areaVaga;
	
	public CadastroDeVagas() {
		
	}
	public CadastroDeVagas(Long id,  String titulo, String descricao, String exigencia , String desejavel, String telefone, String email, String areaVaga) {
		// TODO Auto-generated constructor 
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.exigencia = exigencia;
		this.telefone = telefone;
		this.email = email;
		this.areaVaga = areaVaga;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getExigencia() {
		return exigencia;
	}
	public void setExigencia(String exigencia) {
		this.exigencia = exigencia;
	}
	public String getDesejavel() {
		return desejavel;
	}
	public void setDesejavel(String desejavel) {
		this.desejavel = desejavel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaVaga() {
		return areaVaga;
	}
	public void setAreaVaga(String areaVaga) {
		this.areaVaga = areaVaga;
	}

	

	
	

}
