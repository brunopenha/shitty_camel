package br.nom.penha.bruno.camel.direto;

import org.apache.camel.builder.RouteBuilder;

public class ExemploRotaSimulada extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:exemploEntrada")
        .log("A mensagem recebida foi |${body}| com os cabeçalhos |${headers}|")
        .to("mock:saida");
    }
}
