package controle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Dados;
import modelo.Empresa;
import modelo.Vaga;

public class ControleEmpresa {
	private Empresa empresa;
	
	public Empresa criarEmpresa(String nome, String endereco, long id, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		empresa = new Empresa(nome, endereco, id, email, setor_atuacao, resumo_sobre_empresa, missao);
		return empresa;
		
	}
	public Empresa editarEmpresa(String nome, String endereco, long id, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		empresa.setNome(nome);
		empresa.setEndereco(endereco);
		empresa.setId(id);
		empresa.setEmail(email);
		empresa.setSetorAtuacao(setor_atuacao);
		empresa.setResumoSobreEmpresa(resumo_sobre_empresa);
		empresa.setMissao(missao);
		return empresa;
	}
	public void excluirEmpresa() {
		Dados.removerEmpresa(empresa);
	}
	
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Empresa getEmpresa() {
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
	
	public ControleDeVaga[] puxarVagas() {
		ArrayList<Vaga> vagas = empresa.getVagas();
		ControleDeVaga[] arrayVaga = new ControleDeVaga[vagas.size()];
		for (int i = 0; i < vagas.size(); i++) {
			ControleDeVaga c = new ControleDeVaga();
			c.setVaga(vagas.get(i));
			arrayVaga[i] = c;
		}
		return arrayVaga;
	}
	
	public ControleEmpresa[] puxarEmpresas() {
		ArrayList<Empresa> empresas = Dados.getEmpresas();
		ControleEmpresa[] empresasArray = new ControleEmpresa[empresas.size()];
		for (int i=0; i < empresas.size(); i++) {
			ControleEmpresa c = new ControleEmpresa();
			c.setEmpresa(empresas.get(i));
			empresasArray[i] = c;
		}
		return empresasArray;
	}
	
	/*public DefaultListModel<Vaga> puxarVagas(){
		ArrayList<Vaga> vagas = empresa.getVagas();
		DefaultListModel <Vaga> vagaListModel = new DefaultListModel<>();
		for(Vaga v : vagas) {
			vagaListModel.addElement(v);
		}
		return vagaListModel;
	}*/
	
	public Object[] funcoesVagas() {
		//ArrayList<String> funcoes = new ArrayList<String>();
		ArrayList<Vaga> funcoes = new ArrayList<Vaga>();
		for (Vaga vaga : empresa.getVagas()) {
			String a = vaga.getFuncao();
			//funcoes.add(a);
			funcoes.add(vaga);
		}
		return funcoes.toArray();
	}
	
	public void abrirVaga(String funcao, double salario, String requisitos) {
		empresa.abrirVaga(funcao, salario, requisitos);
	}

	public void excluirVaga(Vaga vaga) {
		empresa.excluirVaga(vaga);
	}
	public boolean vagaExiste(Vaga vaga) {
		if(empresa.getVagas().contains(vaga)) {
			return true;
		}else {
			return false;
		}
	}
	public void editarVaga(Vaga vaga, String novaFuncao, double novoSalario , String novosRequisitos) {
		//empresa.editarVaga(vaga,novaFuncao, novoSalario ,novosRequisitos);
		vaga.setFuncao(novaFuncao);
		vaga.setSalario(novoSalario);
		vaga.setRequisitos(novosRequisitos);
	}
	
	public void inserirDados() {
		Dados.preencherDados();
	}
	
	public String toString() {
		return empresa.getNome();
				
	}

}
