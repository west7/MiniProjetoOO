package modelo;
import java.util.ArrayList;

public class Candidato extends Usuario{
	
	private String habilidades;
	private String formacao;
	private String cargo;
	
	
	
	public Candidato() {
		super();
		Dados.adicionarCandidato(this);
	}

	public Candidato(String nome, String endereco, long id, String email, String habilidades, String formacao,
			String cargo) {
		super(nome, endereco, id, email);
		this.habilidades = habilidades;
		this.formacao = formacao;
		this.cargo = cargo;
		Dados.adicionarCandidato(this);

	}

	//Sobrecarga
	public Candidato(String nome, String endereco, long id, String email, String cargo) {
		super(nome, endereco, id, email);
		this.cargo = cargo;
		Dados.adicionarCandidato(this);
	}
	
	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
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
		return String.format("Nome: %s, Endereço: %S, ID: %d, Email: %s", getNome(), getEndereco(), getId(), getEmail()); 
	}
	
	public void inscrever(Vaga vaga) {
		vagas.add(vaga);
		vaga.adicionarCandidato(this);
	}
	
	public void desinscrever(Vaga vaga) {
		vagas.remove(vaga);
		vaga.removerCandidato(this);
	}
	
	public String verInscricoes() {
		String inscricoes = "";
		if(vagas.isEmpty()) {
			inscricoes += "Você não está inscrito em nenhuma vaga.";
		}else {
			inscricoes += "Vagas inscritas: \n";
			for(Vaga v: vagas) {
				inscricoes += v + "\n";
			}
		}
		return inscricoes;
	}
	
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
	
	public ArrayList<Vaga> buscarVagaPorEmpresa(String nomeEmpresa){
		String args[] = nomeEmpresa.toLowerCase().split(" ");
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
