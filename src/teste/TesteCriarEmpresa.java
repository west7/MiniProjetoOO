package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import controle.ControleEmpresa;

/**
 * Classe TesteCriarEmpresa testa o metodo criarEmpresa() da classe ControleEmpresa
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see ControleEmpresa
 *
 */
public class TesteCriarEmpresa {
	
	ControleEmpresa c = new ControleEmpresa();

	/**
	 * Checa a funcionalidade do metodo
	 */
	@Test 
	public void checarCriarEmpresaS() {
		
		assertTrue(c.criarEmpresa("Amazon", "EUA", "123123", "amazon@", "Varejo", "resumo", "missao"));
		assertFalse(c.criarEmpresa("", "EUA", "123123", "amazon@", "Varejo", "resumo", "missao"));
		assertFalse(c.criarEmpresa("Amazon", "EUA", "123-59-5", "amazon@", "Varejo", "resumo", "missao"));
	}
}
