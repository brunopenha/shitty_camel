package br.nom.penha.bruno.camel.processos;

import org.apache.camel.Exchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.Date;

public class ProcessoInsere implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String entrada = (String) exchange.getIn().getBody();
        System.out.println("Dados que serao persistidos : " + entrada);

        JSONParser parser = new JSONParser();
        Object objeto = parser.parse(entrada);
        JSONObject json = (JSONObject) objeto;

        JSONObject jsonPayload = (JSONObject) json.get("payload");

        String insercao =  "INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)";
        String valores = "VALUES ("+ jsonPayload.get("idatendimento") + ", "+
                                     jsonPayload.get("idpaciente") +", " +
                                     jsonPayload.get("idmedico") + ", " +
                (jsonPayload.get("idunidhospitalar") != null ? jsonPayload.get("idunidhospitalar") : 15) + ", '" +
                (jsonPayload.get("tipoatendimento") != null ? jsonPayload.get("tipoatendimento") : "Emergencia") + "', '" +
                (jsonPayload.get("dataatualizacao") != null ? new Date((Long) jsonPayload.get("dataatualizacao")) : "2020-06-10 08:00:01") + "')"; //TODO tratar data)



        String sql = insercao.concat(valores);

        exchange.getIn().setBody(sql);
    }
}
