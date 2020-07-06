package br.nom.penha.bruno.camel.gson.rotas;

import br.nom.penha.bruno.camel.gson.entidades.EntidadeTeste;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RotaJsonParaObjetoTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaJsonParaObjeto();
    }

    @Test
    public void desagrupaParaGsonTest(){

        EntidadeTeste esperado = new EntidadeTeste();
        esperado.setId(123);
        esperado.setNome("Bruno");
        esperado.setData("10/06/2020");

        String entrada = "{\"id\":123,\"nome\":\"Bruno\",\"data\":\"10/06/2020\"}";

        EntidadeTeste saida = template.requestBody("direct:desagrupa-gson",entrada, EntidadeTeste.class);

        assertEquals(esperado.getId(),saida.getId());
        assertEquals(esperado.getNome(),saida.getNome());
        assertEquals(esperado.getData(),saida.getData());


    }
}