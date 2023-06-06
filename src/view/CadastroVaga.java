package view;
import modelo.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CadastroVaga extends JFrame implements ActionListener {
	
	JFrame tela = new JFrame();
	JTextField funcao = new JTextField("Funcao");
	JTextField salario = new JTextField("Salario");
	JTextField requisitos = new JTextField("Requisitos");
	JButton botaoCadastrar = new JButton("Cadastrar");
	JButton botaoVoltar = new JButton("Voltar");
	
	public CadastroVaga() {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login do Usuário");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		funcao.setBounds(200, 100, 600, 30);
		tela.add(funcao);
		
		salario.setBounds(200, 150, 600, 30);
		tela.add(salario);
		
		requisitos.setBounds(200, 200, 600, 30);
		tela.add(requisitos);
		
		
		botaoCadastrar.setBounds(700, 250, 100, 50);
		tela.add(botaoCadastrar);
		
		botaoVoltar.setBounds(200, 250, 100, 50);
		tela.add(botaoVoltar);

		tela.setVisible(true);
		
		
		botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new TelaEscolha();
				//tela.dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoCadastrar) {
			String fun = funcao.getText();
			String salStr = salario.getText();
			double sal = Double.parseDouble(salStr);
			String req = requisitos.getText();
			//Vaga = new Vaga(fun, sal, req);
		}
		
	}

}
