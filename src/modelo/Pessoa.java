package modelo;

import java.util.ArrayList;

public abstract class Pessoa{
	
	protected String nome;
	protected String endereco;
	protected long id;
	protected ArrayList<Vaga> vagas;
	
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String endereco, long id) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
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

	public ArrayList<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	
}

