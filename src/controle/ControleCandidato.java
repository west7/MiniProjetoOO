package controle;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Candidato;
import modelo.Dados;
import modelo.Vaga;

public class ControleCandidato {

	private Candidato candidato;
	
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
	/*
	public void inscrever(Vaga vaga){
		if (!candidato.getVagas().contains(vaga) && vaga != null) {
			candidato.inscrever(vaga);			
		}
	}*/
	public boolean inscrever(ControleDeVaga cVaga){
		if (cVaga != null) {
			if (!candidato.getVagas().contains(cVaga.getVaga())) {
				candidato.inscrever(cVaga.getVaga());
				return true;
			}
			
		} 
		return false;
	}
	public boolean desinscrever(ControleDeVaga cVaga){
		if (cVaga != null) {
			if (candidato.getVagas().contains(cVaga.getVaga())) {
				candidato.desinscrever(cVaga.getVaga());
				return true;
			}
		}
		return false;
	}

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
	/*
	public ControleDeVaga[] pesquisar(String pesquisa) {
		ArrayList<Vaga> busca;
		ControleDeVaga[] arrayBusca = puxarVagas();
		ControleDeVaga c;
		if (pesquisa.isEmpty()) {
			arrayBusca = puxarVagas();
		} else if (!pesquisa.isEmpty()) {
			if (candidato.buscarVagaPorFuncao(pesquisa).size() > 0) {
				busca = candidato.buscarVagaPorEmpresa(pesquisa);
				arrayBusca = new ControleDeVaga[busca.size()];
				for (int i=0; i < busca.size(); i++) {
					c = new ControleDeVaga();
					c.setVaga(busca.get(i));
					arrayBusca[i] = c;
				}
			} else {
				busca = candidato.buscarVagaPorEmpresa(pesquisa);
				arrayBusca = new ControleDeVaga[busca.size()];
				for (int i=0; i < busca.size(); i++) {
					c = new ControleDeVaga();
					c.setVaga(busca.get(i));
					arrayBusca[i] = c;
				}
			}
		}
		return arrayBusca;
	}*/
	
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

	
	
	
	
}
