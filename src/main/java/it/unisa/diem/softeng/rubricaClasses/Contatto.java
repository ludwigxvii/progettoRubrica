package main.java.it.unisa.diem.softeng.rubricaClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utente
 */
import java.util.TreeSet;


public class Contatto implements Comparable<Contatto> {
    private String nome;
    private String cognome;
    private String[] telefoni; // Fino a 3 numeri di telefono
    private String[] email;   // Fino a 3 email


    public Contatto(String nome, String cognome, String[] telefoni, String[] email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefoni = telefoni;
        this.email = email;
    }


    public void modificaContatto(String nome, String cognome, String[] telefoni, String[] email) {
        if (nome != null) this.nome = nome;
        if (cognome != null) this.cognome = cognome;
        if (telefoni != null) this.telefoni = telefoni;
        if (email != null) this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(" ").append(cognome);
        sb.append(", Telefono: ");
        for (String t : telefoni) {
            if (t != null) sb.append(t).append(" ");
        }
        sb.append(", Email: ");
        for (String e : email) {
            if (e != null) sb.append(e).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public int compareTo(Contatto altro) {
        int confrontoCognome = this.cognome.compareTo(altro.cognome);
        if (confrontoCognome != 0) {
            return confrontoCognome;
        }
        return this.nome.compareTo(altro.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String[] getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(String[] telefoni) {
        this.telefoni = telefoni;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
}
