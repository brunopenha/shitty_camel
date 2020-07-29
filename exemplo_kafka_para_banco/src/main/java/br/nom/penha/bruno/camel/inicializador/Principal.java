package br.nom.penha.bruno.camel.inicializador;

import br.nom.penha.bruno.camel.rotas.RotaKaftaParaMySQL;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class Principal {

    public static void main(String[] args) throws Exception {
        Main inicio = new Main();

        String urlBanco = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";

        inicio.bind("fonteBanco", preparaFonteDados(urlBanco));
        inicio.addRouteBuilder(new RotaKaftaParaMySQL());
        System.out.println("Iniciando a rota do Camel");

        inicio.run();

    }

    private static DataSource preparaFonteDados(String url) {
        BasicDataSource origem = new BasicDataSource();
        origem.setDriverClassName("com.mysql.cj.jdbc.Driver");
        origem.setUrl(url);
        origem.setUsername("root");
        origem.setPassword("Admin123");

        return origem;
    }
}
