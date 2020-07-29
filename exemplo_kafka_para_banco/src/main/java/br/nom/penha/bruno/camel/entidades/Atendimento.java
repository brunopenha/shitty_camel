package br.nom.penha.bruno.camel.entidades;

public class Atendimento {
    private int idAtendimento;
    private int idPaciente;
    private int idMedico;
    private int idHospital;
    private String tipoAtendimento;
    private String dataAtendimento;
    private String dataAtualizacao;

    @Override
    public String toString() {
        return "Atendimento{" +
                "idAtendimento=" + idAtendimento +
                ", idPaciente=" + idPaciente +
                ", idMedico=" + idMedico +
                ", idHospital=" + idHospital +
                ", tipoAtendimento='" + tipoAtendimento + '\'' +
                ", dataAtendimento='" + dataAtendimento + '\'' +
                ", dataAtualizacao='" + dataAtualizacao + '\'' +
                '}';
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
