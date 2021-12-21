package com.sistemas.quiosque.Classes;
public class Produtos {
    private String nome;
    private String preco;
    private String tipo;
    private int id;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public  Produtos (){}
    //sem ID
    public  void  Produtos(String nome,String preco,String tipo){
        this.nome=nome;
        this.preco = preco;
        this.tipo = tipo;
    }
    //com ID
    public   Produtos(int id,String nome,String preco,String tipo){
        this.id = id;
        this.nome=nome;
        this.preco = preco;
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
