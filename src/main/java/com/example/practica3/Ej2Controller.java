package com.example.practica3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Ej2Controller implements Initializable {
    @FXML
    private TreeView treeView;

    @FXML
    private ComboBox cb;

    @FXML
    private TableView<Producto> tableProducto;
    @FXML
    private TableColumn<Producto, String> idCol;
    @FXML
    private TableColumn<Producto, String> descrCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TreeItem<String> rootItem = new TreeItem<>();

        TreeItem<String> branch1 = new TreeItem<>("Hardware");
        branch1.getChildren().add(new TreeItem<>("Tarjeta gráfica"));
        branch1.getChildren().add(new TreeItem<>("Refrigeración líquida"));
        branch1.getChildren().add(new TreeItem<>("Fuente de alimentación "));
        branch1.setExpanded(true);
        rootItem.getChildren().add(branch1);

        TreeItem<String> branch2 = new TreeItem<>("Almacenamiento");
        branch2.getChildren().add(new TreeItem<>("Disco duro SSD"));
        branch2.getChildren().add(new TreeItem<>("Memoria RAM"));
        branch2.setExpanded(true);
        rootItem.getChildren().add(branch2);

        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
        treeView.setRoot(rootItem);
        treeView.setShowRoot(false);


        cb.setItems(FXCollections.observableArrayList("Monitor", "Tarjeta gráfica", "Disco duro SSD", "Refigeración líquida", "Fuente de alimentación", "Memoria RAM"));


        idCol.setCellValueFactory(new PropertyValueFactory<Producto,String>("id"));
        descrCol.setCellValueFactory(new PropertyValueFactory<Producto,String>("descripcion"));

        ObservableList<Producto> data = FXCollections.observableArrayList(
                new Producto(1, "Monitor"),
                new Producto(2, "Tarjeta gráfica"),
                new Producto(3, "Disco duro SSD"),
                new Producto(4, "Refrigeración líquida")
        );

        tableProducto.setItems(data);

    }

}