package controle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Empresa;
import modelo.Vaga;

public class ControleEmpresa {
	private Empresa empresa;
	
	public Empresa criarEmpresa(String nome, String endereco, long id, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		empresa = new Empresa(nome, endereco, id, email, setor_atuacao, resumo_sobre_empresa, missao);
		return empresa;
		
	}
	
	public String nomeEmpresa() {
		return empresa.getNome();
	}
	public String enderecoEmpresa() {
		return empresa.getEndereco();
	}
	public String emailEmpresa() {
		return empresa.getEmail();
	}
	public String setorEmpresa() {
		return empresa.getSetorAtuacao();
	}
	public String missaoEmpresa() {
		return empresa.getMissao();
	}
	public String reumoEmpresa() {
		return empresa.getResumoSobreEmpresa();
	}
	public long idEmpresa() {
		return empresa.getId();
	}
	public ArrayList<Vaga> vagasEmpresa() {
		return empresa.getVagas();
	}
	
	public DefaultListModel<Vaga> puxarVagas(){
		ArrayList<Vaga> vagas = empresa.getVagas();
		DefaultListModel <Vaga> vagaListModel = new DefaultListModel<>();
		for(Vaga v : vagas) {
			vagaListModel.addElement(v);
		}
		return vagaListModel;
	}
	
	public Object[] funcoesVagas() {
		ArrayList<String> funcoes = new ArrayList<String>();
		for (Vaga vaga : empresa.getVagas()) {
			String a = vaga.getFuncao();
			funcoes.add(a);
		}
		return  funcoes.toArray();
	}
	
	public void abrirVaga(String funcao, double salario, String requisitos) {
		empresa.abrirVaga(funcao, salario, requisitos);
	}

}
