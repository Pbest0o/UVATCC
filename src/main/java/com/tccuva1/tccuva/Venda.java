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
    
}
