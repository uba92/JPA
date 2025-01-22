package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate data_nascita;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sesso sesso;

    private List<Partecipazione> lista_partecipazioni = new ArrayList<>();

    //COSTRUTTORE
    public Persona() {

    }

    public Persona(String nome, String cognome, String email, LocalDate data_nascita, Sesso sesso) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.data_nascita=data_nascita;
        this.sesso=sesso;
    }

    //setter
    public void getNome(String nome) {
        this.nome=nome;
    }

    public void setCognome(String cognome) {
        this.cognome=cognome;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita=data_nascita;
    }

    public void setSesso(Sesso sesso) {
        this.sesso=sesso;
    }

    //getter

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }
    public enum Sesso{
        M,
        F
    }
}
