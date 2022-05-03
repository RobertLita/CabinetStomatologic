package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Audit {
    private static Audit instance;
    Audit(){}
    public static Audit getInstance() {
        if(instance == null){
            instance = new Audit();
        }
        return instance;
    }
    public void scrieAudit(String actiune) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("data/audit.csv", true))){
            String line = '\n' + actiune + ", " + Calendar.getInstance().getTime();
            out.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
