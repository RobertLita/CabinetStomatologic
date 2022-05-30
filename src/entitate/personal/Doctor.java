package entitate.personal;

import entitate.programare.Programare;

import java.util.Calendar;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;


public class Doctor extends Persoana{
    private double salariu, nota;
    private int nrPacienti, doctor_id;
    private Asistent asistent;
    private Queue<Programare> programari;

    public Doctor() {}
    public Doctor(String nume, String prenume, String cnp) {
        super(nume, prenume, cnp);
        this.programari = new PriorityQueue<>();
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Asistent getAsistent() {
        return asistent;
    }

    public void setAsistent(Asistent asistent) {
        this.asistent = asistent;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getNrPacienti() {
        return nrPacienti;
    }

    public void setNrPacienti(int nrPacienti) {
        this.nrPacienti = nrPacienti;
    }

    public Queue<Programare> getProgramari() {
        return programari;
    }

    public void setProgramari(Queue<Programare> programari) {
        this.programari = programari;
    }

    @Override
    public String toString() {
        return this.getNumeComplet() + " are ratingul " + this.getNota() + " si a avut pana acum " + this.nrPacienti + " pacienti.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Double.compare(doctor.salariu, salariu) == 0 && Double.compare(doctor.nota, nota) == 0 && nrPacienti == doctor.nrPacienti && doctor_id == doctor.doctor_id && Objects.equals(asistent, doctor.asistent) && Objects.equals(programari, doctor.programari);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salariu, nota, nrPacienti, doctor_id, asistent, programari);
    }
}
