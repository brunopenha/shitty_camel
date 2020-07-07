package br.nom.penha.bruno.camel.eip.rotas;

import br.nom.penha.bruno.camel.eip.estrategias.EstrategiaPredicadoAgregador;
import org.apache.camel.builder.RouteBuilder;

public class RotaPadraoAggregateComPredicadoComplementador extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entrada-com-predicado")
        .log("Mensagem recebida |${body}| com o a chave no cabeçalho |${header.idAgregador}|")
        .aggregate(header("idAgregador"), new EstrategiaPredicadoAgregador())
        .completionPredicate(body().contains("ordem-confirmada")) // Condição para juntar a mensagem
        .eagerCheckCompletion() // Sempre tem que ter o eagerCompletion se utilizar completionPredicate
        .log("Mensagem enviada |${body}| com o a chave no cabeçalho |${header.idAgregador}|")
        .to("mock:saida")
        ;
    }
}
