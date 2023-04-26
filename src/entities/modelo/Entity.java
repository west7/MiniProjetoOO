package entities.modelo;

import java.util.ArrayList;

public abstract class Entity {
	
	private String nome;
	private String endereco;
	private long id;
	protected ArrayList<Vaga> vagas;
	
	
	
	public Entity(String nome, String endereco, long id) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
	}

	public Entity(String nome, String endereco, long id, ArrayList<Vaga> vagas) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
		this.vagas = vagas;
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

	public void addVaga(Vaga vaga) {
		this.vagas.add(vaga);
	}
	
	public void removeVaga(Vaga vaga) {
		this.vagas.remove(vaga);
	}
}
