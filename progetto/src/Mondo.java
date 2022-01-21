import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
import com.jgoodies.forms.factories.*;

public class Mondo {

    public int numero_persone; //numero della popolazione in intero
    public ArrayList<Persona> Popolazione; //lista di tutte quante le persone nel mondo
    public Malattia malattia;
    private int verdi; //numero di verdi nel mondo
    private int gialli = 1; // numero di gialli nel mondo
    private int rossi = 0; //numero di rossi nel mondo
    private int neri = 0; //numero di rossi nel mondo
    private int blu = 0; //numero di blu nel mondo
    private int risorse; //risorse ancora disponibili
    private int costotampone; //costo di un singolo tampone
    private int velocità; //incontri medi giornalieri che effettua una persona
    private int giorni = 0; //giorni nel mondo
    private String strategia; //strategia da attuare
    private int cura = 0; //se viene scelta la strategia "cerca cura", questo valore indica l'avanzamento della ricerca della cura

    public Mondo(int popolazione, int Risorse, int CostoTampone, int Velocità, Malattia malattia) { // costruiamo il mondo
        this.numero_persone = popolazione;
        this.verdi = popolazione - 1;
        this.costotampone = CostoTampone;
        this.velocità = Velocità;
        this.risorse = Risorse;
        this.malattia = malattia;
        Popolazione = new ArrayList<Persona>();
        Persona a = new Persona(0, "giallo"); // creo il paziente 0
        Popolazione.add(a);
        for (int i = 1; i < popolazione; i++) { // creo il resto della popolazione;
            Persona x = new Persona(0, "verde");
            Popolazione.add(x);
        }
    }

    public void incontri(Persona a, Persona b) { // incontro tra due persone
        int infettività = this.malattia.getInfettività();
        int contagio = ThreadLocalRandom.current().nextInt(1, 101);
        if (contagio <= infettività) { // se il numero generato è all'interno dell'intervallo [1,infettività] allora viene contagiata una delle due persone
            if (a.Salute == "verde" && b.Salute == "giallo") { //se b è giallo allora incomincia il periodo di incubazione in a
                if (a.getGiorno_x() == -1) {
                    a.setGiorno_x();
                }
            } else if (a.Salute == "giallo" && b.Salute == "verde") { //se a è giallo allora incomincia il periodo di incubazione in b
                if (b.getGiorno_x() == -1) {
                    b.setGiorno_x();
                }
            } else if (a.Salute == "verde" && b.Salute == "rosso") { //se b è rosso allora incomincia il periodo di incubazione in a
                if (a.getGiorno_x() == -1) {
                    a.setGiorno_x();
                }
            }
        }
    }

    public int getRisorse() { // quante risorse abbiamo
        return risorse;
    }

    public int getNeri() {
        return neri;
    }


    public int getBlu() {
        return blu;
    }

    public void setRisorse() { // modifico le risorse
        risorse--;
    }

    public void setRisorse(int rossi) { //costo giornaliero di tutti quanti i sintomatici nel mondo
        risorse = risorse - (3 * costotampone * rossi);
    }

    public int getVelocità() { // quanti incontri medi vengono fatti
        return velocità;
    }

    public void setVelocità(int velocità) { // cambio gli incontri medi che vengono fatti
        velocità = velocità;
    }

    public ArrayList<Persona> getPopolazione() { // persone nel mondo
        return Popolazione;
    }

    public int getPersone() {
        return numero_persone;
    }

    public int getVerdi() {
        return verdi;
    }

    public void setGiorni() {
        giorni++;
    }

    public int getGiorni() {
        return giorni;
    }

    public int getRossi() {
        return rossi;
    }

    public int getGialli() {
        return gialli;
    }

    public void setVerdi() {
        verdi--;
    }

    public void setGialli(int g) {
        gialli = gialli + g;
    }

    public void setRossi(int r) {
        rossi = rossi + r;
    }

    public void setNeri() {
        neri++;
    }

    public void setBlu() {
        blu++;
    }


    public class Persona {
        private boolean movimento = true;  //mi permette di sapere se una persona è ferma o si muove
        private int Incontri;  //mi permette di sapere quante persone incontra ogni giorno
        private String Salute; //mi indica in che stato il virus è
        private int giorno_x = -1; //indica il numero dei giorni che il virus è dentro la persona

        public Persona(int Incontri, String Salute) { // costruttore persona
            this.Salute = Salute;
            this.Incontri = Incontri;
        }

        public boolean isMovimento() { //so se una persona è in movimento oppure no
            return this.movimento;
        }

        public void setMovimento() { // cambio lo stato del movimento
            if (this.movimento == false) {
                this.movimento = true;
            } else {
                this.movimento = false;
            }
        }

        public void setIncontri() { //definisce il numero di incontri che svolgerà una persona
            int numeroincontri = ThreadLocalRandom.current().nextInt(velocità / 2, velocità * 2);
            this.Incontri = numeroincontri;
        }

        public void rimuoviIncontri() {
            this.Incontri--;
        }

        public String getSalute() { // ritorna la salute di una persona
            return this.Salute;
        }

        public boolean getMovimento() {
            return this.movimento;
        }

        public int getIncontri() { // mi dice quante persone può incontrare
            return Incontri;
        }

        public void setSalute(String salute) { // modifico la salute di una persona
            Salute = salute;
        }

        public void setGiorno_x() {
            giorno_x++;
        }

        public int getGiorno_x() {
            return giorno_x;
        }

    }

    public class Strategie { //classe che ci permette di poter scegliere la strategia da utilizzare

        public void quarantenaGialli() { //vengono eseguiti un tot di tamponi al giorno e chi risulta positivo viene messo in quarantena
            strategia="Quarantena gialli";
            int quanti_tamponi = (int) (((verdi+gialli) * 0.3) / 100); //numero di tamponi che vengono svolti
            int x = 0;
            while (x <= quanti_tamponi) { //finchè possiamo svolgere tamponi, li eseguiamo
                int persona_testata = ThreadLocalRandom.current().nextInt(0, numero_persone); //viene presa una persona random
                if (Popolazione.get(persona_testata).isMovimento()) { //la persona deve essere in movimento, poichè chi è fermo è sintomatico
                    if (Popolazione.get(persona_testata).getSalute() == "verde") { //se la persona testata è verde allora non succede niente
                        x++;
                        risorse = risorse - costotampone;
                    } else { //altrimenti viene messa in quarantena
                        x++;
                        Popolazione.get(persona_testata).setMovimento();
                        risorse = risorse - costotampone;
                    }
                }
            }
        }

        public void lockdown() { //tutta la popolazione tranne il 3% viene messa in quarantena (abbiamo supposto che il 3% della popolazione definisca quelle persone che lavorano nei settori essenziali)
            strategia = "Lockdown";
            for (int i = 0; i < Popolazione.size() * 97 / 100; i++) { //il 97% viene messa in quarantena
                Popolazione.get(i).movimento = false;
            }
        }

        public void antilockdown() { //serve quando finisce il lockdown
            if (strategia!="Lockdown"){
                strategia = "Antilockdown";
            }
            for (int i = 0; i < Popolazione.size(); i++) {
                if (Popolazione.get(i).Salute == "giallo" || Popolazione.get(i).Salute == "verde") { //solamente chi è giallo o verde viene messo in movimento
                    Popolazione.get(i).movimento = true;
                }
            }
            velocità = velocità/3;
        }

        public void cercacura(String s) { //si prova a cercare una cura per sconfiggere la malattia
            strategia="Cerca cura";
            if (s.equals("basso")) { //se vogliamo spendere poco per paura di finire subito le risorse
                risorse = risorse - risorse * 1 / 100;
                cura = cura + 2;
            } else if (s.equals("medio")) { //se vogliamo uno sviluppo medio della cura
                risorse = risorse - risorse * 2 / 100;
                cura += 4;
            } else if (s.equals("alto")) { //cerco di trovare la cura il più possibile
                risorse = risorse - risorse * 3 / 100;
                cura += 6;
            }
            if (cura >= 100) { //quando viene completata lo sviluppo della cura, tutti vengono curati
                for (int i = 0; i < Popolazione.size(); i++) {
                    Persona p = Popolazione.get(i);
                    if (p.getSalute().equals("rosso") || p.getSalute().equals("giallo") || p.getSalute().equals("verde")) {
                        p.setSalute("blu");
                        blu++;
                    }
                }
                rossi = 0;
                verdi = 0;
                gialli = 0;
            }
        }

        public void spartana() { //tutti i rossi vengono uccisi. Vengono eseguiti un tot di tamponi per trovare i gialli e uccidere anche loro
            strategia = "Spartana";
            int y = 0;
            int quanti_tamponi = (int) (((verdi+gialli) * 1) / 100);
            int x = 0;
            while (x <= quanti_tamponi && y < Popolazione.size()) { //vengono eseguiti i tamponi per trovare i gialli
                y++;
                int persona_testata = ThreadLocalRandom.current().nextInt(0, numero_persone);
                if (Popolazione.get(persona_testata).getSalute().equals("verde")) { //se la persona testata è verde allora non succede niente
                    x++;
                    risorse = risorse - costotampone;
                } else if (Popolazione.get(persona_testata).getSalute().equals("giallo")) { //se la persona testata è gialla viene uccisa
                    Popolazione.get(persona_testata).setSalute("nero");
                    neri++;
                    gialli--;
                    x++;
                    if (Popolazione.get(persona_testata).isMovimento() == true) {
                        Popolazione.get(persona_testata).setMovimento();
                    }
                    risorse = risorse - costotampone;
                }
            }
            if (rossi > 0) { //finchè ci sono rossi vengono uccisi
                neri = neri + rossi;
                rossi = 0;
                for (int i = 0; i < Popolazione.size(); i++) {
                    Persona p = Popolazione.get(i);
                    if (p.getSalute().equals("rosso")) {
                        p.setSalute("nero");
                    }
                }
            }

        }

        public void niente(){
            strategia = "niente";
        }
    }
    public class Finale extends JFrame {
        public Finale() {
            initComponents();
        }

        private void label1PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(getVerdi());
            label1.setText((z));

        }

        private void title16PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(getRossi());
            title16.setText((z));
        }

        private void title17PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(getGialli());
            title17.setText((z));
        }

        private void title18PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(getBlu());
            title18.setText((z));
        }

        private void title19PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(getNeri());
            title19.setText((z));
        }

        private void title20PropertyChange(PropertyChangeEvent e) {
            title20.setText("");
        }

        private void title21PropertyChange(PropertyChangeEvent e) {
            if (getRisorse()>=0){
                String z= Integer.toString(getRisorse());
                title21.setText(z+"$");
            }
            else {
                String z= "0";
                title21.setText(z+"$");
            }
        }

        private void title22PropertyChange(PropertyChangeEvent e) {
            if (getRisorse() <= 0) {
                title22.setText("Sono finite le risorse");
            } else if (getPersone() == getNeri()) {
                title22.setText("Sono morti tutti");
            } else {
                title22.setText("Epidemia sconfitta!");
            }
        }

        private void label2PropertyChange(PropertyChangeEvent e) {
            String z= Integer.toString(giorni);
            label2.setText("Giorno: "+z);
        }

        private void initComponents() {
            DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
            title1 = compFactory.createTitle("text");
            title2 = compFactory.createTitle("RISULTATI SIMULAZIONE");
            title3 = compFactory.createTitle("text");
            title4 = compFactory.createTitle("text");
            title5 = compFactory.createTitle("text");
            title6 = compFactory.createTitle("text");
            title7 = compFactory.createTitle("text");
            title8 = compFactory.createTitle("text");
            title9 = compFactory.createTitle("text");
            title10 = compFactory.createTitle("text");
            title11 = compFactory.createTitle("text");
            title12 = compFactory.createTitle("text");
            title13 = compFactory.createTitle("text");
            title14 = compFactory.createTitle("text");
            title15 = compFactory.createTitle("text");
            label1 = new JLabel();
            title16 = compFactory.createTitle("text");
            title17 = compFactory.createTitle("text");
            title18 = compFactory.createTitle("text");
            title19 = compFactory.createTitle("text");
            title20 = compFactory.createTitle("text");
            title21 = compFactory.createTitle("text");
            title22 = compFactory.createTitle("text");
            label2 = new JLabel();

            //======== this ========
            setResizable(false);
            var contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- title1 ----
            title1.setIcon(new ImageIcon(getClass().getResource("/Icone/virus1.png")));
            contentPane.add(title1);
            title1.setBounds(405, 5, 100, title1.getPreferredSize().height);
            contentPane.add(title2);
            title2.setBounds(new Rectangle(new Point(385, 115), title2.getPreferredSize()));

            //---- title3 ----
            title3.setIcon(new ImageIcon(getClass().getResource("/Icone/download.jpg")));
            contentPane.add(title3);
            title3.setBounds(425, 235, 45, 45);

            //---- title4 ----
            title4.setIcon(new ImageIcon(getClass().getResource("/Icone/1200px-Single_Color_Flag_-_007500.png")));
            contentPane.add(title4);
            title4.setBounds(110, 235, 45, 45);

            //---- title5 ----
            title5.setIcon(new ImageIcon(getClass().getResource("/Icone/giallo3.jpg")));
            contentPane.add(title5);
            title5.setBounds(265, 235, 45, 46);

            //---- title6 ----
            title6.setIcon(new ImageIcon(getClass().getResource("/Icone/unnamed.jpg")));
            contentPane.add(title6);
            title6.setBounds(580, 235, 45, 45);

            //---- title7 ----
            title7.setIcon(new ImageIcon(getClass().getResource("/Icone/180px-Solid_black.svg.png")));
            contentPane.add(title7);
            title7.setBounds(740, 235, 45, 45);

            //---- title8 ----
            title8.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_virus-18_5862649.png")));
            contentPane.add(title8);
            title8.setBounds(100, 165, 60, title8.getPreferredSize().height);

            //---- title9 ----
            title9.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_virus-25_5862637.png")));
            contentPane.add(title9);
            title9.setBounds(255, 165, 60, title9.getPreferredSize().height);

            //---- title10 ----
            title10.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_virus-11_5862663 (1).png")));
            contentPane.add(title10);
            title10.setBounds(415, 165, 65, title10.getPreferredSize().height);

            //---- title11 ----
            title11.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_check-circle-outline_326568.png")));
            contentPane.add(title11);
            title11.setBounds(570, 165, 65, title11.getPreferredSize().height);

            //---- title12 ----
            title12.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_virus-24_5862639.png")));
            contentPane.add(title12);
            title12.setBounds(730, 165, 65, title12.getPreferredSize().height);

            //---- title13 ----
            title13.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_hygiene-virus-protection-clean-coronavirus_5986238.png")));
            contentPane.add(title13);
            title13.setBounds(170, 335, 65, title13.getPreferredSize().height);

            //---- title14 ----
            title14.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_Dollar_1737376.png")));
            contentPane.add(title14);
            title14.setBounds(415, 330, 60, title14.getPreferredSize().height);

            //---- title15 ----
            title15.setIcon(new ImageIcon(getClass().getResource("/Icone/iconfinder_09-report_5980381.png")));
            contentPane.add(title15);
            title15.setBounds(655, 325, 65, title15.getPreferredSize().height);

            //---- label1 ----
            label1.setText("text");
            label1.addPropertyChangeListener(e -> label1PropertyChange(e));
            contentPane.add(label1);
            label1.setBounds(110, 290, 60, label1.getPreferredSize().height);

            //---- title16 ----
            title16.addPropertyChangeListener(e -> title16PropertyChange(e));
            contentPane.add(title16);
            title16.setBounds(265, 290, 45, title16.getPreferredSize().height);

            //---- title17 ----
            title17.addPropertyChangeListener(e -> title17PropertyChange(e));
            contentPane.add(title17);
            title17.setBounds(425, 290, 45, title17.getPreferredSize().height);

            //---- title18 ----
            title18.addPropertyChangeListener(e -> title18PropertyChange(e));
            contentPane.add(title18);
            title18.setBounds(580, 290, 40, title18.getPreferredSize().height);

            //---- title19 ----
            title19.addPropertyChangeListener(e -> title19PropertyChange(e));
            contentPane.add(title19);
            title19.setBounds(740, 290, 45, title19.getPreferredSize().height);

            //---- title20 ----
            title20.addPropertyChangeListener(e -> title20PropertyChange(e));
            contentPane.add(title20);
            title20.setBounds(255, 355, 155, title20.getPreferredSize().height);

            //---- title21 ----
            title21.addPropertyChangeListener(e -> title21PropertyChange(e));
            contentPane.add(title21);
            title21.setBounds(495, 350, 110, title21.getPreferredSize().height);

            //---- title22 ----
            title22.addPropertyChangeListener(e -> title22PropertyChange(e));
            contentPane.add(title22);
            title22.setBounds(725, 335, 165, title22.getPreferredSize().height);

            //---- label2 ----
            label2.setText("text");
            label2.addPropertyChangeListener(e -> label2PropertyChange(e));
            contentPane.add(label2);
            label2.setBounds(725, 365, 135, label2.getPreferredSize().height);

            contentPane.setPreferredSize(new Dimension(900, 500));
            pack();
            setLocationRelativeTo(getOwner());
        }

        private JLabel title1;
        private JLabel title2;
        private JLabel title3;
        private JLabel title4;
        private JLabel title5;
        private JLabel title6;
        private JLabel title7;
        private JLabel title8;
        private JLabel title9;
        private JLabel title10;
        private JLabel title11;
        private JLabel title12;
        private JLabel title13;
        private JLabel title14;
        private JLabel title15;
        private JLabel label1;
        private JLabel title16;
        private JLabel title17;
        private JLabel title18;
        private JLabel title19;
        private JLabel title20;
        private JLabel title21;
        private JLabel title22;
        private JLabel label2;
    }
}
