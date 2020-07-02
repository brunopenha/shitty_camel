package br.nom.penha.bruno.camel.arquivo;

import org.apache.camel.builder.RouteBuilder;

public class RotaCopiaArquivos extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:dados/entrada?noop=true") // sem esse noop, sera criado um diretorio .camel na origem
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .to("file:dados/saida");

    }
}
