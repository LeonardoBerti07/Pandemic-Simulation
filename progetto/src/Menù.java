import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Menù extends JFrame {
    private int popolazione;
    private int risorse;
    private int costotampone;
    private int velocità;
    private int infettività;
    private int sintomaticità;
    private int letalità;
    private int durata;
    private int incubazione;
    private String s = "quarantenagialli";
    private String s2;


    public Menù() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Simulatore");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,500);
        panel2 = new JPanel();
        Popolazione = new JTextField();
        Risorse = new JTextField();
        CostoTampone = new JTextField();
        NumeroIncontri = new JTextField();
        button4 = new JButton();
        Infettività = new JTextField();
        Sintomaticità = new JTextField();
        Letalità = new JTextField();
        Durata = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        comboBox1 = new JComboBox<>();
        label9 = new JLabel();
        button9 = new JButton();
        label10 = new JLabel();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        label2 = new JLabel();
        label = new JLabel();
        label6 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label1 = new JLabel();
        action4 = new popolo();
        action5 = new soldi();
        action6 = new costo();
        action7 = new incontri();
        action8 = new infetto();
        action9 = new sintomo();
        action10 = new letale();
        action11 = new tempo();
        action13 = new stretgia1();
        action14 = new inizio();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel2 ========
        {
            panel2.setBackground(new Color(51, 110, 123));
            panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel2. getBorder
            ( )) ); panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
            panel2.setLayout(null);
            panel2.add(Popolazione);
            Popolazione.setBounds(600, 40, 190, 30);
            panel2.add(Risorse);
            Risorse.setBounds(600, 120, 190, 30);
            panel2.add(CostoTampone);
            CostoTampone.setBounds(600, 80, 190, 30);
            panel2.add(NumeroIncontri);
            NumeroIncontri.setBounds(600, 160, 190, 30);

            //---- button4 ----
            button4.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button4.setAction(action7);
            panel2.add(button4);
            button4.setBounds(900, 160, 100, 25);
            panel2.add(Infettività);
            Infettività.setBounds(600, 220, 190, 30);
            panel2.add(Sintomaticità);
            Sintomaticità.setBounds(600, 260, 190, 30);
            panel2.add(Letalità);
            Letalità.setBounds(600, 300, 190, 30);
            panel2.add(Durata);
            Durata.setBounds(600, 340, 190, 30);

            //---- button5 ----
            button5.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button5.setAction(action8);
            panel2.add(button5);
            button5.setBounds(900, 220, 100, 25);

            //---- button6 ----
            button6.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button6.setAction(action9);
            panel2.add(button6);
            button6.setBounds(900, 260, 100, 25);

            //---- button7 ----
            button7.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button7.setAction(action10);
            panel2.add(button7);
            button7.setBounds(900, 300, 100, 25);

            //---- button8 ----
            button8.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button8.setAction(action11);
            panel2.add(button8);
            button8.setBounds(900, 340, 100, 25);

            //---- comboBox1 ----
            comboBox1.setMaximumRowCount(11);
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Quarantena positivi",
                "Lockdown",
                "Spartana",
                "Cerca cura basso",
                "Cerca cura medio",
                "Cerca cura alto",
                "Nessuna"
            }));
            comboBox1.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            comboBox1.setAction(action13);
            panel2.add(comboBox1);
            comboBox1.setBounds(600, 380, 150, 30);

            //---- label9 ----
            label9.setText("Scegli la tua strategia");
            label9.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label9.setBackground(new Color(238, 238, 238));
            label9.setForeground(new Color(238, 238, 238));
            panel2.add(label9);
            label9.setBounds(420, 380, 150, 30);

            //---- button9 ----
            button9.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button9.setAction(action14);
            panel2.add(button9);
            button9.setBounds(600, 440, 190, 30);

            //---- label10 ----
            label10.setText("Simulatore malattia");
            label10.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 20));
            label10.setForeground(new Color(238, 238, 238));
            panel2.add(label10);
            label10.setBounds(610, 0, 350, 30);

            //---- button10 ----
            button10.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button10.setAction(action5);
            panel2.add(button10);
            button10.setBounds(900, 120, 100, 25);

            //---- button11 ----
            button11.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button11.setAction(action6);
            panel2.add(button11);
            button11.setBounds(900, 80, 100, 25);

            //---- button12 ----
            button12.setText("conferma");
            button12.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            button12.setAction(action4);
            panel2.add(button12);
            button12.setBounds(900, 40, 100, 25);

            //---- label2 ----
            label2.setText("Costo del tampone in $");
            label2.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label2.setBackground(new Color(238, 238, 238));
            label2.setForeground(new Color(238, 238, 238));
            panel2.add(label2);
            label2.setBounds(420, 75, 176, 35);

            //---- label ----
            label.setText("Media incontri al giorno per ogni persona");
            label.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label.setBackground(new Color(238, 238, 238));
            label.setForeground(new Color(238, 238, 238));
            panel2.add(label);
            label.setBounds(350, 160, 255, 30);

            //---- label6 ----
            label6.setText("Sintomaticit\u00e0 in %");
            label6.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label6.setBackground(new Color(238, 238, 238));
            label6.setForeground(new Color(238, 238, 238));
            panel2.add(label6);
            label6.setBounds(420, 260, 130, 30);

            //---- label5 ----
            label5.setText("Infettivit\u00e0 in %");
            label5.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label5.setBackground(new Color(238, 238, 238));
            label5.setForeground(new Color(238, 238, 238));
            panel2.add(label5);
            label5.setBounds(420, 220, 130, 30);

            //---- label7 ----
            label7.setText("Letalit\u00e0 in %");
            label7.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label7.setBackground(new Color(238, 238, 238));
            label7.setForeground(new Color(238, 238, 238));
            panel2.add(label7);
            label7.setBounds(420, 300, 130, 30);

            //---- label8 ----
            label8.setText("Inserisci durata media per persona");
            label8.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label8.setBackground(new Color(238, 238, 238));
            label8.setForeground(new Color(238, 238, 238));
            panel2.add(label8);
            label8.setBounds(350, 340, 230, 30);

            //---- label3 ----
            label3.setText("Risorse in $");
            label3.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label3.setBackground(new Color(238, 238, 238));
            label3.setForeground(new Color(238, 238, 238));
            panel2.add(label3);
            label3.setBounds(420, 120, 155, 30);

            //---- label4 ----
            label4.setText("Popolazione");
            label4.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
            label4.setBackground(new Color(238, 238, 238));
            label4.setForeground(new Color(238, 238, 238));
            panel2.add(label4);
            label4.setBounds(420, 40, 130, 30);

            //---- label1 ----
            label1.setText("");
            //label1.setIcon(new ImageIcon(getClass().getResource("/Icone/sfondo.gif")));
            label1.setMaximumSize(new Dimension(1920, 1080));
            label1.setMinimumSize(new Dimension(1920, 1080));
            label1.setPreferredSize(new Dimension(1920, 1080));
            panel2.add(label1);
            label1.setBounds(280, -30, 1920, 1080);
        }
        contentPane.add(panel2);
        panel2.setBounds(-280, 0, 1920, 1080);

        contentPane.setPreferredSize(new Dimension(900, 700));
        setSize(900, 700);
        setLocationRelativeTo(getOwner());
    }

    public static void main(String[] args) {
        Menù ciao = new Menù();
    }
    private JPanel panel2;
    private JTextField Popolazione;
    private JTextField Risorse;
    private JTextField CostoTampone;
    private JTextField NumeroIncontri;
    private JButton button4;
    private JTextField Infettività;
    private JTextField Sintomaticità;
    private JTextField Letalità;
    private JTextField Durata;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JComboBox<String> comboBox1;
    private JLabel label9;
    private JButton button9;
    private JLabel label10;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JLabel label2;
    private JLabel label;
    private JLabel label6;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JLabel label3;
    private JLabel label4;
    private JLabel label1;
    private popolo action4;
    private soldi action5;
    private costo action6;
    private incontri action7;
    private infetto action8;
    private sintomo action9;
    private letale action10;
    private tempo action11;
    private stretgia1 action13;
    private inizio action14;

    private class popolo extends AbstractAction {
        private popolo() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            popolazione = Integer.parseInt(Popolazione.getText());
        }

        private void initComponents() {
            putValue(NAME, "conferma");
        }
    }


    private class costo extends AbstractAction {
        private costo() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            costotampone = Integer.parseInt(CostoTampone.getText());
        }
    }

    private class soldi extends AbstractAction {
        private soldi() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            if (Integer.parseInt(Risorse.getText()) <= 100 * popolazione * costotampone) {
                if(Integer.parseInt(Risorse.getText()) == 1){
                    risorse = 2;
                }else{
                    risorse = Integer.parseInt(Risorse.getText());
                }
            } else {
                System.out.println("Valore troppo grande per questa popolazione. Inserisci un nuovo valore");
            }

        }
    }

    private class incontri extends AbstractAction {
        private incontri() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            velocità = Integer.parseInt(NumeroIncontri.getText());
        }
    }

    private class infetto extends AbstractAction {
        private infetto() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            infettività = Integer.parseInt(Infettività.getText());
        }
    }

    private class sintomo extends AbstractAction {
        private sintomo() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            sintomaticità = Integer.parseInt(Sintomaticità.getText());
        }
    }

    private class letale extends AbstractAction {
        private letale() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            letalità = Integer.parseInt(Letalità.getText());
        }
    }

    private class tempo extends AbstractAction {
        private tempo() {
            putValue(NAME, "conferma");
        }

        public void actionPerformed(ActionEvent e) {
            durata = Integer.parseInt(Durata.getText());
        }
    }

    private class stretgia1 extends AbstractAction {
        private stretgia1() {
        }

        public void actionPerformed(ActionEvent e) {
        }
    }

    private class inizio extends AbstractAction {
        private inizio() {
            putValue(NAME, "Inizia simulazione");
        }

        public void actionPerformed(ActionEvent e) {
            s = (String) comboBox1.getSelectedItem();
            boolean lockdown = false;  //serve per verificare se siamo in lockdown oppure no
            boolean fase2 = false; //serve per verificare se siamo in fase2
            boolean primorosso = false; //serve per dire che abbiamo avuto il primo sintomatico e quindi possiamo far partire la strategia

            Malattia malattia = new Malattia(infettività, sintomaticità, letalità, durata); //creiamo la malattia

            Mondo mondo = new Mondo(popolazione, risorse, costotampone, velocità, malattia); //creiamo il mondo

            Mondo.Strategie strategia = mondo.new Strategie(); //creiamo la strategia

            while (mondo.getRisorse() > 0 && mondo.getNeri() != mondo.getPersone() && mondo.getBlu() + mondo.getVerdi() != mondo.getPersone() - mondo.getNeri()) { //se una delle tre condizioni non è più verificata finisce la simulazione
                if (mondo.getRisorse() <= ((risorse / 100) * 30) && s.equals("Lockdown") && fase2 == false) { //se utilizziamo la strategia "lockdown" se arriviamo ad avere il 30% delle risorse, stoppiamo il lockdown per paura di finire le risorse troppo presto
                    strategia.antilockdown();
                    fase2 = true;
                    System.out.println("antilockdown " + mondo.getGiorni());
                }
                for (int i = 0; i < popolazione; i++) { //settiamo il numero di incontri che una persona farà durante il giorno
                    if(!mondo.getPopolazione().get(i).getSalute().equals("nero")){
                        mondo.getPopolazione().get(i).setIncontri();
                    }
                }
                for (int i = 0; i < mondo.getPopolazione().size(); i++) { //incominciamo a far muovere tutte le persone
                    Mondo.Persona pro = mondo.getPopolazione().get(i);
                    if (pro.isMovimento() == true) { //se è in movimento può effetuare gli incontri
                        int incontri = pro.getIncontri();
                        for (int x = 0; x < incontri; x++) {
                            int chi_incontro = ThreadLocalRandom.current().nextInt(0, mondo.getPopolazione().size());
                            if (mondo.getPopolazione().get(chi_incontro).getIncontri() > 0) { //se la persona che incontriamo può effetuare gli incontri allora si verifica l'incontro tra le due persone
                                mondo.getPopolazione().get(chi_incontro).rimuoviIncontri();
                                pro.rimuoviIncontri(); //viene rimosso l'incontro alla persona incontrata
                                mondo.incontri(pro, mondo.getPopolazione().get(chi_incontro));
                            } else {
                                continue;
                            }
                        }
                    } else {
                        int smartworking = ThreadLocalRandom.current().nextInt(1, 101); //se stiamo utilizzando la strategia "lockdown" il 40% della popolazione lavora in smartworking
                        if (lockdown == true && smartworking <= 40) {
                        } else mondo.setRisorse();
                    }
                    if (pro.getSalute() == "verde") {
                        if (pro.getGiorno_x() != -1) { //verifichiamo che non sia stato contagiato. In tal caso incomincia il periodo di incubazione
                            pro.setGiorno_x();
                            if (pro.getGiorno_x() == malattia.getIncubazione()) { //quando è finito il tempo dell'incubazione la persona diventa asintomatica
                                pro.setSalute("giallo");
                                mondo.setVerdi();
                                mondo.setGialli(1);
                            }
                        }
                    } else if (pro.getSalute() == "giallo") {
                        pro.setGiorno_x();
                        if (pro.getGiorno_x() == durata / 3) { //è il giorno in cui la persona può sviluppare i sintomi o rimanere asintomatica
                            int sintomatico = ThreadLocalRandom.current().nextInt(1, 101);
                            if (sintomatico <= sintomaticità) {
                                pro.setSalute("rosso");
                                primorosso = true;
                                if (pro.getMovimento() != false) {
                                    pro.setMovimento();
                                }
                                mondo.setGialli(-1);
                                mondo.setRossi(1);
                            }
                        } else if (pro.getGiorno_x() == durata) { //quando finisce la durata della malattia, la persona è guarita
                            if ((pro.isMovimento() == false && lockdown == false) || (pro.isMovimento() == false && s.equals("quarantenagialli"))) {
                                pro.setMovimento();
                            }
                            pro.setSalute("blu");
                            mondo.setGialli(-1);
                            mondo.setBlu();
                        }
                    } else if (pro.getSalute() == "rosso") {
                        pro.setGiorno_x();
                        if (pro.getGiorno_x() == durata) { //quando finisce la durata della malattia, la persona viene curata
                            pro.setSalute("blu");
                            if (lockdown == false) {
                                pro.setMovimento();
                            }
                            mondo.setRossi(-1);
                            mondo.setBlu();
                        } else if (pro.getGiorno_x() == (durata / 2) + 2) { //è il giorno in cui si decide se una persona muore oppure rimane in vita
                            int letale = ThreadLocalRandom.current().nextInt(1, 101);
                            if (letale <= letalità) {
                                pro.setSalute("nero");
                                mondo.setRossi(-1);
                                mondo.setNeri();
                            }
                        }
                    }
                }
                if (primorosso == true) { //quando è stato verificato il primo sintomatico allora possiamo applicare la strategia
                    if (s.equals("Quarantena gialli")) {
                        strategia.quarantenaGialli();
                    } else if (s.equals("Lockdown") && lockdown == false) {
                        lockdown = true;
                        strategia.lockdown();
                    } else if (s.equals("Cerca cura basso")) {
                        s2 = "basso";
                        strategia.cercacura(s2);
                    }else if (s.equals("Cerca cura medio")) {
                        s2 = "medio";
                        strategia.cercacura(s2);
                    }else if (s.equals("Cerca cura alto")) {
                        s2 = "alto";
                        strategia.cercacura(s2);
                    } else if (s.equals("Spartana")) {
                        strategia.spartana();
                    } else if (s.equals("Niente")){
                        strategia.niente();
                    }
                }
                mondo.setRisorse(mondo.getRossi()); //curiamo tutte le persone sintomatiche
                mondo.setGiorni(); //nuovo giorno
            }
            setVisible(false);
            dispose();
            Mondo.Finale fine = mondo.new Finale();
            fine.setVisible(true);
            fine.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}


