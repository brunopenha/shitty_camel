package br.nom.penha.bruno.camel.processadores;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExemploProcessadorDireto implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        try {
            String atual = (String) exchange.getIn().getBody();

            String modificado = atual.replace(":",",");

            exchange.getIn().setBody(modificado);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
