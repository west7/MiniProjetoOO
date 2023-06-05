package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaLoginCandidato extends JFrame{

	public TelaLoginCandidato() {
		JFrame tela = new JFrame();
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login do Usuário");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		JTextField nome = new JTextField("Nome");
		nome.setBounds(200, 100, 600, 30);
		tela.add(nome);
		
		JTextField email = new JTextField("Email");
		email.setBounds(200, 150, 600, 30);
		tela.add(email);
		
		JTextField endereco = new JTextField("Endereço");
		endereco.setBounds(200, 200, 600, 30);
		tela.add(endereco);
		
		JTextField habilidades = new JTextField("Habilidades");
		habilidades.setBounds(200, 250, 600, 30);
		tela.add(habilidades);

		JTextField formacao = new JTextField("Formação");
		formacao.setBounds(200, 300, 600, 30);
		tela.add(formacao);

		JTextField cargo = new JTextField("Cargo");
		cargo.setBounds(200, 350, 600, 30);
		tela.add(cargo);

		tela.setVisible(true);
		
	}
}
