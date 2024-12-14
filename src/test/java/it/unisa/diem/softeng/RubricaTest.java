
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class RubricaTest {
    @Test
    public void testAggiungiContatto() {
        Rubrica rubrica = new Rubrica();
        assertTrue(rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", ""));
        // Tentativo di aggiungere un contatto duplicato
        assertFalse(rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", ""));
    }
    @Test
    public void testRicercaContatto_schermata() {
        Rubrica rubrica = new Rubrica();
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        Rubrica rubrica_esiti  = rubrica.ricercaContatto_schermata("Mario", "Rossi");
        assertNotNull(rubrica_esiti);
        assertFalse(rubrica_esiti.contatti.isEmpty());
        assertTrue(rubrica_esiti.contatti.contains(contatto));
        
        // Contatto inesistente
        assertNull(rubrica.ricercaContatto("Luigi", "Bianchi"));
    }
    @Test
    public void testRicercaContatto() {
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        Contatto contatto = rubrica.ricercaContatto("Mario", "Rossi");
        assertNotNull(contatto);
        assertEquals("Mario", contatto.getNome());
        assertEquals("Rossi", contatto.getCognome());
        // Contatto inesistente
        assertNull(rubrica.ricercaContatto("Luigi", "Bianchi"));
    }
    @Test
    public void testModificaContatto() {
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        assertTrue(rubrica.modificaContatto("Mario", "Rossi", "Mario", "Bianchi", "987654321", "555555555", "","mario.rossi2@example.com", "", ""));
        // Verifica se il contatto è stato modificato
        Contatto contatto = rubrica.ricercaContatto("Mario", "Bianchi");
        assertNotNull(contatto);
        assertEquals("987654321", contatto.getTelefono1());
        assertEquals("555555555", contatto.getTelefono2());
        assertEquals("", contatto.getTelefono3());
        assertEquals("mario.rossi2@example.com", contatto.getEmail1());
        assertEquals("", contatto.getEmail2());
        assertEquals("", contatto.getEmail3());
        // Tentativo di modifica di un contatto inesistente
        assertFalse(rubrica.modificaContatto("Luigi", "Bianchi", "Luigi", "Verdi",
                 "987654321", "555555555", "","mario.rossi2@example.com", "", ""));
    }
    @Test
    public void testEliminaContatto() {
    Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        // Elimina contatto esistente
        assertTrue(rubrica.eliminaContatto("Mario", "Rossi"));
        // Verifica che il contatto sia stato eliminato
        assertNull(rubrica.ricercaContatto("Mario", "Rossi"));
        // Tentativo di eliminare un contatto inesistente
        assertFalse(rubrica.eliminaContatto("Luigi", "Bianchi"));
    }
    @Test
    public void testVisualizzaContatti() {
        Rubrica rubrica = new Rubrica();
        // Rubrica vuota
        rubrica.visualizzaContatti();
        // Aggiungi contatti
        rubrica.aggiungiContatto("Mario", "Rossi", "123456789", "", "","mario.rossi@example.com", "", "");
        rubrica.aggiungiContatto("Luigi", "Bianchi", "987654321", "", "", "luigi.bianchi@example.com", "", "");
        // Visualizza contatti
        rubrica.visualizzaContatti();
    }
}