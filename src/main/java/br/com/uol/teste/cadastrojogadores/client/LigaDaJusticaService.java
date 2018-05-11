package br.com.uol.teste.cadastrojogadores.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LigaDaJusticaService  implements Buscavel{

	
	public Liga_da_justica getLigaDaJustica() {
		MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML));
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
		restTemplate.getMessageConverters().add(0, converter);
		Liga_da_justica liga = restTemplate.getForObject(fooResourceUrl, Liga_da_justica.class);
		return liga;
	}

	@Override
	public List<String> buscaListaCodinome() {
		Liga_da_justica liga = getLigaDaJustica();
		return liga.getCodinome();
	}

}
