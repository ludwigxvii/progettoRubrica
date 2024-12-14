/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
public class caricaScaricaTest {
    @Test
    public void testSalvaSuFileECaricaDaFile() {
        Rubrica rubricaOriginale = new Rubrica();
        rubricaOriginale.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        rubricaOriginale.aggiungiContatto("Luigi", "Bianchi", "987654321", "", "", "luigi.bianchi@example.com", "", "");
        String filename = "rubricaTest.dat";
        // Salva la rubrica su file
        try {
            caricaScarica.salvaSuFile(rubricaOriginale, filename);
        } catch (IOException e) {
            fail("Errore durante il salvataggio della rubrica: " + e.getMessage());
        }
        // Crea una nuova rubrica e carica i dati dal file
        Rubrica rubricaCaricata = new Rubrica();
        try {
            caricaScarica.caricaDaFile(rubricaCaricata, filename);
        } catch (IOException | ClassNotFoundException e) {
            fail("Errore durante il caricamento della rubrica: " + e.getMessage());
        }
        // Verifica che i contatti siano stati caricati correttamente
        assertEquals(rubricaOriginale.contatti.size(), rubricaCaricata.contatti.size());
        assertTrue(rubricaCaricata.contatti.containsAll(rubricaOriginale.contatti));
        // Pulizia: elimina il file di test
        File file = new File(filename);
        if (file.exists()) {
            assertTrue(file.delete(), "Impossibile eliminare il file di test.");
        }
    }
    @Test
    public void testFileNonTrovato() {
        Rubrica rubrica = new Rubrica();
        String filename = "fileInesistente.dat";
        assertThrows(IOException.class, () -> {
            caricaScarica.caricaDaFile(rubrica, filename);
        });
    
    }
    
}
