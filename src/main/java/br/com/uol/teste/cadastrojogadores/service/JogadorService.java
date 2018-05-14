package br.com.uol.teste.cadastrojogadores.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.uol.teste.cadastrojogadores.client.LigaDaJusticaService;
import br.com.uol.teste.cadastrojogadores.client.VingadoresService;
import br.com.uol.teste.cadastrojogadores.model.Jogador;
import br.com.uol.teste.cadastrojogadores.model.ListaOrigemEnum;
import br.com.uol.teste.cadastrojogadores.repository.JogadorRepository;

@Service
public class JogadorService {
	private static final Logger log = LoggerFactory.getLogger(JogadorService.class);

	
	@Autowired
	JogadorRepository repo;
	
	@Autowired
	VingadoresService vingadoresService;
	
	@Autowired
	LigaDaJusticaService ligaService;
	@Autowired
	LigaDaJusticaService Codino;
	

	public Iterable<Jogador> listaJogadores(){
		Iterable<Jogador> findAll = repo.findAll();
		log.debug(findAll.toString());
		return  findAll;
	}	
	
	
	public boolean salvar(Jogador jogador, BindingResult bindingResult){
		
        if (bindingResult.hasErrors()) {
        	return false;
        }
        String codinome = buscaCodinome(jogador.getOrigem());
		jogador.setCodinome(codinome);
        
		
		if(jogador.getCodinome()== null){
			ObjectError error = new  ObjectError("codinome", "Nao ha codinomes disponiveis");
			bindingResult.addError(error);
			return false;
		}
		
		
		repo.save(jogador);
System.out.println(jogador.getId());
		
        return true;
    }


	private String buscaCodinome(ListaOrigemEnum origem) {
		
		//buscar todos os codnomes cadastrado para essa lista
		List<String> listaCodinomesUsados = repo.findDistinctCodinomeByOrigem(origem);
		
		//buscar todos os codnomes da lista
		List<String> listaTodosCodinomes = origem.getEstrategiaBusca().buscaListaCodinome();
		
		//verificar disponibilidade
		List<String> listaCodinomesDisponiveis = listaTodosCodinomes.stream().filter(i-> !listaCodinomesUsados.contains(i)).collect(Collectors.toList());
		
		if(listaCodinomesDisponiveis.isEmpty()){
			return null;
		}
		
		//retorna codinome aleatorio
		Random r = new Random();
		String codinome = listaCodinomesDisponiveis.get(r.nextInt(listaCodinomesDisponiveis.size()));
		return codinome;
	}
	

	public void teste(){
		System.out.println(vingadoresService.getVingadores());
		System.out.println(ligaService.getLigaDaJustica());
	}	


	public static void main(String[] args) {
		List<String> listaExistente = Arrays.asList("abc", "xyz", "lmn");
		List<String> listapossivel = Arrays.asList("abc", "xyz", "lmn");
	
		List<String> collect = listapossivel.stream().filter(i-> !listaExistente.contains(i)).collect(Collectors.toList());
		
		
		Random r = new Random();
		
		
		System.out.println(collect.size());
		System.out.println(r.nextInt(collect.size()));
	}
}
