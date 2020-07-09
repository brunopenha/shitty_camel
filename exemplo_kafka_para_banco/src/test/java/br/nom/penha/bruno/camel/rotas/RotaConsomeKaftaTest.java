package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotaConsomeKaftaTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaConsomeKafta();
    }

    @Test
    public void testaRecebimentoMensagemDoKafta(){

        String esperado = "Ola Bruno";

        String retorno = consumer.receiveBody("direct:origemKafka", String.class);
        System.out.println("O retorno foi: " + retorno);
        assertEquals(esperado, retorno);
    }
}