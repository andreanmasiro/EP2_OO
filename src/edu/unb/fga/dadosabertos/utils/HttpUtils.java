package edu.unb.fga.dadosabertos.utils;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Classe de utilidade para realizar transções HTTP.
 */
public class HttpUtils {

    /**
     * Realiza uma requisição HTTP/GET
     * @param urlStr a url da requisição
     * @return um objeto GetMethod com o resultado da execução.
     * @throws IOException se algum problema ocorrer durante a requisição.
     */
    public static GetMethod doGet(String urlStr) throws IOException {
        HttpClient httpClient = new HttpClient();
        
        HttpMethod get = new GetMethod(urlStr);
        int status = httpClient.executeMethod(get);
        
        if(status != HttpStatus.SC_OK) {
            return null;
        }
        
        return (GetMethod) get;
    }
}
