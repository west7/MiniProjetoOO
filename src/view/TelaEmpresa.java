package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Empresa;

public class TelaEmpresa extends JFrame implements ListSelectionListener {
	
	private JFrame tela = new JFrame();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel endereco = new JLabel("Endereco: ");
	private JLabel id = new JLabel("ID: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel setorAtuacao = new JLabel("Setor de atuacao: ");
	private JList<String> vagas;
	private JScrollPane scrollPane; 
	JPanel vagaPanel = new JPanel();
	private JButton criar = new JButton("Criar");
	private JButton editar = new JButton("Editar");
	private JButton excluir = new JButton("Excluir");
	
	public TelaEmpresa(Empresa empresa) {
		tela.getContentPane().setBackground(Color.lightGray);
		tela.setSize(1000, 1000);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Empresa");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		
		nome.setBounds(50, 50, 200, 20);
		nome.setText("Nome: " + empresa.getNome());
		tela.add(nome);
		
		endereco.setBounds(50, 70, 200, 20);
		endereco.setText("Endereco: " + empresa.getEndereco());
		tela.add(endereco);
		
		id.setBounds(50,90,200,20);
		id.setText("ID: " + empresa.getId());
		tela.add(id);
		
		email.setBounds(50,110,200,20);
		email.setText("Email: " + empresa.getEmail());
		tela.add(email);
		
		setorAtuacao.setBounds(50,130,200,20);
		setorAtuacao.setText(empresa.getSetorAtuacao() == null ? 
				 "Setor de Atuacao: Não informado" : "Setor de Atuacao: " + empresa.getSetorAtuacao());
		tela.add(setorAtuacao);
		
		vagaPanel.setBounds(600, 10, 300, 600);
		vagaPanel.setBackground(Color.white);
		vagaPanel.setLayout(null);
		tela.add(vagaPanel);
		
		//criar.setBounds(620, 580,80,20);
		criar.setBounds(20,580,80,20);
		editar.setBounds(100,580,80,20);
		excluir.setBounds(180,580,80,20);
		//excluir.setBounds(780,610,80,20);
		vagaPanel.add(criar);
		vagaPanel.add(editar);
		vagaPanel.add(excluir);
		
		String teste[] = {"Vaga1", "Vaga2", "Vaga3", "Vaga4", "Vaga5", "Vaga6", "Vaga7", "Vaga8", "Vaga9", "Vaga10",
				"Vaga11",};
		
		vagas = new JList<String>(teste);
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
	
	public void valueChanged(ListSelectionEvent le) {  
		 
	}

}
