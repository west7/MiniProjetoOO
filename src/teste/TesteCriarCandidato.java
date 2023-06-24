package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.ControleCandidato;

/**
 * Classe TesteCriarCandidato testa o metodo criarCandidato() da classe ControleCandidato
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see ControleCandidato
 *
 */
public class TesteCriarCandidato {

	ControleCandidato c = new ControleCandidato();
	/**
	 * Checa a funcionalidade do metodo
	 */
	@Test
	public void checarCriarCandidato() {
		
		assertTrue(c.criarCandidato("Guilherme","Brazil", "124124", "Guilherme@", "habilidades", "formacao", "cargo"));
		assertFalse(c.criarCandidato("","", "124124", "Guilherme@", "habilidades", "formacao", "cargo"));
	}
}
