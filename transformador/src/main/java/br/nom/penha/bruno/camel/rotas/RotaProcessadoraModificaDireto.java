package br.nom.penha.bruno.camel.rotas;

import br.nom.penha.bruno.camel.processadores.ExemploProcessadorDireto;
import org.apache.camel.builder.RouteBuilder;

public class RotaProcessadoraModificaDireto extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entradaProcessamento")
        .log("Lendo diretamente (direct) com o corpo |${body}| e os cabeçalhos |${headers}|")
        .process(new ExemploProcessadorDireto())
        .to("file:dados/saida?FileName=saida.txt")
        .to("mock:saida");

    }
}
