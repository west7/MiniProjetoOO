package teste;

import view.*;
import modelo.*;

public class Teste2 {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa("Amazon", "Brasil", 0001, "amazon@gmail");
	
		//TelaEscolha tela = new TelaEscolha();
		//TelaLoginCandidato tela = new TelaLoginCandidato();
		//CadastroVaga tela = new CadastroVaga();
		//TelaVaga tela =  new TelaVaga();
		TelaEmpresa tela = new TelaEmpresa(empresa);
		
	}
}
