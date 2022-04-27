package entitate.cabinet;

import entitate.personal.*;

import java.util.*;

public class Cabinet {
    private List<Doctor> doctori;
    private List<Asistent> asistenti;
    private Map<String, Integer> stoc;
    public Cabinet() {
        this.stoc = new HashMap<>();
        this.doctori = new ArrayList<>();
        this.asistenti = new ArrayList<>();
    }

    public Cabinet(ArrayList<Doctor> doctori, ArrayList<Asistent> asistenti) {
        this.doctori = doctori;
        this.asistenti = asistenti;
        this.stoc = new HashMap<>();
    }

    public List<Doctor> getDoctori() {
        return doctori;
    }

    public void setDoctori(ArrayList<Doctor> doctori) {
        this.doctori = doctori;
    }

    public List<Asistent> getAsistenti() {
        return asistenti;
    }

    public void setAsistenti(ArrayList<Asistent> asistenti) {
        this.asistenti = asistenti;
    }

    public void setDoctori(List<Doctor> doctori) {
        this.doctori = doctori;
    }

    public void setAsistenti(List<Asistent> asistenti) {
        this.asistenti = asistenti;
    }

    public Map<String, Integer> getStoc() {
        return stoc;
    }

    public void setStoc(Map<String, Integer> stoc) {
        this.stoc = stoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cabinet cabinet = (Cabinet) o;
        return doctori.equals(cabinet.doctori) && asistenti.equals(cabinet.asistenti) && stoc.equals(cabinet.stoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctori, asistenti, stoc);
    }
}
