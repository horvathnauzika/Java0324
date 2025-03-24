package hu.szamalk.modell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Tantargy implements Comparable<Tantargy>{
    public String nev;
    public int kredit, felev;

    public Tantargy(String nev, int kredit, int felev) {
        this.nev = nev;
        this.kredit = kredit;
        this.felev = felev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tantargy tantargy = (Tantargy) o;
        return kredit == tantargy.kredit && felev == tantargy.felev && Objects.equals(nev, tantargy.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, kredit, felev);
    }

    public String getNev() {
        return nev;
    }

    public int getKredit() {
        return kredit;
    }

    public int getFelev() {
        return felev;
    }

    @Override
    public int compareTo(Tantargy masik) {
        // Névsorba:
        Collator coll = Collator.getInstance();
        return coll.compare(this.nev, masik.nev);
    }

    public static KreditComparator rendezKredit(){
        return new KreditComparator();
    }

    private static class KreditComparator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            return egyik.kredit - masik.kredit;
        }
    }

    public void tantargyakBeolvasas(){
        String tantargyak = "tantargyak.txt";
        try {
            List<String> sorok = Files.readAllLines(Path.of(tantargyak));
            sorok.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Hiba a fájl beolvasása közben" + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "nev='" + nev + '\'' +
                ", kredit=" + kredit +
                '}';
    }
}
