package main.java.it.unisa.diem.softeng.rubricaClasses;



import main.java.it.unisa.diem.softeng.rubricaClasses.Contatto;
import java.util.TreeSet;



/**
 * @brief Questa Classe contiene l'implementazione della classe Rubrica e delle funzioni aggiungiContatto, ricercaContatto, modificaContatto, eliminaContatto e visualizzaContatti, che nello specifico implementa la funzione di visita della rubrica. Per ulteriori dettagli riguardante il ruolo delle funzioni consultare la documentazione all'interno del progetto.
 * @author Guido
 */
public class Rubrica {
    public TreeSet<Contatto> contatti;


    public Rubrica() {
        this.contatti = new TreeSet<>();
    }
/**
 * @brief Aggiunge un contatto alla Rubrica restituendo un esito positivo o negativo.
 * @param nome Nome Del Contatto
 * @param cognome Cognome del Contatto
 * @param telefono1 Numero di telefono 1
 * @param telefono2 Numero di Telefono 2
 * @param telefono3 Numero di Telefono 2
 * @param email1 
 * @param email2
 * @param email3
 * @return True se l'aggiunta è riuscita, False se è fallita
 */
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

/**
 * 
 * @param nome
 * @param cognome
 * @return 
 */
    public Contatto ricercaContatto(String nome, String cognome) {
        for (Contatto contatto : contatti) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return contatto;
            }
        }
        return null;
    }

/**
 * 
 * @param nome
 * @param cognome
 * @param nuovoNome
 * @param nuovoCognome
 * @param nuoviTelefono1
 * @param nuoviTelefono2
 * @param nuoviTelefono3
 * @param nuovaEmail1
 * @param nuovaEmail2
 * @param nuovaEmail3
 * @return 
 */
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

/**
 * 
 * @param nome
 * @param cognome
 * @return 
 */
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
/**
 * @brief Questo è um metodo usato per convertire la rubrica in una versione leggibile in modo corretto dalla Tabella dell'Applicazione
 * @return Rubrica che verrà letta dalla tabella
 */
            public Rubrica tableConverter(){
                Rubrica new_rubrica = new Rubrica();
                for(Contatto cont : contatti){
                    String nuovamail=cont.getEmail1()+"\n"+cont.getEmail2()+"\n"+cont.getEmail3();
                    String nuovitel=cont.getTelefono1()+"\n"+cont.getTelefono2()+"\n"+cont.getTelefono3();
                    new_rubrica.aggiungiContatto(cont.getNome(),cont.getCognome(), nuovitel,"","", nuovamail,"","");
                }

                    return new_rubrica;
            }
            /**
             * @brief Stampa a schermo i Contatti
             */
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