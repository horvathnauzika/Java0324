package hu.szamalk;

import hu.szamalk.modell.Szak;
import hu.szamalk.modell.Tantargy;
import java.util.List;

public class Main {

    static List<Tantargy> tantargyak;

    public static void main(String[] args) {
        Szak szak = new Szak("Infó");
        szak.szakKiirasa();
        szak.szakBeolvasas();

        Tantargy t = new Tantargy("t", 3,1);
        t.compareTo((Tantargy) tantargyak);
        tantargyak.sort(((Tantargy) tantargyak).rendezKredit());
    }
}