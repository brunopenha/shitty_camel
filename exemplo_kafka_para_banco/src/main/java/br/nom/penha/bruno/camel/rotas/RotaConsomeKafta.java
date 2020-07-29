package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.builder.RouteBuilder;

public class RotaConsomeKafta extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:localhost:2021?brokers=localhost:9092&topic=topico-canonico&autoOffsetReset=latest&groupId=group1&consumersCount=1&heartbeatIntervalMs=3100") // latest ou earliest
        .log("Corpo das mensage ${body}")
        .to("direct:origemKafka");
    }
}
