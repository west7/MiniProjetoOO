package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleCandidato;

/**
 * Classe que gera a visualizacao do cadastro do Candidato
 * 
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Candidato
 *
 */
public class TelaLoginCandidato extends JFrame implements ListSelectionListener, ActionListener{
	
	private JFrame tela = new JFrame();
	private JTextField nomeBox = new JTextField("");
	private JTextField emailBox = new JTextField("");
	private JTextField cpfBox = new JTextField("");
	private JTextField enderecoBox = new JTextField("");
	private JTextField competenciasBox = new JTextField("");
	private JTextField formacaoBox = new JTextField("");
	private JTextField cargoBox = new JTextField("");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoEditar = new JButton("Editar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JLabel nomeLabel = new JLabel("<html><font color='red'>*</font> Nome</html>");
	private JLabel emailLabel = new JLabel("<html><font color='red'>*</font> Email</html>");
	private JLabel cpfLabel = new JLabel("<html><font color='red'>*</font> CPF</html>");
	private JLabel enderecoLabel = new JLabel("<html><font color='red'>*</font> Endereco</html>");
	private JLabel competenciasLabel = new JLabel("Habilidades");
	private JLabel formacaoLabel = new JLabel("Formação");
	private JLabel cargoLabel = new JLabel("Cargo");
	private JList<ControleCandidato> candidatos;
	private JScrollPane scrollPane;
	private ControleCandidato controle;


	/**
	 * Construtor verifica se o candidato quer cadastrar ou editar os dados
	 * @param c ControleCandidato
	 * @param editar boolean
	 */
	public TelaLoginCandidato(ControleCandidato c, boolean editar) {

		if (editar == false) {
			controle = new ControleCandidato();
			
			tela.getContentPane().setBackground(Color.lightGray);
			tela.setSize(1000, 1000);
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setTitle("Login do Candidato");
			tela.setLocationRelativeTo(null);
			tela.setLayout(null);
			
			nomeLabel.setBounds(200, 75, 100, 30);
			nomeBox.setBounds(200, 100, 600, 30);
			tela.add(nomeBox);
			tela.add(nomeLabel);
			
			emailLabel.setBounds(200, 125, 100, 30);
			emailBox.setBounds(200, 150, 600, 30);
			tela.add(emailBox);
			tela.add(emailLabel);
			
			cpfLabel.setBounds(200, 175, 100, 30);
			cpfBox.setBounds(200, 200, 600, 30);
			tela.add(cpfLabel);
			tela.add(cpfBox);
			
			enderecoLabel.setBounds(200, 225, 100, 30);
			enderecoBox.setBounds(200, 250, 600, 30);
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			competenciasLabel.setBounds(200, 275, 100, 30);
			competenciasBox.setBounds(200, 300, 600, 30);
			tela.add(competenciasBox);
			tela.add(competenciasLabel);
			
			formacaoLabel.setBounds(200, 325, 100, 30);
			formacaoBox.setBounds(200, 350, 600, 30);
			tela.add(formacaoBox);
			tela.add(formacaoLabel);
			
			cargoLabel.setBounds(200, 375, 100, 30);
			cargoBox.setBounds(200, 400, 600, 30);
			tela.add(cargoBox);
			tela.add(cargoLabel);
			
			botaoSalvar.setBounds(700, 600, 100, 50);
			tela.add(botaoSalvar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
			candidatos = new JList<ControleCandidato>(controle.puxarCandidatos());
			candidatos.setFixedCellHeight(20);
			candidatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			scrollPane = new JScrollPane(candidatos);
			scrollPane.setBounds(350,450,300,200);
			candidatos.addListSelectionListener(this);
			tela.add(scrollPane);
			
			tela.setVisible(true);
			
			botaoSalvar.addActionListener(this);
			botaoVoltar.addActionListener(this);
			
		}
		if (editar == true) {
			controle = c;
			tela.getContentPane().setBackground(Color.lightGray);
			tela.setSize(1000, 1000);
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setTitle("Login do Candidato");
			tela.setLocationRelativeTo(null);
			tela.setLayout(null);
			
			nomeLabel.setBounds(200, 75, 100, 30);
			nomeBox.setBounds(200, 100, 600, 30);
			nomeBox.setText(controle.nomeCandidato());
			tela.add(nomeBox);
			tela.add(nomeLabel);
			
			emailLabel.setBounds(200, 125, 100, 30);
			emailBox.setBounds(200, 150, 600, 30);
			emailBox.setText(controle.emailCandidato());
			tela.add(emailBox);
			tela.add(emailLabel);
			
			cpfLabel.setBounds(200, 175, 100, 30);
			cpfBox.setBounds(200, 200, 600, 30);
			cpfBox.setText(Long.toString(controle.cpfCandidato()));
			tela.add(cpfLabel);
			tela.add(cpfBox);
			
			enderecoLabel.setBounds(200, 225, 100, 30);
			enderecoBox.setBounds(200, 250, 600, 30);
			enderecoBox.setText(controle.enderecoCandidato());
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			competenciasLabel.setBounds(200, 275, 100, 30);
			competenciasBox.setBounds(200, 300, 600, 30);
			competenciasBox.setText(controle.competenciasCandidato());
			tela.add(competenciasBox);
			tela.add(competenciasLabel);
			
			formacaoLabel.setBounds(200, 325, 100, 30);
			formacaoBox.setBounds(200, 350, 600, 30);
			formacaoBox.setText(controle.formacaoCandidato());
			tela.add(formacaoBox);
			tela.add(formacaoLabel);
			
			cargoLabel.setBounds(200, 375, 100, 30);
			cargoBox.setBounds(200, 400, 600, 30);
			cargoBox.setText(controle.cargoCandidato());
			tela.add(cargoBox);
			tela.add(cargoLabel);
			
			botaoEditar.setBounds(700, 600, 100, 50);
			tela.add(botaoEditar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
			tela.setVisible(true);
			
			botaoEditar.addActionListener(this);
			
			botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCandidato(controle);
				tela.dispose();
			}
		});
		}
		
	}
	/**
	 * Implementa o metodo actionPerformed da interface ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String cpf = cpfBox.getText();
			String email = emailBox.getText();
			String competencias = competenciasBox.getText();
			String formacao = formacaoBox.getText();
			String cargo = cargoBox.getText();
			
			if (controle.criarCandidato(nome, endereco, cpf, email, competencias, formacao, cargo)) {
				new TelaCandidato(controle);
				tela.dispose();
			} else {
				mensagemDadosInvalidos();
			}
				
		}else if(e.getSource() == botaoVoltar) {
			new TelaEscolha(false);
			tela.dispose();
		} else if (e.getSource() == botaoEditar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String cpf = cpfBox.getText();
			String email = emailBox.getText();
			String competencias = competenciasBox.getText();
			String formacao = formacaoBox.getText();
			String cargo = cargoBox.getText();
			
			if (controle.editarCandidato(nome, endereco, cpf, email, competencias, formacao, cargo)) {
				new TelaCandidato(controle);
				tela.dispose();
			} else {
				mensagemDadosInvalidos();
			}
		}
	}
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && candidatos.getSelectedIndex() != -1) {
			controle.setCandidato(candidatos.getSelectedValue().getCandidato());
			new TelaCandidato(controle);
			tela.dispose();
		}
	}
	
	/**
	 * Gera uma mensagem de erro para usuario
	 */
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios com informacoes validas", null, JOptionPane.ERROR_MESSAGE);
	}

}