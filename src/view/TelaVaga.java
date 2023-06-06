package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaVaga extends JFrame {

	JFrame tela = new JFrame("Descrição da vaga");
	JLabel vagaLabel = new JLabel ("Cargo da Vaga");
	JLabel nomeEmpresaLabel = new JLabel ("Nome da empresa");
	JLabel localLabel = new JLabel ("Local da vaga");
	JLabel salarioLabel = new JLabel("Salario da Vaga");
	JLabel requisitosLabel = new JLabel ("Requisitos da Vaga");
	JPanel vagaPanel = new JPanel();
	
	public TelaVaga() {

		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login do Usuário");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		vagaLabel.setBounds(5, 5, 500, 40);
		vagaLabel.setFont(new Font("Arial", Font.BOLD, 32));
		vagaLabel.setText("<html><b>Descrição da Vaga - Titulo</b></html>");
		tela.add(vagaLabel);
		
		nomeEmpresaLabel.setBounds(5, 50, 200, 20);
		nomeEmpresaLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		nomeEmpresaLabel.setText("<html><b>Nome da Empresa</b></html>");
		tela.add(nomeEmpresaLabel);
		
		vagaPanel.setBounds(600, 10, 300, 600);
		vagaPanel.setBackground(Color.white);
		tela.add(vagaPanel);
		
		localLabel.setBounds(5, 70, 200, 50);
		localLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
		localLabel.setForeground(Color.black);
		tela.add(localLabel);
		//vagaPanel.add(requisitosLabel);
		
		tela.setVisible(true);
	}
}
