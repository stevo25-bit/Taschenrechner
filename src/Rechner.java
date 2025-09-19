import Main.Rechner.RechnerLogik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechner extends JFrame{

    private RechnerLogik logik = new RechnerLogik();

    private JPanel panel;
    private JTextArea ausgabe3;
    private JButton button_eins;
    private JButton button_zwei;
    private JButton button_drei;
    private JButton button_vier;
    private JButton button_fuenf;
    private JButton button_sechs;
    private JButton button_sieben;
    private JButton button_acht;
    private JButton button_neun;
    private JButton button_null;
    private JButton button_vorzeichen;
    private JButton button_komma;
    private JButton button_del_back;
    private JButton button_del_alles;
    private JButton button_add;
    private JButton button_sub;
    private JButton button_div;
    private JButton button_mul;
    private JButton button_berechnen;
    private JLabel ausgabe1;
    private JLabel ausgabe2;
    private JScrollPane scrollbar;
    private JButton button_del_eingabe;
    private JButton button_hochzwei;
    private JButton button_wurzel;


    public Rechner(String titel) {

        super(titel);
        // Grundeinstellungen
        setContentPane(panel);
        setVisible(true);
        //Fenstergröße definieren
        setSize(550, 320);
        // das Fenster soll mittig erstellt werden
        setLocationRelativeTo(null);
        // Fenstergröße darf nicht geändert werden
        //TODO: Fenstergröße feststellen
        //setResizable(false);

        // Größe fest setzten, damit die Fenster nicht springen
        scrollbar.setPreferredSize(new Dimension(200, 100));

        //die Standardaktion setzen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button_del_back.setIcon(new ImageIcon("bitmaps/loschen.png"));
        button_del_back.setText("");

        // Anzeige beim Erstellen vereinfachen
        ausgabe1.setText("");
        ausgabe2.setText("");

        // Button von hoch2 und Wurzel benennen
        button_hochzwei.setText("x\u00B2");
        button_wurzel.setText("√x");

        button_null.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 0);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_eins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 1);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_zwei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 2);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_drei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 3);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_vier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 4);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_fuenf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 5);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_sechs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 6);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_sieben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 7);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_acht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 8);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_neun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + 9);
                ausgabe1.setText(logik.getEingabe1());
            }
        });
        button_komma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Nur ein Komma in der Eingabe zulassen
                if (logik.getEingabe1().contains(",")){
                    JOptionPane.showMessageDialog(
                            Rechner.this,   // Bezug auf das JFrame
                            "Nur ein Komma möglich!!!",
                            "Achtung!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    //Wenn nichts drin steht, dann mit 0 beginnen
                    if (logik.getEingabe1().length() == 0){
                        logik.setEingabe1(logik.getEingabe1() + "0,");
                        ausgabe1.setText(logik.getEingabe1());
                    } else {
                        logik.setEingabe1(logik.getEingabe1() + ",");
                        ausgabe1.setText(logik.getEingabe1());
                    }
                }
            }
        });
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn alles leer, nichts machen
                if (ausgabe1.getText().length() < 1 && ausgabe2.getText().length() < 1){
                    //Nichts machen
                } else {
                    if (ausgabe1.getText().length() > 0) { // in Eingabe 1 was drin steht, dann berechnen
                        logik.anzeige('+',ausgabe1, ausgabe2, ausgabe3);
                    } else {
                        // ansonnsten Opperand auf + ändern
                        ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "+");
                        logik.setEingabe3(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "+ ");
                        ausgabe3.setText(logik.getEingabe3());
                    }
                }
            }
        });
        button_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn alles leer, nichts machen
                if (ausgabe1.getText().length() < 1 && ausgabe2.getText().length() < 1){
                    //Nichts machen
                } else {
                    if (ausgabe1.getText().length() > 0) {
                        logik.anzeige('-', ausgabe1, ausgabe2, ausgabe3);
                    } else {
                        // ansonnsten Opperand auf - ändern
                        ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "-");
                        logik.setEingabe3(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "- ");
                        ausgabe3.setText(logik.getEingabe3());
                    }
                }
            }
        });
        button_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn alles leer, nichts machen
                if (ausgabe1.getText().length() < 1 && ausgabe2.getText().length() < 1){
                    //Nichts machen
                } else {
                    if (ausgabe1.getText().length() > 0) {
                        logik.anzeige('/', ausgabe1, ausgabe2, ausgabe3);
                    } else {
                        // ansonnsten Opperand auf / ändern
                        ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "/");
                        logik.setEingabe3(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "/ ");
                        ausgabe3.setText(logik.getEingabe3());
                    }
                }
            }
        });
        button_mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn alles leer, nichts machen
                if (ausgabe1.getText().length() < 1 && ausgabe2.getText().length() < 1){
                    //Nichts machen
                } else {
                    if (ausgabe1.getText().length() > 0) {
                        logik.anzeige('*', ausgabe1, ausgabe2, ausgabe3);
                    } else {
                        // ansonnsten Opperand auf * ändern
                        ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "*");
                        logik.setEingabe3(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "* ");
                        ausgabe3.setText(logik.getEingabe3());
                    }
                }
            }
        });
        button_berechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.berechnen(ausgabe1, ausgabe2, ausgabe3);
            }
        });
        button_del_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logik.getEingabe1().length() > 0) {
                    logik.setEingabe1(logik.getEingabe1().substring(0, logik.getEingabe1().length() - 1));
                    ausgabe1.setText(logik.getEingabe1());
                }
            }
        });
        button_del_eingabe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + "");
                ausgabe1.setText("");
            }
        });
        button_del_alles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logik.setEingabe1(logik.getEingabe1() + "");
                logik.setEingabe3("");
                ausgabe1.setText("");
                ausgabe2.setText("");
                ausgabe3.setText("");

            }
        });
        button_vorzeichen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logik.getEingabe1().charAt(0) == '-'){
                    logik.setEingabe1(logik.getEingabe1().substring(1));
                    ausgabe1.setText(logik.getEingabe1());
                }
                else {
                    logik.setEingabe1("-" + logik.getEingabe1());
                    ausgabe1.setText(logik.getEingabe1());
                }

            }
        });
        button_hochzwei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logik.getEingabe1().length() > 0) {
                    // Falls Komma vorhanden, dann umwandeln
                    logik.setEingabe1(logik.getEingabe1().replace(',', '.'));
                    double temp = Double.parseDouble(logik.getEingabe1());
                    temp = temp * temp;
                    logik.setEingabe1(logik.ausgabe(temp));
                    ausgabe1.setText(logik.getEingabe1());
                }
            }
        });
        button_wurzel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logik.getEingabe1().length() > 0) {
                    // Falls Komma vorhanden, dann umwandeln
                    logik.setEingabe1(logik.getEingabe1().replace(',', '.'));
                    double temp = Double.parseDouble(logik.getEingabe1());
                    temp = Math.sqrt(temp);
                    logik.setEingabe1(logik.ausgabe(temp));
                    ausgabe1.setText(logik.getEingabe1());
                }
            }
        });
    }




}
