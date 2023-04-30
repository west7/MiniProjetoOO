package entities.modelo;


public class Vaga {

	private String funcao;
	private Double salario;
	private String requisitos;
	private Empresa empresa;
	
	public Vaga(String funcao, Double salario, String requisitos, Empresa empresa) {
		super();
		this.funcao = funcao;
		this.salario = salario;
		this.requisitos = requisitos;
		this.empresa = empresa;
	}
	
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String toString() {
		return String.format("Função: %s, Requisitos: %s, Empresa: %s, Salario: %.2f", getFuncao(), getRequisitos(), empresa.getNome(), getSalario());
				
	}

	
}
