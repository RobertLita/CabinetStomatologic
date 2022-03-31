package Personal;

import Programare.Diagnostic;
import Programare.Programare;
import Programare.Tratament;


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

    public void oferaNota(double nota) {
        int nrPacienti = this.doctor.getNrPacienti() + 1;
        this.doctor.setNrPacienti(nrPacienti);
        double n = this.doctor.getNota();
        n = (n + nota) / nrPacienti;
        this.doctor.setNota(n);
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

    public void afiseazaProgramare() {
        if(this.programare == null){
            System.out.println("Pacientul nu are nicio programare.");
            return;
        }
        System.out.println(this.programare);
    }

    public void afiseazaRecomandari() {
        if(this.tratament == null) {
            System.out.println("Pacientul nu are niciun tratament.");
            return;
        }
        if(this.tratament.getRecomandari().equals("")){
            System.out.println("Pacientul nu are nicio recomandare");
            return;
        }
        System.out.println("Pentru " + this.getNumeComplet() + ", recomandarea este sa " + this.tratament.getRecomandari());
    }
    public void afiseazaTotalPlata() {
        if(this.totalPlata == 0) {
            System.out.println("Pacientul " + this.getNumeComplet() + " nu are nimic de platit.");
            return;
        }
        System.out.println("Pacientul " + this.getNumeComplet() + " are de platit " + this.totalPlata + " de lei.");
    }

    @Override
    public String toString() {
        return "Pacientul " + this.getNumeComplet() + "a fost diagnosticat cu " + this.diagnostic + " si urmeaza tratamentul " + this.tratament;
    }
}
