package entitate.personal;

import entitate.programare.Programare;

import java.util.Calendar;
import java.util.PriorityQueue;
import java.util.Queue;


public class Doctor extends Persoana{
    private double salariu, nota;
    private int nrPacienti;
    private Asistent asistent;
    private Queue<Programare> programari;

    public Doctor() {}
    public Doctor(String nume, String prenume, String cnp) {
        super(nume, prenume, cnp);
        this.programari = new PriorityQueue<>();
    }

    public void afiseazaProgramare() {
        if(this.programari.isEmpty()){
            System.out.println("Nu exista nicio progrmare");
            return;
        }
        System.out.println(this.programari.peek());
    }

    public void eliminaProgramare() {
        this.programari.remove();
    }

    public void afiseazaProgramariAzi() {
        Calendar c = Calendar.getInstance();
        for(Programare p : this.programari) {
            if(p.getData().get(Calendar.DAY_OF_MONTH) != c.get(Calendar.DAY_OF_MONTH))
                break;
            System.out.println(p);
        }
    }

    public void adaugaPrimaProgramare(Pacient p, int zi, int luna, int an, int ora, int minut, String subiect) {
        Programare programareNoua = new Programare(zi, luna, an, ora, minut, p, subiect);
        this.programari.add(programareNoua);
        p.setProgramare(programareNoua);
    }

    public void adaugaUrmProgramare(String subiect, int zilePeste) {
        Programare programareNoua = new Programare();
        Programare programareCurenta = this.programari.peek();
        if(programareCurenta == null) {
            return;
        }
        Pacient p = programareCurenta.getPacient();
        Calendar dataNoua = programareCurenta.getData();
        dataNoua.add(Calendar.DATE, zilePeste);
        programareNoua.setData(dataNoua);
        programareNoua.setSubiect(subiect);
        programareNoua.setPacient(p);
        p.setProgramare(programareNoua);
        this.programari.add(programareNoua);
    }

    public void afiseazaProgramari() {
        for(Programare p : this.programari) {
            System.out.println(p);
        }
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

    public void setProgramari(PriorityQueue<Programare> programari) {
        this.programari = programari;
    }

    @Override
    public String toString() {
        return this.getNumeComplet() + " are ratingul " + this.getNota() + " si a avut pana acum " + this.nrPacienti + " pacienti.";
    }
}
