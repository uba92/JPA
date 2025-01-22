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

    public enum Stato{
        CONFERMATO,
        DA_CONFERMARE
    }
}
