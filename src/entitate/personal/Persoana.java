package entitate.personal;

public class Persoana implements Comparable<Persoana>{
    protected String nume, prenume, cnp;

    public Persoana() {}

    public Persoana(String nume, String prenume, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNumeComplet() {
        return this.nume + ' ' + this.prenume;
    }

    @Override
    public int compareTo(Persoana o) {
        String n1 = this.nume + this.prenume, n2 = o.nume + o.prenume;
        return n1.compareTo(n2);
    }

    @Override
    public String toString() {
        return this.getNumeComplet();
    }
}
