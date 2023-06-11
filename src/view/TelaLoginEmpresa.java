package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleDeVaga;
import controle.ControleEmpresa;

public class TelaLoginEmpresa extends JFrame implements ActionListener{

	//public JTextField nome, email, endereco, setor, resumo, missao;
	//public JButton botaoSalvar, botaoVoltar;
	private JFrame tela = new JFrame();
	private JTextField nomeBox = new JTextField("");
	private JTextField emailBox = new JTextField("");
	private JTextField enderecoBox = new JTextField("");
	private JTextField setorBox = new JTextField("");
	private JTextField resumoBox = new JTextField("");
	private JTextField missaoBox = new JTextField("");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel emailLabel = new JLabel("Email: ");
	private JLabel enderecoLabel = new JLabel("Endereço: ");
	private JLabel setorLabel = new JLabel("Setor: ");
	private JLabel resumoLabel = new JLabel("Resumo: ");
	private JLabel missaoLabel = new JLabel("Missão: ");
	private ControleEmpresa controle;
	//private ControleDeVaga controleVaga;
	
	public TelaLoginEmpresa() {
		
		controle = new ControleEmpresa();
		//controleVaga = new ControleDeVaga();
		
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Login da Empresa");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		nomeLabel.setBounds(200, 75, 100, 30);
		nomeBox.setBounds(200, 100, 600, 30);
		tela.add(nomeBox);
		tela.add(nomeLabel);
		
		emailLabel.setBounds(200, 125, 100, 30);
		emailBox.setBounds(200, 150, 600, 30);
		tela.add(emailBox);
		tela.add(emailLabel);
		
		enderecoLabel.setBounds(200, 175, 100, 30);
		enderecoBox.setBounds(200, 200, 600, 30);
		tela.add(enderecoBox);
		tela.add(enderecoLabel);

		setorLabel.setBounds(200, 225, 100, 30);
		setorBox.setBounds(200, 250, 600, 30);
		tela.add(setorBox);
		tela.add(setorLabel);

		resumoLabel.setBounds(200, 275, 100, 30);
		resumoBox.setBounds(200, 300, 600, 30);
		tela.add(resumoBox);
		tela.add(resumoLabel);

		missaoLabel.setBounds(200, 325, 100, 30);
		missaoBox.setBounds(200, 350, 600, 30);
		tela.add(missaoBox);
		tela.add(missaoLabel);
		
		botaoSalvar.setBounds(700, 600, 100, 50);
		tela.add(botaoSalvar);
		
		botaoVoltar.setBounds(200, 600, 100, 50);
		tela.add(botaoVoltar);

		tela.setVisible(true);
		
		botaoSalvar.addActionListener(this);
		botaoVoltar.addActionListener(this);
		
		/*botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEscolha();
				tela.dispose();
			}
		});*/
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String email = emailBox.getText();
			String setor = setorBox.getText();
			String resumo = resumoBox.getText();
			String missao = missaoBox.getText();
			
			if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() || setor.isEmpty() || 
					resumo.isEmpty() || missao.isEmpty()) {
				mensagemDadosInvalidos();
			} else {
				controle.criarEmpresa(nome, endereco, 0001, email, setor, resumo, missao);
				//Empresa empresa = new Empresa(nome, endereco, 0001, email, setor, resumo, missao);				
				new TelaEmpresa(controle);
				tela.dispose();
			}
				
		}else if(e.getSource() == botaoVoltar) {
			new TelaEscolha();
			tela.dispose();
		}
	}
	
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Insira dados válidos", null, JOptionPane.INFORMATION_MESSAGE);
		//janela.dispose();
	}

}
