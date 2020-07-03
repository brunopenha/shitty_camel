package br.nom.penha.bruno.camel.processadores;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExemploProcessadorArquivo implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        // Use essa saída para idenficar a Interface do processador
        System.out.println("A troca no processador eh: " + exchange.getIn().getBody());

        GenericFile<File> arquivo = (GenericFile<File>) exchange.getIn().getBody();

        if(arquivo != null){
            FileReader leitor  = new FileReader(arquivo.getFile());

            BufferedReader linha = new BufferedReader(leitor);

            String lendo = null;
            String novo = "";
            while(null != (lendo = linha.readLine())){
                System.out.println("A linha contem " + lendo);

                String original = lendo;

                novo = novo.concat(original.replace(",",":")).concat("\n");
                exchange.getIn().setBody(novo);
            }
        }
    }
}
