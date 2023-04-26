package entities.modelo;

import java.util.ArrayList;

public class Vaga {

	private String funcao;
	private Double salario;
	private String requisitos;
	private Empresa empresa;
	private ArrayList<Candidato> candidatos;
	
	public Vaga(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	

	public Vaga(String funcao, Double salario, String requisitos, Empresa empresa) {
		super();
		this.funcao = funcao;
		this.salario = salario;
		this.requisitos = requisitos;
		this.empresa = empresa;
	}
	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public void addCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	public void removeCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

	
}