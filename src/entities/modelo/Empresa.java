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
		Vaga vaga = new Vaga(funcao, salario, requisitos, this);
		vagas.add(vaga);
		return vaga;
	}
	
	public void excluirVaga(Vaga vaga) {
		vagas.remove(vaga);
			for(Candidato candidato: vaga.getCandidatos()) {
				if(candidato.getVagas().contains(vaga)) {
					candidato.getVagas().remove(vaga);
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
