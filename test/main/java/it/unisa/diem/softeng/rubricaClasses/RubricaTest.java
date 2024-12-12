/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RubricaTest {

    @Test
    public void testAggiungiContatto() {
        Rubrica rubrica = new Rubrica();

        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        assertTrue(rubrica.aggiungiContatto("Mario", "Rossi", telefoni, email));

        // Tentativo di aggiungere un contatto duplicato
        assertFalse(rubrica.aggiungiContatto("Mario", "Rossi", telefoni, email));
    }

    @Test
    public void testRicercaContatto() {
        Rubrica rubrica = new Rubrica();

        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        rubrica.aggiungiContatto("Mario", "Rossi", telefoni, email);

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

        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        rubrica.aggiungiContatto("Mario", "Rossi", telefoni, email);

        String[] nuoviTelefoni = {"987654321", "555555555", ""};
        String[] nuoveEmail = {"mario.rossi2@example.com", "", ""};
        assertTrue(rubrica.modificaContatto("Mario", "Rossi", "Mario", "Bianchi", nuoviTelefoni, nuoveEmail));

        // Verifica se il contatto è stato modificato
        Contatto contatto = rubrica.ricercaContatto("Mario", "Bianchi");
        assertNotNull(contatto);
        assertArrayEquals(nuoviTelefoni, contatto.getTelefoni());
        assertArrayEquals(nuoveEmail, contatto.getEmail());

        // Tentativo di modifica di un contatto inesistente
        assertFalse(rubrica.modificaContatto("Luigi", "Bianchi", "Luigi", "Verdi", nuoviTelefoni, nuoveEmail));
    }

    @Test
    public void testEliminaContatto() {
        Rubrica rubrica = new Rubrica();

        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        rubrica.aggiungiContatto("Mario", "Rossi", telefoni, email);

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
        String[] telefoni1 = {"123456789", "", ""};
        String[] email1 = {"mario.rossi@example.com", "", ""};
        String[] telefoni2 = {"987654321", "", ""};
        String[] email2 = {"luigi.bianchi@example.com", "", ""};
        rubrica.aggiungiContatto("Mario", "Rossi", telefoni1, email1);
        rubrica.aggiungiContatto("Luigi", "Bianchi", telefoni2, email2);

        // Visualizza contatti
        rubrica.visualizzaContatti();
    }
}
