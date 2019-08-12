package pachet;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Model {

    public int numarulDeProfesori(ArrayList<Profersor> profersors){
        return profersors.size();
    }

    public int numarulDeXProfesori(ArrayList<Profersor> profersors,int nr){
        int nr1=0;
        for(Profersor profersor :profersors){
            if(profersor.getMaterii().size()==nr){
                nr1++;
            }
        }
        return nr1;
    }

    public int numarulDeStudenti(ArrayList<Student> students){
        return students.size();
    }

    public void average(ArrayList<Student> students){
        for(Student student:students){
            float nr=0;
            for(Integer integer:student.getMateriiCuNote().values()){
                nr+=integer;
            }
            nr/=student.getMateriiCuNote().size();
            student.setAvg(nr);
        }
    }

    public int numarulDeMaterii(HashSet<String> materii){
        return materii.size();
    }

    public int nrBursa(ArrayList<Student> students){
        int nr=0;
        for(Student student:students){
            if(student.getAvg()>8.50){
                nr++;
            }
        }
        return nr;
    }

    public int numarulDeRestantieri(ArrayList<Student> students){
        int rest=0;
        for(Student student:students){
            for(Integer integer:student.getMateriiCuNote().values()){
                if(integer<5){
                    rest++;
                    break;
                }
            }
        }
        return rest;
    }

}
