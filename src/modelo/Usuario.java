package modelo;

import java.util.ArrayList;

/**
 * Classe Abstrata Usuario simula os usuarios da plataforma que podem ser empresas ou candidatos
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0 
 *
 */
public abstract class Usuario{
	
	protected String nome;
	protected String endereco;
	protected String email;
	protected ArrayList<Vaga> vagas;
	
	/**
	 * Construtor sem argumentos
	 */
	public Usuario() {
	}
	 /**
	  * Construtor com todos os argumentos
	  * @param nome String
	  * @param endereco String
	  * @param email String
	  */
	public Usuario(String nome, String endereco, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
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

