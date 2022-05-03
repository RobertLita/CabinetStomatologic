package service;

import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Programare;

import java.util.Calendar;
import java.util.Queue;

public class DoctorService implements IDoctorService {


    @Override
    public void afiseazaProgramare(Doctor doctor) {
        Queue<Programare> programari = doctor.getProgramari();
        if(programari.isEmpty()){
            System.out.println("Nu exista nicio progrmare");
            return;
        }
        System.out.println(programari.peek());
        audit.scrieAudit("afiseazaProgramare");
    }

    @Override
    public void afiseazaProgramari(Doctor doctor) {
        Queue<Programare> programari = doctor.getProgramari();
        for(Programare p : programari) {
            System.out.println(p);
        }
        audit.scrieAudit("afiseazaProgramari");
    }

    @Override
    public void eliminaProgramare(Doctor doctor) {
        Queue<Programare> programari = doctor.getProgramari();
        programari.remove();
        audit.scrieAudit("eliminaProgramare");
    }

    @Override
    public void afiseazaProgramariAzi(Doctor doctor) {
        Calendar c = Calendar.getInstance();
        Queue<Programare> programari = doctor.getProgramari();
        for(Programare p : programari) {
            if(p.getData().get(Calendar.DAY_OF_MONTH) != c.get(Calendar.DAY_OF_MONTH))
                break;
            System.out.println(p);
        }
        audit.scrieAudit("afiseazaProgramariAzi");
    }

    @Override
    public void adaugaPrimaProgramare(Doctor doctor, Pacient pacient, int zi, int luna, int an, int ora, int minut, String subiect) {
        Programare programareNoua = new Programare(zi, luna, an, ora, minut, pacient, subiect);
        Queue<Programare> programari = doctor.getProgramari();
        programari.add(programareNoua);
        pacient.setProgramare(programareNoua);
        audit.scrieAudit("adaugaPrimaProgramare");
    }

    @Override
    public void adaugaUrmProgramare(Doctor doctor, String subiect, int zilePeste) {
        Queue<Programare> programari = doctor.getProgramari();
        Programare programareNoua = new Programare();
        Programare programareCurenta = programari.peek();
        if(programareCurenta == null) {
            return;
        }
        Pacient p = programareCurenta.getPacient();
        Calendar dataNoua = programareCurenta.getData();
        dataNoua.add(Calendar.DATE, zilePeste);
        programareNoua.setData(dataNoua);
        programareNoua.setSubiect(subiect);
        programareNoua.setPacient(p);
        p.setProgramare(programareNoua);
        programari.add(programareNoua);
        audit.scrieAudit("adaugaUrmProgramare");
    }
}
