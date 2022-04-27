package comparatori;

import entitate.personal.Doctor;

import java.util.Comparator;

public class NotaComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor o1, Doctor o2) {
        return -Double.compare(o1.getNota(), o2.getNota());
    }

}