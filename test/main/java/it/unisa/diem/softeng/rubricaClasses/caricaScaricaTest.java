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
        String[] telefoni1 = {"123456789", "", ""};
        String[] email1 = {"mario.rossi@example.com", "", ""};
        rubricaOriginale.aggiungiContatto("Mario", "Rossi", telefoni1, email1);

        String[] telefoni2 = {"987654321", "", ""};
        String[] email2 = {"luigi.bianchi@example.com", "", ""};
        rubricaOriginale.aggiungiContatto("Luigi", "Bianchi", telefoni2, email2);

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

    @Test
    public void testCaricaDaFileVuoto() {
        Rubrica rubrica = new Rubrica();
        String filename = "fileVuoto.dat";

        try {
            // Crea un file vuoto
            new FileOutputStream(filename).close();

            // Carica dalla rubrica vuota
            caricaScarica.caricaDaFile(rubrica, filename);

            // Verifica che la rubrica sia ancora vuota
            assertTrue(rubrica.contatti.isEmpty());
        } catch (IOException | ClassNotFoundException e) {
            fail("Errore durante il test con file vuoto: " + e.getMessage());
        } finally {
            // Pulizia: elimina il file vuoto
            File file = new File(filename);
            if (file.exists()) {
                assertTrue(file.delete(), "Impossibile eliminare il file vuoto di test.");
            }
        }
    }
}


