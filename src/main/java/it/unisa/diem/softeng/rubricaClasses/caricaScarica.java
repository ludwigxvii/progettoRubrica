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
        objo.writeInt(rubrica.contatti.size());
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
    Contatto temp = null;
    int lunghezza = (int)objin.readInt();
    for(int i=0;i<lunghezza;i++){
            temp = (Contatto) objin.readObject();
            rubrica.aggiungiContatto(temp.getNome(),temp.getCognome(), temp.getTelefono1(),
                    temp.getTelefono2(), temp.getTelefono3(), temp.getEmail1(),
                    temp.getEmail2(), temp.getEmail3());
            }
            objin.close();
    }
}
