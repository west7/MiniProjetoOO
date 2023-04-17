package entities;

public class Vaga implements Comparable<Vaga>{

	private String funcao;
	private Double salario;
	private String requisitos;
	private Empresa empresa;
	
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

	public Vaga(String funcao, Double salario, String requisitos, Empresa empresa) {
		super();
		this.funcao = funcao;
		this.salario = salario;
		this.requisitos = requisitos;
		this.empresa = empresa;
	}
	
	public int compareTo(Vaga vaga) {
		if(this.salario > vaga.getSalario()) {
				return -1;
		} 
		if(this.salario < vaga.getSalario()) {
				return 1;
		}
		return 0;
		}
	
	
	
}
