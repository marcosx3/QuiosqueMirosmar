package com.sistemas.quiosque;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EstoqueController {

    @FXML
    private Button btngoAtualizarProdutos;

    @FXML
    private Button btngoCadastrarProdutos;

    @FXML
    private Button btngoDeletarProdutos;

    @FXML
    private Button btngoListarProdutos;

    @FXML
    void btngoListarProdutos(MouseEvent event) {

    }

    @FXML
    void goAtualizarProdutos(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("atualizarProduto.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Atualiza Produtos");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void goCadastrarProdutos(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("cadastrarProduto.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Cadastrar Produtos");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void goDeletarProdutos(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("deletarProduto.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Excluir  Produto");
        window.setScene(new Scene(root,600,400));
    }
    @FXML
    void goListarProdutos(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("listarProdutos.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Excluir  Produto");
        window.setScene(new Scene(root,600,400));
    }
    @FXML
    private Button btnCaixa;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnHelp;


    @FXML
    void goCaixa(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Excluir  Produto");
        window.setScene(new Scene(root,600,400));
    }
    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btngoCadastrarProdutos.getScene().getWindow();
        window.setTitle("Excluir  Produto");
        window.setScene(new Scene(root,600,400));
    }
    @FXML
    void goHelp(MouseEvent event) {

    }

}
