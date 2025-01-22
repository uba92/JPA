package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Stato stato;

    //costruttore
    public Partecipazione(){}

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona=persona;
        this.evento=evento;
        this.stato=stato;
    }

    //getter
    public Long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }


    //setter
    public void setPersona(Persona persona) {
        this.persona=persona;
    }

    public void setEvento(Evento evento) {
        this.evento=evento;
    }

    public void setStato(Stato stato) {
        this.stato=stato;
    }


    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }


    public enum Stato{
        CONFERMATO,
        DA_CONFERMARE
    }
}
