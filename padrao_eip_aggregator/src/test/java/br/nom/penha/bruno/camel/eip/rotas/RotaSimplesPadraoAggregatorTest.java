package br.nom.penha.bruno.camel.eip.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RotaSimplesPadraoAggregatorTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaSimplesPadraoAggregator();
    }

    @Test
    public void agregadorSimplesTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:saida");
        mock.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simplesAgregador", "1","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "2","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "4","idAgregador", "2");
        template.sendBodyAndHeader("direct:simplesAgregador", "3","idAgregador", "1");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void agregadorSimplesVariasMensagensTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:saida");

        // Caso tenha obtido o erro:
        //java.lang.AssertionError: mock://saida Received message count. Expected: <1> but was: <2>
        // Faltou criar uma lista
        List<String> listaValoresEsperados = new ArrayList<String>();
        listaValoresEsperados.add("123");
        listaValoresEsperados.add("567");
        mock.expectedBodiesReceived(listaValoresEsperados);

        template.sendBodyAndHeader("direct:simplesAgregador", "1","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "2","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "4","idAgregador", "2");
        template.sendBodyAndHeader("direct:simplesAgregador", "3","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "5","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "6","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "7","idAgregador", "1");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void agregadorSimplesVariasMensagensTestParaDireentesIdAgregador() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:saida");

        // Caso tenha obtido o erro:
        //java.lang.AssertionError: mock://saida Received message count. Expected: <1> but was: <2>
        // Faltou criar uma lista
        List<String> listaValoresEsperados = new ArrayList<String>();
        listaValoresEsperados.add("123");
        listaValoresEsperados.add("456");
        mock.expectedBodiesReceived(listaValoresEsperados);

        template.sendBodyAndHeader("direct:simplesAgregador", "1","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "2","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "4","idAgregador", "2");
        template.sendBodyAndHeader("direct:simplesAgregador", "3","idAgregador", "1");
        template.sendBodyAndHeader("direct:simplesAgregador", "5","idAgregador", "2");
        template.sendBodyAndHeader("direct:simplesAgregador", "6","idAgregador", "2");
        template.sendBodyAndHeader("direct:simplesAgregador", "7","idAgregador", "2");

        assertMockEndpointsSatisfied();
    }
}