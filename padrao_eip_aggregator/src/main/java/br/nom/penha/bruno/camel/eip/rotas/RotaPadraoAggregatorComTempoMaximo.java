package br.nom.penha.bruno.camel.eip.rotas;

import br.nom.penha.bruno.camel.eip.estrategias.EstrategiaRotaSimplesPadraoAggregator;
import org.apache.camel.builder.RouteBuilder;

public class RotaPadraoAggregatorComTempoMaximo extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:aggregadorTempoMaxmo")
            .log("Recebi a mensage com |${body}| e com o id no cabeçalho |${header.idAgregador}|")
            .aggregate(header("idAgregador"), new EstrategiaRotaSimplesPadraoAggregator())
            .completionSize(3)
            .completionTimeout(3000) // 3 segundos
            .log("Agreguei as mensagens com |${body}| e com o id no cabeçalho |${header.idAgregador}|")
            .to("mock:saida");
    }
}
