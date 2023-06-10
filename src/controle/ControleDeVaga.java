package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
}
