package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	private JButton botaoVoltar = new JButton("Voltar");
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel emailLabel = new JLabel("Email: ");
	private JLabel enderecoLabel = new JLabel("Endereço: ");
	private JLabel habilidadesLabel = new JLabel("Habilidades: ");
	private JLabel formacaoLabel = new JLabel("Formação: ");
	private JLabel cargoLabel = new JLabel("Cargo: ");


	public TelaLoginCandidato() {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login do Usuário");
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
		
		/*
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEscolha();
				tela.dispose();
			}
		});*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String n = nomeBox.getText();
			String end = enderecoBox.getText();
			String eml = emailBox.getText();
			String f = formacaoBox.getText();
			String h = habilidadesBox.getText();
			String c = cargoBox.getText();
		}else if(e.getSource() == botaoVoltar) {
			new TelaEscolha();
			tela.dispose();
			//tela.setVisible(true);
			//this.dispose();
		}
		
	}
}
