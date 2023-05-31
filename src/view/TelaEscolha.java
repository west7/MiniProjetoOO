package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Candidato;
import modelo.Empresa;

public class TelaEscolha implements ActionListener{
	
	public JButton botaoCandidato, botaoEmpresa;

	public TelaEscolha() {
		JFrame jFrame = new JFrame("Tela Escolha");
		jFrame.getContentPane().setBackground(Color.lightGray);
		jFrame.setTitle("Escolha de Usuário");
		jFrame.setVisible(true);
		jFrame.setSize(1000, 500);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setLayout(null);
	
		JButton botaoCandidato = new JButton("Candidato");
		botaoCandidato.setBounds(250, 200, 200, 70);
		botaoCandidato.setFont(new Font("Arial", Font.BOLD, 20));
		
		jFrame.add(botaoCandidato);
		
		JButton botaoEmpresa = new JButton("Empresa");
		botaoEmpresa.setBounds(550, 200, 200, 70);
		botaoEmpresa.setFont(new Font("Arial", Font.BOLD, 20));
		jFrame.add(botaoEmpresa);
		
		JLabel label = new JLabel("ESCOLHA: ");
		label.setBounds(450, 100, 200, 70);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setForeground(Color.black);
		jFrame.add(label);
		
		botaoCandidato.addActionListener(this);
		botaoEmpresa.addActionListener(this);
		this.botaoCandidato = botaoCandidato;
		this.botaoEmpresa = botaoEmpresa;
		}	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoCandidato) {
			System.out.println("candidato");			
		}else if(e.getSource() == botaoEmpresa) {
			System.out.println("empresa");	
		}
	}
}
