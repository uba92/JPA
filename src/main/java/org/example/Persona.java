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

    @Column(name = "nome")
    private String nome;


    private String cognome;


    private String email;


    private LocalDate data_nascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
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

    public void setLista_partecipazioni(List<Partecipazione> lista_partecipazioni) {
        this.lista_partecipazioni=lista_partecipazioni;
    }

    public void addPartecipazioni(Partecipazione partecipazione) {
        lista_partecipazioni.add(partecipazione);
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

    public List<Partecipazione> getLista_partecipazioni() {
        return lista_partecipazioni;
    }

    public enum Sesso{
        M,
        F
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_nascita=" + data_nascita +
                ", sesso=" + sesso +

                '}';
    }
}
