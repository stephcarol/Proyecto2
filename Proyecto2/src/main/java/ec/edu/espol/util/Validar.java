/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class Validar {
    public static boolean validarDato(TextField sc) throws RegistroException {
        String validName = sc.getText().trim();

        if (validName.matches("^[a-zA-Z]+((['. ][a-zA-Z ])?[a-zA-Z]*)*$") ) {
            validName = sc.getText().trim();
            return true;
        } else {            
            throw new RegistroException("Ingrese dato Valido");
            
        }     
    }   
     
}
