/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class Dictionary {
    private static final String filePath="dictionary";

    public static List<String> readDictionary() {
        List<String> words = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return words;
    }

    public static void writeDictionary(List<String> words) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
