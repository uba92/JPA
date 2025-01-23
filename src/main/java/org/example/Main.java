package org.example;

import org.example.DAO.*;

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

        //creo nuove Persone

        Persona umberto = new Persona("Umberto", "Tramontano", "umberto@umberto.com", LocalDate.of(1992,4,6), Persona.Sesso.M);
        Persona niccolo = new Persona("Niccolò", "Albanese", "nicco@alba.com", LocalDate.of(1990,4,6), Persona.Sesso.M);
        Persona valentina = new Persona("Valentina", "Gargiulo", "vale@vale.com", LocalDate.of(2000,4,6), Persona.Sesso.F);

        //creo nuove partecipazioni

        Partecipazione partecipazione1 = new Partecipazione(umberto, nuovoEvento, Partecipazione.Stato.CONFERMATO);
        Partecipazione partecipazione2 = new Partecipazione(niccolo, nuovoEvento, Partecipazione.Stato.CONFERMATO);
        Partecipazione partecipazione3 = new Partecipazione(umberto, nuovoEvento2, Partecipazione.Stato.DA_CONFERMARE);
        Partecipazione partecipazione4 = new Partecipazione(valentina, nuovoEvento, Partecipazione.Stato.DA_CONFERMARE);
        Partecipazione partecipazione5 = new Partecipazione(valentina, nuovoEvento2, Partecipazione.Stato.CONFERMATO);


        PersonaDAO personaDAO = new PersonaDAOImpl();
        personaDAO.save(umberto);
        personaDAO.save(niccolo);
        personaDAO.save(valentina);

        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAOImpl();

        partecipazioneDAO.save(partecipazione1);
        partecipazioneDAO.save(partecipazione2);
        partecipazioneDAO.save(partecipazione3);
        partecipazioneDAO.save(partecipazione4);
        partecipazioneDAO.save(partecipazione5);

        umberto.addPartecipazioni(partecipazione1);
        umberto.addPartecipazioni(partecipazione3);

        System.out.println("Partecipazioni di umberto: " + umberto.getLista_partecipazioni());
    }
}
