package com.sistemas.quiosque;

import com.sistemas.quiosque.Classes.Produtos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DeletarProdutoDAO;

import java.io.IOException;
import java.sql.SQLException;

public class DeletarProdutoController {

    @FXML
    private Button btnCaixa;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnHelp;

    @FXML
    private ChoiceBox<String> ckTipo;

    @FXML
    private TextField cxID;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private Button btnCancelar;

    @FXML
    void cancelaExcluir(MouseEvent event) {
            zerarTela();
    }

    @FXML
    void deletarProduto(MouseEvent event) {
        try {
            DeletarProdutoDAO del = new DeletarProdutoDAO();
            del.deletarProduto(Integer.parseInt(cxID.getText()));
            Alert cadSucesso = new Alert(Alert.AlertType.INFORMATION);
            cadSucesso.setTitle("Exclusao Confirmada!");
            cadSucesso.setContentText("Produto Excluido no Banco de Dados!");
            cadSucesso.setHeaderText(null);
            cadSucesso.showAndWait();
            zerarTela();
        } catch (SQLException e){
            Alert cadSucesso = new Alert(Alert.AlertType.ERROR);
            cadSucesso.setTitle("Exclusao Incompleta!");
            cadSucesso.setContentText("Produto não foi Excluido no Banco de Dados!");
            cadSucesso.setHeaderText(null);
            cadSucesso.showAndWait();

        }
    }
    void zerarTela(){
        cxID.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        ckTipo.setValue("");
    }
    @FXML
    void buscarProduto(MouseEvent event) throws SQLException {
        DeletarProdutoDAO deP = new DeletarProdutoDAO();
        Produtos produto =   deP.getProdutos(Integer.parseInt(cxID.getText()));
        txtNome.setText(produto.getNome());
        txtPreco.setText(produto.getPreco());
        ckTipo.setValue(produto.getTipo());
    }
    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void goHelp(MouseEvent event) {

    }

    @FXML
    void goHome(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }


}
