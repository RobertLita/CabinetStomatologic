package service;

import entitate.cabinet.Cabinet;
import entitate.personal.Persoana;
import io.Audit;

public interface ICabinetService {
    Audit audit = Audit.getInstance();
    void adaugaPersonal(Cabinet cabinet, Persoana persoana);
    void stergePersonal(Cabinet cabinet, Persoana persoana);
    void afiseazaDoctori(Cabinet cabinet);
    void afiseazaAsistenti(Cabinet cabinet);
    void sorteazaNume(Cabinet cabinet);
    void sorteazaNrPacienti(Cabinet cabinet);
    void sorteazaNota(Cabinet cabinet);
    void modificaSalarius(Cabinet cabinet, Persoana persoana, int diferenta);
    void adaugaMateriale(Cabinet cabinet, String material, int cantitate);
    void scadeMateriale(Cabinet cabinet, String material, int cantitate);
    void afiseazaStoc(Cabinet cabinet);
    void afiseazaMaterial(Cabinet cabinet, String material);
    void afiseazaSalariu(Cabinet cabinet, Persoana persoana);
}
