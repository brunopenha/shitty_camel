package br.nom.penha.bruno.camel.direto;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ExemploRotaDiretaTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new ExemploRotaDireta();
    }

    @Test
    public void criaRotaTest() throws InterruptedException {
        // template é um objeto Produtor
        template.sendBody("direct:entradaExemplo", "1234,Bruno Penha, Arquiteto");
        Thread.sleep(5000);

        File saida = new File("exemploSaida");
        assertTrue(saida.isDirectory());

        Exchange trocador = consumer.receive("file:exemploSaida");
        assertEquals("saida.txt", trocador.getIn().getHeader("CamelFileName"));
        assertEquals("1234,Bruno Penha, Arquiteto", trocador.getIn().getBody(String.class));

    }
}
