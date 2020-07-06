package br.nom.penha.bruno.camel.xml.rotas;

import br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DesagrupadorComXStreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DesagrupadorComXStream();
    }

    @Test
    public void desagrupaXMLComXStream() throws InterruptedException {
        EntidadeTeste entidade = new EntidadeTeste();
        entidade.setId(123);
        entidade.setNome("Bruno");
        entidade.setData("10/06/2020");

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(entidade.toString());

        String entrada = "<?xml version='1.0' encoding='UTF-8'?><entidade><id>123</id><data>10/06/2020</data><nome>Bruno</nome></entidade>";
        template.sendBody("direct:entrada-xml",entrada);

        assertMockEndpointsSatisfied();

    }
}
