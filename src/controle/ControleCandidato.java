package controle;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Candidato;
import modelo.Dados;
import modelo.Vaga;

public class ControleCandidato {

	private Candidato candidato;
	
	public Candidato criarCandidato (String nome, String endereco, long id, String email, String habilidades,
			String formacao, String cargo) {
		candidato = new Candidato(nome, endereco, id, email, habilidades, formacao, cargo);
		//Dados.preencherDados();
		return candidato;
	}
	
	public Candidato editarCandidato(String nome, String endereco, long id, String email, String habilidades,
			String formacao, String cargo) {
		candidato.setNome(nome);
		candidato.setEndereco(endereco);
		candidato.setId(id);
		candidato.setEmail(email);
		candidato.setHabilidades(habilidades);
		candidato.setFormacao(formacao);
		candidato.setCargo(cargo);
		return candidato;
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
	
	public void inscrever(Vaga vaga){
		if (!candidato.getVagas().contains(vaga)) {
			candidato.inscrever(vaga);			
		}
	}
	public void desinscrever(Vaga vaga){
		candidato.desinscrever(vaga);
	}
	/*
	public DefaultListModel<Vaga> puxarVagas() {
		ArrayList<Vaga> vagas = Dados.getVagas();
		DefaultListModel<Vaga> vagaListModel = new DefaultListModel<>();
		for(Vaga v : vagas) {
			vagaListModel.addElement(v);
		}
		return vagaListModel;
	}*/
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
