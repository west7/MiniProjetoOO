package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleDeVaga;
import controle.ControleEmpresa;

/**
 * Classe gera a visualizacao da tela principal de uma Empresa 
 * @author Guilherme Westphall and Lucas Martins
 * @since 2023
 * @version 1.0
 * @see Empresa
 *
 */
public class TelaEmpresa extends JFrame implements ListSelectionListener, ActionListener {
	
	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	private JLabel cnpj = new JLabel("CNPJ: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel setorAtuacao = new JLabel("Setor de atuacao: ");
	private JLabel resumo = new JLabel("Resumo: ");
	private JLabel missao = new JLabel("Missao: ");
	private JList<ControleDeVaga> vagas;
	private JScrollPane scrollPane; 
	private JPanel vagaPanel = new JPanel();
	private JButton criar = new JButton("Criar");
	private JButton atualizar = new JButton("Atualizar");
	private JButton editarVaga = new JButton("Editar");
	private JButton editarEmpresa = new JButton("Editar Dados");
	private JButton excluirVaga = new JButton("Excluir");
	private JButton pagInicial = new JButton("Pagina Inicial");
	private JButton excluirConta = new JButton("Excluir conta");
	private ControleEmpresa controle;
	private ControleDeVaga controleVaga;
	private JLabel nomeVaga;
	private JLabel reqVaga;
	private JLabel salVaga;
	
	/**
	 * Construtor da tela
	 * @param c ControleEmpresa
	 */
	public TelaEmpresa(ControleEmpresa c) {
		controle = c;
		controleVaga = new ControleDeVaga();
		
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Empresa");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		nome.setBounds(50, 50, 200, 20);
		nome.setText("Nome: " + controle.nomeEmpresa());
		tela.add(nome);
		
		endereco.setBounds(50, 70, 200, 20);
		endereco.setText("Endereco: " + controle.enderecoEmpresa());
		tela.add(endereco);
		
		cnpj.setBounds(50,90,200,20);
		cnpj.setText("CNPJ: " + controle.cnpjEmpresa());
		tela.add(cnpj);
		
		email.setBounds(50,110,200,20);
		email.setText("Email: " + controle.emailEmpresa());
		tela.add(email);
		
		setorAtuacao.setBounds(50,130,200,20);
		setorAtuacao.setText("Setor de Atuacao: " + controle.setorEmpresa());
		tela.add(setorAtuacao);
		
		resumo.setBounds(50,150,200,20);
		resumo.setText("Resumo: " + controle.resumoEmpresa());
		tela.add(resumo);
		
		missao.setBounds(50, 170, 200, 20);
		missao.setText("Missao: " + controle.missaoEmpresa());
		tela.add(missao);
		
		vagaPanel.setBounds(400, 200, 500, 400);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		criar.setBounds(50,600,150,20);
		atualizar.setBounds(200,600,150,20);
		editarVaga.setBounds(100,380,80,20);
		editarEmpresa.setBounds(290, 20, 120, 20);
		excluirVaga.setBounds(180,380,80,20);
		pagInicial.setBounds(50, 20, 120, 20);
		excluirConta.setBounds(170,20,120,20);
		
		tela.add(criar);
		tela.add(atualizar);
		tela.add(editarEmpresa);
		tela.add(pagInicial);
		tela.add(excluirConta);
		
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		editarVaga.addActionListener(this);
		editarEmpresa.addActionListener(this);
		excluirVaga.addActionListener(this);
		pagInicial.addActionListener(this);
		excluirConta.addActionListener(this);
		
		vagas = new JList<ControleDeVaga>(controle.puxarVagas());
		vagas.setFixedCellHeight(20);
		vagas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		scrollPane = new JScrollPane(vagas);  
		scrollPane.setBounds(50,200,300,400);
		vagas.addListSelectionListener(this);
		tela.add(scrollPane);
		
		tela.setVisible(true);
	
	}
	
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && vagas.getSelectedIndex() != -1) {
			atualizarPanel();
		}
	}
	
	/**
	 * Implementa o metodo da interface
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == criar) {
			new TelaCadastroVaga(controle, this);
		}
		if (e.getSource() == atualizar) {
			vagas.setListData(controle.puxarVagas());
			vagas.updateUI();
			vagaPanel.removeAll();
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
		if(e.getSource() == editarVaga) {
			if (vagas.getSelectedValue() != null) {
				controleVaga.setVaga(vagas.getSelectedValue().getVaga());
				new TelaCadastroVaga(controle, controleVaga, this);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma vaga antes", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == excluirVaga) {
			if (vagas.getSelectedValue() != null) {
				controle.excluirVaga(vagas.getSelectedValue().getVaga());
				vagas.setListData(controle.puxarVagas());
				vagas.updateUI();
				
				vagaPanel.removeAll();
				
				JLabel excluir = new JLabel("Vaga exlcuída com sucesso!");
				excluir.setBounds(20, 250, 200, 40);
				excluir.setForeground(Color.red);
				vagaPanel.add(excluir);
				vagaPanel.revalidate();
				vagaPanel.repaint();				
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma vaga antes", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == editarEmpresa) {
			new TelaLoginEmpresa(controle, true);
			tela.dispose();
		}
		if (e.getSource() == pagInicial) {
			new TelaEscolha(false);
			tela.dispose();
		}
		if (e.getSource() == excluirConta) {
			controle.excluirEmpresa();
			new TelaEscolha(false);
			tela.dispose();
		}
	}
	/**
	 * Atualiza o JPanel
	 */
	public void atualizarPanel() {
		vagaPanel.removeAll();
	    vagaPanel.revalidate();
	    vagaPanel.repaint();
	    
		vagaPanel.add(editarVaga);
		vagaPanel.add(excluirVaga);
		
		String nomeVagaSelecionada = "Funcao: " + vagas.getSelectedValue().funcaoVaga();
		String reqVagaSelecionada = "Requisitos: " + vagas.getSelectedValue().requisitosVaga();
		Double salVagaSelecionada = vagas.getSelectedValue().salarioVaga();
		String salStr = "Salario: R$ " + String.valueOf(salVagaSelecionada);
		
		nomeVaga =  new JLabel(nomeVagaSelecionada);
		reqVaga = new JLabel(reqVagaSelecionada);
		salVaga = new JLabel(salStr);
		nomeVaga.setBounds(20, 50, 200, 20);
		salVaga.setBounds(20, 70, 200, 20);
		reqVaga.setBounds(20,90,200,20);
		vagaPanel.add(nomeVaga);
		vagaPanel.add(salVaga);
		vagaPanel.add(reqVaga);
		vagaPanel.revalidate();
		vagaPanel.repaint();
	}
	/**
	 * Atualiza o JList
	 */
	public void atualizarJList() {
		vagas.setListData(controle.puxarVagas());
		vagas.updateUI();
	}
}
