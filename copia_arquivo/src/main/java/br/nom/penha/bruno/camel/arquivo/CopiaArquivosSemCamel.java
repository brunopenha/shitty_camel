package br.nom.penha.bruno.camel.arquivo;

import java.io.*;

public class CopiaArquivosSemCamel {

    public static void main(String[] args) throws IOException {
        //Passo 1 Crie um objeto File para ler o diretorio
        File diretorioEntrada = new File("dados/entrada");
        File diretorioSaida = new File("dados/saida");

        //Passo 2 Le os arquivos do diretorio e varre os arquivos
        File[] arquivos = diretorioEntrada.listFiles();

        //Passo 3 Cria uma transmissao para ler e receber os dados dos arquivos
        for (File origem: arquivos) {

            File destino = new File(diretorioSaida.getPath() + File.separator + origem.getName());

            OutputStream transmissaoSaida = new FileOutputStream(destino);
            byte[] buffer = new byte[(int) origem.length()];
            FileInputStream transmissaoEntrada = new FileInputStream(origem);
            transmissaoEntrada.read(buffer);
            try {
                transmissaoSaida.write(buffer);
            }finally {
                //Passo 4 Encerro a transmissão
                transmissaoEntrada.close();
                transmissaoSaida.close();
            }


        }


    }
}
