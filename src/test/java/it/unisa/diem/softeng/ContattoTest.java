/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.it.unisa.diem.softeng.rubricaClasses;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ContattoTest {

    @Test
    public void testCostruttore() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        assertEquals("Mario", contatto.getNome());
        assertEquals("Rossi", contatto.getCognome());
        assertEquals("123456789", contatto.getTelefono1());
        assertEquals("mario.rossi@example.com", contatto.getEmail1());
        assertEquals("",contatto.getTelefono2());
        assertEquals("",contatto.getTelefono3());
        assertEquals("",contatto.getEmail2());
        assertEquals("",contatto.getEmail3());
        
    }

    @Test
    public void testSetterAndGetter() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");

        contatto.setTelefono2("111222333");
        contatto.setTelefono3("444555666");
        contatto.setEmail2("mario.rossi2@example.com");
        contatto.setEmail3("mario.rossi3@example.com");

        assertEquals("111222333", contatto.getTelefono2());
        assertEquals("444555666", contatto.getTelefono3());
        assertEquals("mario.rossi2@example.com", contatto.getEmail2());
        assertEquals("mario.rossi3@example.com", contatto.getEmail3());
    }

    @Test
    public void testToString() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        contatto.setTelefono2("111222333");
        contatto.setTelefono3("444555666");
        contatto.setEmail2("mario.rossi2@example.com");
        contatto.setEmail3("mario.rossi3@example.com");

        String expected = "Mario Rossi, Telefono: 123456789, 111222333, 444555666, E-mail: mario.rossi@example.com, mario.rossi2@example.com, mario.rossi3@example.com;";
        assertEquals(expected, contatto.toString());
    }

    @Test
    public void testCompareTo() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario.rossi@example.com", "", "");
        Contatto contatto2 = new Contatto("Luigi", "Bianchi", "987654321", "", "", "luigi.bianchi@example.com", "", "");
        Contatto contatto3 = new Contatto("Anna", "Rossi", "555555555", "", "", "anna.rossi@example.com", "", "");

        assertTrue(contatto.compareTo(contatto2) > 0); // Rossi > Bianchi
        assertTrue(contatto2.compareTo(contatto) < 0); // Bianchi < Rossi
        assertTrue(contatto.compareTo(contatto3) > 0); // Mario > Anna
    }
}