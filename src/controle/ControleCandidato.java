package controle;

import modelo.Candidato;
import modelo.Vaga;

public class ControleCandidato {

	private Candidato candidato;
	
	public Candidato criarCandidato (String nome, String endereco, long id, String email, String habilidades,
			String formacao, String cargo) {
		candidato = new Candidato(nome, endereco, id, email, habilidades, formacao, cargo);
		return candidato;
	}
	
	public String nomeCandidato() {
		return candidato.getNome();
	}
	public String enderecoCandidato() {
		return candidato.getEndereco();
	}
	public String emailCandidato() {
		return candidato.getEmail();
	}
	public String habilidadesCandidato() {
		return candidato.getHabilidades();
	}
	public String formacaoCandidato() {
		return candidato.getFormacao();
	}
	public String cargoCandidato() {
		return candidato.getCargo();
	}
	
	public void inscrever(Vaga vaga){
		candidato.inscrever(vaga);
	}
	public void desinscrever(Vaga vaga){
		candidato.desinscrever(vaga);
	}
}
