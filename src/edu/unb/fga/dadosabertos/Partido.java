package edu.unb.fga.dadosabertos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Um partido político.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Partido {
    
    protected String idPartido;
    protected String sigla;
    protected String nome;

    public Partido() {
    }

    public Partido(String idPartido, String sigla, String nome) {
        this.idPartido = idPartido;
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
