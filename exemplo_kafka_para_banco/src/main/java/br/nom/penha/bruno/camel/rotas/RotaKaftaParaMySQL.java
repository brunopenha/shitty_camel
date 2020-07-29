package br.nom.penha.bruno.camel.rotas;

import br.nom.penha.bruno.camel.estrategias.EstrategiaPredicadoAgregador;
import br.nom.penha.bruno.camel.excecoes.ProcessoExcetion;
import br.nom.penha.bruno.camel.processos.ProcessoAtendimento;
import br.nom.penha.bruno.camel.processos.ProcessoInsere;
import br.nom.penha.bruno.camel.processos.ProcessoPrescricao;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

import java.sql.SQLException;

public class RotaKaftaParaMySQL extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        onException(SQLException.class, Exception.class)
                .handled(true)
                .log("Uma exceção aconteceu enquanto consumia a mensagem")
                .process(new ProcessoExcetion());


        from("kafka:localhost:2021?brokers=localhost:9092&topic=topico-paciente&autoOffsetReset=latest&groupId=group1&consumersCount=1&heartbeatIntervalMs=3100") // latest ou earliest
                .log("Corpo das mensage ${body}")
                .process(new ProcessoAtendimento())
                .to("direct:insereBanco");

        from("kafka:localhost:2021?brokers=localhost:9092&topic=topico-prescricao&autoOffsetReset=latest&groupId=group1&consumersCount=1&heartbeatIntervalMs=3100") // latest ou earliest
                .log("Corpo das mensage ${body}")
                .process(new ProcessoPrescricao())
                .to("direct:insereBanco");

        from("kafka:localhost:2021?brokers=localhost:9092&topic=topico-laudo&autoOffsetReset=latest&groupId=group1&consumersCount=1&heartbeatIntervalMs=3100") // latest ou earliest
                .log("Corpo das mensage ${body}")
                .process(new ProcessoLaudo())
                .to("direct:insereBanco");


        from("direct:insereBanco")
                .log("Corpo das mensage ${body}")
                .aggregate(header("idAgregador"), new EstrategiaPredicadoAgregador())
            .completionPredicate(body().contains("resultado")) // Condição para juntar a mensagem
            .eagerCheckCompletion() // Sempre tem que ter o eagerCompletion se utilizar completionPredicate
                .process(new ProcessoInsere())
            .to("jdbc:fonteBanco")
                .to("sql:select * from atendimento?dataSource=fonteBanco")
                .to("direct:saida");
}
}
