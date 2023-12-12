/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.cafeconpalito.controllers.RegisterController;
import com.cafeconpalito.registerUserData.userRegisterInfo;
import com.cafeconpalito.staticElements.Colors;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class Register_1Controller implements Initializable {

    @FXML
    private TextField nicknametexfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private TextField imagetextfield;
    @FXML
    private Button selectImgButton;
    @FXML
    private ComboBox<String> rolecombobox;
    @FXML
    private ImageView backArrow;
    @FXML
    private Button registerButton;
    @FXML
    private Label nicknameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label rPaswordLabel;
    @FXML
    private TextField rPasswordtextfield;
    @FXML
    private ImageView defaultImage;
    @FXML
    private Label imageLabel;
    @FXML
    private Label roleLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rolecombobox.getItems().addAll("user", "developer");

//        nicknametexfield.setText(userRegisterInfo.getNickname());
//        passwordtextfield.setText(userRegisterInfo.getPassword());
//        rPasswordtextfield.setText(userRegisterInfo.getrPassword());
//        imagetextfield.setText(userRegisterInfo.getImage());
//        rolecombobox.setValue(userRegisterInfo.getRole());
    }

    @FXML
    private void backBtn(MouseEvent event) throws IOException {
        //incluir persistencia de datos aqui ******** aunque  no se haya relellenado todo

        if (nicknametexfield.getText()!=null) {
            userRegisterInfo.setNickname(nicknametexfield.getText());           
        }else if(passwordtextfield.getText()!=null) {
            userRegisterInfo.setPassword(passwordtextfield.getText());
        }else if(rPasswordtextfield.getText()!=null) {
            userRegisterInfo.setrPassword(rPasswordtextfield.getText());
        }else if(imagetextfield.getText()!=null) {
            userRegisterInfo.setImage(imagetextfield.getText());
        }else if(rolecombobox.getValue()!=null) {
            userRegisterInfo.setRole(rolecombobox.getValue().toString());
        }

        MainView.main.setCenter(App.loadFXML("register"));

    }

    @FXML
    private void imageClicked(MouseEvent event) {

        //mismo que imageButton... debería desplegar un filechooser
    }

    @FXML
    private void SelectImage(ActionEvent event) {
    }

    @FXML
    private void tryToRegister(ActionEvent event) {
        if (nicknametexfield.getText().isBlank()) {
            nicknameLabel.setTextFill(Colors.textColorError);
        } else if (passwordtextfield.getText().isBlank()) {
            passwordLabel.setTextFill(Colors.textColorError);
        } else if (rPasswordtextfield.getText().isBlank() || rPasswordtextfield.getText() != passwordtextfield.getText()) {
            rPaswordLabel.setTextFill(Colors.textColorError);
        } else if (imagetextfield.getText().isBlank()) {
            imageLabel.setTextFill(Colors.textColorError);
        } else if (rolecombobox.getValue() == null) {
            roleLabel.setTextFill(Colors.textColorError);
        }

        // aquí va to lo gordo
        System.out.println("intentando registrar usuario");

    }

    @FXML
    private void nickNameFocused(MouseEvent event) {
        nicknameLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void passwordFocused(MouseEvent event) {
        passwordLabel.setTextFill(Colors.textColor);
    }

    private void rPasswordFocused(MouseEvent event) {
        rPaswordLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void imageTextfieldFocused(MouseEvent event) {
        imageLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void imageButton(MouseEvent event) {
        //mismo que imageCliked... debería desplegar un filechooser
    }

    @FXML
    private void roleComboBoxFocused(MouseEvent event) {
        roleLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void rpasswordFocused(MouseEvent event) {
    }

}
