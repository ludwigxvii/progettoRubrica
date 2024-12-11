package main.java.it.unisa.diem.softeng.rubricaClasses;

/*
@brief Questo file contiene l'implementazione della classe Rubrica e delle funzioni aggiungiContatto, ricercaContatto, modificaContatto, eliminaContatto e visualizzaContatti, che nello specifico implementa
la funzione di visita della rubrica. Per ulteriori dettagli riguardante il ruolo delle funzioni consultare la documentazione all'interno del progetto.
 */

/**
 *
 * @author Guido
 */
import main.java.it.unisa.diem.softeng.rubricaClasses.Contatto;
import java.util.TreeSet;


public class Rubrica {
    private TreeSet<Contatto> contatti;


    public Rubrica() {
        this.contatti = new TreeSet<>();
    }

    public void aggiungiContatto(String nome, String cognome, String[] telefoni, String[] email) {
        Contatto nuovoContatto = new Contatto(nome, cognome, telefoni, email);
        if (contatti.add(nuovoContatto)) {
            System.out.println("Contatto aggiunto: " + nuovoContatto);
        } else {
            System.out.println("Il contatto esiste già: " + nuovoContatto);
        }
    }


    public Contatto ricercaContatto(String nome, String cognome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto;
            }
        }
        return null;
    }


    public void modificaContatto(String nome, String cognome, String nuovoNome, String nuovoCognome, String[] nuoviTelefoni, String[] nuoveEmail) {
        Contatto contatto = ricercaContatto(nome, cognome);
        if (contatto != null) {
            contatti.remove(contatto);
            contatto.modificaContatto(nuovoNome, nuovoCognome, nuoviTelefoni, nuoveEmail);
            contatti.add(contatto);
            System.out.println("Contatto modificato: " + contatto);
        } else {
            System.out.println("Contatto non trovato.");
        }
    }


    public void eliminaContatto(String nome, String cognome) {
        Contatto contatto = ricercaContatto(nome, cognome);
        if (contatto != null) {
            contatti.remove(contatto);
            System.out.println("Contatto eliminato: " + contatto);
        } else {
            System.out.println("Contatto non trovato.");
        }
    }


    public void visualizzaContatti() {
        if (!contatti.isEmpty()) {
            System.out.println("Contatti nella rubrica:");
            for (Contatto contatto : contatti) {
                System.out.println(contatto);
            }
        } else {
            System.out.println("La rubrica è vuota.");
        }
    }
}
