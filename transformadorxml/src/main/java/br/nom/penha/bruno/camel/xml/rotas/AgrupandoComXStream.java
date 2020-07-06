package br.nom.penha.bruno.camel.xml.rotas;

import br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste;
import br.nom.penha.bruno.camel.xml.processadores.ProcessadorXStream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class AgrupandoComXStream extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entrada-csv")
            .process(new ProcessadorXStream())
            //.marshal().xstream()
            .marshal(populaDefinicaoXML())
            .log("Corpo da mensagem [${body}]")
            .to("log:?level=INFO&showBody=true")
            .to("mock:saida");

    }

    private XStreamDataFormat populaDefinicaoXML(){

        XStreamDataFormat xStreamDataFormat = null;
        xStreamDataFormat = new XStreamDataFormat();

        Map<String, String> mapeaTags = new HashMap<String, String>();
        mapeaTags.put("entidade",EntidadeTeste.class.getName());
        xStreamDataFormat.setAliases(mapeaTags);

        return xStreamDataFormat;
    }
}
