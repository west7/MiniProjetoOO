package controle;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Candidato;
import modelo.Dados;
import modelo.Vaga;

public class ControleCandidato {

	private Candidato candidato;
	
	public boolean criarCandidato(String nome, String endereco, long id, String email, String habilidades,
			String formacao, String cargo) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !email.isEmpty()) {
			candidato = new Candidato(nome, endereco, id, email, habilidades, formacao, cargo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean editarCandidato(String nome, String endereco, long id, String email, String habilidades,
			String formacao, String cargo) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !email.isEmpty()) {
			candidato.setNome(nome);
			candidato.setEndereco(endereco);
			candidato.setId(id);
			candidato.setEmail(email);
			candidato.setHabilidades(habilidades);
			candidato.setFormacao(formacao);
			candidato.setCargo(cargo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String nomeCandidato() {
		return candidato.getNome();
	}
	public String enderecoCandidato() {
		return candidato.getEndereco();
	}
	public String emailCandidato() {
		return candidato.getEmail();
	}
	public String habilidadesCandidato() {
		return candidato.getHabilidades();
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
