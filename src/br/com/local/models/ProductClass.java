package br.com.local.models;

public class ProductClass {
    private String nomeProduto;
    private String descricaoProduto;
    private double valorProduto;
    private int quantiaNoEstoque;

    public ProductClass(String nomeProduto, String descricaoProduto, double valorProduto, int quantiaNoEstoque) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.quantiaNoEstoque = quantiaNoEstoque;
    }

    public void descreveProduto(){
        System.out.printf("Produto: %s \n Descrição: %s \n Valor: %.2f", nomeProduto, descricaoProduto, valorProduto);

    }


}

