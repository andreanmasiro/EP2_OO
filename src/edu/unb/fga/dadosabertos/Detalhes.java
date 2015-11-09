package edu.unb.fga.dadosabertos;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Detalhes de um deputado.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Detalhes {
    
    protected int numLegislatura;
    protected String situacaoNaLegislaturaAtual;
    protected String ufRepresentacaoAtual;
    protected String dataNascimento;
    protected String dataFalecimento;
    
    @XmlElement(name = "partidoAtual")
    protected Partido partido;
    
    @XmlElement(name = "comissoes")
    List<Comissao> comissoes;

    public Detalhes() {
    }

    public Detalhes(int numLegislatura, String situacaoNaLegislaturaAtual, String ufRepresentacaoAtual, String dataNascimento, String dataFalecimento, Partido partido) {
        this.numLegislatura = numLegislatura;
        this.situacaoNaLegislaturaAtual = situacaoNaLegislaturaAtual;
        this.ufRepresentacaoAtual = ufRepresentacaoAtual;
        this.dataNascimento = dataNascimento;
        this.dataFalecimento = dataFalecimento;
        this.partido = partido;
    }

    public int getNumLegislatura() {
        return numLegislatura;
    }

    public void setNumLegislatura(int numLegislatura) {
        this.numLegislatura = numLegislatura;
    }

    public String getSituacaoNaLegislaturaAtual() {
        return situacaoNaLegislaturaAtual;
    }

    public void setSituacaoNaLegislaturaAtual(String situacaoNaLegislaturaAtual) {
        this.situacaoNaLegislaturaAtual = situacaoNaLegislaturaAtual;
    }

    public String getUfRepresentacaoAtual() {
        return ufRepresentacaoAtual;
    }

    public void setUfRepresentacaoAtual(String ufRepresentacaoAtual) {
        this.ufRepresentacaoAtual = ufRepresentacaoAtual;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(String dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    
}
