package entities.modelo;

import java.util.ArrayList;

public abstract class Personalidade{
	
	protected String nome;
	protected String endereco;
	protected long id;
	protected ArrayList<Vaga> vagas;
	
	public Personalidade(String nome, String endereco, long id) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
		this.vagas = new ArrayList<Vaga>();
	}

	/*
	public Entity(String nome, String endereco, long id, ArrayList<Vaga> vagas) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
		this.vagas = vagas;
	}*/

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

	public ArrayList<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	
}

