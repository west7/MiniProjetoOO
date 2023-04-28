package entities.modelo;

public class Candidato extends Entity {
	
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
	
	public String toString() {
		return String.format("Nome: %s, Endereço: %S, ID: %d, Email: %s", getNome(), getEndereco(), getId(), getEmail()); 
	}
	
}
