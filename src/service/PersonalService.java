package service;

import entitate.personal.Doctor;
import entitate.personal.Pacient;

public class PersonalService implements IPersonalService{
    @Override
    public void oferaNota(Pacient pacient, double nota) {
        pacient.oferaNota(nota);
    }

    @Override
    public void afiseazaRecomandari(Pacient pacient) {
        pacient.afiseazaRecomandari();
    }

    @Override
    public void afiseazaProgramare(Pacient pacient) {
        pacient.afiseazaProgramare();
    }

    @Override
    public void afiseazaProgramare(Doctor doctor) {
        doctor.afiseazaProgramare();
    }

    public void afiseazaProgramari(Doctor doctor) {
        doctor.afiseazaProgramari();
    }

    @Override
    public void eliminaProgramare(Doctor doctor) {
        doctor.eliminaProgramare();
    }

    @Override
    public void afiseazaProgramariAzi(Doctor doctor) {
        doctor.afiseazaProgramariAzi();
    }

    @Override
    public void adaugaPrimaProgramare(Doctor doctor, Pacient pacient, int zi, int luna, int an, int ora, int minut, String subiect) {
        doctor.adaugaPrimaProgramare(pacient, zi, luna, an, ora, minut, subiect);
    }

    @Override
    public void adaugaUrmProgramare(Doctor doctor, String subiect, int zilePeste) {
        doctor.adaugaUrmProgramare(subiect, zilePeste);
    }

    @Override
    public void afiseazaTotalPlata(Pacient pacient) {
        pacient.afiseazaTotalPlata();
    }
}
