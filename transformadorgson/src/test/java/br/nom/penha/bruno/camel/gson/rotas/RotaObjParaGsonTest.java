package br.nom.penha.bruno.camel.gson.rotas;

import br.nom.penha.bruno.camel.gson.entidades.EntidadeTeste;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RotaObjParaGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaObjParaGson();
    }

    @Test
    public void agrupaUsandoGson(){

        String esperado = "{\"id\":123,\"nome\":\"Bruno\",\"data\":\"10/06/2020\"}";

        EntidadeTeste entidade = new EntidadeTeste();
        entidade.setId(123);
        entidade.setNome("Bruno");
        entidade.setData("10/06/2020");

        String saida = template.requestBody("direct:agrupa-gson",entidade, String.class);

        assertEquals(esperado,saida);

    }
}