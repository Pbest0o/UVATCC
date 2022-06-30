package com;

public class Lead {

    private String name;
    private String email;
    private String cod_lead;
    private String idade;
    private String canal;
    private String dataCriacao;
    

    public Lead(String name, String email, String cod_lead, String idade, String canal, String dataCriacao) {
        this.name = name;
        this.email = email;
        this.cod_lead = cod_lead;
        this.idade = idade;
        this.canal = canal;
        this.dataCriacao = dataCriacao;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCod_lead() {
        return cod_lead;
    }

    public void setCod_lead(String cod_lead) {
        this.cod_lead = cod_lead;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
