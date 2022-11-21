module com.example.practica3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica3 to javafx.fxml;
    exports com.example.practica3;
}