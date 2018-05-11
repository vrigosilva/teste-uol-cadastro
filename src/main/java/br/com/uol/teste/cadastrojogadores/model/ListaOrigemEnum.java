package br.com.uol.teste.cadastrojogadores.model;

import br.com.uol.teste.cadastrojogadores.client.Buscavel;
import br.com.uol.teste.cadastrojogadores.client.LigaDaJusticaService;
import br.com.uol.teste.cadastrojogadores.client.VingadoresService;

public enum ListaOrigemEnum{
	VINGADORES("Vingadores", new VingadoresService()), 
	LIGA("Liga da Justiça", new LigaDaJusticaService());

	private String descricao;
	private Buscavel estrategiaBusca;
	
	ListaOrigemEnum(String descricao, Buscavel estrategiaBusca){
		this.descricao = descricao;
		this.estrategiaBusca = estrategiaBusca;
		
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	public Buscavel getEstrategiaBusca(){
		return this.estrategiaBusca;
	}
}
