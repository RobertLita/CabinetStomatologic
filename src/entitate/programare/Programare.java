package entitate.programare;

import entitate.personal.Pacient;
import java.util.Calendar;


public class Programare implements Comparable<Programare>{
    private int programare_id;
    private Calendar data;
    private String subiect;
    private Pacient pacient;
    public Programare() {}
    public Programare(int zi, int luna, int an, int ora, int minut, Pacient pacient, String subiect) {
        this.data = Calendar.getInstance();
        this.data.set(an, luna - 1, zi, ora, minut, 0);
        this.pacient = pacient;
        this.subiect = subiect;
    }
    public void setData(int zi, int luna, int an, int ora, int minut) {
        this.data = Calendar.getInstance();
        this.data.set(an, luna - 1, zi, ora, minut, 0);
    }

    public int getProgramare_id() {
        return programare_id;
    }

    public void setProgramare_id(int programare_id) {
        this.programare_id = programare_id;
    }

    public void setData(Calendar c) {
        this.data = (Calendar) c.clone();
    }
    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getSubiect() {
        return this.subiect;
    }

    public Calendar getData() {
        return (Calendar) this.data.clone();
    }

    public void setSubiect(String subiect) {
        this.subiect = subiect;
    }

    @Override
    public String toString() {
        return "Pacientul " + this.pacient.getNumeComplet() + " are o programare cu titlul <" + this.subiect + "> pe " + this.getData().getTime();
    }

    @Override
    public int compareTo(Programare o) {
        return this.data.compareTo(o.getData());
    }
}
