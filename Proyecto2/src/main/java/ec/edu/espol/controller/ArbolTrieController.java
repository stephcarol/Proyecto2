/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author scabezas
 */
public class ArbolTrieController implements Initializable {

    @FXML
    private Pane panel;
    public static final int DIAMETRO=30;
    public static final int RADIO= DIAMETRO/2;
    public static final int ANCHO=50;
    @FXML
    private TextArea textArea;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btInsertar;
    @FXML
    private Button btEliminar;
    @FXML
    private Button btCargar;
    @FXML
    private Button btGuardar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
   

    
}
