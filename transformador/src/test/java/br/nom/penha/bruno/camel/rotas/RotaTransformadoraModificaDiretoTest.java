package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RotaTransformadoraModificaDiretoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaTransformadoraModificaDireto();
    }

    @Test
    public void transformaDiretoTest(){
        String esperado = "123*Bruno*02-05-2020";
        String entrada  = "123,Bruno,02-05-2020";

        String saida = (String) template.requestBody("direct:entradaTransformadora",entrada);

        assertEquals(esperado,saida);
    }

    @Test
    public void transformaDiretoMockTest() throws InterruptedException {
        String esperado = "123*Bruno*02-05-2020";
        String entrada  = "123,Bruno,02-05-2020";

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);

        template.sendBody("direct:entradaTransformadora",entrada);

        assertMockEndpointsSatisfied();
    }
}
