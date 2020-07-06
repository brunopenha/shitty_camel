package br.nom.penha.bruno.camel.gson.rotas;

import br.nom.penha.bruno.camel.gson.entidades.EntidadeTeste;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class RotaJsonParaObjeto extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        GsonDataFormat formatador = new GsonDataFormat(EntidadeTeste.class);

        from("direct:desagrupa-gson")
            .log("Antes de desagrupar : ${body}")
            .unmarshal(formatador)
            .log("Gson desagrupado para objeto : ${body}");
    }
}
