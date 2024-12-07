package main.java.it.unisa.diem.softeng.rubricaClasses;


import java.util.Arrays;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ludwi
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String mail[];
    private String tel[];

    public Contatto(String nome, String cognome,String mail1,String mail2,String mail3, String tel1,String tel2,String tel3) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail[0]=mail1;
        this.mail[1]=mail2;
        this.mail[2]=mail3;
        this.tel[0]=tel1;
        this.tel[1]=tel2;
        this.tel[2]=tel3;
        
       
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getMail(int n) {
        return this.mail[n];
    }

    public String getTel(int n) {
        return this.tel[n];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMail(String mail,int n) {
        this.mail[n] = mail;
    }

    public void setTel(String tel,int n) {
        this.tel[n] = tel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Arrays.deepEquals(this.mail, other.mail)) {
            return false;
        }
        return Arrays.deepEquals(this.tel, other.tel);
    }
    
    
}
