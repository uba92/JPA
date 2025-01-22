package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

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



    public enum Sesso{
        M,
        F
    }
}
