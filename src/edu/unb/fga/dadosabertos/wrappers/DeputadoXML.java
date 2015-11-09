package edu.unb.fga.dadosabertos.wrappers;

import edu.unb.fga.dadosabertos.Deputado;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe que representa um arquivo XML de deputados.
 */
@XmlRootElement(name = "deputados")
public class DeputadoXML {

    /**
     * A lista de deputados.
     */
    @XmlElement(name = "deputado")
    protected List<Deputado> deputados;

    /**
     * Retorna a lista de deputados.
     * @return a lista de deputados.
     */
    @XmlTransient
    public List<Deputado> getDeputados() {
        return deputados;
    }

    
}
