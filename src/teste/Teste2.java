package teste;

import modelo.Candidato;
import modelo.Empresa;
import modelo.Vaga;

public class Teste2 {

	public static void main(String[] args) {
		Empresa empresa1 = new Empresa("Google","EUA",1234);
		Vaga vaga1 = empresa1.abrirVaga("Java Developer",2000.0,"ingles");
		System.out.println(vaga1.getSalario());
		Candidato candidato1 = new Candidato("Lucas", "Brasil", 4321, "lucas@gmail");
		candidato1.inscrever(vaga1);
		candidato1.verInscricoes();
		System.out.println("///");
		empresa1.excluirVaga(vaga1);
		System.out.println(vaga1.getSalario());
		candidato1.verInscricoes();
		System.out.println("///");
		System.out.println(candidato1.getEmail());
	}

}
