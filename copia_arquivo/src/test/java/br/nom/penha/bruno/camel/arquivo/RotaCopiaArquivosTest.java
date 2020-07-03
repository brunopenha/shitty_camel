package br.nom.penha.bruno.camel.arquivo;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RotaCopiaArquivosTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaCopiaArquivos();
    }

    @Test
    public void osArquivosExistemNoDiretorioSaida() throws InterruptedException {

        //De um tempo para o Camel processar e criar os diretorios
        Thread.sleep(5000);

        File saida = new File("dados/saida");

        assertTrue(saida.isDirectory());
        assertEquals(new File("dados/entrada").listFiles().length, saida.listFiles().length);

    }
}
