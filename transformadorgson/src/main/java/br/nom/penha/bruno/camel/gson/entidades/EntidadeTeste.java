package br.nom.penha.bruno.camel.gson.entidades;

public class EntidadeTeste {

    private int id;
    private String nome;
    private String data;

    @Override
    public String toString() {
        return "EntidadeTeste{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
