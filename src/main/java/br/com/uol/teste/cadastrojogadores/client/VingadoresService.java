package br.com.uol.teste.cadastrojogadores.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VingadoresService implements Buscavel{

	
	public Vingadores getVingadores() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
		restTemplate.getMessageConverters().add(0, converter);
		Vingadores vingadores = restTemplate.getForObject(fooResourceUrl, Vingadores.class);
		return vingadores;
	}

	@Override
	public List<String> buscaListaCodinome() {
		List<String> retorno =  new ArrayList<>();
		
		List<Vingador> vingadores = getVingadores().getVingadores();
		vingadores.forEach(i -> retorno.add(i.getCodinome()));
		
		return retorno;
	}

}
