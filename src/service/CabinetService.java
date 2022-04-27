package service;

import comparatori.NotaComparator;
import comparatori.NrPacientiComparator;
import entitate.cabinet.Cabinet;
import entitate.personal.Asistent;
import entitate.personal.Doctor;
import entitate.personal.Persoana;
import java.util.List;
import java.util.Map;


public class CabinetService implements ICabinetService {
    @Override
    public void adaugaPersonal(Cabinet cabinet, Persoana persoana) {
        List<Doctor> doctori = cabinet.getDoctori();
        List<Asistent> asistenti = cabinet.getAsistenti();
        if(persoana instanceof Doctor) {
            doctori.add((Doctor) persoana);
        }
        else if(persoana instanceof Asistent) {
            asistenti.add((Asistent) persoana);
        }
    }

    @Override
    public void stergePersonal(Cabinet cabinet, Persoana persoana) {
        List<Doctor> doctori = cabinet.getDoctori();
        List<Asistent> asistenti = cabinet.getAsistenti();
        if(persoana instanceof Doctor) {
            doctori.remove((Doctor) persoana);
        }
        else if(persoana instanceof Asistent) {
            asistenti.remove((Asistent) persoana);
        }
    }

    @Override
    public void afiseazaDoctori(Cabinet cabinet) {
        List<Doctor> doctori = cabinet.getDoctori();
        for(Doctor d : doctori) {
            System.out.println(d);
        }
    }

    @Override
    public void afiseazaAsistenti(Cabinet cabinet) {
        List<Asistent> asistenti = cabinet.getAsistenti();
        for(Asistent a : asistenti) {
            System.out.println(a);
        }
    }

    @Override
    public void sorteazaNume(Cabinet cabinet) {
        List<Doctor> doctori = cabinet.getDoctori();
        doctori.sort(null);
    }

    @Override
    public void sorteazaNrPacienti(Cabinet cabinet) {
        List<Doctor> doctori = cabinet.getDoctori();
        NrPacientiComparator comp = new NrPacientiComparator();
        doctori.sort(comp);
    }

    @Override
    public void sorteazaNota(Cabinet cabinet) {
        List<Doctor> doctori = cabinet.getDoctori();
        NotaComparator comp = new NotaComparator();
        doctori.sort(comp);
    }

    @Override
    public void modificaSalarius(Cabinet cabinet, Persoana persoana, int diferenta) {
        if(persoana instanceof Doctor) {
            ((Doctor) persoana).setSalariu(((Doctor) persoana).getSalariu() + diferenta);
        }
        else if(persoana instanceof Asistent) {
            ((Asistent) persoana).setSalariu(((Asistent) persoana).getSalariu() + diferenta);
        }
    }

    @Override
    public void adaugaMateriale(Cabinet cabinet, String material, int cantitate) {
        Map<String, Integer> stoc = cabinet.getStoc();
        if(stoc.containsKey(material)) {
            int c = stoc.get(material);
            stoc.put(material, cantitate + c);
        }
        else {
            stoc.put(material, cantitate);
        }
    }

    @Override
    public void scadeMateriale(Cabinet cabinet, String material, int cantitate) {
        Map<String, Integer> stoc = cabinet.getStoc();
        if(stoc.containsKey(material)) {
            int c = stoc.get(material);
            c -= cantitate;
            if(c <= 0) {
                System.out.println("Nu mai exista " + material + " pe stoc.");
                stoc.put(material, 0);
            }
            else {
                stoc.put(material, c);
            }
        }
        else {
            System.out.println("Nu exista acest material!");
        }
    }

    @Override
    public void afiseazaStoc(Cabinet cabinet) {
        Map<String, Integer> stoc = cabinet.getStoc();
        for(String material : stoc.keySet()) {
            System.out.println(material + " -> " + stoc.get(material));
        }
    }

    @Override
    public void afiseazaMaterial(Cabinet cabinet, String material) {
        Map<String, Integer> stoc = cabinet.getStoc();
        if(stoc.containsKey(material))
            System.out.println("Au mai ramas " + stoc.get(material) + "x " + material);
        else
            System.out.println("Cabinetul nu are acest material.");
    }

    @Override
    public void afiseazaSalariu(Cabinet cabinet, Persoana persoana) {
        if(persoana instanceof Doctor) {
            System.out.println("Doctorul " + persoana.getNumeComplet() + " castiga " + ((Doctor) persoana).getSalariu() + " de lei.");
        }
        else if(persoana instanceof Asistent) {
            System.out.println("Asistentul " + persoana.getNumeComplet() + " castiga " + ((Asistent) persoana).getSalariu() + " de lei.");
        }
    }
}
