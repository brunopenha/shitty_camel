package br.nom.penha.bruno.camel.rotas;

import br.nom.penha.bruno.camel.processos.ProcessoInsere;
import org.apache.camel.builder.RouteBuilder;

public class RotaBancoMySQL extends RouteBuilder {
    @Override
    public void configure() throws Exception {


        from("direct:entradaBanco")
            .to("log:?level=INFO&showBody=true")
            .process(new ProcessoInsere())
            .to("jdbc:fonteBanco")
//            .to("sql:select * from atendimento?datasource=fonteDados")
            .to("log:?level=INFO&showBody=true")
        ;
    }
}
