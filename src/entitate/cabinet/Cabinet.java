package entitate.cabinet;

import comparatori.NrPacientiComparator;
import comparatori.NotaComparator;
import entitate.personal.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void adaugaPersonal(Persoana p) {
        if(p instanceof Doctor) {
            this.doctori.add((Doctor) p);
        }
        else if(p instanceof Asistent) {
            this.asistenti.add((Asistent) p);
        }
    }

    public void stergePersonal(Persoana p) {
        if(p instanceof Doctor) {
            this.doctori.remove((Doctor) p);
        }
        else if(p instanceof Asistent) {
            this.asistenti.remove((Asistent) p);
        }
    }

    public void modificaSalariu(Persoana p, int diferenta) {
        if(p instanceof Doctor) {
            ((Doctor) p).setSalariu(((Doctor) p).getSalariu() + diferenta);
        }
        else if(p instanceof Asistent) {
            ((Asistent) p).setSalariu(((Asistent) p).getSalariu() + diferenta);
        }
    }

    public void adaugaMaterial(String material, int cantintate) {
        if(this.stoc.containsKey(material)) {
            int c = this.stoc.get(material);
            this.stoc.put(material, cantintate + c);
        }
        else {
            this.stoc.put(material, cantintate);
        }
    }

    public void scadeMaterial(String material, int cantitiate) {
        if(this.stoc.containsKey(material)) {
            int c = this.stoc.get(material);
            c -=  cantitiate;
            if(c <= 0) {
                System.out.println("Nu mai exista " + material + " pe stoc.");
                this.stoc.put(material, 0);
            }
            else {
                this.stoc.put(material, c);
            }

        }
        else {
            System.out.println("Nu exista acest material!");
        }
    }

    public void afiseazaStoc() {
        for(String material : this.stoc.keySet()) {
            System.out.println(material + " -> " + this.stoc.get(material));
        }
    }

    public void afiseazaMaterial(String material) {
        if(this.stoc.containsKey(material))
            System.out.println("Au mai ramas " + this.stoc.get(material) + "x " + material);
        else
            System.out.println("Cabinetul nu are acest material.");
    }

    public void sorteazaNume() {
        this.doctori.sort(null);
    }

    public void sorteazaNrPacienti() {
        NrPacientiComparator comp = new NrPacientiComparator();
        this.doctori.sort(comp);
    }

    public void sorteazaNota() {
        NotaComparator comp = new NotaComparator();
        this.doctori.sort(comp);
    }

    public void afiseazaDoctori() {
        for(Doctor d : this.doctori) {
            System.out.println(d);
        }
    }

    public void afiseazaAsistenti() {
        for(Asistent a : this.asistenti) {
            System.out.println(a);
        }
    }

    public void afiseazaSalariu(Persoana persoana) {
        if(persoana instanceof Doctor) {
            System.out.println("Doctorul " + persoana.getNumeComplet() + " castiga " + ((Doctor) persoana).getSalariu() + " de lei.");
        }
        else if(persoana instanceof Asistent) {
            System.out.println("Asistentul " + persoana.getNumeComplet() + " castiga " + ((Asistent) persoana).getSalariu() + " de lei.");
        }
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
}
