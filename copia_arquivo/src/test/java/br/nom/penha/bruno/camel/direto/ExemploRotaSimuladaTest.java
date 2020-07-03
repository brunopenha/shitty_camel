package br.nom.penha.bruno.camel.direto;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ExemploRotaSimuladaTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ExemploRotaSimulada();
    }

    @Test
    public void exemploRotaSimuladaTest() throws InterruptedException {
        String entrada = "Ola";

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(entrada);

        template.sendBody("direct:exemploEntrada", "Ola");

        assertMockEndpointsSatisfied();

    }
}
