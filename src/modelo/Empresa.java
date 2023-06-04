package modelo;

public class Empresa extends Usuario{
	
	private String setor_atuacao;
	private String resumo_sobre_empresa;
	private String missao;
	
	
	public Empresa() {
		super();
		Dados.adicionarEmpresa(this);
	}

	public Empresa(String nome, String endereco, long id, String email) {
		super(nome, endereco, id, email);
		Dados.adicionarEmpresa(this);
	}

	public Empresa(String nome, String endereco, long id, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		super(nome, endereco, id, email);
		this.setor_atuacao = setor_atuacao;
		this.resumo_sobre_empresa = resumo_sobre_empresa;
		this.missao = missao;
		Dados.adicionarEmpresa(this);
	}

	public String getSetorAtuacao() {
		return setor_atuacao;
	}

	public void setSetorAtuacao(String setor_atuacao) {
		this.setor_atuacao = setor_atuacao;
	}

	public String getResumoSobreEmpresa() {
		return resumo_sobre_empresa;
	}

	public void setResumoSobreEmpresa(String resumo_sobre_empresa) {
		this.resumo_sobre_empresa = resumo_sobre_empresa;
	}

	public String getMissao() {
		return missao;
	}

	public void setMissao(String missao) {
		this.missao = missao;
	}
	
	public String toString() {
		return String.format("Nome: %s, Endereço: %s, ID: %d, Setor de Atuacao: %s", getNome(), getEndereco(), getId(), getSetorAtuacao());
	}

	public Vaga abrirVaga(String funcao, Double salario, String requisitos) {
		Vaga vaga = new Vaga(funcao, salario, requisitos, this);
		vagas.add(vaga);
		return vaga;
	}
	
	public void excluirVaga(Vaga vaga) {
		vagas.remove(vaga);
			for(Candidato candidato: vaga.getCandidatos()) {
				if(candidato.getVagas().contains(vaga)) {
					candidato.getVagas().remove(vaga);
				}
			}
		vaga.getCandidatos().clear();
		Dados.removerVaga(vaga);
		}
	
	public void editarVaga(Vaga vaga, String novaFuncao, Double novoSalario, String novosRequisitos){
		if (vagas.contains(vaga)) {
			String funcao = novaFuncao != null ? novaFuncao : vaga.getFuncao();
			Double salario = novoSalario != null ? novoSalario : vaga.getSalario();
			String requisitos = novosRequisitos != null ? novosRequisitos : vaga.getRequisitos();
			vaga.setFuncao(funcao);
			vaga.setSalario(salario);
			vaga.setRequisitos(requisitos);
			//System.out.println("Vaga editada com sucesso!");
		}else {
			//System.out.println("Vaga não encontrada.");
		}
	}
	
	public String verVagas() {
		String verVagas = "";
		if(vagas.isEmpty()) {
			verVagas = verVagas + "A Empresa não possui nenhuma vaga aberta.";
		}else {
			//System.out.println("Vagas Abertas: ");
			for(Vaga v: vagas) {
				verVagas = verVagas + v + "\n";
			}
		}
		return verVagas;
	}

}
