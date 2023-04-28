package teste;

import java.util.ArrayList;

import entities.modelo.Candidato;
import entities.modelo.Empresa;
import entities.modelo.Vaga;

public class teste {

	public static void main(String[] args) {

		
		//ArrayList<Vaga> vagasEmpresa1 = new ArrayList<>();
		//ArrayList<Vaga> vagasEmpresa2 = new ArrayList<>();
		ArrayList<Candidato> candidatos = new ArrayList<>();
		Empresa e1 = new Empresa("Amazon", "Brasil", 0001);
		Empresa e2 = new Empresa("Netflix", "EUA", 0002);
		Candidato c1 = new Candidato("Guilherme", "Brasil", 01 , "g@");
		Candidato c2 = new Candidato("Lucas", "Brasil", 02, "l@");
		Vaga v1 = new Vaga(candidatos);
		
		v1.addCandidato(c1);
		v1.addCandidato(c2);
		e1.addVaga(v1);
		e1.showCandidatos();
		
	}

}
