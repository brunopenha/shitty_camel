package br.nom.penha.bruno.camel.eip.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotaPadraoAggregateComPredicadoComplementadorTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaPadraoAggregateComPredicadoComplementador();
    }

    @Test
    public void rotaComPredicadoAgregadorTest() throws InterruptedException {

        String ordemCriada = "123,produto1,ordem-criada";
        String ordemConfirmada = "123,produto1,ordem-confirmada";

        String esperado = ordemCriada.concat(":").concat(ordemConfirmada);

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);

        template.sendBodyAndHeader("direct:entrada-com-predicado",ordemCriada,"idAgregador", "1");
        template.sendBodyAndHeader("direct:entrada-com-predicado",ordemConfirmada,"idAgregador", "1");

        assertMockEndpointsSatisfied();
    }
}