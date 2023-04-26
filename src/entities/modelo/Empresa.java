package entities.modelo;

import java.util.ArrayList;

public class Empresa extends Entity{
	
	private String cnpj;
	private String setor;
	private String contato;
	//private ArrayList<Vaga> vagas;
	private ArrayList<Candidato> candidatos;
	
	
	
	public Empresa(String nome, String endereco, long id, ArrayList<Vaga> vagas) {
		super(nome, endereco, id, vagas);
	}


	public Empresa(String nome, String endereco, long id,ArrayList<Vaga> vagas, String cnpj, String setor, String contato) {
		super(nome, endereco, id, vagas);
		this.cnpj = cnpj;
		this.setor = setor;
		this.contato = contato;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	
	public ArrayList<Vaga> getVagas() {
		return vagas;
	}


	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}


	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}


	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}


	public void showCandidatos() {
		for(Vaga v: vagas) {
			ArrayList<Candidato> candidato = v.getCandidatos();
			System.out.println(candidato);
		}
	}
	
	

}
