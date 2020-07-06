package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.builder.RouteBuilder;

public class RotaTransformadoraModificaDireto extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entradaTransformadora")
        .transform(body().regexReplaceAll(",","*"))
        //.to("direct:saidaTransformadora")
        .to("mock:saida");

    }
}
