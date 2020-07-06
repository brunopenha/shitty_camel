package br.nom.penha.bruno.json.rotas;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class RotaXmlParaJson extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:entrada-xml")
        .to("log:?level=INFO&showBody=true")
        .marshal().xmljson()
        .to("log:?level=INFO&showBody=true");

        XmlJsonDataFormat formatador = new XmlJsonDataFormat();
        formatador.setRootName("entidade");


        from("direct:entrada-json")
        .to("log:?level=INFO&showBody=true")
        //.unmarshal().xmljson()
        .unmarshal(formatador)
        .to("log:?level=INFO&showBody=true");

    }
}
