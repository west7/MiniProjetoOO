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
	}
	
	public void desinscrever(Vaga vaga) {
		for(Vaga v: vagas) {
			if(v == vaga) {}
			vagas.remove(v);
		}
	}
	
	public void verInscricoes() {
		for(Vaga v: vagas) {
			System.out.println(v);
		}
	}
	
	public String toString() {
		return String.format("Nome: %s, Endereço: %S, ID: %d, Email: %s", getNome(), getEndereco(), getId(), getEmail()); 
	}
	
}
