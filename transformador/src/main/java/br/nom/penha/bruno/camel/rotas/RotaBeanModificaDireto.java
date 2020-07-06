package br.nom.penha.bruno.camel.rotas;

import br.nom.penha.bruno.camel.beans.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class RotaBeanModificaDireto extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entradaBean")
        .log("Antes a mensagem esta assim: ${body}")
        .bean(new CamelBean(), "mapeador")
        .log("Agora a mensagem ficou: ${body}" )
        .to("mock:saida");

        from("direct:entradaBeanDiferente")
                .log("Antes a mensagem esta assim: ${body}")
                .bean(new CamelBean(),"mapeadorDiferente")
                .log("Agora a mensagem ficou diferente: ${body}" )
                .to("mock:saida");

    }
}
