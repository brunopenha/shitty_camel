package br.nom.penha.bruno.camel.xml.entidades;

public class EntidadeTeste {

    private int id;
    private String data;
    private String nome;

    @Override
    public String toString() {
        return "EntidadeTeste{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
