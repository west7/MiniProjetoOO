package view;
//import modelo.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroVaga extends JFrame implements ActionListener {
	
	JFrame tela = new JFrame();
	JLabel funcaoLabel = new JLabel("Função: "); 
	JTextField funcaoBox = new JTextField();
	JLabel salarioLabel = new JLabel("Salario: ");
	JTextField salarioBox = new JTextField();
	JLabel requisitosLabel = new JLabel("Requisitos: ");
	JTextField requisitosBox = new JTextField();
	JButton botaoCadastrar = new JButton("Cadastrar");
	JButton botaoVoltar = new JButton("Voltar");
	
	public CadastroVaga() {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(525, 350);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Cadastrar vaga");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		funcaoLabel.setBounds(50,30,100,20);
		funcaoBox.setBounds(50, 50, 400, 30);
		tela.add(funcaoLabel);
		tela.add(funcaoBox);
		
		salarioLabel.setBounds(50,80,100,20);
		salarioBox.setBounds(50, 100, 400, 30);
		tela.add(salarioLabel);
		tela.add(salarioBox);
		
		requisitosLabel.setBounds(50,130,100,20);
		requisitosBox.setBounds(50, 150, 400, 30);
		tela.add(requisitosLabel);
		tela.add(requisitosBox);
		
		
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
			String fun = funcaoBox.getText();
			String salStr = salarioBox.getText();
			double sal = Double.parseDouble(salStr);
			String req = requisitosBox.getText();
			//Vaga = new Vaga(fun, sal, req);
		}
		
	}

}
