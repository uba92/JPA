package org.example;

import org.example.DAO.EventoDAOImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAOImpl eventoDAO = new EventoDAOImpl();

        Evento nuovoEvento = new Evento("Concerto",
                LocalDate.of(2025,2,28),
                "Speriamo sia un bel concerto!",
                Evento.TipoEvento.PUBBLICO,
                500);

        eventoDAO.save(nuovoEvento);
        System.out.println("Evento salvato con ID: " + nuovoEvento.getId());

        System.out.println("evento: " + nuovoEvento.getDescrizione() + " " + nuovoEvento.getTitolo());

        eventoDAO.close();

        Evento nuovoEvento2 = new Evento("AltroConcerto",
                LocalDate.of(2025,4,3),
                "Non ci spero",
                Evento.TipoEvento.PRIVATO,
                200);

        eventoDAO.save(nuovoEvento2);
        System.out.println("Evento salvato con ID: " + nuovoEvento2.getId());

        System.out.println("evento: " + nuovoEvento2.getDescrizione() + " " + nuovoEvento2.getTitolo());

    }
}
