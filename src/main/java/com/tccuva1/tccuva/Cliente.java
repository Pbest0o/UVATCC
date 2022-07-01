package com.tccuva1.tccuva;

public class Cliente {

    public String cod_cliente;
    public String cod_lead;
    public String name;
    public String email;
    public String idade;
    public String qtd_compras;
    public String qtd_atendimento;
    public String dataCriacao;
    



    public Cliente(String cod_cliente, String cod_lead, String name, String email, String idade, String qtd_compras,
            String qtd_atendimento, String dataCriacao) {
        this.cod_cliente = cod_cliente;
        this.cod_lead = cod_lead;
        this.name = name;
        this.email = email;
        this.idade = idade;
        this.qtd_compras = qtd_compras;
        this.qtd_atendimento = qtd_atendimento;
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
