import entitate.cabinet.Cabinet;
import entitate.personal.Asistent;
import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Diagnostic;
import entitate.programare.Tratament;
import service.CabinetService;
import service.PersonalService;


public class Main {
    public static void main(String[] args) {
        //doctori
        Doctor D1 = new Doctor("Popescu", "Mihnea", "05111"), D2 = new Doctor("Vasile", "Vlad", "0222"),
                D3 = new Doctor("Anton", "Ioana", "222");

        //asistenti
        Asistent A1 = new Asistent("Toma", "Octavian", "0123"), A2 = new Asistent("Ionescu", "Maria", "111"),
                A3 = new Asistent("Grigore", "Laura", "02432123");

        //Cabinet
        Cabinet C = new Cabinet();

        CabinetService CService = new CabinetService();
        PersonalService PService = new PersonalService();

        //adaug doctori in cabinet
        CService.adaugaPersonal(C, D1);
        CService.adaugaPersonal(C, D2);
        CService.adaugaPersonal(C, D3);

        //adaug asistenti in cabinet
        CService.adaugaPersonal(C, A1);
        CService.adaugaPersonal(C, A2);
        CService.adaugaPersonal(C, A3);


        //diagnostic
        Diagnostic Di1 = new Diagnostic("halitoza"), Di2 = new Diagnostic("carie");

        //tratament
        Tratament T1 = new Tratament("plombarea molarului afectat", 30, 100, "nu consumati alimente reci"),
                T2 = new Tratament("detartraj", 25, 95, "nu consumati alimente reci");

        //pacienti
        Pacient P1 = new Pacient("Popa", "Alin", "123", D1, Di1, T2), P2 = new Pacient("Apostol", "Bianca", "222", D2, Di2, T1),
                P3 = new Pacient("Parvu", "Marius", "333", D2, Di2, T1);

        //adaug materiale pe stoc
        CService.adaugaMateriale(C, "sarma", 12);
        CService.adaugaMateriale(C, "sarma", 1);
        CService.adaugaMateriale(C, "anestezic", 5);
        CService.adaugaMateriale(C, "seringa", 30);
        CService.adaugaMateriale(C, "material plomba", 40);

        //sterg materiale de pe stoc
        CService.eliminaMateriale(C,"sarma", 1);

        //afisez stocul de materiale
        CService.afiseazaStoc(C);
        System.out.println();
        //afisez stocul pentru un anumit material
        CService.afiseazaMaterial(C, "seringa");
        System.out.println();

        //adaug primele programari pentru P1 si P2
        PService.adaugaPrimaProgramare(D1, P1,28, 3, 2022, 12, 0, "detartraj");
        PService.adaugaPrimaProgramare(D2, P2, 16, 3, 2022, 10, 30, "carie molar");
        PService.adaugaPrimaProgramare(D2, P3, 31, 4, 2022, 14, 30, "carie premolar");

        PService.afiseazaProgramari(D1);
        //pacientul P1 vine la cabinet, iar la sfarsit, doctorul adauga urmatoarea lui programare, peste 3 zile la aceeasi ora, apoi elimina programarea curenta
        PService.adaugaUrmProgramare(D1, "periaj", 3);
        PService.eliminaProgramare(D1);

        //afisez programarile lui D1 si programarile de azi ale lui D2
        PService.afiseazaProgramari(D1);
        System.out.println();

        PService.afiseazaProgramariAzi(D2);
        System.out.println();

        //afisez programarea viitoare a lui P1
        PService.afiseazaProgramare(P3);
        System.out.println();

        //afisez recomandarile lui P3 date de medic
        PService.afiseazaRecomandari(P3);
        System.out.println();

        //P3 ii ofera o nota doctorului sau
        PService.oferaNota(P3, 10);
        PService.oferaNota(P2, 9);

        //sortez si afisez doctorii descrescator in functie de nota
        CService.sorteazaNota(C);
        CService.afiseazaDoctori(C);
        System.out.println();

        CService.sorteazaNume(C);
        CService.afiseazaDoctori(C);
        System.out.println();

        //afisez totalul de plata pt P2
        PService.afiseazaTotalPlata(P2);

        //modific si afisez salariul unui doctor
        CService.modificaSalarius(C, D1, 100);
        CService.afiseazaSalariu(C, D1);

    }
}
