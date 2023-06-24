package modelo;

/**
 * Classe Vaga simula uma vaga de emprego que podera ser ofertada por empresas e buscada por candidatos
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 *
 */
public class Vaga {

	private String funcao;
	private Double salario;
	private String requisitos;
	private Empresa empresa;
	
	/**
	 * Construtor de vaga com todos os argumentos da classe
	 * @param funcao Funcao da vaga
	 * @param salario Salario da vaga
	 * @param requisitos Requisitos para a vaga
	 * @param empresa Empresa que está ofertando a vaga
	 */
	public Vaga(String funcao, Double salario, String requisitos, Empresa empresa) {
		super();
		this.funcao = funcao;
		this.salario = salario;
		this.requisitos = requisitos;
		this.empresa = empresa;
		Dados.adicionarVaga(this);
	}
	
	
	/**
	 * Construtor de vaga sem o argumento "empresa"
	 * @param funcao String
	 * @param salario Double
	 * @param requisitos String
	 */
	public Vaga(String funcao, Double salario, String requisitos) {
		super();
		this.funcao = funcao;
		this.salario = salario;
		this.requisitos = requisitos;
		Dados.adicionarVaga(this);
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
		//return String.format("Função: %s, Requisitos: %s, Empresa: %s, Salario: $%.2f", getFuncao(), getRequisitos(), empresa.getNome(), getSalario());
		return getFuncao();
	}
}
