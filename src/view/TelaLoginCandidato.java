package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaLoginCandidato extends JFrame implements ActionListener{
	
	//public JTextField nome, email, endereco, habilidades, formacao, cargo;
	//public JButton botaoSalvar, botaoVoltar;
	JFrame tela = new JFrame();
	JTextField nome = new JTextField("Nome");
	JTextField email = new JTextField("Email");
	JTextField endereco = new JTextField("Endereço");
	JTextField habilidades = new JTextField("Habilidades");
	JTextField formacao = new JTextField("Formação");
	JTextField cargo = new JTextField("Cargo");
	JButton botaoSalvar = new JButton("Salvar");
	JButton botaoVoltar = new JButton("Voltar");

	public TelaLoginCandidato() {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login do Usuário");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		nome.setBounds(200, 100, 600, 30);
		tela.add(nome);
		
		email.setBounds(200, 150, 600, 30);
		tela.add(email);
		
		endereco.setBounds(200, 200, 600, 30);
		tela.add(endereco);
		
		habilidades.setBounds(200, 250, 600, 30);
		tela.add(habilidades);

		formacao.setBounds(200, 300, 600, 30);
		tela.add(formacao);

		cargo.setBounds(200, 350, 600, 30);
		tela.add(cargo);
		
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
			String n = nome.getText();
			String end = endereco.getText();
			String eml = email.getText();
			String f = formacao.getText();
			String h = habilidades.getText();
			String c = cargo.getText();
		}else if(e.getSource() == botaoVoltar) {
			//TelaEscolha tela = new TelaEscolha();
			//tela.setVisible(true);
			//this.dispose();
		}
		
	}
}
