package br.nom.penha.bruno.camel.eip.rotas;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class RotaPadraoAggregatorComExchangeAgrupado extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:agregador-agrupado")
        .log("Mensagem recebida ${body} com o idAgregador ${header.idAgregador}")
        .aggregate(header("idAgregador"), new GroupedExchangeAggregationStrategy())
        .completionSize(3)
        .log("Mensagem agrupada ${body} com o idAgregador ${header.idAgregador}")
        .to("mock:saida");
    }
}
