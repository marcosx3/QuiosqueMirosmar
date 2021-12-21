package com.sistemas.quiosque;


import com.sistemas.quiosque.Classes.Produtos;
import javafx.concurrent.Task;
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
import model.CadastroProdutoDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastrarProdutoController implements Initializable {

    @FXML
    private Button btnCadastrarProduto;
    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnHelp;
    @FXML
    private TextField cxID;

    @FXML
    private Button btnCancelaCadastroProduto;

    @FXML
    private ChoiceBox<String> ckTipo;

    @FXML
    private TextField txtNomeProduto;

    @FXML
    private TextField txtPrecoProduto;
    private String[] t = {"Bebida","Comida","Doce","Salgados","Balas"};

    void setarCxID() throws SQLException {
        CadastroProdutoDAO cad = new CadastroProdutoDAO();
        int iD = cad.recuperarID() + 1;
        cxID.setText(Integer.toString(iD));
    }
    // ncessario criar uma thread para atualizar o numero em paralelo

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            ckTipo.getItems().addAll(t);
            ckTipo.setValue("Bebida");
            //recuperacao de ID para cadastro
        try {
            setarCxID();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    Produtos cadProd(){
        Produtos produto = new Produtos();
        produto.setNome(txtNomeProduto.getText());
        produto.setPreco(txtPrecoProduto.getText());
        produto.setTipo(ckTipo.getValue());

        return produto;
    }

    @FXML
    void cadastrarProduto(MouseEvent event) throws SQLException {
        CadastroProdutoDAO cad = new CadastroProdutoDAO();
        try{
            cad.cadastroProduto(cadProd());
            Alert cadSucesso = new Alert(Alert.AlertType.CONFIRMATION);
            cadSucesso.setTitle("Cadastro Validado");
            cadSucesso.setContentText("Produto Cadastrado no Banco de Dados!");
            cadSucesso.setHeaderText(null);
            cadSucesso.showAndWait();
            zerarTela();
        } catch (SQLException e){
            System.out.println(e);
        }


    }
    void zerarTela(){
        txtNomeProduto.setText("");
        txtPrecoProduto.setText("");
        ckTipo.setValue("Bebida");
    }
    @FXML
    void cancelarCadastro(MouseEvent event) {
            zerarTela();
    }
    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

}
