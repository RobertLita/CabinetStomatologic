package entitate.programare;

public class Tratament {
    private String nume, recomandari;
    private int durata, cost;

    public Tratament() {}
    public Tratament(String nume, int durata, int cost, String recomandari) {
        this.cost = cost;
        this.durata = durata;
        this.nume = nume;
        this.recomandari = recomandari;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRecomandari() {
        return recomandari;
    }

    public void setRecomandari(String recomandari) {
        this.recomandari = recomandari;
    }

    @Override
    public String toString() {
        return "Tramentul " + this.nume + " costa " + this.cost + " si dureaza " + this.durata + " de zile.";
    }
}
