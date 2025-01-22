package org.example;

import jakarta.persistence.*;

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String citta;

    public Location(){}

    public Location(String nome, String citta) {
        this.nome=nome;
        this.citta=citta;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public void setCitta(String citta) {
        this.citta=citta;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
    }
}
