package com.tccuva1.tccuva;

public class Atendimento {
 
    
    public String cod_atendimento;
    public String cod_cliente;
    public String tipo_atendimento;
    public String comentario;
    public String status;
    public String data_criacao;

    public Atendimento(String cod_atendimento, String cod_cliente, String tipo_atendimento, String comentario, String status, String data_criacao){
        this.cod_atendimento = cod_atendimento;
        this.cod_cliente = cod_cliente;
        this.tipo_atendimento = tipo_atendimento;
        this.comentario = comentario;
        this.status = status;
        this.data_criacao = data_criacao;
    }
}