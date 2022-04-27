package entitate.personal;

import java.util.Objects;

public class Asistent extends Persoana{
    private double salariu;
    public Asistent() {}
    public Asistent(String nume, String prenume, String cnp) {
        super(nume, prenume, cnp);
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Asistent " + this.getNumeComplet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asistent asistent = (Asistent) o;
        return Double.compare(asistent.salariu, salariu) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salariu);
    }
}
