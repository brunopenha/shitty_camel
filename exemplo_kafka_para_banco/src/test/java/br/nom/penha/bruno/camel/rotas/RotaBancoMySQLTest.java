package br.nom.penha.bruno.camel.rotas;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RotaBancoMySQLTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RotaBancoMySQL();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
        DataSource fonteDados = preparaFonteDados(url);

        SimpleRegistry registro = new SimpleRegistry();
        registro.put("fonteBanco",fonteDados);

        CamelContext contexto = new DefaultCamelContext(registro);
        return contexto;
    }

    private DataSource preparaFonteDados(String url) {
        BasicDataSource fonte = new BasicDataSource();
        fonte.setUsername("root");
        fonte.setDriverClassName("com.mysql.cj.jdbc.Driver");
        fonte.setPassword("Admin123");
        fonte.setUrl(url);

        return fonte;
    }

    @Test
    public void insereDadosTest(){

     //   String valores = "VALUES (103, 1, 2, 15, 'Emergencia', '2020-06-10 08:00:01')";
        String valores = "{\"ROWTIME\":1593806813699,\"ROWKEY\":\"null\",\"schema\":{\"type\":\"struct\",\"fields\":[{\"type\":\"int32\",\"optional\":false,\"field\":\"idprescricao\"},{\"type\":\"int32\",\"optional\":true,\"field\":\"idpaciente\"},{\"type\":\"int32\",\"optional\":true,\"field\":\"idmedico\"},{\"type\":\"int32\",\"optional\":true,\"fi\n" +
                "eld\":\"idatendimento\"},{\"type\":\"string\",\"optional\":true,\"field\":\"tipoprescricao\"},{\"type\":\"int32\",\"optional\":true,\"field\":\"idresultado\"},{\"type\":\"int64\",\"optional\":true,\"name\":\"org.apache.kafka.connect.data.Timestamp\",\"version\":1,\"field\":\"dataprescricao\"},{\"type\":\"int64\",\"opt\n" +
                "ional\":false,\"name\":\"org.apache.kafka.connect.data.Timestamp\",\"version\":1,\"field\":\"dataatualizacao\"}],\"optional\":false,\"name\":\"prescricao\"},\"payload\":{\"idprescricao\":2,\"idpaciente\":1,\"idmedico\":4,\"idatendimento\":2,\"tipoprescricao\":\"Exame\",\"idresultado\":null,\"dataprescricao\":\n" +
                "1593808459000,\"dataatualizacao\":1593806788000}}";
        ArrayList retorno = template.requestBody("direct:entradaBanco", valores, ArrayList.class);
        System.out.println("Tamanho do retorno: " + retorno.size());
        assertNotSame(0,retorno.size());

    }
}