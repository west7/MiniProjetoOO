package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.Empresa;
import modelo.Vaga;

public class ControleDeVaga {

	private ArrayList<Vaga> vagas;
	
	public ArrayList<Vaga> BuscarPorEmpresa(String nomeEmpresa){
		ArrayList<Vaga> vagasFiltradasEmpresa = new ArrayList<>();
		for(Vaga v : vagas) {
			Empresa empresa = v.getEmpresa();
			if (empresa != null && empresa.getNome().equals(nomeEmpresa)) {
				vagasFiltradasEmpresa.add(v);
			}
		}
		return vagasFiltradasEmpresa;
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