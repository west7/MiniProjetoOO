package entities.modelo;

public class Candidato extends Personalidade{
	
	private String email;

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
	
	public String toString() {
		return String.format("Nome: %s, Endereço: %S, ID: %d, Email: %s", getNome(), getEndereco(), getId(), getEmail()); 
	}
	
}
