package models;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.unb.fga.dadosabertos.Deputado;

public class DeputadosTableModel implements TableModel {

	
	private CamaraModel model;
	
	public DeputadosTableModel() {
		model = CamaraModel.getInstance();
	}
	
	private String[] columnNames = {"Nome",
			"Partido",
			"Estado",
			"Email",
			"Telefone",
			"Condição"};
	
	@Override
	public int getRowCount() {
			if (model.getDeputados() == null) {
				return 0;
			}
		return model.getDeputados().size();
	}

	@Override
	public int getColumnCount() {
		// Nome, Partido, Estado, Email, Telefone e Condição.
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Deputado deputado = model.getDeputados().get(rowIndex);
		String value = null;
		switch (columnIndex) {
		case 0:
			value = deputado.getNome();
			break;
		case 1:
			value = deputado.getPartido();
			break;
		case 2:
			value = deputado.getUf();
			break;
		case 3:
			value = deputado.getEmail();
			break;
		case 4:
			value = deputado.getFone();
			break;
		case 5:
			value = deputado.getCondicao();
			break;
		default:
			break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}
}
