package com.sistemas.quiosque;

import com.sistemas.quiosque.Classes.Produtos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ListaProdutosDAO;

import java.io.IOException;
import java.sql.SQLException;

public class ListarProdutoController {

    @FXML
    private Button btnCaixa;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnListar;

    @FXML
    private TableColumn<Produtos, Integer> colID;

    @FXML
    private TableColumn<Produtos,String> colNome;

    @FXML
    private TableColumn<Produtos, String> colPreco;

    @FXML
    private TableColumn<Produtos, String> colTipo;

    @FXML
    private TableView<Produtos> tabela;

    @FXML
    void goCaixa(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }
    void carregarTabela(){

        tabela.setItems(listandoProdutos());
        colID.setCellValueFactory(new PropertyValueFactory<Produtos,Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Produtos,String>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<Produtos,String>("preco"));
        colTipo.setCellValueFactory(new PropertyValueFactory<Produtos,String>("tipo"));
    }
    @FXML
    void listarProdutos(MouseEvent event) throws SQLException {
        carregarTabela();

    }
    public ObservableList<Produtos> listandoProdutos()  {
        ListaProdutosDAO lP = new ListaProdutosDAO();
        return FXCollections.observableList(lP.getLista());
    }

}
