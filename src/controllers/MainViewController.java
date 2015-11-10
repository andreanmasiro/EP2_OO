package controllers;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MainViewController extends JFrame {
	
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    
    String [][] dados = {
    		{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
    		{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
    		{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
    		};
    String [] colunas = {"Nome", "Telefone", "Email"}; 

	public MainViewController(TableModel model) {
		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		tabela = new JTable(model); 
		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem); 
		getContentPane().add(painelFundo); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 120); 
		setVisible(true);
	}
}
