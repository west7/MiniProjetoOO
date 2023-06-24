package modelo;

import java.util.ArrayList;

/**
 * Classe Dados armazena todos os objetos instanciados simulando um banco de dados
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 */
public class Dados {

	private static ArrayList<Empresa> empresas = new ArrayList<>();
	private static ArrayList<Candidato> candidatos = new ArrayList<>();
	private static  ArrayList<Vaga> vagas = new ArrayList<>();
	
	/**
	 * Metodo instacia algumas empresas e vagas para simular o banco de dados
	 * 
	 */
	public static void preencherDados(){
        Empresa e1 = new Empresa("Google", "EUA - Califórnia", 0003, "google@gmail", "Tecnologia", "Resumo", "Missao");
		Empresa e2 = new Empresa("Facebook", "EUA - Califórnia", 0004, "facebook@gmail", "Internet", "Resumo", "Missao");
		Empresa e3 = new Empresa("Amazon", "EUA - Washington", 0005, "amazon@gmail", "Comércio", "Resumo", "Missao");
		Empresa e4 = new Empresa("Netflix", "EUA - Califórnia", 0006, "netflix@gmail", "Streaming", "Resumo", "Missao");
		Empresa e5 = new Empresa ("CNN Brasil", "Brasil - São Paulo", 0007, "cnn@gmail", "Televisivo", "Resumo", "Missao");
		e1.abrirVaga("Analista de Sistemas", 2000.0, "Inglês");
		e1.abrirVaga("Gerente de Projetos", 1500.0, "Alemão");
		e1.abrirVaga("Desenvolvedor Junior Java", 1000.0, "Ensino médio completo");
		e1.abrirVaga("Cientista de dados", 10000.0, "10 anos de experiência");
		e1.abrirVaga("Web designer", 5000.0, "Experiência com Figma");
		e1.abrirVaga("Desenvolvedor Frontend", 3000.0, "Angular e node.js");
		e2.abrirVaga("Desenvolvedor Senior Java", 5000.0, "20 anos de experiância");
		e5.abrirVaga("Redator", 2000.0, "");
		e5.abrirVaga("Repórter", 8000.0, "5 anos de experiência");
		
    }
	
	public static ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	
	public static ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public static ArrayList<Vaga> getVagas() {
		return vagas;
	}
	
	/**
	 * Adiciona uma empresa ao banco de dados
	 * @param empresa Empresa
	 */
	public static void adicionarEmpresa(Empresa empresa) {
		empresas.add(empresa);
	}
	
	/**
	 * Remove uma empresa do banco de dados
	 * @param empresa Empresa
	 */
	public static void removerEmpresa(Empresa empresa) {
		empresas.remove(empresa);
		for (int i=0; i < empresa.getVagas().size(); i++) {
			empresa.excluirVaga(empresa.getVagas().get(i));			
			removerVaga(empresa.getVagas().get(i));
		}
	}
	/**
	 * Adiciona um candidato ao banco de dados
	 * @param candidato Candidato
	 */
	public static void adicionarCandidato(Candidato candidato) {
		candidatos.add(candidato);
	}
	/**
	 * Remove um candidato do banco de dados
	 * @param candidato Candidato
	 */
	public static void removerCandidato(Candidato candidato) {
		candidatos.remove(candidato);
	}
	/**
	 * Adiciona uma vaga ao banco de dados
	 * @param vaga Vaga
	 */
	public static void adicionarVaga(Vaga vaga) {
		vagas.add(vaga);
	}
	/**
	 * Remove uma vaga do banco de dados
	 * @param vaga Vaga
	 */
	public static void removerVaga(Vaga vaga) {
		vagas.remove(vaga);
	}
	
	
}
