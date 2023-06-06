package view;
import modelo.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CadastroVaga extends JFrame implements ActionListener {
	
	JFrame tela = new JFrame();
	//JLabel func = new JLabel("Função"); 
	JTextField funcao = new JTextField("Funcao");
	JTextField salario = new JTextField("Salario");
	JTextField requisitos = new JTextField("Requisitos");
	JButton botaoCadastrar = new JButton("Cadastrar");
	JButton botaoVoltar = new JButton("Voltar");
	
	public CadastroVaga() {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(525, 350);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Cadastrar vaga");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		funcao.setBounds(50, 50, 400, 30);
		tela.add(funcao);
		
		salario.setBounds(50, 100, 400, 30);
		tela.add(salario);
		
		requisitos.setBounds(50, 150, 400, 30);
		tela.add(requisitos);
		
		
		botaoCadastrar.setBounds(350, 200, 100, 50);
		tela.add(botaoCadastrar);
		
		botaoVoltar.setBounds(50, 200, 100, 50);
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
