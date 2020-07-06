package br.nom.penha.bruno.camel.gson.rotas;

import br.nom.penha.bruno.camel.gson.entidades.EntidadeTeste;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class RotaObjParaGson extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        GsonDataFormat formato = new GsonDataFormat(EntidadeTeste.class);


        from("direct:agrupa-gson")
            .log("Antes de agrupar -> ${body}")
            .marshal(formato)
            .log("O objecto agrupado -> ${body}")
            ;
    }
}
