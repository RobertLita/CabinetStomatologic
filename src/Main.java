import Cabinet.Cabinet;
import Personal.Asistent;
import Personal.Doctor;
import Personal.Pacient;
import Personal.Persoana;
import Programare.Diagnostic;
import Programare.Tratament;


public class Main implements Service {
    Main() {}

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
        cabinet.sorteazaNota();
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

    @Override
    public void afiseazaSalariu(Cabinet cabinet, Persoana persoana) {
        cabinet.afiseazaSalariu(persoana);
    }

    public static void main(String[] args) {
        //obiect main care face apeluri catre servicii
        Main M = new Main();

        //doctori
        Doctor D1 = new Doctor("Popescu", "Mihnea", "05111"), D2 = new Doctor("Vasile", "Vlad", "0222"),
                D3 = new Doctor("Tomescu", "Ioana", "222");

        //asistenti
        Asistent A1 = new Asistent("Toma", "Octavian", "0123"), A2 = new Asistent("Ionescu", "Maria", "111"),
                A3 = new Asistent("Grigore", "Laura", "02432123");

        //Cabinet
        Cabinet C = new Cabinet();

        //adaug doctori in cabinet
        M.adaugaPersonal(C, D1);
        M.adaugaPersonal(C, D2);
        M.adaugaPersonal(C, D3);

        //adaug asistenti in cabinet
        M.adaugaPersonal(C, A1);
        M.adaugaPersonal(C, A2);
        M.adaugaPersonal(C, A3);


        //diagnostic
        Diagnostic Di1 = new Diagnostic("halitoza"), Di2 = new Diagnostic("carie");

        //tratament
        Tratament T1 = new Tratament("plombarea molarului afectat", 30, 100, "nu consumati alimente reci"),
                T2 = new Tratament("detartraj", 25, 95, "nu consumati alimente reci");

        //pacienti
        Pacient P1 = new Pacient("Popa", "Alin", "123", D1, Di1, T2), P2 = new Pacient("Apostol", "Bianca", "222", D2, Di2, T1),
                P3 = new Pacient("Parvu", "Marius", "333", D2, Di2, T1);

        //adaug materiale pe stoc
        M.adaugaMateriale(C, "sarma", 12);
        M.adaugaMateriale(C, "sarma", 1);
        M.adaugaMateriale(C, "anestezic", 5);
        M.adaugaMateriale(C, "seringa", 30);
        M.adaugaMateriale(C, "material plomba", 40);

        //sterg materiale de pe stoc
        M.eliminaMateriale(C,"sarma", 1);

        //afisez stocul de materiale
        M.afiseazaStoc(C);
        System.out.println();
        //afisez stocul pentru un anumit material
        M.afiseazaMaterial(C, "seringa");
        System.out.println();

        //adaug primele programari pentru P1 si P2
        M.adaugaPrimaProgramare(D1, P1,28, 3, 2022, 12, 0, "detartraj");
        M.adaugaPrimaProgramare(D2, P2, 27, 3, 2022, 10, 30, "carie molar");
        M.adaugaPrimaProgramare(D2, P3, 31, 3, 2022, 14, 30, "carie premolar");

        //pacientul P1 vine la cabinet, iar la sfarsit, doctorul adauga urmatoarea lui programare, peste 3 zile la aceeasi ora, apoi elimina programarea curenta
        M.adaugaUrmProgramare(D1, "periaj", 3);
        M.eliminaProgramare(D1);

        //afisez programarile lui D1 si programarile de azi ale lui D2
        M.afiseazaProgramari(D1);
        System.out.println();

        M.afiseazaProgramariAzi(D2);
        System.out.println();

        //afisez programarea viitoare a lui P1
        M.afiseazaProgramare(P1);
        System.out.println();

        //afisez recomandarile lui P3 date de medic
        M.afiseazaRecomandari(P3);
        System.out.println();

        //P3 ii ofera o nota doctorului sau
        M.oferaNota(P3, 10);
        M.oferaNota(P2, 9);

        //sortez si afisez doctorii descrescator in functie de nota
        M.sorteazaNota(C);
        M.afiseazaDoctori(C);
        System.out.println();

        M.sorteazaNrPacienti(C);
        M.afiseazaDoctori(C);
        System.out.println();

        //afisez totalul de plata pt P2
        M.afiseazaTotalPlata(P2);

        //modific si afisez salariul unui doctor
        M.modificaSalarius(C, D1, 100);
        M.afiseazaSalariu(C, D1);

    }
}
