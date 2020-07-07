package br.nom.penha.bruno.camel.contentbasedrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class RotaPadraoContentBasedRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaPadraoContentBasedRouter();
    }

    @Test
    public void padraoContentBasedRouterTest() throws InterruptedException {
        Thread.sleep(5000); //pela copia dos arquivos

        File diretorioHtml = new File("saida/html");
        assertTrue(diretorioHtml.isDirectory());

        File diretorioTxt = new File("saida/txt");
        assertTrue(diretorioTxt.isDirectory());

        File diretorioJson = new File("saida/json");
        assertTrue(diretorioJson.isDirectory());

        File diretorioFormatoDesconhecido = new File("saida/9_desconhecido");
        assertTrue(diretorioFormatoDesconhecido.isDirectory());

        File diretorioComTodosOsArquivos = new File("saida/0_todosOsArquivos");
        assertTrue(diretorioComTodosOsArquivos.isDirectory());


    }
}