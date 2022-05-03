package io;

import entitate.personal.Asistent;
import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Tratament;
import exceptii.WrongObjectType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class WriteCSVService {

    private static WriteCSVService instance;

    private WriteCSVService() {}

    public static WriteCSVService getInstance() {
        if(instance == null) {
            instance = new WriteCSVService();
        }
        return instance;
    }

    public <T> void scrieCSV(T object, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            String line = "\n";
            if(object instanceof Doctor) {
                Doctor d = (Doctor) object;
                line += d.getNume() + ", " + d.getPrenume() + ", " + d.getCnp() + ", " + d.getNrPacienti() + ", " +d.getSalariu();
                out.write(line);
            }
            else if(object instanceof Asistent) {
                Asistent a = (Asistent) object;
                line += a.getNume() + ", " + a.getPrenume() + ", " + a.getCnp() + ", " + a.getSalariu();
                out.write(line);
            }
            else if(object instanceof Pacient) {
                Pacient p = (Pacient) object;
                line += p.getNume() + ", " + p.getPrenume() + ", " + p.getCnp() + ", " + p.getTotalPlata();
                out.write(line);
            }
            else if(object instanceof Tratament) {
                Tratament t = (Tratament) object;
                line += t.getNume() + ", " + t.getDurata() + ", " + t.getCost() + ", " + t.getRecomandari();
                out.write(line);
            }
            else throw new WrongObjectType("Obiectul dat nu poate fi scris in fisier.");
        } catch (IOException | WrongObjectType e) {
            e.printStackTrace();
        }
    }
}
