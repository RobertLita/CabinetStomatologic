package entitate.programare;

import java.util.Objects;

public class Tratament {
    private String nume, recomandari;
    private int durata, cost, tratament_id;

    public Tratament() {}
    public Tratament(String nume, int durata, int cost, String recomandari) {
        this.cost = cost;
        this.durata = durata;
        this.nume = nume;
        this.recomandari = recomandari;
    }

    public int getTratament_id() {
        return tratament_id;
    }

    public void setTratament_id(int tratament_id) {
        this.tratament_id = tratament_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tratament tratament = (Tratament) o;
        return durata == tratament.durata && cost == tratament.cost && tratament_id == tratament.tratament_id && Objects.equals(nume, tratament.nume) && Objects.equals(recomandari, tratament.recomandari);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, recomandari, durata, cost, tratament_id);
    }
}
