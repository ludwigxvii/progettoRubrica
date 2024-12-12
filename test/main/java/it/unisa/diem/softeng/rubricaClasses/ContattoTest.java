/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.it.unisa.diem.softeng.rubricaClasses;
import main.it.unisa.diem.softeng.rubricaClasses.Contatto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContattoTest {

    @Test
    public void testCostruttore() {
        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        Contatto contatto = new Contatto("Mario", "Rossi", telefoni, email);

        assertEquals("Mario", contatto.getNome());
        assertEquals("Rossi", contatto.getCognome());
        assertArrayEquals(telefoni, contatto.getTelefoni());
        assertArrayEquals(email, contatto.getEmail());
    }

    @Test
    public void testSetterAndGetter() {
        String[] telefoni = {"123456789", "", ""};
        String[] email = {"mario.rossi@example.com", "", ""};
        Contatto contatto = new Contatto("Mario", "Rossi", telefoni, email);

        String[] nuoviTelefoni = {"111222333", "444555666", ""};
        String[] nuoveEmail = {"mario.rossi2@example.com", "mario.rossi3@example.com", ""};
        contatto.setTelefoni(nuoviTelefoni);
        contatto.setEmail(nuoveEmail);

        assertArrayEquals(nuoviTelefoni, contatto.getTelefoni());
        assertArrayEquals(nuoveEmail, contatto.getEmail());
    }

    @Test
    public void testToString() {
        String[] telefoni = {"123456789", "987654321", ""};
        String[] email = {"mario.rossi@example.com", "mario.rossi2@example.com", ""};
        Contatto contatto = new Contatto("Mario", "Rossi", telefoni, email);
String expected = "Mario Rossi, Telefono: 123456789, 111222333, 444555666, E-mail: mario.rossi@example.com, mario.rossi2@example.com, mario.rossi3@example.com;";

        String expected = "Mario Rossi, Telefono: 123456789, 111222333, 444555666, E-mail: mario.rossi@example.com, mario.rossi2@example.com, mario.rossi3@example.com;";
        assertEquals(expected, contatto.toString());
    }

    @Test
    public void testCompareTo() {
        String[] telefoni1 = {"123456789", "", ""};
        String[] email1 = {"mario.rossi@example.com", "", ""};
        Contatto contatto1 = new Contatto("Mario", "Rossi", telefoni1, email1);

        String[] telefoni2 = {"987654321", "", ""};
        String[] email2 = {"luigi.bianchi@example.com", "", ""};
        Contatto contatto2 = new Contatto("Luigi", "Bianchi", telefoni2, email2);

        String[] telefoni3 = {"555555555", "", ""};
        String[] email3 = {"anna.rossi@example.com", "", ""};
        Contatto contatto3 = new Contatto("Anna", "Rossi", telefoni3, email3);

        assertTrue(contatto1.compareTo(contatto2) > 0); // Rossi > Bianchi
        assertTrue(contatto2.compareTo(contatto1) < 0); // Bianchi < Rossi
        assertTrue(contatto1.compareTo(contatto3) > 0); // Mario > Anna
        assertEquals(0, contatto1.compareTo(new Contatto("Mario", "Rossi", telefoni1, email1))); // Stesso cognome e nome
    }
}

