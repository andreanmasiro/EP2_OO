package models;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.unb.fga.dadosabertos.Deputado;
import edu.unb.fga.dadosabertos.Partido;

public class PartidosTableModel implements TableModel {

	private CamaraModel model = CamaraModel.getInstance();
	
	private String[] columnNames = {"Sigla", "Nome", "ID"};
	
	@Override
	public int getRowCount() {
		return model.getPartidos().size();
	}

	@Override
	public int getColumnCount() {
		// Sigla, Nome e ID.
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
		Partido partido = model.getPartidos().get(rowIndex);
		String value = null;
		switch (columnIndex) {
		case 0:
			value = partido.getSigla();
			break;
		case 1:
			value = partido.getNome();
			break;
		case 2:
			value = partido.getIdPartido();
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
