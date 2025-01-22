package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //questa annotazione indica che la classe si comporterà come una entità, quindi ogni oggetto istanziato
// con questa classe rappresenterà una riga della tabella del DB

@Table(name = "evento") //mappa la classe Evento sulla tabella "evento" di postgres
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate data_evento;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipo_evento;

    @Column(name = "numero_massimo_partecipanti")
    private int numero_massimo_partecipanti;

    @Column(name = "location")
    private Location location;
    //costruttori
    public Evento() {

    }

    public Evento(String titolo, LocalDate data_evento, String descrizione, TipoEvento tipo_evento, int numero_massimo_partecipanti) {
        this.titolo=titolo;
        this.data_evento=data_evento;
        this.descrizione=descrizione;
        this.tipo_evento=tipo_evento;
        this.numero_massimo_partecipanti=numero_massimo_partecipanti;
    }

    //metodi getter
    public Long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipo_evento() {
        return tipo_evento;
    }

    public int getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    //metodi setter


    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipo_evento(TipoEvento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    //tipo enum
    public enum TipoEvento {
        PUBBLICO,
        PRIVATO
    }
}
