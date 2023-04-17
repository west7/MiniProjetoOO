package entities.controle;

import java.util.ArrayList;

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
	
}
