import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import controllers.MainViewController;
import models.DeputadosModel;

public class EP2 {
	public static void main(String[] args) {
		DeputadosModel model = new DeputadosModel();
		MainViewController controller = new MainViewController(model);
//		try {
//			camara.obterDados();
//		} catch (IOException e) {
//			System.out.println("Erro ao obter dados");
//		} catch (JAXBException e) {
//			System.out.println("Erro ao interpretar XML");
//		}
		System.out.println("Dados obtidos");
		
//		List<Deputado> deputados = camara.getDeputados();
//		System.out.println("Foram obtidos " + deputados.size() + " deputados.");
//		for (Deputado deputado : deputados) {
//			System.out.println(deputado.getNome());
//		}
	}
}
