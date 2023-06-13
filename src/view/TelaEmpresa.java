package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleDeVaga;
import controle.ControleEmpresa;

public class TelaEmpresa extends JFrame implements ListSelectionListener, ActionListener {
	
	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	private JLabel id = new JLabel("ID: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel setorAtuacao = new JLabel("Setor de atuacao: ");
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
	//private DefaultListModel<Vaga> vagaListModel = new DefaultListModel<>();
	private JLabel nomeVaga;
	private JLabel reqVaga;
	private JLabel salVaga;
	private JLabel nomeEmpresa;
	
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
		
		id.setBounds(50,90,200,20);
		id.setText("ID: " + controle.idEmpresa());
		tela.add(id);
		
		email.setBounds(50,110,200,20);
		email.setText("Email: " + controle.emailEmpresa());
		tela.add(email);
		
		setorAtuacao.setBounds(50,130,200,20);
		setorAtuacao.setText(controle.setorEmpresa() == null ? 
				 "Setor de Atuacao: Não informado" : "Setor de Atuacao: " + controle.setorEmpresa());
		tela.add(setorAtuacao);
		
		vagaPanel.setBounds(600, 10, 300, 600);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		//criar.setBounds(620, 580,80,20);
		criar.setBounds(50,580,80,20);
		atualizar.setBounds(130,580,100,20);
		editarVaga.setBounds(100,580,80,20);
		editarEmpresa.setBounds(290, 20, 120, 20);
		excluirVaga.setBounds(180,580,80,20);
		pagInicial.setBounds(50, 20, 120, 20);
		excluirConta.setBounds(170,20,120,20);
		tela.add(criar);
		tela.add(atualizar);
		tela.add(editarEmpresa);
		tela.add(pagInicial);
		tela.add(excluirConta);
		vagaPanel.add(editarVaga);
		vagaPanel.add(excluirVaga);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		editarVaga.addActionListener(this);
		editarEmpresa.addActionListener(this);
		excluirVaga.addActionListener(this);
		pagInicial.addActionListener(this);
		excluirConta.addActionListener(this);
		//excluir.setBounds(780,610,80,20);
		//vagaPanel.add(criar);
		
		/*String teste[] = {"Vaga1", "Vaga2", "Vaga3", "Vaga4", "Vaga5", "Vaga6", "Vaga7", "Vaga8", "Vaga9", "Vaga10",
				"Vaga11",};*/
		
		vagas = new JList<ControleDeVaga>(controle.puxarVagas());
		vagas.setFixedCellHeight(20);
		
		//vagas = new JList<Vaga>((ListModel<Vaga>) controle.vagasEmpresa());
		//vagas.setBounds(50, 200, 100, 100);
		vagas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		scrollPane = new JScrollPane(vagas);  
		//scrollPane.setPreferredSize(new Dimension(200, 200));
		scrollPane.setBounds(50,160,300,200);
		vagas.addListSelectionListener(this);
		//tela.add(vagas);
		tela.add(scrollPane);
		
		
		tela.setVisible(true);
		

			
	}
	
		
	
	
	public void valueChanged(ListSelectionEvent e) {  
		if(!e.getValueIsAdjusting() && vagas.getSelectedIndex() != -1) {
			vagaPanel.removeAll();
		    vagaPanel.revalidate();
		    vagaPanel.repaint();
		    
			editarVaga.setBounds(100,580,80,20);
			excluirVaga.setBounds(180,580,80,20);
			vagaPanel.add(editarVaga);
			vagaPanel.add(excluirVaga);
			
			String nomeVagaSelecionada = "Funcao: " + vagas.getSelectedValue().funcaoVaga();
			String reqVagaSelecionada = "Requisitos: " + vagas.getSelectedValue().requisitosVaga();
			Double salVagaSelecionada = vagas.getSelectedValue().salarioVaga();
			String salStr = "Salario: " + String.valueOf(salVagaSelecionada);
			String nomeEmpresaVagaSelecionada = vagas.getSelectedValue().empresaVaga().getNome();
			
			nomeVaga =  new JLabel(nomeVagaSelecionada);
			reqVaga = new JLabel(reqVagaSelecionada);
			salVaga = new JLabel(salStr);
			nomeEmpresa = new JLabel(nomeEmpresaVagaSelecionada);
			nomeVaga.setBounds(20, 50, 200, 20);
			salVaga.setBounds(20, 70, 200, 20);
			reqVaga.setBounds(20,90,200,20);
			vagaPanel.add(nomeVaga);
			vagaPanel.add(salVaga);
			vagaPanel.add(reqVaga);
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == criar) {
			new TelaCadastroVaga(controle);
		}
		if (e.getSource() == atualizar) {
			//vagas.setListData( (Vaga[]) controle.funcoesVagas());
			vagas.setListData(controle.puxarVagas());
			vagas.updateUI();
		}
		if(e.getSource() == editarVaga) {
			controleVaga.setVaga(vagas.getSelectedValue().getVaga());
			new TelaCadastroVaga(controle, controleVaga);
		}
		if(e.getSource() == excluirVaga) {
			controle.excluirVaga(vagas.getSelectedValue().getVaga());
			vagas.setListData(controle.puxarVagas());
			vagas.updateUI();
			
			vagaPanel.remove(nomeVaga);
			vagaPanel.remove(salVaga);
			vagaPanel.remove(reqVaga);
			vagaPanel.revalidate();
			vagaPanel.repaint();
			
			JLabel excluir = new JLabel("Vaga exlcuída com sucesso!");
			excluir.setBounds(20, 250, 200, 40);
			excluir.setForeground(Color.red);
			vagaPanel.add(excluir);
			vagaPanel.revalidate();
			vagaPanel.repaint();
		}
		if (e.getSource() == editarEmpresa) {
			new TelaLoginEmpresa(controle, true);
		}
		if (e.getSource() == pagInicial) {
			new TelaEscolha();
			tela.dispose();
		}
		if (e.getSource() == excluirConta) {
			controle.excluirEmpresa();
			new TelaEscolha();
			tela.dispose();
		}
	}
}
