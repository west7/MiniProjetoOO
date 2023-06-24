package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

import controle.ControleDeVaga;
import controle.ControleEmpresa;

public class TelaLoginEmpresa extends JFrame implements ListSelectionListener, ActionListener{

	private JFrame tela = new JFrame();
	private JTextField nomeBox = new JTextField("");
	private JTextField emailBox = new JTextField("");
	private JTextField cnpjBox = new JTextField("");
	private JTextField enderecoBox = new JTextField("");
	private JTextField setorBox = new JTextField("");
	private JTextField resumoBox = new JTextField("");
	private JTextField missaoBox = new JTextField("");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoEditar = new JButton("Editar");
	private JButton botaoVoltar = new JButton("Voltar");
	private JLabel nomeLabel = new JLabel("<html><font color='red'>*</font> Nome</html>");
	private JLabel emailLabel = new JLabel("<html><font color='red'>*</font> Email</html>");
	private JLabel cnpjLabel = new JLabel("<html><font color='red'>*</font> CNPJ</html>");
	private JLabel enderecoLabel = new JLabel("<html><font color='red'>*</font> Endereco</html>");
	private JLabel setorLabel = new JLabel("<html><font color='red'>*</font> Setor</html>");
	private JLabel resumoLabel = new JLabel("Resumo");
	private JLabel missaoLabel = new JLabel("Missão");
	private JList<ControleEmpresa> empresas;
	private JScrollPane scrollPane;
	private ControleEmpresa controle;
	
	public TelaLoginEmpresa(ControleEmpresa c, boolean editar) {
		
		if(editar == false) {
			controle = new ControleEmpresa();
			
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
			
			cnpjLabel.setBounds(200, 175, 100, 30);
			cnpjBox.setBounds(200, 200, 600, 30);
			tela.add(cnpjLabel);
			tela.add(cnpjBox);
			
			enderecoLabel.setBounds(200, 225, 100, 30);
			enderecoBox.setBounds(200, 250, 600, 30);
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			setorLabel.setBounds(200, 275, 100, 30);
			setorBox.setBounds(200, 300, 600, 30);
			tela.add(setorBox);
			tela.add(setorLabel);
			
			resumoLabel.setBounds(200, 325, 100, 30);
			resumoBox.setBounds(200, 350, 600, 30);
			tela.add(resumoBox);
			tela.add(resumoLabel);
			
			missaoLabel.setBounds(200, 375, 100, 30);
			missaoBox.setBounds(200, 400, 600, 30);
			tela.add(missaoBox);
			tela.add(missaoLabel);
			
			botaoSalvar.setBounds(700, 600, 100, 50);
			tela.add(botaoSalvar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
			empresas = new JList<ControleEmpresa>(controle.puxarEmpresas());
			empresas.setFixedCellHeight(20);
			empresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			scrollPane = new JScrollPane(empresas);
			scrollPane.setBounds(350,450,300,200);
			empresas.addListSelectionListener(this);
			tela.add(scrollPane);
			
			tela.setVisible(true);
			
			botaoSalvar.addActionListener(this);
			botaoVoltar.addActionListener(this);
			
		}
		if (editar == true) {
			controle = c;
			
			tela.getContentPane().setBackground(Color.lightGray);
			tela.setSize(1000, 1000);
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setTitle("Login da Empresa");
			tela.setLocationRelativeTo(null);
			tela.setLayout(null);
			
			nomeLabel.setBounds(200, 75, 100, 30);
			nomeBox.setBounds(200, 100, 600, 30);
			nomeBox.setText(controle.nomeEmpresa());
			tela.add(nomeBox);
			tela.add(nomeLabel);
			
			emailLabel.setBounds(200, 125, 100, 30);
			emailBox.setBounds(200, 150, 600, 30);
			emailBox.setText(controle.emailEmpresa());
			tela.add(emailBox);
			tela.add(emailLabel);
			
			cnpjLabel.setBounds(200, 175, 100, 30);
			cnpjBox.setBounds(200, 200, 600, 30);
			cnpjBox.setText(Long.toString(controle.cnpjEmpresa()));
			tela.add(cnpjLabel);
			tela.add(cnpjBox);
			
			enderecoLabel.setBounds(200, 225, 100, 30);
			enderecoBox.setBounds(200, 250, 600, 30);
			enderecoBox.setText(controle.enderecoEmpresa());
			tela.add(enderecoBox);
			tela.add(enderecoLabel);
			
			setorLabel.setBounds(200, 275, 100, 30);
			setorBox.setBounds(200, 300, 600, 30);
			setorBox.setText(controle.setorEmpresa());
			tela.add(setorBox);
			tela.add(setorLabel);
			
			resumoLabel.setBounds(200, 325, 100, 30);
			resumoBox.setBounds(200, 350, 600, 30);
			resumoBox.setText(controle.resumoEmpresa());
			tela.add(resumoBox);
			tela.add(resumoLabel);
			
			missaoLabel.setBounds(200, 375, 100, 30);
			missaoBox.setBounds(200, 400, 600, 30);
			missaoBox.setText(controle.missaoEmpresa());
			tela.add(missaoBox);
			tela.add(missaoLabel);
			
			botaoEditar.setBounds(700, 600, 100, 50);
			tela.add(botaoEditar);
			
			botaoVoltar.setBounds(200, 600, 100, 50);
			tela.add(botaoVoltar);
			
			tela.setVisible(true);
			
			botaoEditar.addActionListener(this);
			
			botaoVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaEmpresa(controle);
				tela.dispose();
			}
		});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoSalvar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String cnpj = cnpjBox.getText();
			String email = emailBox.getText();
			String setor = setorBox.getText();
			String resumo = resumoBox.getText();
			String missao = missaoBox.getText();
			if (controle.criarEmpresa(nome, endereco, cnpj, email, setor, resumo, missao)) {
				new TelaEmpresa(controle);
				tela.dispose();
			} else {
				mensagemDadosInvalidos();
			}
				
		}else if(e.getSource() == botaoVoltar) {
			new TelaEscolha(false);
			tela.dispose();
		}
		else if (e.getSource() == botaoEditar) {
			String nome = nomeBox.getText();
			String endereco = enderecoBox.getText();
			String cnpj = cnpjBox.getText();
			String email = emailBox.getText();
			String setor = setorBox.getText();
			String resumo = resumoBox.getText();
			String missao = missaoBox.getText();
			
			if(controle.editarEmpresa(nome, endereco, cnpj, email, setor, resumo, missao)) {
				new TelaEmpresa(controle);
				tela.dispose();
			} else {
				mensagemDadosInvalidos();
			}
		}
	}
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && empresas.getSelectedIndex() != -1) {
			controle.setEmpresa(empresas.getSelectedValue().getEmpresa());
			new TelaEmpresa(controle);
			tela.dispose();
		}
	}
	
	public void mensagemDadosInvalidos() {
		JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios com informacoes validas", null, JOptionPane.ERROR_MESSAGE);
	}

}
