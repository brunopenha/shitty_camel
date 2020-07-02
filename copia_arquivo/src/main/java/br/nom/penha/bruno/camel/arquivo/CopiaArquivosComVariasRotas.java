package br.nom.penha.bruno.camel.arquivo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopiaArquivosComVariasRotas {
    public static void main(String[] args) {
        CamelContext contexto = new DefaultCamelContext();

        try {
            contexto.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:dados/entrada?noop=true") // sem esse noop, sera criado um diretorio .camel na origem
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:dados/saida")
                            .to("file:dados/outra_saida");

                    from("file:dados/entrada1?noop=true")
                            .to("file:dados/saida1");
                }
            });

            contexto.start();

            Thread.sleep(5000);

            contexto.stop();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
