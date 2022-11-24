package com.example.practica3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Ej2Controller implements Initializable {

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ObservableList<String> listaCB = FXCollections.observableArrayList();
    
    @FXML
    private TreeView treeView;

    private String nuevoValor, antiguoValor;

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

        treeView.setOnEditCommit(new EventHandler<TreeView.EditEvent>() {
            @Override
            public void handle(TreeView.EditEvent editEvent) {
                antiguoValor = editEvent.getOldValue().toString();
                nuevoValor = editEvent.getNewValue().toString();
                for (int i = 0; i < listaCB.size(); i++) {
                    if (listaCB.get(i).equals(antiguoValor)){
                        listaCB.set(i, nuevoValor);
                        cb.setItems(listaCB);
                    }
                }

            }
        });
        
        listaCB.addAll("Monitor", "Tarjeta gráfica", "Disco duro SSD", "Refigeración líquida", "Fuente de alimentación", "Memoria RAM");

        cb.setItems(listaCB);


        idCol.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
        descrCol.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));

        llenarTabla();

    }

    private void llenarTabla() {
        listaProductos.addAll(
                new Producto(1, "Monitor"),
                new Producto(2, "Tarjeta gráfica"),
                new Producto(3, "Disco duro SSD"),
                new Producto(4, "Refrigeración líquida")
        );

        tableProducto.setItems(listaProductos);
    }

    @FXML
    public void onActionCB() {
        String valor = cb.getValue().toString();
        listaProductos.add(new Producto(listaProductos.size() + 1, valor));
        tableProducto.setItems(listaProductos);
    }



}