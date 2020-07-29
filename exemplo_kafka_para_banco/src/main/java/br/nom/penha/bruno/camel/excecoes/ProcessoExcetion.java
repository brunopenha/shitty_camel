package br.nom.penha.bruno.camel.excecoes;

import org.apache.camel.Exchange;

public class ProcessoExcetion implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception excecao = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Mensagem da exceção: " + excecao.getMessage());
        System.out.println("Classe da exceção: " + excecao.getClass());

        String falha = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Falhou: " + falha);

        exchange.getIn().setBody("Ocorreu uma exceção na rota.");
    }
}
