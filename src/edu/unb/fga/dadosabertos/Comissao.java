package edu.unb.fga.dadosabertos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Comissão da câmara.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Comissao {
    
    protected int idOrgaoLegislativoCD;
    protected String siglaComissao;
    protected String nomeComissao;
    protected String condicaoMembro;
    protected String dataEntrada;
    protected String dataSaida;

    public Comissao() {
    }

    public Comissao(int idOrgaoLegislativoCD, String siglaComissao, String nomeComissao, String condicaoMembro, String dataEntrada, String dataSaida) {
        this.idOrgaoLegislativoCD = idOrgaoLegislativoCD;
        this.siglaComissao = siglaComissao;
        this.nomeComissao = nomeComissao;
        this.condicaoMembro = condicaoMembro;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getIdOrgaoLegislativoCD() {
        return idOrgaoLegislativoCD;
    }

    public void setIdOrgaoLegislativoCD(int idOrgaoLegislativoCD) {
        this.idOrgaoLegislativoCD = idOrgaoLegislativoCD;
    }

    public String getSiglaComissao() {
        return siglaComissao;
    }

    public void setSiglaComissao(String siglaComissao) {
        this.siglaComissao = siglaComissao;
    }

    public String getNomeComissao() {
        return nomeComissao;
    }

    public void setNomeComissao(String nomeComissao) {
        this.nomeComissao = nomeComissao;
    }

    public String getCondicaoMembro() {
        return condicaoMembro;
    }

    public void setCondicaoMembro(String condicaoMembro) {
        this.condicaoMembro = condicaoMembro;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    
}
