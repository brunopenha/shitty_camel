package br.nom.penha.bruno.camel.eip.estrategias;

import org.apache.camel.Exchange;

public class EstrategiaRotaSimplesPadraoAggregator implements org.apache.camel.processor.aggregate.AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(null != oldExchange){

            String antigo = (String) oldExchange.getIn().getBody();
            String novo = (String) newExchange.getIn().getBody();

            novo = antigo.concat(novo);

            newExchange.getIn().setBody(novo);

        }
        return newExchange;
    }
}
