module ec.edu.espol.Proyecto{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto2 to javafx.fxml;
    exports ec.edu.espol.proyecto2;
    
    opens ec.edu.espol.controller to javafx.fxml;
    exports ec.edu.espol.controller;
    
    opens ec.edu.espol.model to javafx.fxml;
    exports ec.edu.espol.model;
}
