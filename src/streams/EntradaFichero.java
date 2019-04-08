/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 *
 * @author josea
 */
public class EntradaFichero extends FileNotFoundException{
    
    public FileWriter error;
    

    public EntradaFichero() {
    }

    public EntradaFichero(String mensaje) {
        super(mensaje);
    }

    public static String errorEntrada(){
        
    }

}