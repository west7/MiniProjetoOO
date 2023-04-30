package teste;

import entities.modelo.Candidato;
import entities.modelo.Empresa;
import entities.modelo.Vaga;

public class teste {

	public static void main(String[] args) {

		
		Empresa e1 = new Empresa("Amazon", "Brasil", 0001);
		Empresa e2 = new Empresa("Netflix", "EUA", 0002);
		Candidato c1 = new Candidato("Guilherme", "Brasil", 01 , "g@");
		Candidato c2 = new Candidato("Lucas", "Brasil", 02, "l@");
		//Vaga v1 = new Vaga(candidatos);
		//Vaga v2 = new Vaga("Desenvolvedor", 2000.0, "Inglês", e1 );
		
		Vaga v1 = e1.abrirVaga("Desenvolvedor", 2000.0, "Inglês", e1);
		Vaga v2 = e2.abrirVaga("Desenvolvedor", 1500.0, "Alemão", e2);
		c1.inscrever(v1);
		c1.inscrever(v2);
		c1.verInscricoes();
		e2.excluirVaga(v2);
		e1.excluirVaga(v1);
		System.out.println();
		c1.verInscricoes();
		
		//e1.verVagas();
		//e1.excluirVaga(v1);
		//c1.verInscricoes();
		
	
		
	}

}
