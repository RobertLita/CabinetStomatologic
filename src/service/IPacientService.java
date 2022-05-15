package service;

import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Diagnostic;
import entitate.programare.Tratament;
import io.Audit;

public interface IPacientService {
    Audit audit = Audit.getInstance();
    void afiseazaTotalPlata(Pacient pacient);
    void afiseazaProgramare(Pacient pacient);
    void afiseazaRecomandari(Pacient pacient);
    void oferaNota(Pacient pacient, double nota);
    void adaugaDoctor(Pacient pacient, Doctor doctor);
    void adaugaDiagnostic(Pacient pacient, Diagnostic diagnostic);
    void adaugaTratament(Pacient pacient, Tratament tratament);
}
