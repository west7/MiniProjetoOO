package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaLoginEmpresa extends JFrame implements ActionListener{

	//public JTextField nome, email, endereco, setor, resumo, missao;
	//public JButton botaoSalvar, botaoVoltar;
	JFrame tela = new JFrame();
	JTextField nomeBox = new JTextField("");
	JTextField emailBox = new JTextField("");
	JTextField enderecoBox = new JTextField("");
	JTextField setorBox = new JTextField("");
	JTextField resumoBox = new JTextField("");
	JTextField missaoBox = new JTextField("");
	JButton botaoSalvar = new JButton("Salvar");
	JButton botaoVoltar = new JButton("Voltar");
	JLabel nomeLabel = new JLabel("Nome: ");
	JLabel emailLabel = new JLabel("Email: ");
	JLabel enderecoLabel = new JLabel("Endereço: ");
	JLabel setorLabel = new JLabel("Setor: ");
	JLabel resumoLabel = new JLabel("Resumo: ");
	JLabel missaoLabel = new JLabel("Missão: ");
	
	public TelaLoginEmpresa() {
		
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

		setorLabel.setBounds(200, 225, 100, 30);
		setorBox.setBounds(200, 250, 600, 30);
		tela.add(setorBox);
		tela.add(setorLabel);

		resumoLabel.setBounds(200, 275, 100, 30);
		resumoBox.setBounds(200, 300, 600, 30);
		tela.add(resumoBox);
		tela.add(resumoLabel);

		missaoLabel.setBounds(200, 325, 100, 30);
		missaoBox.setBounds(200, 350, 600, 30);
		tela.add(missaoBox);
		tela.add(missaoLabel);
		
		botaoSalvar.setBounds(700, 600, 100, 50);
		tela.add(botaoSalvar);
		
		botaoVoltar.setBounds(200, 600, 100, 50);
		tela.add(botaoVoltar);

		tela.setVisible(true);
		
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEscolha();
				tela.dispose();
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String n = nomeBox.getText();
			String end = enderecoBox.getText();
			String eml = emailBox.getText();
			String s = setorBox.getText();
			String r = resumoBox.getText();
			String m = missaoBox.getText();
		}else if(e.getSource() == botaoSalvar) {
			TelaEscolha tela = new TelaEscolha();
			tela.setVisible(true);
			setVisible(false);
			this.dispose();
		}
	}
}
