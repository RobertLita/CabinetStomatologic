package entitate.personal;

import entitate.programare.Diagnostic;
import entitate.programare.Programare;
import entitate.programare.Tratament;

import java.util.Objects;


public class Pacient extends Persoana{
    private int pacient_id;
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

    public int getPacient_id() {
        return pacient_id;
    }

    public void setPacient_id(int pacient_id) {
        this.pacient_id = pacient_id;
    }

    @Override
    public String toString() {
        return "Pacientul " + this.getNumeComplet() + " a fost diagnosticat cu " + this.diagnostic + " si urmeaza tratamentul " + this.tratament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacient pacient = (Pacient) o;
        return pacient_id == pacient.pacient_id && totalPlata == pacient.totalPlata && Objects.equals(diagnostic, pacient.diagnostic) && Objects.equals(tratament, pacient.tratament) && Objects.equals(programare, pacient.programare) && Objects.equals(doctor, pacient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacient_id, diagnostic, tratament, programare, doctor, totalPlata);
    }
}
