package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.Exchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ProcessoLaudo implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String entrada = (String) exchange.getIn().getBody();
        System.out.println("Dados que serao persistidos : " + entrada);

        JSONParser parser = new JSONParser();
        Object objeto = parser.parse(entrada);
        JSONObject json = (JSONObject) objeto;

        JSONObject jsonPayload = (JSONObject) json.get("payload");


        exchange.getIn().setBody(jsonPayload);
    }
}
