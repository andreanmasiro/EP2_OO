
package edu.unb.fga.dadosabertos;

import edu.unb.fga.dadosabertos.utils.HttpUtils;
import edu.unb.fga.dadosabertos.utils.XMLUtils;
import edu.unb.fga.dadosabertos.wrappers.DetalhesXML;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Classe com os principais dados de um deputado.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Deputado {
    private static final String DETALHES_URL =  "http://www.camara.gov.br/SitCamaraWS/Deputados.asmx/ObterDetalhesDeputado";
    protected int ideCadastro;
    protected int matricula;
    protected String condicao;
    protected String nome;
    protected String nomeParlamentar;
    protected String urlFoto;
    protected String sexo;
    protected String uf;
    protected String partido;
    protected String gabinete;
    protected String anexo;
    protected String fone;
    protected String email;
    protected List<Comissao> comissoes;
    
    @XmlTransient
    protected Detalhes detalhes;

    public Deputado() {
    }

    public Deputado(int ideCadastro, int matricula, String condicao, String nome, String nomeParlamentar, String urlFoto, String sexo, String uf, String partido, String gabinete, String anexo, String fone, String email, List<Comissao> comissoes, Detalhes detalhes) {
        this.ideCadastro = ideCadastro;
        this.matricula = matricula;
        this.condicao = condicao;
        this.nome = nome;
        this.nomeParlamentar = nomeParlamentar;
        this.urlFoto = urlFoto;
        this.sexo = sexo;
        this.uf = uf;
        this.partido = partido;
        this.gabinete = gabinete;
        this.anexo = anexo;
        this.fone = fone;
        this.email = email;
        this.comissoes = comissoes;
        this.detalhes = detalhes;
    }

    /**
     * Se conecta ao servidor da câmara e obtém detalhes sobre um deputado.
     * 
     * @throws JAXBException se ocorrer algum problema na hora de interpretar o XML.
     * @throws IOException se algum erro ocorrer na hora de baixar os dados.
     */
   public void obterDetalhes() throws IOException, JAXBException {
        GetMethod get = HttpUtils.doGet(DETALHES_URL + "?ideCadastro="+getIdeCadastro()+"&numLegislatura=");
        InputStream inputStream = get.getResponseBodyAsStream();
        DetalhesXML lista = (DetalhesXML) XMLUtils.unmarshal(inputStream, DetalhesXML.class);
        get.releaseConnection();
        
        detalhes = lista.getDetalhes();
    }

    public int getIdeCadastro() {
        return ideCadastro;
    }

    public void setIdeCadastro(int ideCadastro) {
        this.ideCadastro = ideCadastro;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Comissao> getComissoes() {
        return comissoes;
    }

    public void setComissoes(List<Comissao> comissoes) {
        this.comissoes = comissoes;
    }

    public Detalhes getDetalhes() {
        return detalhes;
    }
    
}
