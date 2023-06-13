package controle;

import modelo.Empresa;
import modelo.Vaga;

public class ControleDeVaga {

	private Vaga vaga;
	
	public String funcaoVaga() {
		return vaga.getFuncao();
	}
	public String requisitosVaga() {
		return vaga.getRequisitos();
	}
	public Double salarioVaga() {
		return vaga.getSalario();
	}
	public Empresa empresaVaga() {
		return vaga.getEmpresa();
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	public String toString() {
		return vaga.toString();
	}
}
