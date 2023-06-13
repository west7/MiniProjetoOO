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
import modelo.Vaga;

public class TelaCandidato extends JFrame implements ListSelectionListener, ActionListener {

	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	//private JLabel id = new JLabel("ID: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel formacao = new JLabel("Formação: ");
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
	private ControleDeVaga controleVaga;
	//private DefaultListModel<Vaga> vagaListModel = new DefaultListModel<>();
	private JLabel nomeVaga;
	private JLabel reqVaga;
	private JLabel salVaga;
	private JLabel nomeEmpresa;
	private JLabel inscricao = new JLabel("Inscrição concluída com sucesso!");
	private JLabel desinscricao = new JLabel("Inscrição cancelada!");
	
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
		
		endereco.setBounds(50, 70, 200, 20);
		endereco.setText("Endereco: " + controle.enderecoCandidato());
		tela.add(endereco);
		
		email.setBounds(50,90,200,20);
		email.setText("Email: " + controle.emailCandidato());
		tela.add(email);
		
		formacao.setBounds(50,110,200,20);
		formacao.setText(controle.formacaoCandidato() == null ? 
				 "Formação: Não informado" : "Formação: " + controle.formacaoCandidato());
		tela.add(formacao);
		
		vagaPanel.setBounds(600, 200, 300, 400);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		buscar.setBounds(800, 50, 80, 20);
		buscarField.setBounds(600,50, 200, 20);
		todasVagas.setBounds(50,580,150,20);
		minhasInscricoes.setBounds(200,580,150,20);
		inscrever.setBounds(40,380,120,20);
		desinscrever.setBounds(160,380,120,20);
		editarCandidato.setBounds(300, 50, 120, 20);
		pagInicial.setBounds(50, 20, 120, 20);
		tela.add(todasVagas);
		tela.add(minhasInscricoes);
		tela.add(buscar);
		tela.add(buscarField);
		tela.add(editarCandidato);
		tela.add(pagInicial);
		vagaPanel.add(inscrever);
		vagaPanel.add(desinscrever);
		todasVagas.addActionListener(this);
		buscar.addActionListener(this);
		minhasInscricoes.addActionListener(this);
		inscrever.addActionListener(this);
		desinscrever.addActionListener(this);
		editarCandidato.addActionListener(this);
		pagInicial.addActionListener(this);
		
		vagas = new JList<ControleDeVaga>(controle.puxarVagas());
		vagas.setFixedCellHeight(20);
		//vagas = new JList<Vaga>((ListModel<Vaga>) controle.vagasEmpresa());
		//vagas.setBounds(50, 200, 100, 100);
		vagas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		scrollPane = new JScrollPane(vagas);  
		//scrollPane.setPreferredSize(new Dimension(200, 200));
		scrollPane.setBounds(50,160,300,200);
		vagas.addListSelectionListener(this);
		//tela.add(vagas);
		tela.add(scrollPane);
		
		
		tela.setVisible(true);
		
		
		
	}
	
	
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && vagas.getSelectedIndex() != -1) {
			vagaPanel.removeAll();
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
		    
		    inscrever.setBounds(40,380,120,20);
			desinscrever.setBounds(160,380,120,20);
			vagaPanel.add(inscrever);
			vagaPanel.add(desinscrever);
			
			String nomeVagaSelecionada = "Funcao: " + vagas.getSelectedValue().funcaoVaga();
			String reqVagaSelecionada = "Requisitos: " + vagas.getSelectedValue().requisitosVaga();
			Double salVagaSelecionada = vagas.getSelectedValue().salarioVaga();
			String salStr = "Salario: " + String.valueOf(salVagaSelecionada);
			String nomeEmpresaVagaSelecionada = "Empresa: " + vagas.getSelectedValue().empresaVaga().getNome();
			
			nomeVaga =  new JLabel(nomeVagaSelecionada);
			reqVaga = new JLabel(reqVagaSelecionada);
			salVaga = new JLabel(salStr);
			nomeEmpresa = new JLabel(nomeEmpresaVagaSelecionada);
			nomeVaga.setBounds(20, 50, 250, 20);
			salVaga.setBounds(20, 70, 250, 20);
			reqVaga.setBounds(20,90,250,20);
			nomeEmpresa.setBounds(20, 110, 250, 20);
			vagaPanel.add(nomeVaga);
			vagaPanel.add(salVaga);
			vagaPanel.add(reqVaga);
			vagaPanel.add(nomeEmpresa);
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
				}else /*if(controle.pesquisarEmpresa(campoBusca) != null)*/ {
					vagas.setListData(controle.pesquisarEmpresa(campoBusca));
					vagas.updateUI();
				}
			}
		}
			
		if (e.getSource() == inscrever) {
			vagaPanel.remove(desinscricao);
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
			
			controle.inscrever(vagas.getSelectedValue().getVaga());
			
			inscricao.setBounds(20, 260, 250, 40);
			inscricao.setForeground(Color.green);
			vagaPanel.add(inscricao);
			vagaPanel.revalidate();
			vagaPanel.repaint();
			
		}
		if (e.getSource() == desinscrever) {
			vagaPanel.remove(inscricao);
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
			
			controle.desinscrever(vagas.getSelectedValue().getVaga());
			
			desinscricao.setBounds(20, 260, 250, 40);
			desinscricao.setForeground(Color.red);
			vagaPanel.add(desinscricao);
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
		
		if (e.getSource() == todasVagas) {
			vagas.setListData(controle.puxarVagas());
			vagas.updateUI();
		}
		if (e.getSource() == minhasInscricoes) {
			vagas.setListData(controle.inscricoesCandidato());
			vagas.updateUI();
		}
		if (e.getSource() == editarCandidato) {
			new TelaLoginCandidato(controle, true);
		}
		if (e.getSource() == pagInicial) {
			new TelaEscolha();
			tela.dispose();
		}
	}
	public void mensagemInscricaoSucesso() {
		JOptionPane.showMessageDialog(null, "Inscricao feita com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
	}
	public void mensagemInscricaoErro() {
		JOptionPane.showMessageDialog(null, "Erro ao se inscrever", null, JOptionPane.INFORMATION_MESSAGE);
	}
}
