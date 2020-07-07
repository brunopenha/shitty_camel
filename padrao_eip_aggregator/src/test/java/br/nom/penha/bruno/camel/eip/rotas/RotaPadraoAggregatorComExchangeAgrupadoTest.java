package br.nom.penha.bruno.camel.eip.rotas;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static org.apache.camel.Exchange.GROUPED_EXCHANGE;
import static org.junit.Assert.*;

public class RotaPadraoAggregatorComExchangeAgrupadoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaPadraoAggregatorComExchangeAgrupado();
    }

    @Test
    public void enviaMensagemComExchangeAgrupadoTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:agregador-agrupado", "1", "idAgregador", "1");
        template.sendBodyAndHeader("direct:agregador-agrupado", "2", "idAgregador", "1");
        template.sendBodyAndHeader("direct:agregador-agrupado", "3", "idAgregador", "1");

        assertMockEndpointsSatisfied();

        // Para visualizar as mensagens agrupadasd
        Exchange listaExchange = mock.getExchanges().get(0);

        List<Exchange> propriedadesExchange = (List<Exchange>) listaExchange.getProperty(Exchange.GROUPED_EXCHANGE);

         propriedadesExchange.stream()
                 .forEach( exchange -> System.out.println("Exchange is " + exchange.getIn().getBody()));

    }
}