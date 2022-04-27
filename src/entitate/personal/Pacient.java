package entitate.personal;

import entitate.programare.Diagnostic;
import entitate.programare.Programare;
import entitate.programare.Tratament;

import java.util.Objects;


public class Pacient extends Persoana{
    private Diagnostic diagnostic;
    private Tratament tratament;
    private Programare programare;
    private Doctor doctor;
    private int totalPlata;

    public Pacient() {}
    public Pacient(String nume, String prenume, String cnp) {
        super(nume, prenume, cnp);
    }
    public Pacient(String nume, String prenume, String cnp, Doctor doctor, Diagnostic diagnostic, Tratament tratament) {
        super(nume, prenume, cnp);
        this.doctor = doctor;
        this.diagnostic = diagnostic;
        this.tratament = tratament;
        this.totalPlata = tratament.getCost();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Tratament getTratament() {
        return tratament;
    }

    public void setTratament(Tratament tratament) {
        this.tratament = tratament;
        this.totalPlata = tratament.getCost();
    }

    public Programare getProgramare() {
        return programare;
    }

    public void setProgramare(Programare programare) {
        this.programare = programare;
    }

    public int getTotalPlata() {
        return totalPlata;
    }

    public void setTotalPlata(int totalPlata) {
        this.totalPlata = totalPlata;
    }

    @Override
    public String toString() {
        return "Pacientul " + this.getNumeComplet() + "a fost diagnosticat cu " + this.diagnostic + " si urmeaza tratamentul " + this.tratament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacient pacient = (Pacient) o;
        return totalPlata == pacient.totalPlata && diagnostic.equals(pacient.diagnostic) && tratament.equals(pacient.tratament) && programare.equals(pacient.programare) && doctor.equals(pacient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnostic, tratament, programare, doctor, totalPlata);
    }
}
