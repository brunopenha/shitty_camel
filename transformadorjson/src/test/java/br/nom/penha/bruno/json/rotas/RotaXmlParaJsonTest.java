package br.nom.penha.bruno.json.rotas;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotaXmlParaJsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaXmlParaJson();
    }

    @Test
    public void agrupaXmlParaJsonTest(){

        String esperado = "{\"id\":\"123\",\"data\":\"10/06/2020\",\"nome\":\"Bruno\"}";

        String entrada = "<?xml version='1.0' encoding='UTF-8'?><entidade><id>123</id><data>10/06/2020</data><nome>Bruno</nome></entidade>";
        String saida = template.requestBody("direct:entrada-xml",entrada, String.class);

        assertEquals(esperado,saida);

    }


    @Test
    public void desagrupaJsonParaXMLTest(){
        String entrada = "{\"id\":\"123\",\"data\":\"10/06/2020\",\"nome\":\"Bruno\"}";

        // CRLF ==> \r\n
        String esperado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<entidade><data>10/06/2020</data><id>123</id><nome>Bruno</nome></entidade>\r\n";

        String saida = template.requestBody("direct:entrada-json",entrada, String.class);

        System.out.println("|" + saida + "|");
        assertEquals(esperado,saida);

    }
}