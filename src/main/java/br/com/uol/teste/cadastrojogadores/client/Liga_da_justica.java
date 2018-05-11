package br.com.uol.teste.cadastrojogadores.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


//class Liga_da_justica {
//    @JacksonXmlElementWrapper(localName = "codinomes")
//    private List codinome;
//}

@XmlRootElement (name = "liga_da_justica")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liga_da_justica implements Serializable {

	private static final long serialVersionUID = -4990331330137155878L;

	@JacksonXmlElementWrapper(localName = "codinomes")
	private List<String> codinome = new ArrayList<>();
	
	public List<String> getCodinome() {
		return codinome;
	}
	public void setCodinome(List<String> codinome) {
		this.codinome = codinome;
	}
	
	@Override
	public String toString() {
		return "Liga_da_justica [codinome=" + codinome + "]";
	}
	
}

