package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RotaBeanModificaDiretoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaBeanModificaDireto();
    }

    @Test
    public void rotaBeanTest(){
        String esperado = "123*Bruno*02-05-2020";
        String entrada  = "123,Bruno,02-05-2020";

        String saida = (String) template.requestBody("direct:entradaBean", entrada);

        assertEquals(esperado,saida);
    }

    @Test
    public void rotaBeanMockTest() throws InterruptedException {
        String esperado = "123*Bruno*02-05-2020";
        String entrada  = "123,Bruno,02-05-2020";

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);
        template.sendBody("direct:entradaBean",entrada);

        assertMockEndpointsSatisfied();

    }

    @Test
    public void rotaBeanDiferenteMockTest() throws InterruptedException {
        String esperado = "123++Bruno++02-05-2020";
        String entrada  = "123,Bruno,02-05-2020";

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);
        template.sendBody("direct:entradaBeanDiferente",entrada);

        assertMockEndpointsSatisfied();

    }
}
