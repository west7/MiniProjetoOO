package teste;

import modelo.Dados;
import modelo.Empresa;
import modelo.Vaga;
import view.TelaEscolha;

public class Teste2 {

	public static void main(String[] args) {
	
		Empresa e1 = new Empresa("Amazon", "Brasil", 0001, "Amazon@" );
		Vaga v1 = new Vaga("Teste", (double)10000, "Teste", e1);
		TelaEscolha tela = new TelaEscolha();
		//TelaLoginCandidato tela = new TelaLoginCandidato();
		//TelaCadastroVaga tela = new TelaCadastroVaga();
		//TelaCandidato tela =  new TelaCandidato(new ControleCandidato());
		//Empresa empresa = new Empresa("Amazon", "Brasil", 0001, "amazon@gmail");
		//ControleEmpresa controle = new ControleEmpresa();
		//controle.criarEmpresa("Amazon", "EUA", 0123, "amazon@", "ecommerce", "resumo", "missao");
		//TelaEmpresa tela = new TelaEmpresa(controle);
		
	}
}
