package controllers;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MainViewController extends JFrame {
	
	JPanel depsPanel;
	JPanel partiesPanel;
    JTable depsTable;
    JTable partiesTable;
    JScrollPane depsTableScrollPane;
    JScrollPane partiesTableScrollPane;
    JTabbedPane tabbedPane;

	public MainViewController(TableModel depsModel, TableModel partiesModel) {
		tabbedPane = new JTabbedPane();
		depsPanel = new JPanel();
		depsPanel.setLayout(new GridLayout(1, 1));
		depsTable = new JTable(depsModel); 
		depsTableScrollPane = new JScrollPane(depsTable);
		depsPanel.add(depsTableScrollPane);
		tabbedPane.insertTab("Deputados", null, depsPanel, null, 0);
		
		partiesPanel = new JPanel();
		partiesPanel.setLayout(new GridLayout(1, 1));
		partiesTable = new JTable(partiesModel);
		partiesTableScrollPane = new JScrollPane(partiesTable);
		partiesPanel.add(partiesTableScrollPane);
		tabbedPane.insertTab("Partidos", null, partiesPanel, null, 1);	
		getContentPane().add(tabbedPane);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 120); 
		setVisible(true);
	}
}
