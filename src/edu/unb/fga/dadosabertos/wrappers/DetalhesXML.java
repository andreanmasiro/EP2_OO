package edu.unb.fga.dadosabertos.wrappers;

import edu.unb.fga.dadosabertos.Detalhes;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe que representa um arquivo XML com os detalhes de um deputado.
 */
@XmlRootElement(name = "Deputados")
public class DetalhesXML {
   
    /**
     * Os detalhes de um deputado.
     */
    @XmlElement(name = "Deputado")
    protected Detalhes detalhes;

    /**
     * Retorna os detalhes de um deputado.
     * @return os detalhes de um deputado.
     */
    @XmlTransient
    public Detalhes getDetalhes() {
        return detalhes;
    }
}
