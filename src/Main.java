import entitate.cabinet.Cabinet;
import entitate.personal.Asistent;
import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Diagnostic;
import entitate.programare.Programare;
import entitate.programare.Tratament;
import io.ReadCSVService;
import io.WriteCSVService;
import service.CabinetService;
import service.DoctorService;
import service.PacientService;
import service_db.DoctorDatabase;
import service_db.PacientDatabase;
import service_db.ProgramareDatabase;
import service_db.TratamentDatabase;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        CabinetService CService = new CabinetService();
        DoctorService DService = new DoctorService();
        PacientService PService = new PacientService();
        ReadCSVService in = ReadCSVService.getInstance();


        List<Diagnostic> diagnostice = in.citesteCSV("data/diagnostice.csv", "Diagnostic");
        Diagnostic Di1 = diagnostice.get(0), Di2 = diagnostice.get(1), Di3 = diagnostice.get(2);


        List<Doctor> doctori = in.citesteCSV("data/doctori.csv", "Doctor");
        Doctor D1 = doctori.get(0), D2 = doctori.get(1), D3 = doctori.get(2);
        DoctorDatabase DDB = new DoctorDatabase();
        DDB.createTable();
//        DDB.create(D1);
//        DDB.create(D2);
//        DDB.create(D3);
        //DDB.delete(2);
        //DDB.read().forEach(System.out::println);
        D1 = DoctorDatabase.readAt(3);
        D2 = DoctorDatabase.readAt(5);
        D3 = DoctorDatabase.readAt(4);
//        D1.setNrPacienti(100);
//        DDB.update(D1);

        TratamentDatabase TDB = new TratamentDatabase();
        TDB.createTable();

        List<Tratament> tratamente = in.citesteCSV("data/tratamente.csv", "Tratament");
        Tratament T1 = tratamente.get(0), T2 = tratamente.get(1), T3 = tratamente.get(2);
//        List<Programare> programari = in.citesteCSV("data/programari.csv", "Programare");
//        Programare Pr1 = programari.get(0), Pr2 = programari.get(1), Pr3 = programari.get(2);
//        TDB.create(T1);
//        TDB.create(T2);
//        TDB.delete(2);
//        TDB.read().forEach(System.out::println);
        T1 = TratamentDatabase.readAt(3);
        T2 = TratamentDatabase.readAt(4);
//        T1.setRecomandari("nicio recomandare");
//        TDB.update(T1);
//        TDB.create(T2);
//        TDB.create(T3);
        List<Pacient> pacienti = in.citesteCSV("data/pacienti.csv", "Pacient");
        Pacient P1 = pacienti.get(0), P2 = pacienti.get(1), P3 = pacienti.get(2), P4 = pacienti.get(3);
        PService.adaugaDoctor(P1, D1);
        PService.adaugaDiagnostic(P1, Di1);
        PService.adaugaTratament(P1, T1);
        PService.adaugaDoctor(P2, D2);
        PService.adaugaDiagnostic(P2, Di2);
        PService.adaugaTratament(P2, T1);
        PService.adaugaDoctor(P3, D2);
        PService.adaugaDiagnostic(P3, Di2);
        PService.adaugaTratament(P3, T1);
        PacientDatabase PDB = new PacientDatabase();
//        PDB.createTable();
////        PDB.create(P2);
////        PDB.create(P2);
//        PDB.delete(1);
//        PDB.delete(3);
//        PDB.delete(4);
//        PDB.delete(5);
        P2 = PacientDatabase.readAt(8);
        Programare Pr1 = new Programare(30, 5, 2022, 14, 5, P1, "extractie"),
                Pr2 = new Programare(31, 5, 2022, 15, 40, P2, "detartraj");
        ProgramareDatabase PrDB = new ProgramareDatabase();
        PrDB.createTable();
        PrDB.create(Pr2);
        PrDB.delete(2);
        Pr1 = ProgramareDatabase.readAt(8);
        Pr1.setSubiect("niciun subiect");
        PrDB.update(Pr1);

//        PDB.read().forEach(System.out::println);
//        PDB.delete(7);
//        P2 = PacientDatabase.readAt(8);
//        P2.setPrenume("Prenume");
//        PDB.update(P2);
//        //doctori
//        //asistenti
////        Asistent A1 = new Asistent("Toma", "Octavian", "0123"), A2 = new Asistent("Ionescu", "Maria", "111"),
////                A3 = new Asistent("Grigore", "Laura", "02432123");
//
//        List<Asistent> asistenti = in.citesteCSV("data/asistenti.csv", "Asistent");
//        Asistent A1 = asistenti.get(0), A2 = asistenti.get(1), A3 = asistenti.get(2);
//
//        //Cabinet
//        Cabinet C = new Cabinet();
//
//        CabinetService CService = new CabinetService();
//        DoctorService DService = new DoctorService();
//        PacientService PService = new PacientService();
//
//        //adaug doctori in cabinet
//        CService.adaugaPersonal(C, D1);
//        CService.adaugaPersonal(C, D2);
//        CService.adaugaPersonal(C, D3);
//
//        //adaug asistenti in cabinet
//        CService.adaugaPersonal(C, A1);
//        CService.adaugaPersonal(C, A2);
//        CService.adaugaPersonal(C, A3);
//
//
//        //diagnostic
////        Diagnostic Di1 = new Diagnostic("halitoza"), Di2 = new Diagnostic("carie");
//        List<Diagnostic> diagnostice = in.citesteCSV("data/diagnostice.csv", "Diagnostic");
//        Diagnostic Di1 = diagnostice.get(0), Di2 = diagnostice.get(1), Di3 = diagnostice.get(2);
//
//        //tratament
//        Tratament T1 = new Tratament("plombarea molarului afectat", 30, 100, "nu consumati alimente reci"),
//                T2 = new Tratament("detartraj", 25, 95, "nu consumati alimente reci");
//        List<Tratament> tratamente = in.citesteCSV("data/tratamente.csv", "Tratament");
//        Tratament T1 = tratamente.get(0), T2 = tratamente.get(1), T3 = tratamente.get(2);
//
//        //pacienti
////        Pacient P1 = new Pacient("Popa", "Alin", "123", D1, Di1, T2), P2 = new Pacient("Apostol", "Bianca", "222", D2, Di2, T1),
////                P3 = new Pacient("Parvu", "Marius", "333", D2, Di2, T1);
//        List<Pacient> pacienti = in.citesteCSV("data/pacienti.csv", "Pacient");
//        Pacient P1 = pacienti.get(0), P2 = pacienti.get(1), P3 = pacienti.get(2), P4 = pacienti.get(3);
//
//        //adaug materiale pe stoc
//        CService.adaugaMateriale(C, "sarma", 12);
//        CService.adaugaMateriale(C, "sarma", 1);
//        CService.adaugaMateriale(C, "anestezic", 5);
//        CService.adaugaMateriale(C, "seringa", 30);
//        CService.adaugaMateriale(C, "material plomba", 40);
//
//        //sterg materiale de pe stoc
//        CService.scadeMateriale(C,"sarma", 1);
//
//        //afisez stocul de materiale
//        CService.afiseazaStoc(C);
//        System.out.println();
//        //afisez stocul pentru un anumit material
//        CService.afiseazaMaterial(C, "seringa");
//        System.out.println();
//
//        //adaug primele programari pentru P1 si P2
//        DService.adaugaPrimaProgramare(D1, P1,28, 3, 2022, 12, 0, "detartraj");
//        DService.adaugaPrimaProgramare(D2, P2, 27, 4, 2022, 10, 30, "carie molar");
//        DService.adaugaPrimaProgramare(D2, P3, 27, 4, 2022, 12, 30, "extractie");
//        DService.adaugaPrimaProgramare(D2, P3, 4, 5, 2022, 14, 30, "carie premolar");
//
//        DService.afiseazaProgramari(D1);
//        //pacientul P1 vine la cabinet, iar la sfarsit, doctorul adauga urmatoarea lui programare, peste 3 zile la aceeasi ora, apoi elimina programarea curenta
//        DService.adaugaUrmProgramare(D1, "periaj", 3);
//        DService.eliminaProgramare(D1);
//
//        //afisez programarile lui D1 si programarile de azi ale lui D2
//        DService.afiseazaProgramari(D1);
//        System.out.println();
//
//        DService.afiseazaProgramariAzi(D2);
//        System.out.println();
//
//        //afisez programarea viitoare a lui P1
//        PService.afiseazaProgramare(P3);
//        System.out.println();
//
//        //afisez recomandarile lui P3 date de medic
//        PService.afiseazaRecomandari(P3);
//        System.out.println();
//
//        //P3 ii ofera o nota doctorului sau
//        PService.oferaNota(P3, 10);
//        PService.oferaNota(P2, 9);
//
//        //sortez si afisez doctorii descrescator in functie de nota
//        CService.sorteazaNota(C);
//        CService.afiseazaDoctori(C);
//        System.out.println();
//
//        CService.sorteazaNume(C);
//        CService.afiseazaDoctori(C);
//        System.out.println();
//
//        //afisez totalul de plata pt P2
//        PService.afiseazaTotalPlata(P2);
//
//        //modific si afisez salariul unui doctor
//        CService.modificaSalarius(C, D1, 1500);
//        CService.afiseazaSalariu(C, D1);
//
//        Doctor DNou = new Doctor("Mugur","Dorian", "09090909");
//        WriteCSVService out = WriteCSVService.getInstance();
//        out.scrieCSV(DNou, "data/output.csv");
    }
}
