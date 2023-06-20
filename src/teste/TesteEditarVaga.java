package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controle.ControleEmpresa;
import modelo.Vaga;

public class TesteEditarVaga {

	ControleEmpresa c = new ControleEmpresa();
	
	@Test
	public void checarEditarVaga() {
		
		Vaga v1 = new Vaga("funcao", 10000.0, "req");
		
		String salarioCorreto = "5000.0";
		String salarioErrado = "5000,0";

		assertTrue(c.editarVaga(v1, "funcao", salarioCorreto, "req"));
		assertFalse(c.editarVaga(v1, "funcao", salarioErrado, "req"));
	}
}
