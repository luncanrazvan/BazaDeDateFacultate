package pachet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Controller {

    private View view;
    private Model model;
    private ArrayList<Profersor> profersors;
    private ArrayList<Student> students;
    private HashSet<String> materii;
    private String nuAtiIntrodusToateDatele="Nu ati introdus toate datele!";
    private String nuAtiIntrodusUnNumar="Nu ati introudus un numar.";
    private String nuExistaProfPredMat="Nu exista profesor care sa predea aceasta materie!";
    private String atAlesActGresita="Ati ales actiunea gresita!";
    private String nuExistaAcestProf="Nu exista acest profesor in facultate!";
    private String nuExistaAcestStud="Nu exista acest student";
    private String profesoriiCarePredauAceastaMateie="Profesorii care predau aceasta materie sunt:\n";
    private String profesorulSelectatPredaMateriile="Profesorul selectat preda materiile:\n";
    private String areNotele=" are notele:\n";
    private String studentiiCareAuAceastaNotaSunt="Studentii care au aceasta nota sunt:\n";
    private String niciunStudentNuAreNotaAsta="Niciun stundent nu are nota asta.";
    private String nuAtiIntrodusUnNumePentruProfesor="Nu ati introdus un nume pentru profesor!";
    private String nuAtiIntrodusUnNumePentruStudent="Nu ati introdus un nume pentru student!";
    private String nuAtiIntrodusUnNumePentruMaterie="Nu ati introdus un nume pentru materie!";
    private String numarulDeProfesoriDinFacultateEsteDe="Numarul de profesori din facultate este de: ";
    private String numarulDeStudentiDinFacultateEsteDe="Numarul de studenti din facultate este de ";
    private String numarulDeMateriiCareSePredaLaFacultateEsteDe="Numarul de materii care se preda la facultate este de ";
    private String top5Studenti="Cei top 5 studenti sunt:\n";
    private String numarulDeStudentiCuRestanta="Numarul de studenti cu restante este de ";
    private String resetBD="S-a resetat baza de date!";
    private String numarulDeProfesoriCarePredau="Numarul de profesori care predau ";
    private String materiiEsteDe=" materii este de ";
    private String nuExistaProfCareSaPredea="Nu exista profesor care sa predea ";
    private String materiiString=" materii.";
    private String studentiiCuBursaSunt="Numarul de studenti cu bursa este: ";

    public Controller(View view,Model model){
        this.view=view;
        this.model=model;
        view.oprireTimerAction(new OprireLogo());
        view.setDarkThemeAction(new setDarkTheme());
        view.butonSetare(new butonSeteaza());
        view.butonAfisare(new butonAfiseaza());
        view.butonSterge(new butonSterge());
        view.CBProfesor(new CBProf());
        view.CBStudenti(new CBStudent());
        view.CBMaterii(new CBMaterie());
        view.MProfesor(new MProfSel());
        view.MMaterie(new MMatSel());
        view.MStudent(new MStudSel());
        view.MNota(new MNotSel());
        view.AReseteaza(new Reseteaza());
        view.actiunePentruCombo(new alegeActiune());
        view.actiunePentruProfi(new SProfSel());
        view.actiunePentruXProfi(new SProfXSel());
        view.actiunePentruNrStudenti(new SStudSel());
        view.actiuneNrMaterii(new SMatSel());
        view.actiuneTop5Student(new Stop5Sel());
        view.actiuneEnter(new apasaEnter());
        view.englezaSelect(new steagEngleza());
        view.romanaSelect(new steagRomana());
        view.actiuneRestantieri(new SnrRest());
        view.actiuneBursieri(new SnrBur());
        this.profersors=new ArrayList<>();
        this.students=new ArrayList<>();
        this.materii=new HashSet<>();
    }

    public class OprireLogo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getOprireLogo().isSelected()){
                view.getTimer().stop();
            }else{
                view.getTimer().start();
            }
        }
    }

    public class setDarkTheme implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getSetDarkTheme().isSelected()){
                view.getCelDinEst().setBackground(Color.BLACK);
                view.getCelDinNord().setBackground(Color.BLACK);
                view.getCelDinCentruYAxis().setBackground(Color.BLACK);
                view.getSetariLaLogo().setBackground(Color.BLACK);
                view.getCelDinSud().setBackground(Color.BLACK);
                view.getContents().setBackground(Color.BLACK);
                view.getSetariBackground().setBackground(Color.BLACK);
                view.getCelDinVest().setBackground(Color.BLACK);
                view.getScrieMaterie().setBackground(Color.BLACK);
                view.getScrieNota().setBackground(Color.BLACK);
                view.getScrieProfesor().setBackground(Color.BLACK);
                view.getScrieStudent().setBackground(Color.BLACK);
                view.getCheckBoxuriStergereProf().setBackground(Color.BLACK);
                view.getCheckProf().setBackground(Color.BLACK);
                view.getCheckBoxuriStergereStudent().setBackground(Color.BLACK);
                view.getChechBoxuriStergereMaterie().setBackground(Color.BLACK);
            }else{
                view.getCelDinEst().setBackground(Color.gray);
                view.getCelDinNord().setBackground(Color.gray);
                view.getCelDinCentruYAxis().setBackground(Color.gray);
                view.getSetariLaLogo().setBackground(Color.gray);
                view.getCelDinSud().setBackground(Color.gray);
                view.getContents().setBackground(Color.gray);
                view.getSetariBackground().setBackground(Color.gray);
                view.getCelDinVest().setBackground(Color.gray);
                view.getScrieMaterie().setBackground(Color.gray);
                view.getScrieNota().setBackground(Color.gray);
                view.getScrieProfesor().setBackground(Color.gray);
                view.getScrieStudent().setBackground(Color.gray);
                view.getCheckBoxuriStergereProf().setBackground(Color.gray);
                view.getCheckBoxuriStergereProf().setBackground(Color.gray);
                view.getCheckProf().setBackground(Color.gray);
                view.getCheckBoxuriStergereStudent().setBackground(Color.gray);
                view.getChechBoxuriStergereMaterie().setBackground(Color.gray);
            }
        }
    }

    public class butonSeteaza implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getAlegeri().getSelectedIndex()==3) {
                if(view.getProfesorCB().isSelected()){
                    if ((view.getScrieProfesor().getText().isEmpty() || view.getScrieMaterie().getText().isEmpty())) {
                        view.showJOptionPane(nuAtiIntrodusToateDatele);
                    } else {
                        boolean found=false;
                        for(Profersor profersor:profersors){
                            if(profersor.getNume().equals(view.getScrieProfesor().getText())){
                                found=true;
                                profersor.getMaterii().add(view.getScrieMaterie().getText());
                                materii.add(view.getScrieMaterie().getText());
                            }
                        }
                        if(!found){
                            Profersor profersor=new Profersor(view.getScrieProfesor().getText());
                            profersor.getMaterii().add(view.getScrieMaterie().getText());
                            materii.add(view.getScrieMaterie().getText());
                            profersors.add(profersor);
                        }
                    }
                    for(Profersor profersor:profersors){
                        System.out.println(profersor.getMaterii());
                    }

                }
                if(view.getStudentCB().isSelected()){
                    if(view.getScrieStudent().getText().isEmpty() || view.getScrieMaterie().getText().isEmpty() || view.getScrieNota().getText().isEmpty()){
                        view.showJOptionPane(nuAtiIntrodusToateDatele);
                    }else{
                        boolean exists=false;
                        for(Profersor profersor :profersors){
                            for(String materii:profersor.getMaterii()){
                                if(materii.equals(view.getScrieMaterie().getText())){
                                    exists=true;
                                }
                            }
                        }
                        if(exists){
                            boolean found=false;
                            for(Student student:students){
                                if(student.getNume().equals(view.getScrieStudent().getText())){
                                    found=true;
                                    try{
                                        int nrnot=Integer.parseInt(view.getScrieNota().getText());
                                        if(nrnot>=1 && nrnot<=10){
                                            student.getMateriiCuNote().put(view.getScrieMaterie().getText(),nrnot);
                                            model.average(students);
                                        }else{
                                            view.showJOptionPane("Error");
                                        }
                                    }catch (Exception ex){
                                        view.showJOptionPane(nuAtiIntrodusUnNumar);
                                    }
                                }
                            }
                            if(!found){
                                try{
                                    int nrnot=Integer.parseInt(view.getScrieNota().getText());
                                    if(nrnot>=1 && nrnot<=10){
                                        Student student=new Student(view.getScrieStudent().getText());
                                        student.getMateriiCuNote().put(view.getScrieMaterie().getText(),nrnot);
                                        students.add(student);
                                        model.average(students);
                                    }else{
                                        view.showJOptionPane("Error ");
                                    }
                                }catch (Exception ex1){
                                    view.showJOptionPane(nuAtiIntrodusUnNumar);
                                }

                            }
                        }else {
                            view.showJOptionPane(nuExistaProfPredMat);
                        }

                    }
                    for(Student student:students){
                        System.out.println(student.getMateriiCuNote());
                    }
                }
                if(view.getMaterieCB().isSelected()){
                    if((view.getScrieProfesor().getText().isEmpty() || view.getScrieMaterie().getText().isEmpty())){
                        view.showJOptionPane(nuAtiIntrodusToateDatele);
                    }else{
                        boolean found=false;
                        for(Profersor profersor:profersors){
                            if(profersor.getNume().equals(view.getScrieProfesor().getText())){
                                found=true;
                                profersor.getMaterii().add(view.getScrieMaterie().getText());
                            }
                        }
                        if(!found){
                            Profersor profersor=new Profersor(view.getScrieProfesor().getText());
                            profersor.getMaterii().add(view.getScrieMaterie().getText());
                            profersors.add(profersor);
                        }
                    }
                }

            }else{
                view.showJOptionPane(atAlesActGresita);
            }
        }
    }

    public class butonAfiseaza implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getAlegeri().getSelectedIndex()==2){
                //Daca noi cautam profesorii care predau o anumita materie
                if(view.getProfesor().isSelected()){
                    view.getScrieProfesor().setEditable(false);
                    view.getScrieStudent().setEditable(false);
                    view.getScrieMaterie().setEditable(true);
                    view.getScrieNota().setEditable(false);
                    int ok=0;
                    String ceva=profesoriiCarePredauAceastaMateie;
                    for(Profersor profersor:profersors){
                        if(profersor.getMaterii().contains(view.getScrieMaterie().getText())){
                            ok=1;
                            ceva+=profersor.getNume()+"\n";
                        }
                    }
                    if(ok==0){
                        view.showJOptionPane(nuExistaProfPredMat);
                    }else{
                        view.showJOptionPane(ceva);
                    }
                }
                //Daca noi cautam materii si vrem sa vedem profesorii
                if(view.getMaterie().isSelected()){
                    view.getScrieProfesor().setEditable(true);
                    view.getScrieStudent().setEditable(false);
                    view.getScrieMaterie().setEditable(false);
                    view.getScrieNota().setEditable(false);
                    String ceva=profesorulSelectatPredaMateriile;
                    int ok=0;
                    for(Profersor profersor:profersors){
                        if(profersor.getNume().equals(view.getScrieProfesor().getText())){
                            ok=1;
                            ceva+=profersor.afiseazaMateriile();
                        }
                    }
                    if(ok==0){
                        view.showJOptionPane(nuExistaAcestProf);
                    }else{
                        view.showJOptionPane(ceva);
                    }
                }
                //Cautam un student si afisam materiile pe care le invata si afisam si notele materiilor
                if(view.getStudent().isSelected()){
                    view.getScrieProfesor().setEditable(false);
                    view.getScrieStudent().setEditable(true);
                    view.getScrieMaterie().setEditable(false);
                    view.getScrieNota().setEditable(false);
                    String ceva=view.getScrieStudent().getText()+areNotele;
                    int ok=0;
                    for(Student student:students){
                        if(student.getNume().equals(view.getScrieStudent().getText())) {
                            ok = 1;
                            for (String sir : student.getMateriiCuNote().keySet()) {
                                ceva += sir + " " + student.getMateriiCuNote().get(sir) + "\n";
                            }
                        }
                    }
                    if(ok==0){
                        view.showJOptionPane(nuExistaAcestStud);
                    }else{
                        view.showJOptionPane(ceva);
                    }
                }
                if(view.getNota().isSelected()) {
                    view.getScrieProfesor().setEditable(false);
                    view.getScrieStudent().setEditable(false);
                    view.getScrieMaterie().setEditable(false);
                    view.getScrieNota().setEditable(true);
                    String ceva = studentiiCareAuAceastaNotaSunt;
                    int ok = 0;
                    for (Student student : students) {
                        for (Integer note : student.getMateriiCuNote().values()) {
                            if (note==Integer.parseInt(view.getScrieNota().getText())){
                                ok=1;
                                for(String sir:student.getMateriiCuNote().keySet()){
                                    if(student.getMateriiCuNote().get(sir)==Integer.parseInt(view.getScrieNota().getText())){
                                        ceva+=student.getNume()+" "+sir+"\n";
                                    }
                                }

                            }
                        }
                    }
                    if(ok==0){
                        view.showJOptionPane(niciunStudentNuAreNotaAsta);
                    }else{
                        view.showJOptionPane(ceva);
                    }
                }
            }else{
                view.showJOptionPane(atAlesActGresita);
            }
        }
    }

    public class butonSterge implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getAlegeri().getSelectedIndex()==1){
                if(view.getProfesorCB().isSelected()) {
                    if (view.getScrieProfesor().getText().isEmpty()) {
                        view.showJOptionPane(nuAtiIntrodusUnNumePentruProfesor);
                    } else {
                        for (int i = 0; i < profersors.size(); i++) {
                            if (profersors.get(i).getNume().equals(view.getScrieProfesor().getText())) {
                                profersors.remove(i);
                            }
                        }
                    }
                }
                if(view.getStudentCB().isSelected()){
                    if(view.getScrieStudent().getText().isEmpty()){
                        view.showJOptionPane(nuAtiIntrodusUnNumePentruStudent);
                    }else{
                        for(int i=0; i<students.size(); i++){
                            if(students.get(i).getNume().equals(view.getScrieStudent().getText())){
                                students.remove(i);
                            }
                        }
                    }
                }
                if(view.getMaterieCB().isSelected()){
                    if(view.getScrieMaterie().getText().isEmpty()){
                        view.showJOptionPane(nuAtiIntrodusUnNumePentruMaterie);
                    }else{
                        for(Profersor profersor:profersors){
                            for(String sir:profersor.getMaterii()){
                                if(sir.equals(view.getScrieMaterie().getText())){
                                    profersor.getMaterii().remove(view.getScrieMaterie().getText());
                                }
                            }
                        }
                        for(Student student:students){
                            if(student.getMateriiCuNote().containsKey(view.getScrieMaterie().getText())){
                                student.getMateriiCuNote().remove(view.getScrieMaterie().getText());
                            }
                        }
                    }
                }
            }
        }
    }

    public class CBProf implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getProfesorCB().isSelected() && view.getAlegeri().getSelectedIndex()==3){
                view.getProfesorCB().setSelected(true);
                view.getStudentCB().setSelected(false);
                view.getMaterieCB().setSelected(false);
                view.getScrieProfesor().setEditable(true);
                view.getScrieStudent().setEditable(false);
                view.getScrieMaterie().setEditable(true);
                view.getScrieNota().setEditable(false);
            }
            if(view.getProfesorCB().isSelected() && view.getAlegeri().getSelectedIndex()==2){
                view.getProfesorCB().setSelected(true);
                view.getStudentCB().setSelected(false);
                view.getMaterieCB().setSelected(false);
                view.getScrieProfesor().setEditable(true);
                view.getScrieStudent().setEditable(false);
                view.getScrieMaterie().setEditable(false);
                view.getScrieNota().setEditable(false);
            }

        }
    }

    public class CBStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getStudentCB().isSelected()){
                view.getStudentCB().setSelected(true);
                view.getMaterieCB().setSelected(false);
                view.getProfesorCB().setSelected(false);
                view.getScrieProfesor().setEditable(false);
                view.getScrieStudent().setEditable(true);
                view.getScrieMaterie().setEditable(true);
                view.getScrieNota().setEditable(true);

            }
        }
    }

    public class CBMaterie implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getMaterieCB().isSelected()){
                view.getMaterieCB().setSelected(true);
                view.getProfesorCB().setSelected(false);
                view.getStudentCB().setSelected(false);
                view.getScrieProfesor().setEditable(true);
                view.getScrieStudent().setEditable(false);
                view.getScrieMaterie().setEditable(true);
                view.getScrieNota().setEditable(false);
            }
        }
    }

    public class MProfSel implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(view.getProfesor().isSelected()){
                view.getMaterie().setSelected(false);
                view.getStudent().setSelected(false);
                view.getNota().setSelected(false);
                view.getScrieProfesor().setEditable(true);
                view.getScrieNota().setEditable(false);
                view.getScrieMaterie().setEditable(false);
                view.getScrieStudent().setEditable(false);
            }
        }
    }

    public class MStudSel implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (view.getStudent().isSelected()){
                view.getStudent().setSelected(true);
                view.getMaterie().setSelected(false);
                view.getProfesor().setSelected(false);
                view.getNota().setSelected(false);
                view.getScrieProfesor().setEditable(false);
                view.getScrieNota().setEditable(false);
                view.getScrieMaterie().setEditable(false);
                view.getScrieStudent().setEditable(true);
            }
        }
    }

    public class MMatSel implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (view.getMaterie().isSelected()) {
               view.getMaterie().setSelected(true);
                view.getProfesor().setSelected(false);
                view.getStudent().setSelected(false);
                view.getNota().setSelected(false);
                view.getScrieProfesor().setEditable(false);
                view.getScrieNota().setEditable(false);
                view.getScrieMaterie().setEditable(true);
                view.getScrieStudent().setEditable(false);
            }
        }
    }

    public class MNotSel implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (view.getNota().isSelected()) {
                view.getNota().setSelected(true);
                view.getProfesor().setSelected(false);
                view.getStudent().setSelected(false);
                view.getMaterie().setSelected(false);
                view.getScrieProfesor().setEditable(false);
                view.getScrieNota().setEditable(true);
                view.getScrieMaterie().setEditable(false);
                view.getScrieStudent().setEditable(false);
            }
        }
    }

    public class SProfSel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int nr=model.numarulDeProfesori(profersors);
            view.showJOptionPane(numarulDeProfesoriDinFacultateEsteDe+nr);
        }
    }

    public class SProfXSel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getPentruNrMaterii().setVisible(true);
        }
    }

    public class SStudSel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showJOptionPane(numarulDeStudentiDinFacultateEsteDe+model.numarulDeStudenti(students));
        }
    }

    public class SMatSel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showJOptionPane(numarulDeMateriiCareSePredaLaFacultateEsteDe+model.numarulDeMaterii(materii));

        }
    }

    public class Stop5Sel implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(students);
            String rez=top5Studenti;
            if(students.size()>=5){
                for(int i=0; i<5; i++){
                    rez+=students.get(i).getNume()+" "+students.get(i).getAvg()+"\n";
                }
                view.showJOptionPane(rez);
            }else{
                view.showJOptionPane("Error");
            }

        }
    }

    public class SnrRest implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           view.showJOptionPane(numarulDeStudentiCuRestanta+model.numarulDeRestantieri(students));
        }
    }

    public class SnrBur implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showJOptionPane(studentiiCuBursaSunt+model.nrBursa(students));
        }
    }

    public class Reseteaza implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showJOptionPane(resetBD);
            profersors.clear();
            students.clear();
            materii.clear();
        }
    }

    public class alegeActiune implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getAlegeri().getSelectedIndex()==2){
                view.getProfesorCB().setSelected(false);
                view.getStudentCB().setSelected(false);
                view.getMaterieCB().setSelected(false);
                view.getProfesorCB().setEnabled(false);
                view.getStudentCB().setEnabled(false);
                view.getMaterieCB().setEnabled(false);
                view.getScrieProfesor().setEditable(false);
                view.getScrieStudent().setEditable(false);
                view.getScrieMaterie().setEditable(false);
                view.getScrieNota().setEditable(false);
                //view.getProfesor().setSelected(false);
                view.getProfesor().setEnabled(true);
                view.getStudent().setSelected(false);
                view.getStudent().setEnabled(true);
                //view.getMaterie().setSelected(false);
                view.getMaterie().setEnabled(true);
                //view.getNota().setSelected(false);
                view.getNota().setEnabled(true);;
            }
            if(view.getAlegeri().getSelectedIndex()==3) {
                view.getProfesorCB().setEnabled(true);
                view.getStudentCB().setEnabled(true);
                view.getMaterieCB().setEnabled(true);
                view.getProfesor().setSelected(false);
                view.getProfesor().setEnabled(false);
                view.getStudent().setSelected(false);
                view.getStudent().setEnabled(false);
                view.getMaterie().setSelected(false);
                view.getMaterie().setEnabled(false);
                view.getNota().setSelected(false);
                view.getNota().setEnabled(false);
            }
            if(view.getAlegeri().getSelectedIndex()==1){
                view.getProfesorCB().setEnabled(true);
                view.getStudentCB().setEnabled(true);
                view.getMaterieCB().setEnabled(true);
                view.getProfesor().setSelected(false);
                view.getProfesor().setEnabled(false);
                view.getStudent().setSelected(false);
                view.getStudent().setEnabled(false);
                view.getMaterie().setSelected(false);
                view.getMaterie().setEnabled(false);
                view.getNota().setSelected(false);
                view.getNota().setEnabled(false);
            }
        }
    }

    public class apasaEnter implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                try{
                    int nr=Integer.parseInt(view.getTextnumarulDeMaterii().getText());
                    int nr1=model.numarulDeXProfesori(profersors,nr);
                    if(nr1!=0){
                        view.showJOptionPane(numarulDeProfesoriCarePredau+nr+materiiEsteDe+nr1+".");
                    }else{
                        view.showJOptionPane(nuExistaProfCareSaPredea+nr+materiiString);
                    }
                    view.getPentruNrMaterii().setVisible(false);
                }catch (Exception e1){
                    view.showJOptionPane(nuAtiIntrodusUnNumar);
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class steagEngleza implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getNumeProfesor().setText("Professor Name");
            view.getNumeStudent().setText("Student Name   ");
            view.getNumeMaterie().setText("Subject Name    ");
            view.getNumeNota().setText("Grade                  ");
            view.getCheckProf().setText("Professor");
            view.getCheckStud().setText("Student");
            view.getCheckMat().setText("Subject");
            view.getOpresteLogoul().setText("Stop the Logo");
            view.getMeniu().setText("Menu");
            view.getFiltre().setText("Filters");
            view.getStatistici().setText("Statistics");
            view.getNumarulDeProfesori().setText("Get Number Of Professors");
            view.getNumarulXProfesori().setText("Get Number Of X Professors");
            view.getNumarulDeStundeti().setText("Get Number Of Students");
            view.getNumarulDeMaterii().setText("Get number Of Subjects");
            view.getTop5Studenti().setText("Top 5 Students");
            view.getNumarulDeBursieri().setText("Number of students with a scolarship");
            view.getProfesor().setText("Professors");
            view.getStudent().setText("Students");
            view.getMaterie().setText("Subject");
            view.getNota().setText("Grade               ");
            view.getReseteaza().setText("Reset");
            view.getAfiseaza().setText("Show");
            view.getSterge().setText("Delete");
            view.getSeteaza().setText("Apply");
            view.getAlegeri().removeItemAt(3);
            view.getAlegeri().removeItemAt(2);
            view.getAlegeri().removeItemAt(1);
            view.getAlegeri().removeItemAt(0);
            view.getAlegeri().addItem("No action");
            view.getAlegeri().addItem("Delete");
            view.getAlegeri().addItem("Search");
            view.getAlegeri().addItem("Add");
            view.getNumarRestantieri().setText("Number of Students Who Failed An Exam");
            nuAtiIntrodusToateDatele="You Have Not Entered All The Data!";
            nuAtiIntrodusUnNumar="You Have Not Entered a number";
            nuExistaProfPredMat="The is no teacher who teaches this subject.";
            atAlesActGresita="You have chosen the wrong action!";
            nuExistaAcestProf="This professor is not in our university";
            nuExistaAcestStud="This student does not exists!";
            profesoriiCarePredauAceastaMateie="The professors who teach this subject are\n";
            profesorulSelectatPredaMateriile="The selected professor teaches the subjects:\n";
            areNotele=" has the grades:\n";
            studentiiCareAuAceastaNotaSunt="The students who have recieved this grades are:\n";
            niciunStudentNuAreNotaAsta="No student has this grade";
            nuAtiIntrodusUnNumePentruProfesor="You have not entered a name for the teacher!";
            nuAtiIntrodusUnNumePentruStudent="You have not entered a name for the student!";
            nuAtiIntrodusUnNumePentruMaterie="You have not entered a name for the subject!";
            numarulDeProfesoriDinFacultateEsteDe="The number of teachers form this university is: ";
            numarulDeStudentiDinFacultateEsteDe="The number of sudents form this university is: ";
            numarulDeMateriiCareSePredaLaFacultateEsteDe="The number of subjects form this university is: ";
            top5Studenti="The top 5 students are:\n";
            numarulDeStudentiCuRestanta="The number of students who failed an exam is: ";
            resetBD="The database has been reseted!";
            numarulDeProfesoriCarePredau="The number teachers who teach ";
            materiiEsteDe=" subjects is ";
            nuExistaProfCareSaPredea="There is no teacher who teaches a number of ";
            materiiString=" subjects.";
            studentiiCuBursaSunt="The number of students with a scolarhip is: ";
            view.setImageIcon(new ImageIcon("C:/Users/Razvan/Desktop/logo.png"));

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    public class steagRomana implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            view.getNumeProfesor().setText("Nume Profesor");
            view.getNumeStudent().setText("Nume Student ");
            view.getNumeMaterie().setText("Nume Materie  ");
            view.getNumeNota().setText("Nota                  ");
            view.getCheckProf().setText("Profesor");
            view.getCheckStud().setText("Student");
            view.getCheckMat().setText("Materie");
            view.getOpresteLogoul().setText("Opreste Logo-ul");
            view.getMeniu().setText("Meniu");
            view.getFiltre().setText("Filtre");
            view.getStatistici().setText("Statistici");
            view.getNumarulDeProfesori().setText("Numarul de Profesori");
            view.getNumarulXProfesori().setText("Numarul de X Profesori");
            view.getNumarulDeStundeti().setText("Numarul de Studenti");
            view.getNumarulDeMaterii().setText("Numarul de Materii");
            view.getNumarRestantieri().setText("Numar de restantieri");
            view.getTop5Studenti().setText("Top 5 Studenti");
            view.getNumarulDeBursieri().setText("Numarul de studenti bursieri");
            view.getProfesor().setText("Profesori");
            view.getStudent().setText("Studenti");
            view.getMaterie().setText("Materie");
            view.getNota().setText("Nota                ");
            view.getReseteaza().setText("Reseteaza");
            view.getAfiseaza().setText("Afiseaza");
            view.getSterge().setText("Sterge");
            view.getSeteaza().setText("Seteaza");
            view.getAlegeri().removeItemAt(3);
            view.getAlegeri().removeItemAt(2);
            view.getAlegeri().removeItemAt(1);
            view.getAlegeri().removeItemAt(0);
            view.getAlegeri().addItem("Nicio actiune");
            view.getAlegeri().addItem("Sterge");
            view.getAlegeri().addItem("Cauta");
            view.getAlegeri().addItem("Adauga");
            nuAtiIntrodusToateDatele="Nu ati introdus toate datele!";
            nuAtiIntrodusUnNumar="Nu ati introudus un numar.";
            nuExistaProfPredMat="Nu exista profesor care sa predea aceasta materie!";
            atAlesActGresita="Ati ales actiunea gresita!";
            nuExistaAcestProf="Nu exista acest profesor in facultate!";
            nuExistaAcestStud="Nu exista acest student";
            profesoriiCarePredauAceastaMateie="Profesorii care predau aceasta materie sunt:\n";
            profesorulSelectatPredaMateriile="Profesorul selectat preda materiile:\n";
            areNotele=" are notele:\n";
            studentiiCareAuAceastaNotaSunt="Studentii care au aceasta nota sunt:\n";
            niciunStudentNuAreNotaAsta="Niciun stundent nu are nota asta.";
            nuAtiIntrodusUnNumePentruProfesor="Nu ati introdus un nume pentru profesor!";
            nuAtiIntrodusUnNumePentruStudent="Nu ati introdus un nume pentru student!";
            nuAtiIntrodusUnNumePentruMaterie="Nu ati introdus un nume pentru materie!";
            numarulDeProfesoriDinFacultateEsteDe="Numarul de profesori din facultate este de: ";
            numarulDeStudentiDinFacultateEsteDe="Numarul de studenti din facultate este de ";
            numarulDeMateriiCareSePredaLaFacultateEsteDe="Numarul de materii care se preda la facultate este de ";
            top5Studenti="Cei top 5 studenti sunt:\n";
            numarulDeStudentiCuRestanta="Numarul de studenti cu restante este de ";
            resetBD="S-a resetat baza de date!";
            numarulDeProfesoriCarePredau="Numarul de profesori care predau ";
            materiiEsteDe=" materii este de ";
            nuExistaProfCareSaPredea="Nu exista profesor care sa predea ";
            materiiString=" materii.";
            studentiiCuBursaSunt="Numarul de studenti cu bursa este: ";
            view.setImageIcon(new ImageIcon("C:/Users/Razvan/Desktop/logo1.png"));

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }
}