module ec.edu.espol.proyecto2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto2 to javafx.fxml;
    exports ec.edu.espol.proyecto2;
}
