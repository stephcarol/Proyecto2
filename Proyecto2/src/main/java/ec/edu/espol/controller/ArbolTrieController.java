/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.Trie;
import ec.edu.espol.proyecto2.App;
import ec.edu.espol.util.Archivos;
import ec.edu.espol.util.RegistroException;
import ec.edu.espol.util.Validar;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    private Trie trie=new Trie();
    @FXML
    private TextArea textArea;    
    @FXML
    private TextField txtBuscar;
    @FXML
    private TextField txtInsertar;
    @FXML
    private TextField txtEliminar;
    @FXML
    private TextField txtArchivo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
    	Trie trie = new Trie();
        String salida=trie.print();
        textArea.appendText(salida);
        
    }    

    public Trie getTrie() {
        return trie;
    }

    public void setTrie(Trie trie) {
        this.trie = trie;
    }

    @FXML
    private void ClickBuscar(MouseEvent event) {
       
//        boolean encontrado=false;
//        List<String> lista = trie.listWords();
//        for (String s : lista) {
//            if (txtBuscar.getText().equals(s)) {
//                encontrado=true;
//                break;
//            }
//                
//        }
        if(trie.contains(txtBuscar.getText())){
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "SE HA ENCONTRADO EXITOSAMENTE LA PALABRA INGRESADA");
            alerta.show();
        }
        else{
            Alert alerta = new Alert(Alert.AlertType.ERROR, "NO SE ENCONTRÓ LA PALABRA INGRESADA");
            alerta.show();
        }
        

    }

    @FXML
    private void ClickInsertar(MouseEvent event) {

        try {
            String dato = txtInsertar.getText();
            if (Validar.validarDato(txtInsertar)) {
                if (textArea.getText().isEmpty()) {
                    trie.insert(dato);
                    textArea.appendText(dato);
                    txtInsertar.clear();
                } else if((!textArea.getText().isEmpty())){
                    trie.insert(dato);
                    String salida = trie.print();
                    textArea.clear();
                    textArea.appendText(salida);
                    txtInsertar.clear();
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
        // Obtener la palabra a eliminar
        String palabraEliminar = txtEliminar.getText();

        // Verificar si la palabra está en el Trie
        if (trie.contains(palabraEliminar)) {
            trie.delete(palabraEliminar);
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Palabra eliminada exitosamente");
            alerta.show();
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "La palabra no existe en el diccionario");
            alerta.show();
        }
    
    }

    @FXML
    private void ClickCargar(MouseEvent event) {
        String nomfile = Archivos.cargarArchivo();
        System.out.println(nomfile);
        ArrayList<String> lista = Archivos.leerTrie(App.pathFile+nomfile);

        Trie t = new Trie();
        for (String s : lista) {
            t.insert(s);
        }
        String salida = t.print();
        if (textArea.getText().isEmpty()) {
            textArea.appendText(salida);
        } 
        textArea.clear();
        textArea.appendText(salida);
        

    }

    @FXML
    private void ClickGuardar(MouseEvent event) {
       String nomfile=txtArchivo.getText();
       List<String> lista=trie.listWords();
       if(!lista.isEmpty()){
           Archivos.escribirTrie(lista, nomfile+".txt");
           Alert a =new Alert(Alert.AlertType.CONFIRMATION,"Datos guardados exitosamente");
           a.show();
       }else{
           Alert a =new Alert(Alert.AlertType.ERROR,"El archivo esta vacio");
           a.show();
       }
       
            
        
        
        
    }
    
    
   

    
}
