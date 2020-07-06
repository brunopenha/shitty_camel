package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RotaProcessadoraModificaDiretoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaProcessadoraModificaDireto();
    }

    @Test
    public void processadorDiretoTest(){

        String esperado = "123,Bruno,02-05-2020\n" +
                "456,Penha,02-06-2020\n";


        String entrada = "123:Bruno:02-05-2020\n" +
                "456:Penha:02-06-2020\n";

        String saida = (String) template.requestBody("direct:entradaProcessamento",entrada);

        assertEquals(esperado,saida);
    }

    @Test
    public void processadorDiretoMockTest() throws InterruptedException {
        String esperado = "123,Bruno,02-05-2020";
        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(esperado);

        String entrada = "123:Bruno:02-05-2020";
        template.sendBody("direct:entradaProcessamento",entrada);

        assertMockEndpointsSatisfied();
    }
}
