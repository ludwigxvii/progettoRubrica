/**
 *@brief Questo Package comprende tutte le classi non FXML che implementano i metodi usati dall'Applicazione.
 *@author Ludwig,Guido,Nicola
 * @version 2.0
 * 
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *@brief Questa classe implementa tramite ObjectOutputStream la serializzazione dello stato attuale della rubrica, importando
 * tramite caricaDaFile uno stato scritto su dile dat, o salvando lo stato attuale su file tramite salvaSuFile.
 *@author Ludwig
 * @version 2.0
 * 
 */
public class caricaScarica {
/**
 * @brief Questo metodo salva lo stato attuale della Rubrica fornita come parametro nel file il cui nome è fornito come secondo parametro String.
 * @param rubrica Istanza della classe Rubrica usata dall'Applicazione in esecuzione.
 * @param filename Nome del File di salvataggio.
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public static void salvaSuFile(Rubrica rubrica, String filename) throws FileNotFoundException, IOException {
        FileOutputStream outp;
        outp = new FileOutputStream(filename);
        ObjectOutputStream objo;
        objo = new ObjectOutputStream(outp);
        objo.writeInt(rubrica.contatti.size());
        for (Contatto contatto : rubrica.contatti) {
            objo.writeObject(contatto);
        }
        objo.close();
    }
/**
 * @brief Questo Metodo carica uno stato della rubrica presente su un file dat precedentemente generato e lo deserializza
 * @param rubrica Istanza della classe Rubrica usata dall'Applicazione in esecuzione.
 * @param filename Nome del File da caricare.
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ClassNotFoundException 
 */
    public static void caricaDaFile(Rubrica rubrica, String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream inpt;
        inpt = new FileInputStream(filename);
        ObjectInputStream objin;
        objin = new ObjectInputStream(inpt);
        Contatto temp = null;
        int lunghezza = (int) objin.readInt();
        for (int i = 0; i < lunghezza; i++) {
            temp = (Contatto) objin.readObject();
            rubrica.aggiungiContatto(temp.getNome(), temp.getCognome(), temp.getTelefono1(), temp.getTelefono2(), temp.getTelefono3(), temp.getEmail1(), temp.getEmail2(), temp.getEmail3());
        }
        objin.close();
    }
}
