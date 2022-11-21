package com.example.practica3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Ej2Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}