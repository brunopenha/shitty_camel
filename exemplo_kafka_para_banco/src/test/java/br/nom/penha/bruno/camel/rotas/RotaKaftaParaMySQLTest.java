package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

public class RotaKaftaParaMySQLTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaKaftaParaMySQL();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext contexto = null;

        String url = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
        DataSource origem = preparaFonteDados(url);

        SimpleRegistry registro = new SimpleRegistry();
        registro.put("fonteBanco", origem);

        contexto = new DefaultCamelContext(registro);

        return contexto;
    }

    private DataSource preparaFonteDados(String url) {
        BasicDataSource origem = new BasicDataSource();
        origem.setDriverClassName("com.mysql.cj.jdbc.Driver");
        origem.setUrl(url);
        origem.setUsername("root");
        origem.setPassword("Admin123");

        return origem;
    }

    @Test
    public void doKafkaParaBanco(){
        List retorno = (List) consumer.receiveBody("direct:saida");
        System.out.println("Retorno: " + retorno.size());
        assertNotSame(0,retorno.size());
    }
}