package modelo;

import java.util.ArrayList;

public class Dados {

	private ArrayList<Empresa> empresas;
	private ArrayList<Candidato> candidatos;
	private ArrayList<Vaga> vagas;
	
	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	public ArrayList<Vaga> getVagas() {
		return vagas;
	}
	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	public void adicionarEmpresa(Empresa empresa) {
		this.empresas.add(empresa);
	}
	
	public void removerEmpresa(Empresa empresa) {
		this.empresas.remove(empresa);
	}
	
	public void adicionarCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	public void removerCandidato(Candidato candidato) {
		this.candidatos.remove(candidato);
	}
	
	public void adicionarVaga(Vaga vaga) {
		this.vagas.add(vaga);
	}
	
	public void removerVaga(Vaga vaga) {
		this.vagas.remove(vaga);
	}
	
	public Vaga listagemVagas() {
		for(Vaga v : vagas) {
			return v;
		}
		return null;
	}
	
}
