package br.nom.penha.bruno.camel.eip.rotas;

import br.nom.penha.bruno.camel.eip.estrategias.EstrategiaRotaSimplesPadraoAggregator;
import org.apache.camel.builder.RouteBuilder;

public class RotaSimplesPadraoAggregator extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:simplesAgregador")
            .log("Mensagem recebida |${body}| com a chave key ${header.idAgregador}")
            .aggregate(header("idAgregador"), new EstrategiaRotaSimplesPadraoAggregator())
            .completionSize(3) // Se as tres proximas mensagens tiveram o mesmo id do agregador, elas serão concatenadas
            .log("Mensagem agregada |${body}| com a chave key ${header.idAgregador}")
            .to("mock:saida");
    }
}
