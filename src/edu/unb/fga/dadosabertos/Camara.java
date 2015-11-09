package edu.unb.fga.dadosabertos;

import edu.unb.fga.dadosabertos.utils.HttpUtils;
import edu.unb.fga.dadosabertos.utils.XMLUtils;
import edu.unb.fga.dadosabertos.wrappers.DeputadoXML;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Principal classe da biblioteca. Através dela é possível obter todos os outros
 * dados.
 */
public class Camara {

    /**
     * A URL para o serviço da câmara.
     */
    private static final String DEPUTADOS_URL = "http://www.camara.gov.br/SitCamaraWS/Deputados.asmx/ObterDeputados";
    
    /**
     * A lista de deputados da câmara.
     */
    List<Deputado> deputados;
    
    /**
     * Se conecta ao servidor da câmara e obtém dados sobre os deputados.
     * 
     * @throws JAXBException se ocorrer algum problema na hora de interpretar o XML.
     * @throws IOException se algum erro ocorrer na hora de baixar os dados.
     */
    public void obterDados() throws JAXBException, IOException {
        GetMethod get = HttpUtils.doGet(DEPUTADOS_URL);
        InputStream inputStream = get.getResponseBodyAsStream();
        DeputadoXML lista = (DeputadoXML) XMLUtils.unmarshal(inputStream, DeputadoXML.class);
        get.releaseConnection();
        this.deputados = lista.getDeputados();
    }

    /**
     * Retorna a lista de deputados. Deve ser chamada após {@link Camara#obterDados}
     * 
     * @return a lista de deputados
     */
    public List<Deputado> getDeputados() {
        return deputados;
    }

}
