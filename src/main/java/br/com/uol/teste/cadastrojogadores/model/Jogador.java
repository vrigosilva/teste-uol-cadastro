package br.com.uol.teste.cadastrojogadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

@Entity
@Table(name="JOGADOR")
public class Jogador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotEmpty 
	@Size(max=50)
	private String name;
	
	@Column
	@NotEmpty 
	@Email
	@Size(max=50)
	private String email;
	
	@Column
	private String fone;
	
	@Column
	private String codinome;

	@Column
	@NotNull
	private ListaOrigemEnum origem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public ListaOrigemEnum getOrigem() {
		return origem;
	}
	public void setOrigem(ListaOrigemEnum origem) {
		this.origem = origem;
	}
	public String getCodinome() {
		return codinome;
	}
	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}
	@Override
	public String toString() {
		return "Jogador [id=" + id + ", name=" + name + ", email=" + email + ", fone=" + fone + ", codinome=" + codinome
				+ ", origem=" + origem + "]";
	}
	
}
