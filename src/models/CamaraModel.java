package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import javax.xml.bind.JAXBException;

import edu.unb.fga.dadosabertos.Camara;
import edu.unb.fga.dadosabertos.Deputado;
import edu.unb.fga.dadosabertos.Partido;

public class CamaraModel {
	
	public static CamaraModel instance;
	public static CamaraModel getInstance() {
		if (instance == null) {
			instance = new CamaraModel();
		}
		return instance;
	}
	
	private Camara camara;
	
	private List<Partido> partidos;
	
	private CamaraModel() {
		partidos = new ArrayList<Partido>();
		camara = new Camara();
		loadCamara();
	}
	
	public void loadCamara() {
		if (camara != null) {
			try { 
				camara.obterDados();
				for (Deputado deputado : getDeputados()) {
					deputado.obterDetalhes();
					if (!partidos.contains(deputado.getDetalhes().getPartido())) {
						partidos.add(deputado.getDetalhes().getPartido());
					}
				}
				System.out.println(partidos);
			} catch (IOException e) {
				
			} catch (JAXBException e) {
				
			}
		}
	}
	
	public List<Deputado> getDeputados() {
		return camara.getDeputados();
	}
	
	public List<Partido> getPartidos() {
		return partidos;
	}
	
}
