package controllers;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import models.CamaraModelDelegate;
import models.DeputadosTableModel;
import models.CamaraModel;

public class MainViewController extends JFrame implements CamaraModelDelegate {
	
	private JTabbedPane tabbedPane;
	private ArrayList<JTable> tables = new ArrayList<JTable>();
	private ArrayList<TableModel> models = new ArrayList<TableModel>();
	private TableModel depsModel;
	private TableModel partiesModel;
	
	private TableRowSorter<TableModel> depsModelSorter;
	private TableRowSorter<TableModel> partiesModelSorter;
	
	public MainViewController(TableModel depsModel, TableModel partiesModel) {
		CamaraModel.getInstance().addListenerForDeps(this);
		CamaraModel.getInstance().addListenerForParties(this);
		
		this.depsModel = depsModel;
		this.partiesModel = partiesModel;
		
		tabbedPane = new JTabbedPane();
		
		tabbedPane.insertTab("Deputados", null, initializePanelWithModel(depsModel), null, 0);
		tabbedPane.insertTab("Partidos", null, initializePanelWithModel(partiesModel), null, 1);
		getContentPane().add(tabbedPane);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1024, 768); 
		setVisible(true);
		
		depsModelSorter = new TableRowSorter<TableModel>(depsModel);
		partiesModelSorter = new TableRowSorter<TableModel>(partiesModel);
		
		tables.get(0).setRowSorter(depsModelSorter);
		tables.get(1).setRowSorter(partiesModelSorter);
		
		filter();
	}
	
	private JPanel initializePanelWithModel(TableModel model) {
		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(1, 1));
		JTable table = new JTable(model); 
		tables.add(table);
		models.add(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		
		return panel;
	}
	
	@Override
	public void updateData() {
		for (int i = 0; i < tables.size(); i++) {
			JTable table = tables.get(i); 
			table.setSize(new Dimension(table.getWidth() + 1, table.getHeight()));
			TableRowSorter<TableModel> t = new TableRowSorter<>();
		}
	}
	
	private void filter() {
//		RowFilter<TableModel, Object> rf = null;
//		rf = RowFilter.regexFilter("");
//		depsModelSorter.setRowFilter(rf);
	}
}
