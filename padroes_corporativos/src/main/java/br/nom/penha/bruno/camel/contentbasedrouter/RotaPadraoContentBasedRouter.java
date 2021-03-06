package br.nom.penha.bruno.camel.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

public class RotaPadraoContentBasedRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("file:entrada?noop=true") // noop é para não realizar nenhuma operação depois de mover o conteudos
           .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                    .when(header("CamelFileNameConsumed").endsWith("html"))
                        .to("file:saida/html")
                    .when(header("CamelFileNameConsumed").endsWith("txt"))
                        .to("file:saida/txt")
                    .when(header("CamelFileNameConsumed").endsWith("json"))
                        .to("file:saida/json")
                    .otherwise()  // Para os formatos desconhecidos
                        .to("file:saida/9_desconhecido").stop() // Isso impedira que arquivos desse formato sejam copiados para o diretorio que contem todos os arquivos
                .end() // Fim da condição
            .to("file:saida/0_todosOsArquivos");

    }
}
