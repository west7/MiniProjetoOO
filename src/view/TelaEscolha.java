package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.*;

/**
 * Classe que gera a visualizacao da escolha do usuario entre Candidato ou Empresa
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Candidato
 * @see Empresa
 *
 */
public class TelaEscolha extends JFrame implements ActionListener{
	
	private JFrame jFrame = new JFrame();
	private JButton botaoCandidato = new JButton("Sou Candidato");
	private JButton botaoEmpresa = new JButton("Sou Empresa");
	private JLabel label = new JLabel("ESCOLHA:");
	private ControleEmpresa c;

	/**
	 * Construtor que verifica se e a primeira vez que o usuario abre a tela ou nao
	 * @param primeiraTela boolean
	 */
	public TelaEscolha(boolean primeiraTela) {
		if (primeiraTela == true) {
			c = new ControleEmpresa();
			c.inserirDados();
			
			jFrame.getContentPane().setBackground(Color.lightGray);
			jFrame.setTitle("Escolha de Usuário");
			jFrame.setVisible(true);
			jFrame.setSize(1000, 1000);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jFrame.setLayout(null);
			
			botaoCandidato.setBounds(250, 400, 200, 70);
			botaoCandidato.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoCandidato);
			
			botaoEmpresa.setBounds(550, 400, 200, 70);
			botaoEmpresa.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoEmpresa);
			
			label.setBounds(450, 300, 200, 70);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			label.setForeground(Color.black);
			jFrame.add(label);
			
			botaoCandidato.addActionListener(this);
			botaoEmpresa.addActionListener(this);
			
		} else if (primeiraTela == false) {
			jFrame.getContentPane().setBackground(Color.lightGray);
			jFrame.setTitle("Escolha de Usuário");
			jFrame.setVisible(true);
			jFrame.setSize(1000, 1000);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jFrame.setLayout(null);
		
			botaoCandidato.setBounds(250, 400, 200, 70);
			botaoCandidato.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoCandidato);
			
			botaoEmpresa.setBounds(550, 400, 200, 70);
			botaoEmpresa.setFont(new Font("Arial", Font.BOLD, 20));
			jFrame.add(botaoEmpresa);
			
			label.setBounds(450, 300, 200, 70);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			label.setForeground(Color.black);
			jFrame.add(label);
			
			botaoCandidato.addActionListener(this);
			botaoEmpresa.addActionListener(this);
		}

	}
	/**
	 * Implementa o metodo actionPerformed da interface ActionListener
	 */
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
	public static void main(String[] args) {
		new TelaEscolha(true);
	}
}
