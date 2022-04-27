package service;

import entitate.personal.Doctor;
import entitate.personal.Pacient;
import entitate.programare.Programare;
import entitate.programare.Tratament;


public class PacientService implements IPacientService{
    @Override
    public void afiseazaTotalPlata(Pacient pacient) {
        int totalPlata = pacient.getTotalPlata();
        if(totalPlata == 0) {
            System.out.println("Pacientul " + pacient.getNumeComplet() + " nu are nimic de platit.");
            return;
        }
        System.out.println("Pacientul " + pacient.getNumeComplet() + " are de platit " + totalPlata + " de lei.");
    }

    @Override
    public void afiseazaProgramare(Pacient pacient) {
        Programare programare = pacient.getProgramare();
        if(programare == null){
            System.out.println("Pacientul nu are nicio programare.");
            return;
        }
        System.out.println(programare);
    }

    @Override
    public void afiseazaRecomandari(Pacient pacient) {
        Tratament tratament = pacient.getTratament();
        if(tratament == null) {
            System.out.println("Pacientul nu are niciun tratament.");
            return;
        }
        if(tratament.getRecomandari().equals("")){
            System.out.println("Pacientul nu are nicio recomandare");
            return;
        }
        System.out.println("Pentru " + pacient.getNumeComplet() + ", recomandarea este sa " + tratament.getRecomandari());
    }

    @Override
    public void oferaNota(Pacient pacient, double nota) {
        Doctor doctor = pacient.getDoctor();
        int nrPacienti = doctor.getNrPacienti() + 1;
        doctor.setNrPacienti(nrPacienti);
        double n = doctor.getNota();
        n = (n + nota) / nrPacienti;
        doctor.setNota(n);
    }
}
