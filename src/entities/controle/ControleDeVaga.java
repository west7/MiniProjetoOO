package entities.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entities.Empresa;
import entities.Vaga;
import entities.enums.VagaStatus;

public class ControleDeVaga {

	private VagaStatus status;
	private ArrayList<Vaga> vagas;
	
	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

	public void addVaga(Vaga vaga) {
		this.vagas.add(vaga);
	}
	
	public void removeVaga(Vaga vaga) {
		this.vagas.remove(vaga);
	}
	
	public ArrayList<Vaga> BuscarPorEmpresa(String nomeEmpresa){
		ArrayList<Vaga> vagasFiltradas = new ArrayList<>();
		for(Vaga v : vagas) {
			Empresa empresa = v.getEmpresa();
			if (empresa != null && empresa.getNome().equals(nomeEmpresa)) {
				vagasFiltradas.add(v);
			}
		}
		return vagasFiltradas;
	}
	
	public ArrayList<Vaga> OrdenarPeloSalario(){
		ArrayList<Vaga> vagasOrdenadasSalario = new ArrayList<>(vagas);
		Collections.sort(vagasOrdenadasSalario, new Comparator<Vaga>() {
			@Override
			public int compare(Vaga v1, Vaga v2) {
				return Double.compare(v2.getSalario(), v1.getSalario()); //Organizando em ordem Decrescente
				
			}
		});
		return vagasOrdenadasSalario;
	}
	
}
