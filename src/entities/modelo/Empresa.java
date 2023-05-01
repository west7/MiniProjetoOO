package entities.modelo;


public class Empresa extends Pessoa{
	
	private String setor;
	
	
	public Empresa() {
		super();
	}

	public Empresa(String nome, String endereco, long id) {
		super(nome, endereco, id);
	}

	//Sobrecarga
	public Empresa(String nome, String endereco, long id, String setor) {
		super(nome, endereco, id);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public Vaga abrirVaga(String funcao, Double salario, String requisitos) {
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
		if(vagas.isEmpty()) {
			System.out.println("A Empresa não possui nenhuma vaga aberta.");
		}else {
			System.out.println("Vagas Abertas: ");
			for(Vaga v: vagas) {
				System.out.println(v);
			}
		}
	}

	public String toString() {
		return String.format("Nome: %s, Endereço: %s, ID: %d, Setor: %s", getNome(), getEndereco(), getId(), getSetor());
	}
}
