package controllers;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableModel;
import models.CamaraModelDelegate;
import models.CamaraModel;

public class MainViewController extends JFrame implements CamaraModelDelegate {
	
	JTabbedPane tabbedPane;
	ArrayList<JTable> tables = new ArrayList<JTable>();
	ArrayList<TableModel> models = new ArrayList<TableModel>();
	TableModel depsModel;
	TableModel partiesModel;

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
		setSize(500, 120); 
		setVisible(true);
	}
	
	private JPanel initializePanelWithModel(TableModel model) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
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
		}
//		reloadDepsPanelWithModel(depsModel);
//		reloadPartiesPanelWithModel(partiesModel);
	}
}
