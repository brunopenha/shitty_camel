package br.nom.penha.bruno.camel.direto;

import org.apache.camel.builder.RouteBuilder;

public class ExemploRotaDireta extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entradaExemplo")
        .log("Mensagem Recebida ${body} com os cabeçalhos ${headers}")
        .to("file:exemploSaida?fileName=saida.txt");
    }
}
