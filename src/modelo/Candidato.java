package modelo;
import java.util.ArrayList;

public class Candidato extends Usuario{
	
	private String email;
	
	
	public Candidato() {
		super();
	}

	//Sobrecarga
	public Candidato(String nome, String endereco, long id, String email) {
		super(nome, endereco, id);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public void verInscricoes() {
		if(vagas.isEmpty()) {
			System.out.println("Você não está inscrito em nenhuma vaga.");
		}else {
			System.out.println("Vagas Inscritas: ");
			for(Vaga v: vagas) {
				System.out.println(v);
			}
		}
	}
	
	public ArrayList<Vaga> buscarVagaporFuncao(String funcao, ArrayList<Vaga> vagas_geral) {
		String args[] = funcao.toLowerCase().split(" ");
		ArrayList<Vaga> VagasFiltradasFuncao = new ArrayList<>();
		int qtd_args = args.length;
		for (Vaga vaga : vagas_geral) {
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
	
	public ArrayList<Vaga> buscarVagaporEmpresa(String nomeEmpresa, ArrayList<Vaga> vagas_geral){
		String args[] = nomeEmpresa.toLowerCase().split(" ");
		ArrayList<Vaga> vagasFiltradasEmpresa = new ArrayList<>();
		int qtd_args = args.length;
		for(Vaga v : vagas_geral) {
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
