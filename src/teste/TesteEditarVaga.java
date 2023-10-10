package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.ControleEmpresa;
import modelo.Vaga;

/**
 * Classe TesteEditarVaga testa o metodo editarVaga da classe ControleEmpresa
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see ControleEmpresa
 *
 */
public class TesteEditarVaga {

	ControleEmpresa c = new ControleEmpresa();
	
	/**
	 * Checa a funcionalidade do metodo
	 */
	@Test
	public void checarEditarVaga() {
		
		Vaga v1 = new Vaga("funcao", 10000.0, "req");
		
		String salarioCorreto = "5000.0";
		String salarioErrado = "5000,0";

		assertTrue(c.editarVaga(v1, "funcao", salarioCorreto, "requisitos"));
		assertFalse(c.editarVaga(v1, "funcao", salarioCorreto, ""));
		assertFalse(c.editarVaga(v1, "funcao", salarioErrado, "requisitos"));
	}
}
