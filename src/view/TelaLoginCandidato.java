package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleCandidato;

public class TelaLoginCandidato extends JFrame implements ActionListener{
	
	//public JTextField nome, email, endereco, habilidades, formacao, cargo;
	//public JButton botaoSalvar, botaoVoltar;
	private JFrame tela = new JFrame();
	private JTextField nomeBox = new JTextField("");
	private JTextField emailBox = new JTextField("");
	private JTextField enderecoBox = new JTextField("");
	private JTextField habilidadesBox = new JTextField("");
	private JTextField formacaoBox = new JTextField("");
	private JTextField cargoBox = new JTextField("");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoEditar = new JButton("Editar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel emailLabel = new JLabel("Email: ");
	private JLabel enderecoLabel = new JLabel("Endereço: ");
	private JLabel habilidadesLabel = new JLabel("Habilidades: ");
	private JLabel formacaoLabel = new JLabel("Formação: ");
	private JLabel cargoLabel = new JLabel("Cargo: ");
	private ControleCandidato controle;


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
			
			enderecoLabel.setBounds(200, 175, 100, 30);
			enderecoBox.setBounds(200, 200, 600, 30);
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			habilidadesLabel.setBounds(200, 225, 100, 30);
			habilidadesBox.setBounds(200, 250, 600, 30);
			tela.add(habilidadesBox);
			tela.add(habilidadesLabel);
			
			formacaoLabel.setBounds(200, 275, 100, 30);
			formacaoBox.setBounds(200, 300, 600, 30);
			tela.add(formacaoBox);
			tela.add(formacaoLabel);
			
			cargoLabel.setBounds(200, 325, 100, 30);
			cargoBox.setBounds(200, 350, 600, 30);
			tela.add(cargoBox);
			tela.add(cargoLabel);
			
			botaoSalvar.setBounds(700, 600, 100, 50);
			tela.add(botaoSalvar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
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
			
			enderecoLabel.setBounds(200, 175, 100, 30);
			enderecoBox.setBounds(200, 200, 600, 30);
			enderecoBox.setText(controle.enderecoCandidato());
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			habilidadesLabel.setBounds(200, 225, 100, 30);
			habilidadesBox.setBounds(200, 250, 600, 30);
			habilidadesBox.setText(controle.habilidadesCandidato());
			tela.add(habilidadesBox);
			tela.add(habilidadesLabel);
			
			formacaoLabel.setBounds(200, 275, 100, 30);
			formacaoBox.setBounds(200, 300, 600, 30);
			formacaoBox.setText(controle.formacaoCandidato());
			tela.add(formacaoBox);
			tela.add(formacaoLabel);
			
			cargoLabel.setBounds(200, 325, 100, 30);
			cargoBox.setBounds(200, 350, 600, 30);
			cargoBox.setText(controle.cargoCandidato());
			tela.add(cargoBox);
			tela.add(cargoLabel);
			
			botaoEditar.setBounds(700, 600, 100, 50);
			tela.add(botaoEditar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
			tela.setVisible(true);
			
			botaoEditar.addActionListener(this);
			//botaoVoltar.addActionListener(this);
			
			botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.dispose();
			}
		});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String email = emailBox.getText();
			String habilidades = habilidadesBox.getText();
			String formacao = formacaoBox.getText();
			String cargo = cargoBox.getText();
			
			if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() || habilidades.isEmpty() || 
					formacao.isEmpty() || cargo.isEmpty()) {
				mensagemDadosInvalidos();
			} else {
				controle.criarCandidato(nome, endereco, 0001, email, habilidades, formacao, cargo);
				new TelaCandidato(controle);
				tela.dispose();
			}
				
		}else if(e.getSource() == botaoVoltar) {
			new TelaEscolha();
			tela.dispose();
		} else if (e.getSource() == botaoEditar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String email = emailBox.getText();
			String habilidades = habilidadesBox.getText();
			String formacao = formacaoBox.getText();
			String cargo = cargoBox.getText();
			
			if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() || habilidades.isEmpty() || 
					formacao.isEmpty() || cargo.isEmpty()) {
				mensagemDadosInvalidos();
			} else {
				controle.editarCandidato(nome, endereco, 0001, email, habilidades, formacao, cargo);
				new TelaCandidato(controle);
				tela.dispose();
			}
		}
	}
	
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Insira dados válidos", null, JOptionPane.INFORMATION_MESSAGE);
		//janela.dispose();
	}

}