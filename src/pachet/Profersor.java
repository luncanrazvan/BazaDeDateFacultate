package pachet;

import java.util.HashSet;

public class Profersor extends Persoana implements Comparable<Profersor> {

    private HashSet<String> materii;

    public Profersor(String nume){
        super(nume);
        this.materii=new HashSet<>();
    }

    public String getNume(){
        return super.getNume();
    }

    public String afiseazaMateriile(){
        String mat="";
        for(String materie: materii){
            mat+=materie+"\n";
        }
        return mat;
    }

    public HashSet<String> getMaterii(){
        return materii;
    }

    public int compareTo(Profersor p){
        return this.getNume().compareTo(p.getNume());
    }

}
