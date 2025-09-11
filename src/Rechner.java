import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechner extends JFrame{
    private JPanel panel;
    private JButton button_klammer_auf;
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
    private JButton button_klammer_zu;
    private JButton button_del_eingabe;
    private JButton button_del_alles;
    private JButton button_add;
    private JButton button_sub;
    private JButton button_div;
    private JButton button_mul;
    private JButton button_berechnen;
    private JLabel ausgabe1;
    private JLabel ausgabe2;

    private String ausgabe = "";

    public Rechner(String titel) {

        super(titel);
        // Grundeinstellungen
        setContentPane(panel);
        setVisible(true);
        //Fenstergröße definieren
        setSize(500, 300);
        // das Fenster soll mittig erstellt werden
        setLocationRelativeTo(null);
        // Fenstergröße darf nicht geändert werden
        //TODO: Fenstergröße feststellen
        //setResizable(false);


        //die Standardaktion setzen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //*******************************
        //TODO: Bild für delete einfügen
        //button_del_alles.setIcon(new ImageIcon("bitmaps/delete.png"));
        //button_del_alles.setText("");
        //*******************************



        button_null.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 0;
                ausgabe1.setText(ausgabe);
            }
        });
        button_eins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 1;
                ausgabe1.setText(ausgabe);
            }
        });
        button_zwei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 2;
                ausgabe1.setText(ausgabe);
            }
        });
        button_drei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 3;
                ausgabe1.setText(ausgabe);
            }
        });
        button_vier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 4;
                ausgabe1.setText(ausgabe);
            }
        });
        button_fuenf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 5;
                ausgabe1.setText(ausgabe);
            }
        });
        button_sechs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 6;
                ausgabe1.setText(ausgabe);
            }
        });
        button_sieben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 7;
                ausgabe1.setText(ausgabe);
            }
        });
        button_acht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 8;
                ausgabe1.setText(ausgabe);
            }
        });
        button_neun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += 9;
                ausgabe1.setText(ausgabe);
            }
        });
        button_komma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += ",";
                ausgabe1.setText(ausgabe);
            }
        });
        button_klammer_auf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += "(";
                ausgabe1.setText(ausgabe);
            }
        });
        button_klammer_zu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe += ")";
                ausgabe1.setText(ausgabe);
            }
        });
    }
}
