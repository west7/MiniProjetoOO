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

/**
 * Classe que gera a visualizacao do cadastro de uma Vaga
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Vaga
 *
 */
public class TelaCadastroVaga extends JFrame implements ActionListener {
	
	private JFrame tela = new JFrame();
	private JLabel funcaoLabel = new JLabel("<html><font color='red'>*</font> Funcao</html>"); 
	private JTextField funcaoBox = new JTextField();
	private JLabel salarioLabel = new JLabel("<html><font color='red'>*</font> Salario</html>");
	private JTextField salarioBox = new JTextField();
	private JLabel requisitosLabel = new JLabel("<html><font color='red'>*</font> Requisitos</html>");
	private JTextField requisitosBox = new JTextField();
	private JButton botaoCadastrar = new JButton("Cadastrar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoEditar = new JButton("Editar");
	private ControleEmpresa controle;
	private ControleDeVaga controleVaga;
	private TelaEmpresa telaEmpresa;
	
	/**
	 * Construtor da tela de cadastro
	 * @param c ControleEmpresa
	 * @param t TelaEmpresa
	 */
	public TelaCadastroVaga(ControleEmpresa c, TelaEmpresa t) {
		controle = c;
		telaEmpresa = t;
		
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
		
		botaoCadastrar.addActionListener(this);
		botaoVoltar.addActionListener(this);
	}
	/**
	 * Construtor da tela de edicao
	 * @param c ControleEmpresa
	 * @param v ControleDeVaga
	 * @param t TelaEmpresa
	 */
	public TelaCadastroVaga(ControleEmpresa c, ControleDeVaga v, TelaEmpresa t) {
		controle = c;
		controleVaga = v;
		telaEmpresa = t;
		
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(525, 350);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Editar vaga");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		funcaoLabel.setBounds(50,30,100,20);
		funcaoBox.setBounds(50, 50, 400, 30);
		funcaoBox.setText(controleVaga.funcaoVaga());
		tela.add(funcaoLabel);
		tela.add(funcaoBox);
		
		salarioLabel.setBounds(50,80,100,20);
		salarioBox.setBounds(50, 100, 400, 30);
		salarioBox.setText(String.valueOf(controleVaga.salarioVaga()));
		tela.add(salarioLabel);
		tela.add(salarioBox);
		
		requisitosLabel.setBounds(50,130,100,20);
		requisitosBox.setBounds(50, 150, 400, 30);
		requisitosBox.setText(controleVaga.requisitosVaga());
		tela.add(requisitosLabel);
		tela.add(requisitosBox);
		
		
		botaoEditar.setBounds(350, 200, 100, 50);
		tela.add(botaoEditar);
		
		botaoVoltar.setBounds(50, 200, 100, 50);
		tela.add(botaoVoltar);

		tela.setVisible(true);
		
		botaoEditar.addActionListener(this);
		botaoVoltar.addActionListener(this);
	}
	/**
	 * Implementa o metodo da interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoCadastrar) {
			String fun = funcaoBox.getText();
			String salStr = salarioBox.getText();
			String req = requisitosBox.getText();
			if (controle.abrirVaga(fun, salStr, req)) {
				tela.dispose();
				telaEmpresa.atualizarJList();
			} else {
				mensagemDadosInvalidos();
			}
		}
		else if (e.getSource() == botaoVoltar) {
			tela.dispose();
		}else if (e.getSource() == botaoEditar) {
			String fun = funcaoBox.getText();
			String salStr = salarioBox.getText();
			String req = requisitosBox.getText();
			if (controle.editarVaga(controleVaga.getVaga(), fun, salStr, req)) {
				tela.dispose();
				telaEmpresa.atualizarPanel();
			} else {
				mensagemDadosInvalidos();
			}
		}

	}
	/**
	 * Gera uma mensagem de erro ao usuario
	 */
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Insira dados válidos", null, JOptionPane.ERROR_MESSAGE);
	}

}
