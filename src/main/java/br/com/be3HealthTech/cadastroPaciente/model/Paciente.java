package br.com.be3HealthTech.cadastroPaciente.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Aviso! o número do prontuário é obrigatório")
	private long numeroProntuario;
	
	@Column(unique=true)//único
	private String cpf;

	@NotNull(message = "Aviso! é obrigatório um nome")
	@Size(min = 2, max = 255, message = "O nome deve ter no mínimo 2 e no máximo 255 caracteres")
	private String nome;
	
	@NotNull(message = "Aviso! é obrigatório um nome")
	@Size(min = 2, max = 255, message = "O sobrenome deve ter no mínimo 2 e no máximo 255 caracteres")
	private String sobrenome;
	
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O atributo Data de Nascimento é Obrigatório!")
	private Date dataNascimento;

	private String genero;
	
	@NotNull
	private String rg;
	
	private String email;
	
	private long telefone;
	
	private long celular;
	
	
	@ManyToOne
	@JsonIgnoreProperties("convenio")
	private Convenio convenio;
	
	//getters and setters

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getNumeroProntuario() {
		return numeroProntuario;
	}


	public void setNumeroProntuario(long numeroProntuario) {
		this.numeroProntuario = numeroProntuario;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getTelefone() {
		return telefone;
	}


	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}


	public long getCelular() {
		return celular;
	}


	public void setCelular(long celular) {
		this.celular = celular;
	}


	public Convenio getConvenio() {
		return convenio;
	}


	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}


			
}
