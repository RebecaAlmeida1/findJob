package br.com.sp.senai.findjob.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome", length = 200, nullable = true)
	private String nome;
	@Column(name = "email", length = 100, nullable = true)
	private String email;
	@Column(name = "matricula", length = 50, nullable = true)
	private String matricula;
	@Column(name = "cpf", length = 50, nullable = true)
	private String cpf;
	@Column(name = "datanasc", columnDefinition = "DATE", nullable = true)
	private Date datanasc;
	@Column(name = "estadocivil", length = 15, nullable = true)
	private String estadoCivil;
	@Column(name = "cep", length = 50, nullable = true)
	private String cep;
	@Column(name = "endereco", length = 100, nullable = true)
	private String endereco;
	@Column(name = "numero", length = 10, nullable = true)
	private String numero;
	@Column(name = "complemento", length = 15, nullable = true)
	private String complemento;
	@Column(name = "bairro", length = 50, nullable = true)
	private String bairro;
	@Column(name = "cidade", length = 50, nullable = true)
	private String cidade;
	@Column(name = "uf", length = 10, nullable = true)
	private String uf;
	@Column(name = "telefone", length = 15, nullable = true)
	private String telefone;
	@Column(name = "celular", length = 15, nullable = true)
	private String celular;
	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;

	
}