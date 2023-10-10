package modelo;


/**
 * Classe Empresa simula uma empresa que vai ofertar vagas na plataforma e herda da classe Usuario
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Usuario
 *
 */
public class Empresa extends Usuario{
	
	private long cnpj;
	private String setor_atuacao;
	private String resumo_sobre_empresa;
	private String missao;
	
	/**
	 * Construtor sem argumentos
	 */
	public Empresa() {
		super();
		Dados.adicionarEmpresa(this);
	}


	/**
	 * Construtor com todos os argumentos
	 * @param nome String
	 * @param endereco String
	 * @param cnpj long
	 * @param email String
	 * @param setor_atuacao String
	 * @param resumo_sobre_empresa String
	 * @param missao String
	 */
	public Empresa(String nome, String endereco, long cnpj, String email, String setor_atuacao,
			String resumo_sobre_empresa, String missao) {
		super(nome, endereco, email);
		this.cnpj = cnpj;
		this.setor_atuacao = setor_atuacao;
		this.resumo_sobre_empresa = resumo_sobre_empresa;
		this.missao = missao;
		Dados.adicionarEmpresa(this);
	}
	
	public long getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(long cnpj) {
		this.cnpj = cnpj;
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
		return String.format("Nome: %s, Endereço: %s, CNPJ: %d, Setor de Atuacao: %s", getNome(), getEndereco(), getCNPJ(), getSetorAtuacao());
	}

	/**
	 * Possibilita a empresa criar novas vagas 
	 * @param funcao String
	 * @param salario Double
	 * @param requisitos String
	 * @return Vaga
	 */
	public Vaga abrirVaga(String funcao, Double salario, String requisitos) {
		Vaga vaga = new Vaga(funcao, salario, requisitos, this);
		vagas.add(vaga);
		return vaga;
	}
	/**
	 * Exclui uma vaga ja existente
	 * @param vaga Vaga
	 */
	public void excluirVaga(Vaga vaga) {
		vagas.remove(vaga);
			for(Candidato candidato: Dados.getCandidatos()) {
				if(candidato.getVagas().contains(vaga)) {
					candidato.getVagas().remove(vaga);
				}
			}
		Dados.removerVaga(vaga);
		}
	/**
	 * Possibilita a empresa editar uma vaga ja existente
	 * @param vaga Vaga
	 * @param novaFuncao String
	 * @param novoSalario Double
	 * @param novosRequisitos String
	 */
	public void editarVaga(Vaga vaga, String novaFuncao, Double novoSalario, String novosRequisitos){
		if (vagas.contains(vaga)) {
			String funcao = novaFuncao != null ? novaFuncao : vaga.getFuncao();
			Double salario = novoSalario != null ? novoSalario : vaga.getSalario();
			String requisitos = novosRequisitos != null ? novosRequisitos : vaga.getRequisitos();
			vaga.setFuncao(funcao);
			vaga.setSalario(salario);
			vaga.setRequisitos(requisitos);
		}else {
			
		}
	}
	

}
