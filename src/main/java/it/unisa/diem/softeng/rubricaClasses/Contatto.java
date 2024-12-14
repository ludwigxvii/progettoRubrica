package main.java.it.unisa.diem.softeng.rubricaClasses;

import java.io.Serializable;




/**
 * @brief Questa è la Classe che definisce i contatti che saranno aggiunti alla Rubrica, con 1-3 Numeri di telefono ed 1-3 E-Mail
 * @author Guido
 */
public class Contatto implements Comparable<Contatto>,Serializable {
    private String nome;
    private String cognome;
    private String telefono1;
    private String telefono2;
    private String telefono3;// Fino a 3 numeri di telefono
    private String email1;   // Fino a 3 email
    private String email2;
    private String email3;

/**
 * @brief Costruttore del Contatto
 * @param nome
 * @param cognome
 * @param telefono1
 * @param telefono2
 * @param telefono3
 * @param email1
 * @param email2
 * @param email3 
 */
    public Contatto(String nome, String cognome, String telefono1, String telefono2, String telefono3, String email1, String email2, String email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
    }

/**
 * @brief Questo metdodo è utilizzato per modificare i campi di un contatto senza eliminarlo
 * @param nome
 * @param cognome
 * @param telefono1
 * @param telefono2
 * @param telefono3
 * @param email1
 * @param email2
 * @param email3 
 */
    public void modificaContatto(String nome, String cognome, String telefono1, String telefono2, String telefono3,
            String email1,String email2,String email3){
        if (nome != null) this.nome = nome;
        if (cognome != null) this.cognome = cognome;
        if (telefono1 != null) this.telefono1 = telefono1;
        if (telefono2 != null) this.telefono2 = telefono2;
        if (telefono3 != null) this.telefono3 = telefono3;
        if (email1 != null) this.email1 = email1;
        if (email2 != null) this.email2 = email2;
        if (email3 != null) this.email3 = email3;
    }
/**
 * @brief Stampa a schermo un contatto
 * @return 
 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(" ").append(cognome);
        sb.append(", Telefono: ");
        sb.append(telefono1).append(", ");
        sb.append(telefono2).append(", ");
        sb.append(telefono3).append("");
        sb.append(", E-mail: ");
        sb.append(email1).append(", ");
        sb.append(email2).append(", ");
        sb.append(email3).append(";");
        return sb.toString().trim();
    }
/**
     * @brief Confronta il contatto corrente con un altro per ordine alfabetico
     * @param altro L'altro contatto da confrontare
     * @return Un valore negativo, zero, o positivo se il contatto corrente precede, è uguale, o segue l'altro
     */
    @Override
    public int compareTo(Contatto altro) {
        int confrontoCognome = this.cognome.compareTo(altro.cognome);
        if (confrontoCognome != 0) {
            return confrontoCognome;
        }
        return this.nome.compareTo(altro.nome);
    }
 /**
     * @brief Restituisce il nome del contatto
     * @return Nome del contatto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @brief Imposta il nome del contatto
     * @param nome Nome da impostare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Restituisce il cognome del contatto
     * @return Cognome del contatto
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Imposta il cognome del contatto
     * @param cognome Cognome da impostare
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @brief Restituisce il primo numero di telefono
     * @return Primo numero di telefono
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * @brief Imposta il primo numero di telefono
     * @param telefono Primo numero di telefono da impostare
     */
    public void setTelefono1(String telefono) {
        this.telefono1 = telefono;
    }

    /**
     * @brief Restituisce il secondo numero di telefono
     * @return Secondo numero di telefono
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * @brief Imposta il secondo numero di telefono
     * @param telefono Secondo numero di telefono da impostare
     */
    public void setTelefono2(String telefono) {
        this.telefono2 = telefono;
    }

    /**
     * @brief Restituisce il terzo numero di telefono
     * @return Terzo numero di telefono
     */
    public String getTelefono3() {
        return telefono3;
    }

    /**
     * @brief Imposta il terzo numero di telefono
     * @param telefono Terzo numero di telefono da impostare
     */
    public void setTelefono3(String telefono) {
        this.telefono3 = telefono;
    }

    /**
     * @brief Restituisce la prima email del contatto
     * @return Prima email
     */
    public String getEmail1() {
        return email1;
    }

    /**
     * @brief Imposta la prima email del contatto
     * @param email Prima email da impostare
     */
    public void setEmail1(String email) {
        this.email1 = email;
    }

    /**
     * @brief Restituisce la seconda email del contatto
     * @return Seconda email
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * @brief Imposta la seconda email del contatto
     * @param email Seconda email da impostare
     */
    public void setEmail2(String email) {
        this.email2 = email;
    }

    /**
     * @brief Restituisce la terza email del contatto
     * @return Terza email
     */
    public String getEmail3() {
        return email3;
    }

    /**
     * @brief Imposta la terza email del contatto
     * @param email Terza email da impostare
     */
    public void setEmail3(String email) {
        this.email3 = email;
    }
}
    