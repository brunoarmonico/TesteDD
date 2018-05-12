package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.emprestimo.modelo.Usuario;

@RunWith(Parameterized.class)
public class UC10CadastrarUsuarioV2 {

	Usuario usuario;
	
	@Parameter
	public String nome;
	@Parameter (1)
	public String ra;
	@Parameter (2)
	public String resultadoEsperado;
	
	@Before
	public void setup() {
		
		usuario = new Usuario();
	}
	
	@Parameters
	public static Collection<Object[]> dadosdoTeste() {
		
		return Arrays.asList(new Object[][] { 
			
			{ "umNome", "1234", "valido"},
			{ "umNome", "", "RA invalido"},
			{ "", "1234", "Nome invalido"},
			{ null, "1234", "Nome invalido"},
			{ "umNome", null, "RA invalido"}
		});
	}
	@Test
	public void CT01UC10ValidaComportamentoDoCadastroUsuario() {
		
		try {
			usuario.setNome(nome);
			usuario.setRa(ra);
			assertEquals(nome,usuario.getNome());
			assertEquals(ra,usuario.getRa());
			assertTrue(resultadoEsperado.equals("valido"));
		} catch (Exception e) {
			assertTrue(resultadoEsperado.equals(e.getMessage()));
		}
		
	}
}
