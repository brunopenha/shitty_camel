package br.nom.penha.bruno.camel.rotas;

import br.nom.penha.bruno.camel.processadores.ExemploProcessadorArquivo;
import org.apache.camel.builder.RouteBuilder;

public class RotaProcessadoraModificaArquivos extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:dados/entrada?noop=true")
        .log("Lendo o arquivo com o corpo |${body}| e os cabeçalhos |${headers}|")
        .process(new ExemploProcessadorArquivo())
        .to("file:dados/saida?FileName= saida.txt")
        .to("mock:saida");

    }
}
