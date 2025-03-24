package hu.szamalk.modell;

import java.io.*;
import java.text.Collator;
import java.util.UUID;

public class Szak implements Serializable{
    private String nev;
    private transient UUID id;

    public Szak(String nev) {
        this.nev = nev;
        idGeneralas();
        Tantargy t = new Tantargy("t",3, 2);
        t.tantargyakBeolvasas();
    }

    public void idGeneralas(){
        id = UUID.randomUUID();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void szakBeolvasas(){
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("targyak.dat"))){
            Szak sz = null;
            try {
                sz = (Szak) objBe.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            sz.idGeneralas();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void szakKiirasa(){
        Szak szak = new Szak("Informatika");
        try(ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("targyak.dat"))){
            objKi.writeObject(szak);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void statitsztika(){

    }

    @Override
    public String toString() {
        return "Szak{" +
                "nev='" + nev + '\'' +
                ", id=" + id +
                '}';
    }
}
