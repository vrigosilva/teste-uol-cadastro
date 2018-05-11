package br.com.uol.teste.cadastrojogadores.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;	
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value="vingadores")
public class Vingadores implements Serializable {

	private static final long serialVersionUID = 9096430371014725398L;
	private List<Vingador> vingadores = new ArrayList<>();
	
	public List<Vingador> getVingadores() {
		return vingadores;
	}
	public void setVingadores(List<Vingador> vingadores) {
		this.vingadores = vingadores;
	}
	@Override
	public String toString() {
		return "Vingadores [vingadores=" + vingadores + "]";
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Vingador{
	private String codinome;

	
	public String getCodinome() {
		return codinome;
	}


	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}


	@Override
	public String toString() {
		return "Vingador [codinome=" + codinome + "]";
	}
	
}