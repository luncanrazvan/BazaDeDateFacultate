package pachet;

import java.util.HashMap;

public class Student extends Persoana implements Comparable<Student> {

    private HashMap<String,Integer> materiiCuNote;
    private float avg;

    public Student(String nume){
        super(nume);
        this.materiiCuNote=new HashMap<>();
    }

    public HashMap<String,Integer> getMateriiCuNote(){
        return materiiCuNote;
    }

    @Override
    public int compareTo(Student o) {
        if(this.avg<=o.avg){
            return 1;
        }else{
            return 0;
        }
    }

    public float getAvg(){
        return avg;
    }

    public float setAvg(float nr){
        return this.avg=nr;
    }
}
