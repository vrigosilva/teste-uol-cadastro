package br.com.uol.teste.cadastrojogadores.controler;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.uol.teste.cadastrojogadores.model.Jogador;
import br.com.uol.teste.cadastrojogadores.model.ListaOrigemEnum;
import br.com.uol.teste.cadastrojogadores.service.JogadorService;

@Controller
public class JogadorControler {

	@Autowired
	JogadorService service;

	
	@RequestMapping("/")
	public String lista(Model model){
		model.addAttribute("jogadores", service.listaJogadores());
		return "lista";
	}
	
	
	@RequestMapping("/jogadorForm")
	public String jogadorForm(Jogador jogador, Model model){
		model.addAttribute("jogador", jogador);
		model.addAttribute("listaOrigem", ListaOrigemEnum.values());
		return "jogadorForm";
	}
	
	@RequestMapping("/salvar")
	public String salvar(@Valid Jogador jogador, BindingResult bindingResult, Model model){
		
        if (!service.salvar(jogador, bindingResult)) {
        	return jogadorForm(jogador, model);
        }
        return "redirect:/";
    }

}
