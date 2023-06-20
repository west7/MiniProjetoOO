package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.ControleCandidato;

public class TesteCriarCandidato {

	ControleCandidato c = new ControleCandidato();
	
	@Test
	public void checarCriarCandidato() {
		
		assertTrue(c.criarCandidato("Guilherme","Brazil", 0, "Guilherme@", "habilidades", "formacao", "cargo"));
		assertFalse(c.criarCandidato("","", 0, "Guilherme@", "habilidades", "formacao", "cargo"));
	}
}