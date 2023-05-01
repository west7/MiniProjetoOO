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
		
		//Criando Vagas a partir do método abrirVaga()
		Vaga v1 = e1.abrirVaga("Desenvolvedor", 2000.0, "Inglês");
		Vaga v2 = e1.abrirVaga("Desenvolvedor", 1500.0, "Alemão");
		Vaga v3 = e2.abrirVaga("Diretor", 3000.0, "3 anos de experiência com produções gráficas");
		Vaga v4 = e2.abrirVaga("Animador Gráfico", 2500.0, "Sem requisitos");
		
		System.out.println("Todas as vagas de e1 a partir do método verVagas():");
		e1.verVagas();
		System.out.println();
		
		//Inscrevendo c1 nas vagas v1 e v2
		c1.inscrever(v1);
		c1.inscrever(v3);
		System.out.println("Vagas em que o c1 está inscrito:");
		c1.verInscricoes();
		System.out.println();
		
		//Excluindo a vaga v1 a partir do método excluirVaga()
		e2.excluirVaga(v1);
		//Desinscrevendo da vaga v3 a partir do método desinscrever()
		c1.desinscrever(v3);
		System.out.println("Após excluir a vaga v1 e se desinscrever da vaga v3, c1 não está mais inscrito em nenhuma delas.");
		c1.verInscricoes();
		System.out.println();
		
	}

}
