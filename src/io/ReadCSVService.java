package io;

import entitate.personal.Asistent;
import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Diagnostic;
import entitate.programare.Tratament;
import exceptii.WrongObjectType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVService {
    private static ReadCSVService instance;

    private ReadCSVService() {}

    public static ReadCSVService getInstance() {
        if(instance == null) {
            instance = new ReadCSVService();
        }
        return instance;
    }

    public <T> List<T> citesteCSV(String path, String objectName) {
        List<T> date = new ArrayList<>();
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine(); // prima linie care contine denumirile coloanelor; o ignoram
            while ((line = in.readLine()) != null) {
                String[] obj = line.split(",");
                for(int i = 0 ; i < obj.length; i++)
                    obj[i] = obj[i].trim();
                rows.add(obj);
            }
            if(objectName.equalsIgnoreCase("Doctor")){
                for(var object : rows){
                    Doctor d = new Doctor(object[0], object[1], object[2]);
                    date.add((T) d);
                }
            }
            else if(objectName.equalsIgnoreCase("Asistent")){
                for(var object : rows){
                    Asistent a = new Asistent(object[0], object[1], object[2]);
                    date.add((T) a);
                }
            }
            else if(objectName.equalsIgnoreCase("Tratament")){
                for(var object : rows){
                    Tratament a = new Tratament(object[0], Integer.parseInt(object[1]), Integer.parseInt(object[2]), object[3]);
                    date.add((T) a);
                }
            }
            else if(objectName.equalsIgnoreCase("Pacient")){
                for(var object : rows){
                    Pacient p = new Pacient(object[0], object[1], object[2]);
                    date.add((T) p);
                }
            }
            else if(objectName.equalsIgnoreCase("Diagnostic")){
                for(var object : rows){
                    Diagnostic d = new Diagnostic(object[0]);
                    date.add((T) d);
                }
            }
            else throw new WrongObjectType("Tipul obiectelor care trebuie citite nu exista.");
        } catch (IOException | WrongObjectType e) {
            e.printStackTrace();
        }
        return date;
    }

}
