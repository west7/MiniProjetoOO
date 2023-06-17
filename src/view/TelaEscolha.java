package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.*;

public class TelaEscolha extends JFrame implements ActionListener{
	
	//public JButton botaoCandidato, botaoEmpresa;
	private JFrame jFrame = new JFrame();
	private JButton botaoCandidato = new JButton("Candidato");
	private JButton botaoEmpresa = new JButton("Empresa");
	private JLabel label = new JLabel("ESCOLHA: ");
	private ControleEmpresa c;

	public TelaEscolha(boolean primeiraTela) {
		if (primeiraTela == true) {
			c = new ControleEmpresa();
			c.inserirDados();
			
			jFrame.getContentPane().setBackground(Color.lightGray);
			jFrame.setTitle("Escolha de Usuário");
			jFrame.setVisible(true);
			jFrame.setSize(1000, 500);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jFrame.setLayout(null);
			
			botaoCandidato.setBounds(250, 200, 200, 70);
			botaoCandidato.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoCandidato);
			
			botaoEmpresa.setBounds(550, 200, 200, 70);
			botaoEmpresa.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoEmpresa);
			
			label.setBounds(450, 100, 200, 70);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			label.setForeground(Color.black);
			jFrame.add(label);
			
			botaoCandidato.addActionListener(this);
			botaoEmpresa.addActionListener(this);
			
		} else if (primeiraTela == false) {
			jFrame.getContentPane().setBackground(Color.lightGray);
			jFrame.setTitle("Escolha de Usuário");
			jFrame.setVisible(true);
			jFrame.setSize(1000, 500);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jFrame.setLayout(null);
		
			botaoCandidato.setBounds(250, 200, 200, 70);
			botaoCandidato.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoCandidato);
			
			botaoEmpresa.setBounds(550, 200, 200, 70);
			botaoEmpresa.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoEmpresa);
			
			label.setBounds(450, 100, 200, 70);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			label.setForeground(Color.black);
			jFrame.add(label);
			
			botaoCandidato.addActionListener(this);
			botaoEmpresa.addActionListener(this);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoCandidato) {
			new TelaLoginCandidato(null, false);
			jFrame.dispose();
		}else if(e.getSource() == botaoEmpresa) {
			new TelaLoginEmpresa(null, false);
			jFrame.dispose();
		}
	}
}
