package service;

import entitate.cabinet.Cabinet;
import entitate.personal.Persoana;

public class CabinetService implements ICabintService{
    @Override
    public void adaugaPersonal(Cabinet cabinet, Persoana persoana) {
        cabinet.adaugaPersonal(persoana);
    }

    @Override
    public void stergePersonal(Cabinet cabinet, Persoana persoana) {
        cabinet.stergePersonal(persoana);
    }

    @Override
    public void afiseazaDoctori(Cabinet cabinet) {
        cabinet.afiseazaDoctori();
    }

    @Override
    public void afiseazaAsistenti(Cabinet cabinet) {
        cabinet.afiseazaAsistenti();
    }

    @Override
    public void sorteazaNume(Cabinet cabinet) {
        cabinet.sorteazaNume();
    }

    @Override
    public void sorteazaNrPacienti(Cabinet cabinet) {
        cabinet.sorteazaNrPacienti();
    }

    @Override
    public void sorteazaNota(Cabinet cabinet) {
        cabinet.sorteazaNota();
    }

    @Override
    public void modificaSalarius(Cabinet cabinet, Persoana persoana, int diferenta) {
        cabinet.modificaSalariu(persoana, diferenta);
    }

    @Override
    public void adaugaMateriale(Cabinet cabinet, String material, int cantitate) {
        cabinet.adaugaMaterial(material, cantitate);
    }

    @Override
    public void eliminaMateriale(Cabinet cabinet, String material, int cantitate) {
        cabinet.scadeMaterial(material, cantitate);
    }

    @Override
    public void afiseazaStoc(Cabinet cabinet) {
        cabinet.afiseazaStoc();
    }

    @Override
    public void afiseazaMaterial(Cabinet cabinet, String material) {
        cabinet.afiseazaMaterial(material);
    }

    @Override
    public void afiseazaSalariu(Cabinet cabinet, Persoana persoana) {
        cabinet.afiseazaSalariu(persoana);
    }
}
