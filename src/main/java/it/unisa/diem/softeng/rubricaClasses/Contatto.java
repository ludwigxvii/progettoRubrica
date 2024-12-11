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
public class Contatto implements Comparable<Contatto> {
    private String nome;
    private String cognome;
    private String telefono;
    private String telefono2;
    private String telefono3;
    private String email;
    private String email2;
    private String email3;


    public Contatto(String nome, String cognome, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }


    public void modificaContatto(String nome, String cognome, String telefono, String email) {
        if (nome != null) this.nome = nome;
        if (cognome != null) this.cognome = cognome;
        if (telefono != null) this.telefono = telefono;
        if (telefono2 != null) this.telefono2 = telefono2;
        if (telefono3 != null) this.telefono3 = telefono3;
        if (email != null) this.email = email;
        if (email2 != null) this.email2 = email2;
        if (email3 != null) this.email3 = email3;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ", Tel: " + telefono + ", Tel2: " + telefono2 + ", Tel3: " + telefono3 + ", Email: " + email + ", Email2: " + email2 + ", Email3: " + email3;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    
    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail2() {
        return email;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }
}
