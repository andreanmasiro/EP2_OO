import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import controllers.MainViewController;
import models.CamaraModel;
import models.DeputadosTableModel;
import models.PartidosTableModel;

public class EP2 {
	public static void main(String[] args) {
		DeputadosTableModel depsModel = new DeputadosTableModel();
		PartidosTableModel partiesModel = new PartidosTableModel();
		MainViewController controller = new MainViewController(depsModel, partiesModel);
	}
}
