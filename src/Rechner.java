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

    private String eingabe1 = "";
    private double eingabe2 = 0;

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

        // Anzeige beim erstllen vereinfachen
        ausgabe1.setText("");
        ausgabe2.setText("");

        //*******************************



        button_null.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 0;
                ausgabe1.setText(eingabe1);
            }
        });
        button_eins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 1;
                ausgabe1.setText(eingabe1);
            }
        });
        button_zwei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 2;
                ausgabe1.setText(eingabe1);
            }
        });
        button_drei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 3;
                ausgabe1.setText(eingabe1);
            }
        });
        button_vier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 4;
                ausgabe1.setText(eingabe1);
            }
        });
        button_fuenf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 5;
                ausgabe1.setText(eingabe1);
            }
        });
        button_sechs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 6;
                ausgabe1.setText(eingabe1);
            }
        });
        button_sieben.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 7;
                ausgabe1.setText(eingabe1);
            }
        });
        button_acht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 8;
                ausgabe1.setText(eingabe1);
            }
        });
        button_neun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += 9;
                ausgabe1.setText(eingabe1);
            }
        });
        button_komma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += ",";
                ausgabe1.setText(eingabe1);
            }
        });
        button_klammer_auf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += "(";
                ausgabe1.setText(eingabe1);
            }
        });
        button_klammer_zu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 += ")";
                ausgabe1.setText(eingabe1);
            }
        });
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeige('+');
            }
        });
        button_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeige('-');
            }
        });
        button_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeige('/');
            }
        });
        button_mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeige('*');
            }
        });
        button_berechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anzeige(' ');
            }
        });
    }








    private void anzeige(char operand){
        if (ausgabe2.getText().equals("")){
            ausgabe2.setText(eingabe1 + " " + operand);
            eingabe1 = "";
            ausgabe1.setText("");
        }
        else {
            ausgabe2.setText(berechnung() + " " + operand);
            eingabe1 = "";
            ausgabe1.setText("");
        }
    }

    private String berechnung(){
        String[] parts = ausgabe2.getText().split(" ");
        double zahl = Double.parseDouble(parts[0]);
        char operator = parts[1].charAt(0);

        if (operator == '+'){
            zahl += Double.parseDouble(eingabe1);
        } else if (operator == '-') {
            zahl -= Double.parseDouble(eingabe1);
        } else if (operator == '/') {
            zahl /= Double.parseDouble(eingabe1);
        } else if (operator == '*') {
            zahl *= Double.parseDouble(eingabe1);
        }

        // gibt den String entweder mit oder ohne Nachkommerstellen raus.
        if (zahl % 1 == 0){
            return String.format("%.0f", zahl);
        }
        else {
            return String.format("%.5f", zahl);
        }

    }
}
