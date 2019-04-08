/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.FileNotFoundException;

/**
 *
 * @author josea
 */
public class SalidaFichero extends FileNotFoundException{

    public SalidaFichero() {
    }

    public SalidaFichero(String mensaje){
        super(mensaje);
    }
        
}