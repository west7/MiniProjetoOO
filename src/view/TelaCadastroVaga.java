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

public class TelaCadastroVaga extends JFrame implements ActionListener {
	
	private JFrame tela = new JFrame();
	private JLabel funcaoLabel = new JLabel("Função: "); 
	private JTextField funcaoBox = new JTextField();
	private JLabel salarioLabel = new JLabel("Salario: ");
	private JTextField salarioBox = new JTextField();
	private JLabel requisitosLabel = new JLabel("Requisitos: ");
	private JTextField requisitosBox = new JTextField();
	private JButton botaoCadastrar = new JButton("Cadastrar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JButton botaoEditar = new JButton("Editar");
	private ControleEmpresa controle;
	private ControleDeVaga controleVaga;
	
	public TelaCadastroVaga(ControleEmpresa c) {
		controle = c;
		
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
	
	public TelaCadastroVaga(ControleEmpresa c, ControleDeVaga v) {
		controle = c;
		controleVaga = v;
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoCadastrar) {
			String fun = funcaoBox.getText();
			String salStr = salarioBox.getText();
			double sal = Double.parseDouble(salStr);
			String req = requisitosBox.getText();
			controle.abrirVaga(fun, sal, req);
			tela.dispose();
		}
		else if (e.getSource() == botaoVoltar) {
			tela.dispose();
		}else if (e.getSource() == botaoEditar) {
			//String fun = funcaoBox.getText().isEmpty() != true ? funcaoBox.getText() : controleVaga.getVaga().getFuncao();
			//String salStr = salarioBox.getText().isEmpty() != true ? salarioBox.getText() : String.valueOf(controleVaga.getVaga().getSalario());
			//double sal = Double.parseDouble(salStr);
			//String req = requisitosBox.getText().isEmpty() != true ? requisitosBox.getText() : controleVaga.getVaga().getRequisitos();
			String fun = funcaoBox.getText();
			String salStr = salarioBox.getText();
			double sal = Double.parseDouble(salStr);
			String req = requisitosBox.getText();
			if (fun.isEmpty() || salStr.isEmpty() || req.isEmpty()) {
				mensagemDadosInvalidos();
			} else {
				controle.editarVaga(controleVaga.getVaga(), fun, sal, req);
				tela.dispose();				
			}
		}

	}
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Insira dados válidos", null, JOptionPane.INFORMATION_MESSAGE);
		//janela.dispose();
	}

}
