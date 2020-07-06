package br.nom.penha.bruno.camel.xml.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AgrupandoComXStreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AgrupandoComXStream();
    }

    @Test
    public void agrumaXMLtest() throws InterruptedException {
        //String esperado = "<?xml version='1.0' encoding='UTF-8'?><br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste><id>123</id><data>10/06/2020</data><nome>Bruno</nome></br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste>";
        String esperado = "<?xml version='1.0' encoding='UTF-8'?><entidade><id>123</id><data>10/06/2020</data><nome>Bruno</nome></entidade>";
        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);

        String entrada = "123,Bruno,10/06/2020";
        template.sendBody("direct:entrada-csv",entrada);

        assertMockEndpointsSatisfied();
    }
}
