package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCandidato;
import controle.ControleDeVaga;

public class TelaCandidato extends JFrame implements ListSelectionListener, ActionListener {

	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	private JLabel cpf = new JLabel("CPF: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel formacao = new JLabel("Formação: ");
	private JLabel competencias = new JLabel("Habilidades: ");
	private JLabel cargo = new JLabel("Cargo: ");
	private JLabel nomeVaga;
	private JLabel reqVaga;
	private JLabel salVaga;
	private JLabel dadosEmpresa;
	private JLabel inscricao = new JLabel("Inscrição concluída com sucesso!");
	private JLabel desinscricao = new JLabel("Inscrição cancelada!");
	private JList<ControleDeVaga> vagas;
	private JScrollPane scrollPane; 
	private JPanel vagaPanel = new JPanel();
	private JButton todasVagas = new JButton("Vagas Disponiveis");
	private JButton minhasInscricoes = new JButton("Minhas Inscricoes");
	private JButton inscrever = new JButton("Inscrever");
	private JButton desinscrever = new JButton("Desinscrever");
	private JButton buscar = new JButton("Buscar");
	private JButton editarCandidato = new JButton("Editar Dados");
	private JButton pagInicial = new JButton("Pagina Inicial");
	private JTextField buscarField = new JTextField();
	private ControleCandidato controle;
	
	public TelaCandidato(ControleCandidato c) {
		
		controle = c;
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Candidato");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		nome.setBounds(50, 50, 200, 20);
		nome.setText("Nome: " + controle.nomeCandidato());
		tela.add(nome);
		
		cpf.setBounds(50, 70, 200, 20);
		cpf.setText("CPF: " + controle.cpfCandidato());
		tela.add(cpf);
		
		endereco.setBounds(50, 90, 200, 20);
		endereco.setText("Endereco: " + controle.enderecoCandidato());
		tela.add(endereco);
		
		email.setBounds(50,110,200,20);
		email.setText("Email: " + controle.emailCandidato());
		tela.add(email);
		
		formacao.setBounds(50,130,200,20);
		formacao.setText("Formação: " + controle.formacaoCandidato());
		tela.add(formacao);
		
		competencias.setBounds(50, 150, 200, 20);
		competencias.setText("Competencias: " + controle.competenciasCandidato());
		tela.add(competencias);
		
		cargo.setBounds(50, 170, 200, 20);
		cargo.setText("Cargo: " + controle.cargoCandidato());
		tela.add(cargo);
		
		vagaPanel.setBounds(400, 240, 500, 400);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		buscar.setBounds(800, 20, 80, 20);
		tela.add(buscar);
		buscar.addActionListener(this);
		buscarField.setBounds(600,20, 200, 20);
		tela.add(buscarField);
		
		todasVagas.setBounds(50,210,150,20);
		tela.add(todasVagas);
		todasVagas.addActionListener(this);
		
		minhasInscricoes.setBounds(200,210,150,20);
		tela.add(minhasInscricoes);
		minhasInscricoes.addActionListener(this);
		
		inscrever.setBounds(40,420,120,20);
		inscrever.addActionListener(this);
		
		desinscrever.setBounds(160,420,120,20);
		desinscrever.addActionListener(this);	
		
		editarCandidato.setBounds(160, 20, 120, 20);
		tela.add(editarCandidato);
		editarCandidato.addActionListener(this);
		
		pagInicial.setBounds(50, 20, 120, 20);
		tela.add(pagInicial);
		pagInicial.addActionListener(this);
		
		vagas = new JList<ControleDeVaga>(controle.puxarVagas());
		vagas.setFixedCellHeight(20);
		vagas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		scrollPane = new JScrollPane(vagas);  
		scrollPane.setBounds(50,240,300,400);
		vagas.addListSelectionListener(this);
		tela.add(scrollPane);
		
		tela.setVisible(true);
		
	}
	
	
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && vagas.getSelectedIndex() != -1) {
			vagaPanel.removeAll();
		    
		    inscrever.setBounds(40,380,120,20);
			desinscrever.setBounds(160,380,120,20);
			vagaPanel.add(inscrever);
			vagaPanel.add(desinscrever);
			
			String nomeVagaSelecionada = "Funcao: " + vagas.getSelectedValue().funcaoVaga();
			String reqVagaSelecionada = "Requisitos: " + vagas.getSelectedValue().requisitosVaga();
			Double salVagaSelecionada = vagas.getSelectedValue().salarioVaga();
			String salStr = "Salario: R$ " + String.valueOf(salVagaSelecionada);
			String dadosEmpresaselec = String.format("<html>Empresa: %s<br>CNPJ: %d<br>Email: %s<br>Setor de Atuacao: %s<br>Resumo: %s<br>Missao: %s</html>", 
										vagas.getSelectedValue().empresaVaga().getNome(),
										vagas.getSelectedValue().empresaVaga().getCNPJ(),
										vagas.getSelectedValue().empresaVaga().getEmail(),
										vagas.getSelectedValue().empresaVaga().getSetorAtuacao(),
										vagas.getSelectedValue().empresaVaga().getResumoSobreEmpresa(),
										vagas.getSelectedValue().empresaVaga().getMissao());
			nomeVaga =  new JLabel(nomeVagaSelecionada);
			reqVaga = new JLabel(reqVagaSelecionada);
			salVaga = new JLabel(salStr);
			dadosEmpresa = new JLabel(dadosEmpresaselec);
			nomeVaga.setBounds(20, 50, 250, 20);
			salVaga.setBounds(20, 70, 250, 20);
			reqVaga.setBounds(20,90,250,20);
			dadosEmpresa.setBounds(20, 100, 250, 200);
			vagaPanel.add(nomeVaga);
			vagaPanel.add(salVaga);
			vagaPanel.add(reqVaga);
			vagaPanel.add(dadosEmpresa);
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buscar) {
			String campoBusca = buscarField.getText();
			if(campoBusca.isEmpty()) {
				vagas.setListData(controle.puxarVagas());
				vagas.updateUI();
			}else if (!campoBusca.isEmpty()) {
				if(controle.pesquisarFuncao(campoBusca).length > 0){
					vagas.setListData(controle.pesquisarFuncao(campoBusca));
					vagas.updateUI();
				}else{
					vagas.setListData(controle.pesquisarEmpresa(campoBusca));
					vagas.updateUI();
				}
			}
			vagaPanel.removeAll();
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
			
		if (e.getSource() == inscrever) {
			vagaPanel.remove(desinscricao);
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
			
		    if (controle.inscrever(vagas.getSelectedValue())) {
		    	
		    	inscricao.setBounds(20, 260, 250, 40);
		    	inscricao.setForeground(Color.green);
		    	vagaPanel.add(inscricao);
		    	vagaPanel.revalidate();
		    	vagaPanel.repaint();
		    	
		    } else {
		    	JOptionPane.showMessageDialog(null, "Selecione uma vaga antes", null, JOptionPane.ERROR_MESSAGE);
		    }
			
		}
		if (e.getSource() == desinscrever) {
			vagaPanel.remove(inscricao);
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
			
			if (controle.desinscrever(vagas.getSelectedValue())) {
				desinscricao.setBounds(20, 260, 250, 40);
				desinscricao.setForeground(Color.red);
				vagaPanel.add(desinscricao);
				vagaPanel.revalidate();
				vagaPanel.repaint();
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma vaga antes", null, JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource() == todasVagas) {
			vagas.setListData(controle.puxarVagas());
			vagas.updateUI();
			vagaPanel.removeAll();
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
		if (e.getSource() == minhasInscricoes) {
			vagas.setListData(controle.inscricoesCandidato());
			vagas.updateUI();
			vagaPanel.removeAll();
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
		if (e.getSource() == editarCandidato) {
			new TelaLoginCandidato(controle, true);
			tela.dispose();
		}
		if (e.getSource() == pagInicial) {
			new TelaEscolha(false);
			tela.dispose();
		}
	}
	public void mensagemInscricaoSucesso() {
		JOptionPane.showMessageDialog(null, "Inscricao feita com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
	}
	public void mensagemInscricaoErro() {
		JOptionPane.showMessageDialog(null, "Erro ao se inscrever", null, JOptionPane.ERROR_MESSAGE);
	}
}
