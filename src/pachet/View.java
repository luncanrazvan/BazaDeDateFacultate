package pachet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class View extends JFrame implements ActionListener{

    private Timer timer;

    private JFrame pentruNrMaterii;
    private JTextField textnumarulDeMaterii;
    private JLabel labelNumarulDeMaterii;
    private JPanel panelNrMaterii;

    private JButton seteaza;
    private JButton afiseaza;
    private JButton sterge;
    private JButton iesire;


    private JPanel setariLaLogo;
    private JPanel setariBackground;
    private JLabel logo;
    private JLabel opresteLogoul;

    private JPanel contents;
    private JPanel celDinNord;
    private JPanel celDinEst;
    private JPanel celDinSud;
    private JPanel celDinVest;
    private JPanel celDinCentruYAxis;

    private JPanel checkBoxuriStergereProf;
    private JPanel checkBoxuriStergereStudent;
    private JPanel chechBoxuriStergereMaterie;

    private JPanel vizMeniu;

    private JPanel pentruProfesor;
    private JPanel pentruMaterie;
    private JPanel pentruStudent;
    private JPanel pentruNote;


    private JLabel darkTheme;
    private JLabel numeProfesor;
    private JLabel numeMaterie;
    private JLabel numeStudent;
    private JLabel numeNota;
    private JLabel checkProf;
    private JLabel checkStud;
    private JLabel checkMat;

    private JLabel scrisLimbaEngleza;
    private JLabel limbaEngleza;
    private JLabel scrisLimbaRomana;
    private JLabel limbaRomana;

    private ImageIcon imageIcon;
    private ImageIcon steagEng;

    private JCheckBox oprireLogo;
    private JCheckBox setDarkTheme;
    private JCheckBox profesorCB;
    private JCheckBox studentCB;
    private JCheckBox materieCB;

    private JMenuBar barameniu;
    private JMenu meniu;
    private JMenu filtre;
    private JMenu statistici;

    private JMenuItem reseteaza;

    private JRadioButtonMenuItem profesor;
    private JRadioButtonMenuItem student;
    private JRadioButtonMenuItem materie;
    private JRadioButtonMenuItem nota;

    private JMenuItem numarulDeProfesori;
    private JMenuItem numarulXProfesori;
    private JMenuItem numarulDeStudenti;
    private JMenuItem numarulDeMaterii;
    private JMenuItem top5Studenti;
    private JMenuItem numarRestantieri;
    private JMenuItem numarulDeBursieri;

    private JTextField scrieProfesor;
    private JTextField scrieMaterie;
    private JTextField scrieStudent;
    private JTextField scrieNota;

    private JComboBox alegeri;
    int x=900;
    int y=25;

    public View(){
        timer=new Timer(100,this);
        this.contents=new JPanel();

        this.celDinSud=new JPanel();
        this.celDinNord=new JPanel();
        this.celDinEst=new JPanel();
        this.celDinVest=new JPanel();
        this.celDinCentruYAxis=new JPanel();

        this.setariLaLogo=new JPanel();
        this.setariBackground=new JPanel();

        this.pentruProfesor=new JPanel();
        this.pentruMaterie=new JPanel();
        this.pentruStudent=new JPanel();
        this.pentruNote=new JPanel();

        this.vizMeniu=new JPanel(new FlowLayout(FlowLayout.LEFT));

        this.checkBoxuriStergereProf=new JPanel();
        this.checkBoxuriStergereProf.setLayout(new BoxLayout(checkBoxuriStergereProf,BoxLayout.X_AXIS));
        this.checkBoxuriStergereProf.setBackground(Color.gray);

        this.checkBoxuriStergereStudent=new JPanel();
        this.checkBoxuriStergereStudent.setLayout(new BoxLayout(checkBoxuriStergereStudent,BoxLayout.X_AXIS));
        this.checkBoxuriStergereStudent.setBackground(Color.gray);

        this.chechBoxuriStergereMaterie=new JPanel();
        this.chechBoxuriStergereMaterie.setLayout(new BoxLayout(chechBoxuriStergereMaterie,BoxLayout.X_AXIS));
        this.chechBoxuriStergereMaterie.setBackground(Color.gray);

        this.opresteLogoul=new JLabel("Opreste Logo-ul");
        this.darkTheme=new JLabel("Dark Theme");
        this.numeProfesor=new JLabel("Nume Profesor");
        this.numeMaterie=new JLabel("Nume Materie  ");
        this.numeStudent=new JLabel("Nume Student ");
        this.numeNota=new JLabel("Nota                  ");
        this.checkProf=new JLabel("Profesor");
        this.checkStud=new JLabel("Student");
        this.checkMat=new JLabel("Materie");

        this.scrisLimbaEngleza=new JLabel("English:");
        this.limbaEngleza=new JLabel(new ImageIcon("E:/Facultate/An2/Semestrul1/POO/Proiect/eng3.gif"));
        this.scrisLimbaRomana=new JLabel("Romana:");
        this.limbaRomana=new JLabel(new ImageIcon("E:/Facultate/An2/Semestrul1/POO/Proiect/rom.gif"));

        this.oprireLogo=new JCheckBox();
        this.setDarkTheme=new JCheckBox();
        this.profesorCB=new JCheckBox();
        this.studentCB=new JCheckBox();
        this.materieCB=new JCheckBox();

        oprireLogo.setOpaque(false);
        oprireLogo.setForeground(Color.WHITE);
        setDarkTheme.setOpaque(false);
        setDarkTheme.setForeground(Color.WHITE);
        profesorCB.setOpaque(false);
        studentCB.setOpaque(false);
        materieCB.setOpaque(false);


        this.barameniu=new JMenuBar();
       // this.vizMeniu.setLayout(new BoxLayout(vizMeniu,BoxLayout.X_AXIS));
       // this.vizMeniu.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.meniu=new JMenu("Meniu");
        this.filtre=new JMenu("Filtre Cautare");
        this.statistici=new JMenu("Statistici");

        this.reseteaza=new JMenuItem("Reseteaza");

        this.profesor=new JRadioButtonMenuItem("Profesori");
        this.student=new JRadioButtonMenuItem("Studenti");
        this.materie=new JRadioButtonMenuItem("Materie");
        this.nota=new JRadioButtonMenuItem("Nota                ");
        this.numarulDeProfesori=new JMenuItem("Numarul de Profesori");
        this.numarulXProfesori=new JMenuItem("Numarul de X Profesori");
        this.numarulDeStudenti=new JMenuItem("Numarul de Studenti");
        this.numarulDeMaterii=new JMenuItem("Numarul de Materii");
        this.top5Studenti=new JMenuItem("Top 5 Studenti");
        this.numarRestantieri=new JMenuItem("Numar de restantieri");
        this.numarulDeBursieri=new JMenuItem("Numarul de studenti bursieri");


        this.scrieProfesor=new JTextField(null);
        this.scrieMaterie=new JTextField(null);
        this.scrieStudent=new JTextField(null);
        this.scrieNota=new JTextField(null);

        this.scrieProfesor.setBackground(Color.gray);
        //this.scrieProfesor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.scrieMaterie.setBackground(Color.gray);
        this.scrieStudent.setBackground(Color.gray);
        this.scrieNota.setBackground(Color.gray);

        this.alegeri=new JComboBox();
        this.alegeri.addItem("Nicio actiune");
        this.alegeri.addItem("Sterge");
        this.alegeri.addItem("Cauta");
        this.alegeri.addItem("Adauga");


        this.meniu.add(reseteaza);
        this.filtre.add(profesor);
        this.filtre.add(student);
        this.filtre.add(materie);
        this.filtre.add(nota);
        this.statistici.add(numarulDeProfesori);
        this.statistici.add(numarulXProfesori);
        this.statistici.add(numarulDeStudenti);
        this.statistici.add(numarulDeMaterii);
        this.statistici.add(top5Studenti);
        this.statistici.add(numarRestantieri);
        this.statistici.add(numarulDeBursieri);

        this.barameniu.add(meniu);
        this.barameniu.add(filtre);
        this.barameniu.add(statistici);
        this.vizMeniu.add(barameniu);

        this.setariBackground.setLayout(new BoxLayout(setariBackground,BoxLayout.X_AXIS));
        this.setariBackground.add(darkTheme);
        this.setariBackground.add(setDarkTheme);

        this.checkBoxuriStergereProf.add(checkProf);
        this.checkBoxuriStergereProf.add(profesorCB);

        this.checkBoxuriStergereStudent.add(checkStud);
        this.checkBoxuriStergereStudent.add(studentCB);

        this.chechBoxuriStergereMaterie.add(checkMat);
        this.chechBoxuriStergereMaterie.add(materieCB);

        this.imageIcon=new ImageIcon("E:/Facultate/An2/Semestrul1/POO/Proiect/logo1.png");
        this.logo=new JLabel(imageIcon);
        this.logo.setLocation(x,y);
        this.timer.start();

        this.contents.setLayout(new BorderLayout());

        this.celDinCentruYAxis.setLayout(new BoxLayout(celDinCentruYAxis,BoxLayout.Y_AXIS));
        this.celDinNord.setLayout(new BoxLayout(celDinNord,BoxLayout.Y_AXIS));
        this.celDinEst.setLayout(new BoxLayout(celDinEst,BoxLayout.Y_AXIS));
        this.celDinSud.setLayout(new BoxLayout(celDinSud,BoxLayout.X_AXIS));
        this.pentruProfesor.setLayout(new BoxLayout(pentruProfesor,BoxLayout.X_AXIS)); //pentru profesor

        this.pentruNrMaterii=new JFrame("Numarul de Materii");
        this.pentruNrMaterii.setSize(new Dimension(300,70));
        this.pentruNrMaterii.setVisible(false);
        this.panelNrMaterii=new JPanel();
        this.panelNrMaterii.setLayout(new BoxLayout(panelNrMaterii,BoxLayout.X_AXIS));
        this.labelNumarulDeMaterii=new JLabel("Numarul de materii:");
        this.textnumarulDeMaterii=new JTextField("");
        this.panelNrMaterii.add(labelNumarulDeMaterii);
        this.panelNrMaterii.add(textnumarulDeMaterii);
        this.pentruNrMaterii.add(panelNrMaterii);


        this.setTitle("Aplicatie Facultate");
        this.setPreferredSize(new Dimension(900,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.seteaza=new JButton("Seteaza");
        this.afiseaza=new JButton("Afiseaza");
        this.sterge=new JButton("Sterge");
        this.iesire=new JButton("Iesire");

        this.setariLaLogo.setLayout(new BoxLayout(setariLaLogo,BoxLayout.X_AXIS));
        this.setariLaLogo.add(opresteLogoul);
        this.setariLaLogo.add(oprireLogo);

        this.pentruProfesor.add(numeProfesor);
        this.pentruProfesor.add(scrieProfesor);
        this.celDinCentruYAxis.add(pentruProfesor);

        this.pentruMaterie.setLayout(new BoxLayout(pentruMaterie,BoxLayout.X_AXIS));
        this.pentruMaterie.add(numeMaterie);
        this.pentruMaterie.add(scrieMaterie);
        this.celDinCentruYAxis.add(pentruMaterie);

        this.pentruStudent.setLayout(new BoxLayout(pentruStudent,BoxLayout.X_AXIS));
        this.pentruStudent.add(numeStudent);
        this.pentruStudent.add(scrieStudent);
        this.celDinCentruYAxis.add(pentruStudent);

        this.pentruNote.setLayout(new BoxLayout(pentruNote,BoxLayout.X_AXIS));
        this.pentruNote.add(numeNota);
        this.pentruNote.add(scrieNota);
        this.celDinCentruYAxis.add(pentruNote);

        this.celDinVest.add(alegeri);

        this.celDinEst.add(setariLaLogo);
        this.celDinEst.add(setariBackground);
        this.celDinEst.add(checkBoxuriStergereProf);
        this.celDinEst.add(checkBoxuriStergereStudent);
        this.celDinEst.add(chechBoxuriStergereMaterie);
        this.celDinEst.add(scrisLimbaEngleza);
        this.celDinEst.add(limbaEngleza);
        this.celDinEst.add(scrisLimbaRomana);
        this.celDinEst.add(limbaRomana);

        this.celDinNord.add(vizMeniu);
        this.celDinNord.add(logo);

        this.contents.add(celDinEst,BorderLayout.EAST);
        this.contents.add(celDinNord,BorderLayout.NORTH);
        this.contents.add(celDinSud,BorderLayout.SOUTH);
        this.contents.add(celDinCentruYAxis,BorderLayout.CENTER);
        this.contents.add(celDinVest,BorderLayout.WEST);

        this.celDinSud.add(Box.createRigidArea(new Dimension(300,0)));
        this.celDinSud.add(seteaza);
        this.celDinSud.add(Box.createRigidArea(new Dimension(20,0)));
        this.celDinSud.add(afiseaza);
        this.celDinSud.add(Box.createRigidArea(new Dimension(20,0)));
        this.celDinSud.add(sterge);

        getCelDinEst().setBackground(Color.gray);
        getCelDinNord().setBackground(Color.gray);
        getCelDinCentruYAxis().setBackground(Color.gray);
        getSetariLaLogo().setBackground(Color.gray);
        getCelDinSud().setBackground(Color.gray);
        getContents().setBackground(Color.gray);
        getSetariBackground().setBackground(Color.gray);
        getCelDinVest().setBackground(Color.gray);
        getScrieMaterie().setBackground(Color.gray);
        getScrieNota().setBackground(Color.gray);
        getScrieProfesor().setBackground(Color.gray);
        getScrieStudent().setBackground(Color.gray);
        getCheckProf().setBackground(Color.gray);
        getCheckProf().setOpaque(true);

        this.add(contents);
        this.pack();

    }

    public void actionPerformed(ActionEvent e)
    {
        x-=10;
        if(x<-1000){
            x= 900;
        }
        logo.setLocation(x,y);
    }

    public void oprireTimerAction(ActionListener a1){
        oprireLogo.addActionListener(a1);
    }

    public void setDarkThemeAction(ActionListener a2){
        setDarkTheme.addActionListener(a2);
    }

    public void butonSetare(ActionListener a3){seteaza.addActionListener(a3);}

    public void CBProfesor(ActionListener a4){profesorCB.addActionListener(a4);}

    public void CBStudenti(ActionListener a5){studentCB.addActionListener(a5);}

    public void CBMaterii(ActionListener a6){materieCB.addActionListener(a6);}

    public void MProfesor(ActionListener a7){profesor.addActionListener(a7);}

    public void MStudent(ActionListener a8){student.addActionListener(a8);}

    public void MMaterie(ActionListener a9){materie.addActionListener(a9);}

    public void MNota(ActionListener a10){nota.addActionListener(a10);}

    public void AReseteaza(ActionListener a11){reseteaza.addActionListener(a11);}

    public void butonAfisare(ActionListener a12){afiseaza.addActionListener(a12);}

    public void butonSterge(ActionListener a13){sterge.addActionListener(a13);}

    public void actiunePentruCombo(ActionListener a14){alegeri.addActionListener(a14);}

    public void actiunePentruXProfi(ActionListener a15){numarulXProfesori.addActionListener(a15);}

    public void actiunePentruNrStudenti(ActionListener a16){numarulDeStudenti.addActionListener(a16);}

    public void actiuneNrMaterii(ActionListener a17){numarulDeMaterii.addActionListener(a17);}

    public void actiuneTop5Student(ActionListener a18){top5Studenti.addActionListener(a18);}

    public void actiunePentruProfi(ActionListener a19){numarulDeProfesori.addActionListener(a19);}

    public void actiuneEnter(KeyListener a20){textnumarulDeMaterii.addKeyListener(a20);}

    public void englezaSelect(MouseListener a21){limbaEngleza.addMouseListener(a21);}

    public void romanaSelect(MouseListener a22){limbaRomana.addMouseListener(a22);}

    public void actiuneRestantieri(ActionListener a23){numarRestantieri.addActionListener(a23);}

    public void actiuneBursieri(ActionListener a24){numarulDeBursieri.addActionListener(a24);}

    public JCheckBox getSetDarkTheme(){
        return setDarkTheme;
    }

    public JCheckBox getOprireLogo(){
        return oprireLogo;
    }

    public Timer getTimer() {
        return timer;
    }

    public JPanel getSetariLaLogo() {
        return setariLaLogo;
    }

    public JPanel getCelDinNord() {
        return celDinNord;
    }

    public JPanel getCelDinEst() {
        return celDinEst;
    }

    public JPanel getCelDinSud(){
        return celDinSud;
    }

    public JPanel getContents(){
        return contents;
    }

    public JPanel getSetariBackground(){
        return setariBackground;
    }

    public JPanel getCelDinCentruYAxis() {
        return celDinCentruYAxis;
    }

    public JPanel getCelDinVest(){
        return celDinVest;
    }

    public JTextField getScrieProfesor(){
        return scrieProfesor;
    }

    public JTextField getScrieMaterie() {
        return scrieMaterie;
    }

    public JTextField getScrieNota() {
        return scrieNota;
    }

    public JTextField getScrieStudent() {
        return scrieStudent;
    }

    public JTextField getTextnumarulDeMaterii(){
        return textnumarulDeMaterii;
    }

    public JComboBox getAlegeri(){
        return alegeri;
    }

    public JLabel getCheckProf(){
        return checkProf;
    }

    public JLabel getCheckStud(){return checkStud;}

    public JLabel getCheckMat(){return checkMat; }

    public JLabel getOpresteLogoul(){return opresteLogoul;}

    public JPanel getCheckBoxuriStergereProf(){
        return  checkBoxuriStergereProf;
    }

    public JPanel getCheckBoxuriStergereStudent(){
        return checkBoxuriStergereStudent;
    }

    public JPanel getChechBoxuriStergereMaterie(){
        return chechBoxuriStergereMaterie;
    }

    public JButton getAfiseaza(){
        return afiseaza;
    }

    public JButton getSeteaza(){
        return seteaza;
    }

    public JButton getSterge(){return  sterge;}

    public void showJOptionPane(String message){
        JOptionPane.showMessageDialog(this,message);
    }

    public JCheckBox getProfesorCB(){
        return profesorCB;
    }

    public JCheckBox getStudentCB(){
        return studentCB;
    }

    public JCheckBox getMaterieCB(){
        return materieCB;
    }

    public JRadioButtonMenuItem getProfesor(){
        return profesor;
    }

    public JRadioButtonMenuItem getStudent(){
        return student;
    }

    public JRadioButtonMenuItem getMaterie(){
        return materie;
    }

    public JRadioButtonMenuItem getNota(){
        return nota;
    }

    public JMenuItem getNumarulDeProfesori(){return numarulDeProfesori;}

    public JMenuItem getNumarulXProfesori(){return  numarulXProfesori;}

    public JMenuItem getNumarulDeStundeti(){return  numarulDeStudenti;}

    public JMenuItem getNumarulDeMaterii(){return numarulDeMaterii;}

    public JMenuItem getTop5Studenti(){return  top5Studenti;}

    public JMenuItem getNumarRestantieri(){return numarRestantieri;}

    public JMenuItem getNumarulDeBursieri(){return numarulDeBursieri;}

    public JFrame getPentruNrMaterii(){
        return pentruNrMaterii;
    }

    public JLabel getNumeProfesor(){return numeProfesor;}

    public JLabel getNumeStudent(){return  numeStudent;}

    public JLabel getNumeMaterie(){return  numeMaterie;}

    public JLabel getNumeNota(){return  numeNota;}

    public JMenu getMeniu(){return  meniu;}

    public JMenu getFiltre(){return  filtre;}

    public JMenu getStatistici(){return  statistici;}

    public JMenuItem getReseteaza(){return  reseteaza;}

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}