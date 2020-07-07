package br.nom.penha.bruno.camel.eip.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotaPadraoAggregatorComTempoMaximoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaPadraoAggregatorComTempoMaximo();
    }

    @Test
    public void agregacaoComTempoMaximo() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived("12");

        template.sendBodyAndHeader("direct:aggregadorTempoMaxmo", "1","idAgregador", "1");
        template.sendBodyAndHeader("direct:aggregadorTempoMaxmo", "2","idAgregador", "1");
        Thread.sleep(5000);
        template.sendBodyAndHeader("direct:aggregadorTempoMaxmo", "4","idAgregador", "2");
        template.sendBodyAndHeader("direct:aggregadorTempoMaxmo", "3","idAgregador", "1");

        assertMockEndpointsSatisfied();
    }
}