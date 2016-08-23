package br.com.techgold.configuracao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.techgold.dao.EmailDao;
import br.com.techgold.modelo.Email;

public class TesteDeConfiguracaoDeEmail {

	@Test
	public void testeSeExistePeloMenosUmEmailConfigurado(){
		
		EmailDao dao = new EmailDao();
		
		List<Email> emails = dao.listaEmailConfig();
		
		assertEquals(1,emails.size());
		
	}
}
