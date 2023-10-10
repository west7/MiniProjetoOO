package modelo;
import java.util.ArrayList;


/**
 * Classe Candidato simula o comportamento de um Candidato a uma vaga de emprego e herda da classe Usuario
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Usuario
 *
 */
public class Candidato extends Usuario{
	
	private long cpf;
	private String competencias;
	private String formacao;
	private String cargo;
	
	
	/**
	 * Construtor sem parametros da classe Candidato
	 */
	public Candidato() {
		super();
		Dados.adicionarCandidato(this);
	}

	/**
	 * Construtor com todos os parametros da classe Candidato
	 * @param nome String
	 * @param endereco String
	 * @param cpf long
	 * @param email String
	 * @param competencias String
	 * @param formacao String
	 * @param cargo String
	 */
	public Candidato(String nome, String endereco, long cpf, String email, String competencias, String formacao,
			String cargo) {
		super(nome, endereco, email);
		this.cpf = cpf;
		this.competencias = competencias;
		this.formacao = formacao;
		this.cargo = cargo;
		Dados.adicionarCandidato(this);

	}
	
	public long getCPF() {
		return cpf;
	}
	public void setCPF(long cpf) {
		this.cpf = cpf;
	}
	
	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String toString() {
		return String.format("Nome: %s, Endereço: %S, CPF: %d, Email: %s", getNome(), getEndereco(), getCPF(), getEmail()); 
	}
	
	/**
	 * Inscreve o candidato na vaga desejada
	 * @param vaga Vaga
	 */
	public void inscrever(Vaga vaga) {
		vagas.add(vaga);
		//vaga.adicionarCandidato(this);
	}
	/**
	 * Cancela a inscricao do candidato de uma vaga
	 * @param vaga Vaga
	 */
	public void desinscrever(Vaga vaga) {
		vagas.remove(vaga);
	}
	
	/**
	 * Busca por uma vaga dada a funcao pretendida
	 * @param funcao String
	 * @return ArrayList<Vaga>
	 */
	public ArrayList<Vaga> buscarVagaPorFuncao(String funcao) {
		String args[] = funcao.toLowerCase().split(" ");
		ArrayList<Vaga> VagasFiltradasFuncao = new ArrayList<>();
		int qtd_args = args.length;
		for (Vaga vaga : Dados.getVagas()) {
			boolean contem_todos_args = true;
			for (int i = 0; i < qtd_args; i++) {
				contem_todos_args = contem_todos_args && vaga.getFuncao().toLowerCase().contains(args[i]);
			}
			if (contem_todos_args == true) {
				VagasFiltradasFuncao.add(vaga);
			}
		}
		return VagasFiltradasFuncao;
	}
	/**
	 * Busca por uma vaga dado o nome de uma Empresa
	 * @param nomeEmpresa String
	 * @return ArrayList<Vaga>
	 */
	public ArrayList<Vaga> buscarVagaPorEmpresa(String nomeEmpresa){
		String args[] = nomeEmpresa.toLowerCase().split(" ");//Separa o nome da Empresa letra por letra
		ArrayList<Vaga> vagasFiltradasEmpresa = new ArrayList<>();
		int qtd_args = args.length;
		for(Vaga v : Dados.getVagas()) {
			Empresa empresa = v.getEmpresa();
			boolean contem_todos_args = true;
			for (int i=0; i < qtd_args; i++) {
				if (empresa != null) {
					contem_todos_args = contem_todos_args && empresa.getNome().toLowerCase().contains(args[i]);
				}				
			}
			if (contem_todos_args == true) {
				vagasFiltradasEmpresa.add(v);				
			}
		}
		return vagasFiltradasEmpresa;
	}
	
}
