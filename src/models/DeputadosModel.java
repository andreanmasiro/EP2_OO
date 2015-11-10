package models;

import java.io.IOException;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import javax.xml.bind.JAXBException;

import edu.unb.fga.dadosabertos.Camara;
import edu.unb.fga.dadosabertos.Deputado;

public class DeputadosModel implements TableModel {
	
	private Camara camara;
	private String[] columnNames = {"Nome",
			"Partido",
			"Estado",
			"Email",
			"Telefone",
			"Condição"};
	
	public DeputadosModel() {
		camara = new Camara();
		loadCamara();
	}
	
	public void loadCamara() {
		if (camara != null) {
			try { 
				System.out.println("Carregando dados da camara.");
				camara.obterDados();
				System.out.println("Carregando dados dos deputados.");
				for (Deputado deputado : getDeputados()) {
//					deputado.obterDetalhes();
				}
			} catch (IOException e) {
				
			} catch (JAXBException e) {
				
			}
		}
	}
	
	public List<Deputado> getDeputados() {
		return camara.getDeputados();
	}

	@Override
	public int getRowCount() {
		return getDeputados().size();
	}

	@Override
	public int getColumnCount() {
		// Nome, Partido, Estado, Email, Telefone e Condição.
		return 6;
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
		Deputado deputado = getDeputados().get(rowIndex);
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
