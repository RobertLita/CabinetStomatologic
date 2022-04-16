package service;

import entitate.personal.Doctor;
import entitate.personal.Pacient;

public interface IPersonalService {
    void oferaNota(Pacient pacient, double nota);
    void afiseazaRecomandari(Pacient pacient);
    void afiseazaProgramare(Doctor doctor);
    void afiseazaProgramare(Pacient pacient);
    void afiseazaProgramari(Doctor doctor);
    void eliminaProgramare(Doctor doctor);
    void afiseazaProgramariAzi(Doctor doctor);
    void adaugaPrimaProgramare(Doctor doctor, Pacient p, int zi, int luna, int an, int ora, int minut, String subiect);
    void adaugaUrmProgramare(Doctor doctor, String subiect, int zilePeste);
    void afiseazaTotalPlata(Pacient pacient);
}
