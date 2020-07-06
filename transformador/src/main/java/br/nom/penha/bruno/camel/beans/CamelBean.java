package br.nom.penha.bruno.camel.beans;

public class CamelBean {

    public String mapeador(String entrada){

        String novo = entrada.replace(",", "*");

        return novo;
    }

    public String mapeadorDiferente(String entrada){

        String novo = entrada.replace(",", "++");

        return novo;
    }
}
