package edu.unb.fga.dadosabertos.utils;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Classe de utilidade que lê uma stream de dados cujo conteúdo é um XML e o
 * transforma num objeto.
 */
public class XMLUtils {
    /**
     * Lê uma stream de dados que deve conter um XML e cria um objeto a partir
     * dele.
     * @param inputStream a stream de dados a ser lida.
     * @param klass a classe do objeto que vai ser criado.
     * @return um objeto que é a instância de klass
     * @throws JAXBException se ocorrer algum erro durante a transformação.
     */
    public static Object unmarshal(InputStream inputStream, Class klass) throws JAXBException  {
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(inputStream);
    }
}
