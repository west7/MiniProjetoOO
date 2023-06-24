package controle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.Dados;
import modelo.Empresa;
import modelo.Vaga;

public class ControleEmpresa {
	private Empresa empresa;
	
	public boolean criarEmpresa(String nome, String endereco, String cnpjStr, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !cnpjStr.isEmpty() && !email.isEmpty() && !setor_atuacao.isEmpty()) {
			try {
				long cnpj = Long.parseLong(cnpjStr);
				empresa = new Empresa(nome, endereco, cnpj, email, setor_atuacao, resumo_sobre_empresa, missao);
				return true;				
			} catch(NumberFormatException ex) {
				return false;
			}
		} else {
			return false;
		}
	}
	public boolean editarEmpresa(String nome, String endereco, String cnpjStr, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		if (!nome.isEmpty() && !endereco.isEmpty() && !cnpjStr.isEmpty() && !email.isEmpty() && !setor_atuacao.isEmpty()) {
			try {
				long cnpj = Long.parseLong(cnpjStr);
				empresa.setNome(nome);
				empresa.setEndereco(endereco);
				empresa.setCNPJ(cnpj);
				empresa.setEmail(email);
				empresa.setSetorAtuacao(setor_atuacao);
				empresa.setResumoSobreEmpresa(resumo_sobre_empresa);
				empresa.setMissao(missao);
				return true;				
			} catch(NumberFormatException ex) {
				return false;
			}
			
		} else {
			return false;
		}
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
	public long cnpjEmpresa() {
		return empresa.getCNPJ();
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
	public String resumoEmpresa() {
		return empresa.getResumoSobreEmpresa();
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
	
	public boolean abrirVaga(String funcao, String salario, String requisitos) {
		if (!funcao.isEmpty() && !salario.isEmpty() && !requisitos.isEmpty()) {
			try {
				double sal = Double.parseDouble(salario);
				empresa.abrirVaga(funcao, sal, requisitos);
				return true;
			} catch (NumberFormatException ex) {
				return false;
			}
		} else {
			return false;
		}
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
	/*public void editarVaga(Vaga vaga, String novaFuncao, double novoSalario , String novosRequisitos) {
		//empresa.editarVaga(vaga,novaFuncao, novoSalario ,novosRequisitos);
		vaga.setFuncao(novaFuncao);
		vaga.setSalario(novoSalario);
		vaga.setRequisitos(novosRequisitos);
	}*/
	public boolean editarVaga(Vaga vaga, String novaFuncao, String novoSalario , String novosRequisitos) {
		if (!novaFuncao.isEmpty() && !novoSalario.isEmpty() && !novosRequisitos.isEmpty()) {
			try {
				double sal = Double.parseDouble(novoSalario);
				vaga.setSalario(sal);
				vaga.setFuncao(novaFuncao);
				vaga.setRequisitos(novosRequisitos);
				return true;
			} catch (NumberFormatException ex) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void inserirDados() {
		Dados.preencherDados();
	}
	
	public String toString() {
		return empresa.getNome();
				
	}

}
