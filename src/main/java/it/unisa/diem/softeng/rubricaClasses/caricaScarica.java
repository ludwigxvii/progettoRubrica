/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludwi
 */
public class caricaScarica {
    
    
    public static void salvaSuFile(Rubrica rubrica,String filename) throws FileNotFoundException, IOException{
    FileOutputStream outp;
            outp = new FileOutputStream(filename);
            ObjectOutputStream objo;
            objo = new ObjectOutputStream(outp);
        
            for(Contatto contatto : rubrica.contatti){
            objo.writeObject(contatto);
            }
            objo.close();
    }
    public static void caricaDaFile(Rubrica rubrica, String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
    
    FileInputStream inpt;
    inpt = new FileInputStream(filename);
    ObjectInputStream objin;
    objin = new ObjectInputStream(inpt);
    while(objin.available()!=0){
            rubrica.contatti.add((Contatto)objin.readObject());
            }
            objin.close();
    }
}
