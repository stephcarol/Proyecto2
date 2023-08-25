/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import ec.edu.espol.model.Trie;
import ec.edu.espol.proyecto2.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Archivos {
    
    
    

    
    public static void escribirTrie(List<String> lista, String nomfile)  {
        try(BufferedWriter bf=new BufferedWriter(new FileWriter(App.pathFile+nomfile,true))){
            for(String s: lista){
                bf.write(s);
                bf.newLine();
               
            }
            bf.close();
        } catch (IOException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,"NO SE PUDO GUARDAR EL ARCHIVO");
            alerta.showAndWait();
            System.out.println("No se pudo escribir en el archivo");
        }
    }
    
    
    public static ArrayList<String> leerTrie(String nomfile){
        ArrayList<String> lista=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(nomfile))){
            
            String linea;
            while((linea=bf.readLine())!=null){
                lista.add(linea);
            }
        }
        
        catch(Exception e)
        {
            //Alert alerta = new Alert(Alert.AlertType.ERROR,"NO SE PUDO LEER EL ARCHIVO");
            //alerta.showAndWait();
            System.out.println("No se pudo leer en el archivo");
        }
        return lista;
    }
    
    public static String cargarArchivo() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        
        if (selectedFile != null) {
            if (selectedFile.getName().endsWith(".txt")) {
                try {
                    File destination = new File(App.pathFile + selectedFile.getName());
                    Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Alert a =new Alert(Alert.AlertType.CONFIRMATION,"ARCHIVO CARGADO EXITOSAMENTE");
                    a.show();
                } catch (IOException e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR,"NO SE PUDO CARGAR EL ARCHIVO");
                    alerta.showAndWait();
                    System.out.println("Error al cargar el archivo .txt: " + e.getMessage());
                }
            } else {
                System.out.println("Seleccione un archivo .txt");
            }
        }
        return selectedFile.getName();
    }
    
    
    
    
}
