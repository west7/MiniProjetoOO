package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCandidato;
import modelo.Vaga;

public class TelaCandidato extends JFrame implements ListSelectionListener, ActionListener {

	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	//private JLabel id = new JLabel("ID: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel formacao = new JLabel("Formação: ");
	private JList<Vaga> vagas;
	private JScrollPane scrollPane; 
	private JPanel vagaPanel = new JPanel();
	private JButton criar = new JButton("Criar");
	private JButton atualizar = new JButton("Atualizar");
	private JButton inscrever = new JButton("Inscrever");
	private JButton desinscrever = new JButton("Desinscrever");
	private JButton buscar = new JButton("Buscar");
	private JTextField buscarField = new JTextField();
	private ControleCandidato controle;
	//private DefaultListModel<Vaga> vagaListModel = new DefaultListModel<>();
	private JLabel nomeVaga;
	private JLabel reqVaga;
	private JLabel salVaga;
	private JLabel nomeEmpresa;
	
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
		
		email.setBounds(50,110,200,20);
		email.setText("Email: " + controle.emailCandidato());
		tela.add(email);
		
		formacao.setBounds(50,130,200,20);
		formacao.setText(controle.formacaoCandidato() == null ? 
				 "Formação: Não informado" : "Formação: " + controle.formacaoCandidato());
		tela.add(formacao);
		
		vagaPanel.setBounds(600, 200, 300, 400);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		buscar.setBounds(600, 50, 80, 20);
		buscarField.setBounds(700,50, 200, 20);
		criar.setBounds(50,580,80,20);
		atualizar.setBounds(130,580,100,20);
		inscrever.setBounds(40,380,120,20);
		desinscrever.setBounds(160,380,120,20);
		tela.add(criar);
		tela.add(atualizar);
		tela.add(buscar);
		tela.add(buscarField);
		vagaPanel.add(inscrever);
		vagaPanel.add(desinscrever);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		inscrever.addActionListener(this);
		desinscrever.addActionListener(this);
		
		vagas = new JList<Vaga>();
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
		/*if(!e.getValueIsAdjusting() && vagas.getSelectedIndex() != -1) {
			String nomeVagaSelecionada = vagas.getSelectedValue().getFuncao();
			String reqVagaSelecionada = vagas.getSelectedValue().getRequisitos();
			Double salVagaSelecionada = vagas.getSelectedValue().getSalario();
			String salStr = String.valueOf(salVagaSelecionada);
			String nomeEmpresaVagaSelecionada = vagas.getSelectedValue().getEmpresa().getNome();
			
			nomeVaga =  new JLabel(nomeVagaSelecionada);
			reqVaga = new JLabel(reqVagaSelecionada);
			salVaga = new JLabel(salStr);
			nomeEmpresa = new JLabel(nomeEmpresaVagaSelecionada);
			vagaPanel.add(nomeVaga);
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}*/
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == criar) {
			//new TelaCadastroVaga(controle);
			
		}
		if (e.getSource() == atualizar) {
			//vagas.setListData(controle.funcoesVagas());
			//vagas.updateUI();
		}
	}
}
