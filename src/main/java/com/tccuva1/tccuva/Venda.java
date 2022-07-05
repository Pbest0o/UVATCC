package com.tccuva1.tccuva;


public class Venda {

    public String cod_vendas;
    public String cod_cliente;
    public String qnt_itens;
    public String vlr_compra;
    public String data_criacao;

    public Venda(String cod_vendas, String cod_cliente, String qnt_itens, String vlr_compra, String data_criacao){
        this.qnt_itens = qnt_itens;
        this.vlr_compra = vlr_compra;
        this.cod_cliente = cod_cliente;
        this.cod_vendas = cod_vendas;
        this.data_criacao = data_criacao;
    }
    
    public String getCod_vendas(){
        return this.cod_vendas;
    }

    public void setCod_vendas(String cod_vendas){
        this.cod_vendas =cod_vendas;
    }

    public String getCod_cliente(){
        return this.cod_cliente;
    }

    public void setCod_cliente(String cod_cliente){
        this.cod_cliente =cod_cliente;
    }

    public String getQnt_itens(){
        return this.qnt_itens;
    }

    public void setQnt_itens(String qnt_itens){
        this.qnt_itens =qnt_itens;
    }

    public String getVlr_compra(){
        return this.cod_vendas;
    }

    public void setVlr_compra(String vlr_compra){
        this.vlr_compra =vlr_compra;
    }

    public String getData_criacao(){
        return this.data_criacao;
    }

    public void setData_criacao(String data_criacao){
        this.data_criacao =data_criacao;
    }

}
