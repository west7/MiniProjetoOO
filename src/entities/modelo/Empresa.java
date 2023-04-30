package entities.modelo;


public class Empresa extends Personalidade{
	
	private String cnpj;
	private String setor;

	public Empresa(String nome, String endereco, long id) {
		super(nome, endereco, id);
	}


	public Empresa(String nome, String endereco, long id, String cnpj, String setor) {
		super(nome, endereco, id);
		this.cnpj = cnpj;
		this.setor = setor;
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
	
	public Vaga abrirVaga(String funcao, Double salario, String requisitos, Empresa empresa) {
		Vaga v = new Vaga(funcao, salario, requisitos, empresa);
		vagas.add(v);
		return v;
	}
	
	public void excluirVaga(Vaga vaga) {
		for(Vaga v: vagas) {
			if(v == vaga) {
				vagas.remove(v);
			}
		}
	}
	
	public void verVagas() {
		for(Vaga v: vagas) {
			System.out.println(v);
		}
	}

	public String toString() {
		return String.format("Nome: %s, Endereço: %s, ID: %d, CNPJ: %s, Setor: %s", getNome(), getEndereco(), getId(), getCnpj(), getSetor());
	}
}
