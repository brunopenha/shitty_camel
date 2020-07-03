package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class RotaProcessadoraModificaArquivosTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaProcessadoraModificaArquivos();
    }

    @Test
    public void processadorTest() throws InterruptedException {

        String valorEsperado = "123:Bruno:02-05-2020\n" +
                "456:Penha:02-06-2020\n";

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived(valorEsperado);

        Thread.sleep(5000);

        File diretorio = new File("dados/saida");

        assertTrue(diretorio.isDirectory());

        assertMockEndpointsSatisfied();
    }
}