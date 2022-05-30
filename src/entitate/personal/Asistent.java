package entitate.personal;

import java.util.Objects;

public class Asistent extends Persoana{
    private static int id = 0;
    private double salariu;
    private int asistent_id;
    public Asistent() {this.asistent_id = ++id;}
    public Asistent(String nume, String prenume, String cnp) {
        super(nume, prenume, cnp); this.asistent_id = ++id;
    }

    public int getAsistent_id() {
        return asistent_id;
    }

    public void setAsistent_id(int asistent_id) {
        this.asistent_id = asistent_id;
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
        return Double.compare(asistent.salariu, salariu) == 0 && asistent_id == asistent.asistent_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salariu, asistent_id);
    }
}
