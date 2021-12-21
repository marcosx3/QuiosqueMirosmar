package com.sistemas.quiosque;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtUsuario;

   @FXML
    void alterarScena() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window =(Stage) btnEntrar.getScene().getWindow();
        window.setTitle("Home");
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    void efetuarLogin(MouseEvent event) {

    }


    @FXML
    void sair(MouseEvent event) {

    }

}
