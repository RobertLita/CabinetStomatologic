package Personal;

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
}
