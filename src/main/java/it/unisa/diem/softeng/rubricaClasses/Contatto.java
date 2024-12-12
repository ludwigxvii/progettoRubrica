package main.java.it.unisa.diem.softeng.rubricaClasses;

import java.io.Serializable;


/**
 *
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

    public String getTelefono1() {
        return telefono1;
    }
    public String getTelefono2() {
        return telefono2;
    }
    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono1(String telefoni) {
        this.telefono1 = telefoni;
    }
    public void setTelefono2(String telefoni) {
        this.telefono2 = telefoni;
    }
    public void setTelefono3(String telefoni) {
        this.telefono3 = telefoni;
    }

    public String getEmail1() {
        return email1;
    }
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
            return email3;
        }
    public void setEmail1(String email) {
        this.email1 = email;
    }
        public void setEmail2(String email) {
        this.email2 = email;
    }
            public void setEmail3(String email) {
        this.email3 = email;
    }
}
