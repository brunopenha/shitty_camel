package br.nom.penha.bruno.camel.xml.rotas;

import br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class DesagrupadorComXStream extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        XStreamDataFormat formatador = new XStreamDataFormat();
        Map<String, String> mapeador = new HashMap<String, String>();
        mapeador.put("entidade", EntidadeTeste.class.getName());
        formatador.setAliases(mapeador);
        // Para evitar
        // Caused by: com.thoughtworks.xstream.security.ForbiddenClassException: br.nom.penha.bruno.camel.xml.entidades.EntidadeTeste
        formatador.setPermissions(EntidadeTeste.class.getName());

        from("direct:entrada-xml")
        .unmarshal(formatador)
        .to("log:?level=INFO&showBody=true")
        .to("mock:saida");
    }
}
