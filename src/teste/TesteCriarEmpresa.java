package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleEmpresa;

public class TesteCriarEmpresa {
	
	ControleEmpresa c = new ControleEmpresa();

	@Test 
	public void checarCriarEmpresaS() {
		
		assertTrue(c.criarEmpresa("Amazon", "EUA", 1, "amazon@", "Varejo", "resumo", "missao"));
		assertFalse(c.criarEmpresa("", "EUA", 1, "amazon@", "Varejo", "resumo", "missao"));
	}
}
