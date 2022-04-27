package service;

import entitate.cabinet.Cabinet;
import entitate.personal.Persoana;

public interface ICabinetService {
    void adaugaPersonal(Cabinet c, Persoana persoana);
    void stergePersonal(Cabinet c, Persoana persoana);
    void afiseazaDoctori(Cabinet c);
    void afiseazaAsistenti(Cabinet c);
    void sorteazaNume(Cabinet c);
    void sorteazaNrPacienti(Cabinet c);
    void sorteazaNota(Cabinet c);
    void modificaSalarius(Cabinet c, Persoana persoana, int diferenta);
    void adaugaMateriale(Cabinet c, String material, int cantitate);
    void scadeMateriale(Cabinet c, String material, int cantitate);
    void afiseazaStoc(Cabinet c);
    void afiseazaMaterial(Cabinet c, String material);
    void afiseazaSalariu(Cabinet cabinet, Persoana persoana);
}
