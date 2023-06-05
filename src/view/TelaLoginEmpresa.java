package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaLoginEmpresa extends JFrame implements ActionListener{

	//public JTextField nome, email, endereco, setor, resumo, missao;
	//public JButton botaoSalvar, botaoVoltar;
	JFrame tela = new JFrame();
	JTextField nome = new JTextField("Nome");
	JTextField email = new JTextField("Email");
	JTextField endereco = new JTextField("Endereço");
	JTextField setor = new JTextField("Setor de Atuação");
	JTextField resumo = new JTextField("Resumo");
	JTextField missao = new JTextField("Missão");
	JButton botaoSalvar = new JButton("Salvar");
	JButton botaoVoltar = new JButton("Voltar");
	
	public TelaLoginEmpresa() {
		
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
		
		setor.setBounds(200, 250, 600, 30);
		tela.add(setor);

		resumo.setBounds(200, 300, 600, 30);
		tela.add(resumo);

		missao.setBounds(200, 350, 600, 30);
		tela.add(missao);
		
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
			String s = setor.getText();
			String r = resumo.getText();
			String m = missao.getText();
		}else if(e.getSource() == botaoSalvar) {
			TelaEscolha tela = new TelaEscolha();
			tela.setVisible(true);
			setVisible(false);
			this.dispose();
		}
	}
}
