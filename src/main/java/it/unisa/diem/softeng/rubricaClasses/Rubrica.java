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
    public TreeSet<Contatto> contatti;


    public Rubrica() {
        this.contatti = new TreeSet<>();
    }

    public boolean aggiungiContatto(String nome, String cognome, String telefono1, String telefono2, String telefono3,
            String email1,String email2,String email3) {
        Contatto nuovoContatto = new Contatto(nome, cognome, telefono1, telefono2, telefono3, email1, email2, email3);
        if (contatti.add(nuovoContatto)) {
            System.out.println("Contatto aggiunto: " + nuovoContatto);
            return true;
        } else {
            System.out.println("Il contatto esiste già: " + nuovoContatto);
            return false;
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


    public boolean modificaContatto(String nome, String cognome, String nuovoNome, String nuovoCognome, String nuoviTelefono1,
            String nuoviTelefono2,  String nuoviTelefono3, String nuovaEmail1, String nuovaEmail2, String nuovaEmail3) {
        Contatto contatto = ricercaContatto(nome, cognome);
        if (contatto != null) {
            contatti.remove(contatto);
            contatto.modificaContatto(nuovoNome, nuovoCognome, nuoviTelefono1,nuoviTelefono2,nuoviTelefono3, nuovaEmail1, nuovaEmail2, nuovaEmail3);
            contatti.add(contatto);
            System.out.println("Contatto modificato: " + contatto);
            return true;
        } else {
            System.out.println("Contatto non trovato.");
            return false;
        }
    }


    public boolean eliminaContatto(String nome, String cognome) {
        Contatto contatto = ricercaContatto(nome, cognome);
        if (contatto != null) {
            contatti.remove(contatto);
            System.out.println("Contatto eliminato: " + contatto);
            return true;
        } else {
            System.out.println("Contatto non trovato.");
            return false;
        }
    }

            public Rubrica tableConverter(){
                Rubrica new_rubrica = new Rubrica();
                for(Contatto cont : contatti){
                    String nuovamail=cont.getEmail1()+"\n"+cont.getEmail2()+"\n"+cont.getEmail3();
                    String nuovitel=cont.getTelefono1()+"\n"+cont.getTelefono2()+"\n"+cont.getTelefono3();
                    new_rubrica.aggiungiContatto(cont.getNome(),cont.getCognome(), nuovitel,"","", nuovamail,"","");
                }

                    return new_rubrica;
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
