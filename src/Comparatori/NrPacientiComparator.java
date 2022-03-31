package Comparatori;

import Personal.Doctor;

import java.util.Comparator;

public class NrPacientiComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o2.getNrPacienti() - o1.getNrPacienti();
    }
}
