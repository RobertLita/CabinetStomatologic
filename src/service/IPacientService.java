package service;

import entitate.personal.Pacient;

public interface IPacientService {
    void afiseazaTotalPlata(Pacient pacient);
    void afiseazaProgramare(Pacient pacient);
    void afiseazaRecomandari(Pacient pacient);
    void oferaNota(Pacient pacient, double nota);
}
