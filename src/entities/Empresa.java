package entities;

public class Empresa {
	
	private String nome;
	private String cnpj;
	private String setor;
	private String endereco;
	private String contato;
	
	public Empresa(String nome, String cnpj, String setor, String endereco, String contato) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.setor = setor;
		this.endereco = endereco;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	

}
