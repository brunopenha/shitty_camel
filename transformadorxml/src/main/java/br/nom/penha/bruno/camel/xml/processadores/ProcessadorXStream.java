package br.nom.penha.bruno.camel.xml.processadores;

import br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class ProcessadorXStream implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String novo = exchange.getIn().getBody(String.class);

        StringTokenizer delimitador = new StringTokenizer(novo, ",");

        EntidadeTeste entidade = new EntidadeTeste();
        while(delimitador.hasMoreElements()){
            entidade.setId(Integer.parseInt((String) delimitador.nextElement()));
            entidade.setNome((String) delimitador.nextElement());
            entidade.setData((String) delimitador.nextElement());
        }

        exchange.getIn().setBody(entidade);

    }
}
