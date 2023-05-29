package modelo;

import java.util.ArrayList;

public abstract class Usuario{
	
	protected String nome;
	protected String endereco;
	protected long id;
	private String email;
	protected ArrayList<Vaga> vagas;
	
	
	public Usuario() {
	}
	
	public Usuario(String nome, String endereco, long id, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
		this.email = email;
		this.vagas = new ArrayList<Vaga>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	
}

