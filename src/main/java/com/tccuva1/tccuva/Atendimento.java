package com.tccuva1.tccuva;

public class Atendimento {

    public String cod_atendimento;
    public String cod_cliente;
    public String tipo_atendimento;
    public String comentario;
    public String status;
    public String data_criacao;


    public Atendimento(String cod_atendimento,String cod_cliente,String tipo_atendimento,String comentario,String status,String data_criacao){

        this.cod_atendimento =cod_atendimento;
        this.cod_cliente = cod_cliente;
        this.tipo_atendimento =tipo_atendimento;
        this.comentario = comentario;
        this.status = status;
        this.data_criacao = data_criacao;
    }

    public String getCod_atendimento(){
        return this.cod_atendimento;
    }

    public void setCod_atendimento(String cod_atendimento){
        this.cod_atendimento =cod_atendimento;
    }

    public String getCod_cliente(){
        return this.cod_cliente;
    }

    public void setCod_cliente(String cod_cliente){
        this.cod_cliente =cod_cliente;
    }

    public String getTipo_atendimento(){
        return this.tipo_atendimento;
    }

    public void setTipo_atendimento(String tipo_atendimento){
        this.tipo_atendimento =tipo_atendimento;
    }

    public String getComentario(){
        return this.comentario;
    }

    public void setComentario(String comentario){
        this.comentario =comentario;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status =status;
    }

    public String getData_criacao(){
        return this.data_criacao;
    }

    public void setData_criacao(String data_criacao){
        this.data_criacao =data_criacao;
    }
    
}
