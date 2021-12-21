package com.sistemas.quiosque;

import com.sistemas.quiosque.Classes.Produtos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.sistemas.quiosque.Classes.Carrinho;
import model.ListaProdutosDAO;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button btnAdiocionarCarrinho;

    @FXML
    private Button btnCancelarCompra;

    @FXML
    private Button btnEncerrarCompra;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnRemoverCarrinho;

    @FXML
    void adicionarCarrinho(MouseEvent event) {
        carregarTabela();
    }

    @FXML
    void cancelarCompra(MouseEvent event) {

    }

    @FXML
    void encerrarCompra(MouseEvent event) {

    }

    @FXML
    void goEstoque(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Stage window =(Stage) btnEstoque.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void removerCarrinho(MouseEvent event) {

    }

    @FXML
    private TableColumn<Produtos, Integer> colID;

    @FXML
    private TableColumn<Produtos, String> colNome;

    @FXML
    private TableColumn<Produtos, String> colPreco;

    @FXML
    private TableColumn<TextField, String> colQuantidade;

    @FXML
    private TableView<Produtos> tabela;
    @FXML
    private TableColumn<Produtos, Double> colTotal;

    @FXML
    private Button btnMaisQuantidade;

    @FXML
    private Button btnMenosQuantidade;
    @FXML
    public TextField txtQuantidade;

    private int quantidadeText = 0;

    void enviarQuantidade(){
        txtQuantidade.setText(Integer.toString(quantidadeText));
    }

    @FXML
    void adicionaQuantidade(MouseEvent event) {
        quantidadeText += 1;
        enviarQuantidade();
    }
    @FXML
    void subtraiQuantidade(MouseEvent event) {
        if(quantidadeText >0){
            quantidadeText -= 1;
        } else {
            quantidadeText = 0;
        }
        enviarQuantidade();
    }

    void carregarTabela(){

        tabela.setItems(listandoProdutos());

        colID.setCellValueFactory(new PropertyValueFactory<Produtos,Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Produtos,String>("nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory<Produtos,String>("preco"));

    }

    public ObservableSet<Carrinho> listarCarrinho(){
        return FXCollections.observableSet(txtQuantidade);
    }
    public ObservableList<Produtos> listandoProdutos()  {
        ListaProdutosDAO lP = new ListaProdutosDAO();
        return FXCollections.observableList(lP.getLista());
    }
}
