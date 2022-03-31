import Cabinet.Cabinet;
import Personal.Doctor;
import Personal.Pacient;
import Personal.Persoana;


public interface Service {
    void adaugaPersonal(Cabinet c, Persoana persoana);
    void stergePersonal(Cabinet c, Persoana persoana);
    void afiseazaDoctori(Cabinet c);
    void afiseazaAsistenti(Cabinet c);
    void sorteazaNume(Cabinet c);
    void sorteazaNrPacienti(Cabinet c);
    void sorteazaNota(Cabinet c);
    void modificaSalarius(Cabinet c, Persoana persoana, int diferenta);
    void adaugaMateriale(Cabinet c, String material, int cantitate);
    void eliminaMateriale(Cabinet c, String material, int cantitate);
    void afiseazaStoc(Cabinet c);
    void afiseazaMaterial(Cabinet c, String material);
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
    void afiseazaSalariu(Cabinet cabinet, Persoana persoana);
}
