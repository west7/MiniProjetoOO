package modelo;

import java.util.ArrayList;

public class Dados {

	private static ArrayList<Empresa> empresas = new ArrayList<>();
	private static ArrayList<Candidato> candidatos = new ArrayList<>();
	private static  ArrayList<Vaga> vagas = new ArrayList<>();
	
	public static ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	/*
	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}*/
	
	public static ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	/*
	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}*/
	
	public static ArrayList<Vaga> getVagas() {
		return vagas;
	}
	/*
	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	*/
	public static void adicionarEmpresa(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public static void removerEmpresa(Empresa empresa) {
		empresas.remove(empresa);
	}
	
	public static void adicionarCandidato(Candidato candidato) {
		candidatos.add(candidato);
	}
	
	public static void removerCandidato(Candidato candidato) {
		candidatos.remove(candidato);
	}
	
	public static void adicionarVaga(Vaga vaga) {
		vagas.add(vaga);
	}
	
	public static void removerVaga(Vaga vaga) {
		vagas.remove(vaga);
	}
	
	public static Vaga listagemVagas() {
		for(Vaga v : vagas) {
			return v;
		}
		return null;
	}
	
}
