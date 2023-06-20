package main;

import modelo.Candidato;
import modelo.Dados;
import modelo.Empresa;
import modelo.Vaga;

public class teste {

	public static void main(String[] args) {

		
		Empresa e1 = new Empresa("Amazon", "Brasil", 0001, "amazon@gmail");
		Empresa e2 = new Empresa("Netflix", "EUA", 0002, "netflix@gmail");
		Candidato c1 = new Candidato("Guilherme", "Brasil", 01 , "g@", "dev java");
		Candidato c2 = new Candidato("Lucas", "Brasil", 02, "l@", "dev python");
		
		//Criando Vagas a partir do método abrirVaga()
		Vaga v1 = e1.abrirVaga("Desenvolvedor", 2000.0, "Inglês");
		Vaga v2 = e1.abrirVaga("Desenvolvedor", 1500.0, "Alemão");
		Vaga v3 = e2.abrirVaga("Diretor", 3000.0, "3 anos de experiência com produções gráficas");
		Vaga v4 = e2.abrirVaga("Animador Gráfico", 2500.0, "Sem requisitos");
		
		System.out.println("Todas as vagas de e1 a partir do método verVagas():");
		System.out.println(e1.verVagas());
		System.out.println();
		//Editando vaga a partir do editarVagas()
		e1.editarVaga(v4, null, null, "Curso superior");
		System.out.println();
		System.out.println(e2.verVagas());
		System.out.println();
		//Inscrevendo c1 nas vagas v1 e v2
		c1.inscrever(v1);
		c1.inscrever(v3);
		System.out.println("Vagas em que o c1 está inscrito:");
		System.out.println(c1.verInscricoes());
		System.out.println();
		
		//Excluindo a vaga v1 a partir do método excluirVaga()
		e2.excluirVaga(v1);
		//Desinscrevendo da vaga v3 a partir do método desinscrever()
		c1.desinscrever(v3);
		System.out.println("Após excluir a vaga v1 e se desinscrever da vaga v3, c1 não está mais inscrito em nenhuma delas.");
		System.out.println(c1.verInscricoes());
		System.out.println();
		System.out.println(v1.getCandidatos());
		
		System.out.println("Buscando pela vaga de desenvolvedor");
		System.out.println(c1.buscarVagaPorFuncao("Desenvolvedor"));
		
		System.out.println("Listagem de todas as vagas: ");
		System.out.println(Dados.getVagas());
		
	}

}
