package com.sistemas.quiosque;

import DB.Conexao;
import com.sistemas.quiosque.Classes.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AtualizaProdutoDAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AtualizarProdutoController  implements Initializable {

    @FXML
    private Button btnCaixa;

    @FXML
    private Button btnEstoque;
    @FXML
    private ChoiceBox<String> ckTipo;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNome;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtPreco;

    private String[] t = {"Bebida","Comida","Doce"};

    ///buscar produto nao funciona?

    @FXML
    void buscarProduto(MouseEvent event) throws SQLException {
        AtualizaProdutoDAO atD = new AtualizaProdutoDAO();

         Produtos produto =   atD.getProdutos(Integer.parseInt(txtID.getText()));
         txtNome.setText(produto.getNome());
         txtPreco.setText(produto.getPreco());
         ckTipo.setValue(produto.getTipo());
    }

    Produtos aTProd(){
        Produtos produto = new Produtos();
        produto.setNome(txtNome.getText());
        produto.setPreco(txtPreco.getText());
        produto.setTipo(ckTipo.getValue());
        return produto;
    }


    @FXML
    void goHome(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Estoque");
        window.setScene(new Scene(root,600,400));
    }
    @FXML
    void atualizarProduto(MouseEvent event) {
                AtualizaProdutoDAO atD = new AtualizaProdutoDAO();
        try{
            atD.atualizaProduto(Integer.parseInt(txtID.getText()),aTProd());
            Alert cadSucesso = new Alert(Alert.AlertType.INFORMATION);
            cadSucesso.setTitle("Produto Atualizado");
            cadSucesso.setContentText("Produto Atualizado no Banco de Dados!");
            cadSucesso.setHeaderText(null);
            cadSucesso.showAndWait();
            zerarTela();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    void zerarTela(){
        txtID.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        ckTipo.setValue("");
    }
    @FXML
    void cancelarAtualizacao(MouseEvent event) {
            txtID.setText("");
            txtNome.setText("");
            txtPreco.setText("");
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ///atualizacao constante do cktipo
        ckTipo.getItems().addAll(t);


    }
}
