package br.com.sp.senai.findjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "cadastroDeVagas")
public class CadastroDeVagas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
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
	public CadastroDeVagas(long id,  String titulo,String exigencia, String descricao, String desejavel, String telefone, String email, String areaVaga) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.exigencia = exigencia;
		this.telefone = telefone;
		this.email = email;
		this.areaVaga = areaVaga;
	}
	

	
	
}
