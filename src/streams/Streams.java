/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Streams {
    public static void byte_a_byte(String inFile, String outFile){
           int intCharacter;
           FileInputStream fileInput = null;
           FileOutputStream fileOutput = null;
           try {
               fileInput = new FileInputStream(inFile);
               fileOutput = new FileOutputStream(outFile);
               int peliculaPosition = 0;
               int campoPosicion = 0;
               String campoValor = "";
               boolean finalizar=false;
               //0 = título
               //1 = Año
               //2 = Director etc
               do{
                   intCharacter = fileInput.read();

                   if (intCharacter != -1){
                    char charActual = (char)intCharacter;
                    finalizar=true;
                    switch (charActual){
                        case '#':
                            switch (campoPosicion){
                                case 0:
                                    fileOutput.write(
                                 ("------------------------------- \r\n"
                                         +"\r\n"
                                         + "Cartelera FB Moll \r\n"
                                         +"\r\n"
                                + "------------------------------- \r\n").getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    fileOutput.write(("-----" + campoValor + 
                                            "-----").getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                case 1:
                                    fileOutput.write(("Año: " + 
                                            campoValor).getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                case 2: 
                                    fileOutput.write(("Director: " + 
                                            campoValor).getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                case 3: 
                                    fileOutput.write(("Duración: " + campoValor 
                                            + " minutos").getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                case 4:
                                    fileOutput.write(("Sinopsis: " 
                                            + campoValor).getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                case 5:
                                    fileOutput.write(("Reparto: " 
                                            + campoValor).getBytes());
                                    fileOutput.write("\r\n".getBytes());
                                    break;
                                
                            }                      
                            campoPosicion++;
                            fileOutput.write("\r\n".getBytes());
                            campoValor = "";
                            break;
                        case '{':
                             fileOutput.write(("Sesión: " 
                                            + campoValor + " horas").getBytes());
                             fileOutput.write("\r\n".getBytes());
                            peliculaPosition++;
                            campoPosicion = 0;
                            fileOutput.write("\r\n".getBytes());
                            campoValor = "";
                            break;
                        default:
                            campoValor = campoValor + charActual;
                    }
                   }
               } while (intCharacter != -1);
               if (finalizar){
                fileOutput.write(("Sesión: " + campoValor + " horas").getBytes());
                fileOutput.write("\r\n".getBytes());
                fileOutput.write("------------------------".getBytes());
                        }
               
               
           } catch(IOException io){
               System.out.println("Error abriendo el fichero");
           } finally {
               try {
                  if (fileInput != null){
                      fileInput.close();
                  }
                  if (fileOutput != null){
                      fileOutput.close();
                  }
               } catch(IOException io){
                   System.out.println("Error cerrando fichero");
               }
           }
           
    }
    public static void caracter_a_caracter(String inFile, String outFile){ 
        int intCharacter;
           FileReader fileInput = null;
           FileWriter fileOutput = null;
           try {
               fileInput = new FileReader(inFile);
               fileOutput = new FileWriter(outFile);
               int peliculaPosition = 0;
               int campoPosicion = 0;
               String campoValor = "";
               boolean finalizar=false;
               //0 = título
               //1 = Año
               //2 = Director etc
               do{
                   intCharacter = fileInput.read();

                   if (intCharacter != -1){
                    char charActual = (char)intCharacter;
                    finalizar=true;
                    switch (charActual){
                        case '#':
                            switch (campoPosicion){
                                case 0:
                                    fileOutput.write(
                                 ("------------------------------- \r\n"
                                         +"\r\n"
                                         + "Cartelera FB Moll \r\n"
                                         +"\r\n"
                                + "------------------------------- \r\n"));
                                    fileOutput.write("\r\n");
                                    fileOutput.write("-----" + campoValor + 
                                            "-----");
                                    fileOutput.write("\r\n");
                                    break;
                                case 1:
                                    fileOutput.write("Año: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 2: 
                                    fileOutput.write("Director: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 3: 
                                    fileOutput.write("Duración: " + campoValor 
                                            + " minutos");
                                    fileOutput.write("\r\n");
                                    break;
                                case 4:
                                    fileOutput.write("Sinopsis: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 5:
                                    fileOutput.write("Reparto: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                
                            }                      
                            campoPosicion++;
                            fileOutput.write("\r\n");
                            campoValor = "";
                            break;
                        case '{':
                             fileOutput.write("Sesión: " + campoValor + " horas");
                             fileOutput.write("\r\n");
                            peliculaPosition++;
                            campoPosicion = 0;
                            fileOutput.write("\r\n");
                            campoValor = "";
                            break;
                        default:
                            campoValor = campoValor + charActual;
                    }
                   }
               } while (intCharacter != -1);
               if (finalizar){
                fileOutput.write(("Sesión: " + campoValor + " horas"));
                fileOutput.write("\r\n");
                fileOutput.write("------------------------");
                        }
               
               
           } catch(IOException io){
               System.out.println("Error abriendo el fichero");
           } finally {
               try {
                  if (fileInput != null){
                      fileInput.close();
                  }
                  if (fileOutput != null){
                      fileOutput.close();
                  }
               } catch(IOException io){
                   System.out.println("Error cerrando fichero");
               }
           }
    }
    public static void linea_a_linea_buffered(String inFile, String outFile){
        int intCharacter;
           BufferedReader fileInput = null;
           BufferedWriter fileOutput = null;
           
           try {
               fileInput = new BufferedReader(new FileReader(inFile));
               fileOutput = new BufferedWriter(new FileWriter(outFile));
               int peliculaPosition = 0;
               int campoPosicion = 0;
               String campoValor = "";
               boolean finalizar=false;
               //0 = título
               //1 = Año
               //2 = Director etc
               do{
                   intCharacter = fileInput.read();

                   if (intCharacter != -1){
                    char charActual = (char)intCharacter;
                    finalizar=true;
                    switch (charActual){
                        case '#':
                            switch (campoPosicion){
                                case 0:
                                    fileOutput.write(
                                 ("------------------------------- \r\n"
                                         +"\r\n"
                                         + "Cartelera FB Moll \r\n"
                                         +"\r\n"
                                + "------------------------------- \r\n"));
                                    fileOutput.write("\r\n");
                                    fileOutput.write("-----" + campoValor + 
                                            "-----");
                                    fileOutput.write("\r\n");
                                    break;
                                case 1:
                                    fileOutput.write("Año: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 2: 
                                    fileOutput.write("Director: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 3: 
                                    fileOutput.write("Duración: " + campoValor 
                                            + " minutos");
                                    fileOutput.write("\r\n");
                                    break;
                                case 4:
                                    fileOutput.write("Sinopsis: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                case 5:
                                    fileOutput.write("Reparto: " + campoValor);
                                    fileOutput.write("\r\n");
                                    break;
                                
                            }                      
                            campoPosicion++;
                            fileOutput.write("\r\n");
                            campoValor = "";
                            break;
                        case '{':
                             fileOutput.write("Sesión: " + campoValor + " horas");
                             fileOutput.write("\r\n");
                            peliculaPosition++;
                            campoPosicion = 0;
                            fileOutput.write("\r\n");
                            campoValor = "";
                            break;
                        default:
                            campoValor = campoValor + charActual;
                    }
                   }
               } while (intCharacter != -1);
               if (finalizar){
                fileOutput.write(("Sesión: " + campoValor + " horas"));
                fileOutput.write("\r\n");
                fileOutput.write("------------------------");
                        }
               
               
           } catch(IOException io){
               System.out.println("Error abriendo el fichero");
           } finally {
               try {
                  if (fileInput != null){
                      fileInput.close();
                  }
                  if (fileOutput != null){
                      fileOutput.close();
                  }
               } catch(IOException io){
                   System.out.println("Error cerrando fichero");
               }
           }       
    }
    public static void main(String[] args) throws EntradaFichero, SalidaFichero {
        // TODO code application logic here
        //String fileIn = "C:\\files\\cartelera.txt";
        //String fileOut = "C:\\files\\outCartelera.txt";
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir){    
            System.out.println("Escoge una opción");
            System.out.println("1. Leer y escribir byte a byte");
            System.out.println("2. Leer y escribir carácter a carácter");
            System.out.println("3. Leer y escribir línea a línea");
            System.out.println("4. Leer y escribir objetos");
            System.out.println("5. Salir");
            int opcion = sc.nextInt();
            switch(opcion){
                case(1):{
                    System.out.println("Por favor, dime el path del fichero de "
                            + "entrada, por ejemplo "
                            + "(C:\\directorio\\fichero.txt");
                    String fileIn = sc.nextLine();
                    if (fileIn == null){
                        throw new EntradaFichero("El archivo no se ha podido abrir");
                    }
                    System.out.println("Dime ahora el path del fichero donde "
                            + "quieres escribir, por ejemplo "
                            + "C:\\directorio\\fichero.txt");
                    String fileOut = sc.nextLine();
                    while (fileOut == null){
                        throw new SalidaFichero("El archivo de salida no ha "
                                + "sido informado");
                        fileOut = sc.nextLine();
                    }
                     
                    byte_a_byte(fileIn, fileOut);
                    break;
                }
                case(2):{
                    System.out.println("Por favor, dime el path del fichero de "
                            + "entrada");
                    String fileIn = sc.nextLine();
                    caracter_a_caracter(fileIn, fileOut);
                    break;
                }
                case (3):{
                    System.out.println("Por favor, dime el path del fichero de "
                            + "entrada");
                    String fileIn = sc.nextLine();
                    linea_a_linea_buffered(fileIn, fileOut);
                    break;
                }
                case (4):{
                    
                    break;
                }
                case (5):{
                    salir=true;
                    break;
                }
                default: {
                    System.out.println("Escoge una de las opciones indicadas");
                }
            }
        }

    }
    
}
