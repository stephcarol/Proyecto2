/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Trie;
import ec.edu.espol.proyecto2.App;
import ec.edu.espol.util.RegistroException;
import ec.edu.espol.util.Validar;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    private Trie trie=new Trie();
    @FXML
    private TextArea textArea;
    @FXML
    private Button btGuardar;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TextField txtInsertar;
    @FXML
    private TextField txtEliminar;
    @FXML
    private TextArea sugerencia;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
    	Trie trie = new Trie(); 
        trie.insert("abc");
    	trie.insert("bay");
    	trie.insert("bey");
    	trie.insert("bea");
    	trie.insert("bed");
    	trie.insert("bee");
    	trie.insert("boy");
    	trie.insert("boyc");
    	trie.insert("boyd");
    	trie.insert("boye");
    	trie.insert("boycd");
    	trie.insert("bye-bye");
    	trie.insert("by-by");
    	trie.insert("bye");
    	trie.insert("zad");
    	trie.insert("zed");
    	trie.insert("zef");
    	trie.insert("cda");
        trie.insert("abcdd");
        String salida=trie.print();
        textArea.appendText(salida);
        
    }    

    @FXML
    private void ClickBuscar(MouseEvent event) throws IOException {
        /*
        FXMLLoader fxml=App.loadFXMLoader("Buscar");
        App.setRoot(fxml);*/
        
//        List<String> lista=trie.listWords();
//        for(String s:lista ){
//          if(txtBuscar.getText().equals(s)){
//              System.out.println("Hemos encontrado la palabra"); 
//            }  
//        }
        if(trie.contains(txtBuscar.getText()))
            System.out.println("Hemos encontrado la palabra");
        
    }

    @FXML
    private void ClickInsertar(MouseEvent event) {

        try {
            String dato = txtInsertar.getText();
            if (Validar.validarDato(txtInsertar)) {
                if (textArea.getText().isEmpty()) {
                    trie.insert(dato);
                    textArea.appendText(dato);
                } else if((!textArea.getText().isEmpty())){
                    trie.insert(dato);
                    String salida = trie.print();
                    textArea.clear();
                    textArea.appendText(salida);
                }
                Alert a =new Alert(Alert.AlertType.CONFIRMATION,"Datos guardados exitosamente");
                a.show();
            }

        } catch (RegistroException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,"El tipo de formato es solo String");
            alerta.showAndWait();
        }

    }

    @FXML
    private void ClickEliminar(MouseEvent event) {
    
    }

    @FXML
    private void ClickCargar(MouseEvent event) {
    }

    @FXML
    private void ClickGuardar(MouseEvent event) {
    }

    @FXML
    private void updateSugerencias(KeyEvent event) {
//        sugerencia.setText("");
//        String prefijo = txtBuscar.getText();
//        for (String word:trie.listPrefijo(prefijo)){
//            sugerencia.appendText(word +"\n");
//        }
//            
    }
   

    
}
