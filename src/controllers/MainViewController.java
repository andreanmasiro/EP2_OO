package controllers;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import models.CamaraModelDelegate;
import models.CamaraModel;

public class MainViewController extends JFrame implements CamaraModelDelegate {
	
	private JTabbedPane tabbedPane;
	private JTextField searchTextField;
	private JTable depsTable;
	private JTable partiesTable;

	
	private TableRowSorter<TableModel> depsModelSorter;
	private TableRowSorter<TableModel> partiesModelSorter;
	
	private JLabel depsModelStateLabel;
	private JLabel partiesModelStateLabel;
	
	public MainViewController(TableModel depsModel, TableModel partiesModel) {
		CamaraModel.getInstance().addListenerForDeps(this);
		CamaraModel.getInstance().addListenerForParties(this);
		
		tabbedPane = new JTabbedPane();
		
		depsModelStateLabel = new JLabel("Carregando dados.");
		depsModelStateLabel.setSize(depsModelStateLabel.getWidth(), 100);
		partiesModelStateLabel = new JLabel("Carregando dados.");
		
		JPanel depsPanel = new JPanel();
		depsPanel.setLayout(new GridBagLayout());
		depsTable = initializeTableWithModel(depsModel);
		JScrollPane dScrollPane = new JScrollPane(depsTable);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		depsPanel.add(depsModelStateLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 200;
		
		depsPanel.add(dScrollPane, c);
		
		JPanel partiesPanel = new JPanel();
		partiesPanel.setLayout(new GridBagLayout());
		partiesTable = initializeTableWithModel(partiesModel);
		JScrollPane pScrollPane = new JScrollPane(partiesTable);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 0;
		partiesPanel.add(partiesModelStateLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 200;
		partiesPanel.add(pScrollPane, c);
		
		tabbedPane.insertTab("Deputados", null, depsPanel, null, 0);
		tabbedPane.insertTab("Partidos", null, partiesPanel, null, 1);
		
		searchTextField = new JTextField();
		searchTextField.setMaximumSize(searchTextField.getMinimumSize());
		searchTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action performed");
				String text = searchTextField.getText();
				TableRowSorter<TableModel> sorter = null;
				
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					sorter = depsModelSorter;
					break;
				case 1:
					sorter = partiesModelSorter;
				default:
					break;
				}
				
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});
		
		setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 0;
		getContentPane().add(searchTextField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 200;
		getContentPane().add(tabbedPane, c);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600); 
		setVisible(true);
		
		depsModelSorter = new TableRowSorter<TableModel>(depsModel);
		partiesModelSorter = new TableRowSorter<TableModel>(partiesModel);
		
		depsTable.setRowSorter(depsModelSorter);
		partiesTable.setRowSorter(partiesModelSorter);
	}
	
	private JTable initializeTableWithModel(TableModel model) {
		return new JTable(model);
	}
	
	static int x = 1;
	@Override
	public void updateData() {
		depsTable.setSize(depsTable.getWidth() + x, depsTable.getHeight());
		partiesTable.setSize(partiesTable.getWidth() + x, partiesTable.getHeight());
		x = -x;
	}
	
	@Override
	public void depsDataHaveLoaded() {
		depsModelStateLabel.setText("Dados dos deputados.");
	}
	
	@Override
	public void partiesDataHaveLoaded() {
		partiesModelStateLabel.setText("Dados dos partidos.");
	}	
}
