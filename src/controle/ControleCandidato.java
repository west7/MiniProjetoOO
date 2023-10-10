package controle;

import java.util.ArrayList;


import modelo.Candidato;
import modelo.Dados;
import modelo.Vaga;

/**
 * Classe ControleCandidato faz a conexao entre a classe Candidato e as classes da camada view
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Candidato
 * @see ControleDeVaga
 *
 */
public class ControleCandidato {

	private Candidato candidato;
	
	/**
	 * Cria um candidato
	 * @param nome String
	 * @param endereco String
	 * @param cpfStr long
	 * @param email String
	 * @param competencias String
	 * @param formacao String
	 * @param cargo String
	 * @return boolean
	 * @throws Excecao no caso de CPF invalido
	 */
	public boolean criarCandidato(String nome, String endereco, String cpfStr, String email, String competencias,
			String formacao, String cargo) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !cpfStr.isEmpty() && !email.isEmpty()) {
			try {
				long cpf = Long.parseLong(cpfStr);
				candidato = new Candidato(nome, endereco, cpf, email, competencias, formacao, cargo);
				return true;
			} catch (NumberFormatException ex) {
				return false;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * Edita um candidato
	 * @param nome String
	 * @param endereco String
	 * @param cpfStr String
	 * @param email String
	 * @param competencias String
	 * @param formacao String
	 * @param cargo String
	 * @return boolean
	 * @throws Excecao no caso de CPF invalido
	 */
	public boolean editarCandidato(String nome, String endereco, String cpfStr, String email, String competencias,
			String formacao, String cargo) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !cpfStr.isEmpty() && !email.isEmpty()) {
			try {
				long cpf = Long.parseLong(cpfStr);
				candidato.setNome(nome);
				candidato.setEndereco(endereco);
				candidato.setCPF(cpf);
				candidato.setEmail(email);
				candidato.setCompetencias(competencias);
				candidato.setFormacao(formacao);
				candidato.setCargo(cargo);
				return true;
			} catch (NumberFormatException ex) {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public String nomeCandidato() {
		return candidato.getNome();
	}
	public long cpfCandidato() {
		return candidato.getCPF();
	}
	public String enderecoCandidato() {
		return candidato.getEndereco();
	}
	public String emailCandidato() {
		return candidato.getEmail();
	}
	public String competenciasCandidato() {
		return candidato.getCompetencias();
	}
	public String formacaoCandidato() {
		return candidato.getFormacao();
	}
	public String cargoCandidato() {
		return candidato.getCargo();
	}
	
	/**
	 * Inscreve o candidato em uma vaga
	 * @param cVaga ControleDeVaga
	 * @return boolean
	 */
	public boolean inscrever(ControleDeVaga cVaga){
		if (cVaga != null) {
			if (!candidato.getVagas().contains(cVaga.getVaga())) {
				candidato.inscrever(cVaga.getVaga());
				return true;
			}
			
		} 
		return false;
	}
	
	/**
	 * Cancela a incricao de uma candidato em uma vaga
	 * @param cVaga ControleDeVaga
	 * @return boolean
	 */
	public boolean desinscrever(ControleDeVaga cVaga){
		if (cVaga != null) {
			if (candidato.getVagas().contains(cVaga.getVaga())) {
				candidato.desinscrever(cVaga.getVaga());
				return true;
			}
		}
		return false;
	}
	/**
	 * Encontra todas os candidatos
	 * @return ControleCandidato[]
	 */
	public ControleCandidato[] puxarCandidatos() {
		ArrayList<Candidato> candidatos = Dados.getCandidatos();
		ControleCandidato[] candidatosArray = new ControleCandidato[candidatos.size()];
		for (int i=0; i < candidatos.size(); i++) {
			ControleCandidato c = new ControleCandidato();
			c.setCandidato(candidatos.get(i));
			candidatosArray[i] = c;
		}
		return candidatosArray;
	}

	/**
	 * Encontra todas as vagas criadas
	 * @return ControleDeVaga[]
	 */
	public ControleDeVaga[] puxarVagas() {
		ArrayList<Vaga> vagas = Dados.getVagas();
		ControleDeVaga[] arrayVagas = new ControleDeVaga[vagas.size()];
		for (int i=0; i < vagas.size(); i++) {
			//arrayVagas[i] = vagas.get(i);
			ControleDeVaga c = new ControleDeVaga();
			c.setVaga(vagas.get(i));
			arrayVagas[i] = c;
		}
		return arrayVagas;
	}
	/**
	 * Pesquisa as vagas dada a funcao pretendida
	 * @param pesquisa String
	 * @return ControleDeVaga[]
	 */
	public ControleDeVaga[] pesquisarFuncao(String pesquisa) {
		ArrayList<Vaga> busca = candidato.buscarVagaPorFuncao(pesquisa);
		ControleDeVaga[] arrayBusca = new ControleDeVaga[busca.size()];
		for (int i=0; i < busca.size(); i++) {
			ControleDeVaga c = new ControleDeVaga();
			c.setVaga(busca.get(i));
			arrayBusca[i] = c;
		}
		return arrayBusca;
	}
	
	/**
	 * Pesquisa as vagas dado o nome da empresa
	 * @param pesquisa String
	 * @return ControleDeVaga[]
	 */
	public ControleDeVaga[] pesquisarEmpresa(String pesquisa) {
		ArrayList<Vaga> busca = candidato.buscarVagaPorEmpresa(pesquisa);
		ControleDeVaga[] arrayBusca = new ControleDeVaga[busca.size()];
		for (int i=0; i < busca.size(); i++) {
			ControleDeVaga c = new ControleDeVaga();
			c.setVaga(busca.get(i));
			arrayBusca[i] = c;
		}
		return arrayBusca;
	}
	
	/**
	 * Encontra todas as inscricoes do candidato
	 * @return ControleDeVaga[]
	 */
	public ControleDeVaga[] inscricoesCandidato() {
		ArrayList<Vaga> inscricoes = candidato.getVagas();
		ControleDeVaga[] inscricoesArray = new ControleDeVaga[inscricoes.size()];
		for (int i=0; i < inscricoes.size(); i++) {
			ControleDeVaga c = new ControleDeVaga();
			c.setVaga(inscricoes.get(i));
			inscricoesArray[i] = c;
		}
		return inscricoesArray;
	}
	public String toString() {
		return candidato.getNome();
	}

	
	
	
	
}
