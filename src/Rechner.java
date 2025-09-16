import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechner extends JFrame{
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
    private String eingabe1 = "";
    private String eingabe3 = "";


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
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn keine Rechnung vorhanden, dann ausführen
                if (ausgabe1.getText().length() > 0){
                    anzeige('+');
                } else {
                    // ansonnsten Opperand auf + ändern
                    ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "+");
                    ausgabe3.setText(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "+ ");
                }
            }
        });
        button_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn keine Rechnung vorhanden, dann ausführen
                if (ausgabe1.getText().length() > 0){
                    anzeige('-');
                } else {
                    // ansonnsten Opperand auf - ändern
                    ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "-");
                    ausgabe3.setText(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "- ");
                }
            }
        });
        button_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn keine Rechnung vorhanden, dann ausführen
                if (ausgabe1.getText().length() > 0){
                    anzeige('/');
                } else {
                    // ansonnsten Opperand auf / ändern
                    ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "/");
                    ausgabe3.setText(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "/ ");
                }
            }
        });
        button_mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Wenn keine Rechnung vorhanden, dann ausführen
                if (ausgabe1.getText().length() > 0){
                    anzeige('*');
                } else {
                    // ansonnsten Opperand auf * ändern
                    ausgabe2.setText(ausgabe2.getText().substring(0, ausgabe2.getText().length() - 1) + "*");
                    ausgabe3.setText(ausgabe3.getText().substring(0, ausgabe3.getText().length() - 2) + "* ");
                }
            }
        });
        button_berechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ausgabe1.getText().length() > 0 && ausgabe2.getText().length() > 0){
                    anzeige(' ');
                    eingabe3 += "\n = " + ausgabe2.getText();
                    ausgabe3.setText(eingabe3);
                    ausgabe2.setText("");
                } else if (ausgabe1.getText().length() == 0 && ausgabe2.getText().length() > 0 ){
                    // Übergibt die letzte Zahl der Eingabe
                    String temp [] = ausgabe3.getText().split("\n");
                    if (temp.length > 1){
                        String temp1 [] = temp[temp.length - 1].split(" ");
                        eingabe1 = temp1[temp1.length - 2];
                    } else {
                        String temp1 [] = temp[0].split(" ");
                        eingabe1 = temp1[temp1.length - 2];
                    }
                    // Übergibt den letzten Opperanten
                    anzeige(ausgabe3.getText().charAt(ausgabe3.getText().length() - 2));
                    // letzte drei Zeichen wieder abschneiden
                    eingabe3 = eingabe3.substring(0, eingabe3.length() - 3);
                    //Alles ausgeben
                    eingabe3 += "\n = " + ausgabe2.getText().substring(0, ausgabe2.getText().length() - 2);
                    ausgabe3.setText(eingabe3);
                    ausgabe2.setText("");
                    eingabe1 = "";
                } else if (ausgabe1.getText().length() == 0 && ausgabe2.getText().length() == 0 && ausgabe3.getText().length() > 0){
                    // Erstmal alle Informationen holen, die wir brauchen
                    String temp [] = ausgabe3.getText().split("\n");
                    String temp1 [] = temp[temp.length - 2].split(" ");
                    String temp2 [] = temp[temp.length - 1].split("= ");

                    //Werte zuweisen
                    eingabe1 = temp1[temp1.length - 1];
                    ausgabe2.setText(temp2[1] + " " + temp1[temp1.length - 2]);

                    //Berechnung durchführen
                    eingabe3 += "\n" + temp[temp.length -2] + " " + temp1[temp1.length - 2] + " " + temp1[temp1.length - 1];
                    eingabe3 += "\n = " + berechnung();
                    ausgabe3.setText(eingabe3);
                    ausgabe2.setText("");
                    eingabe1 = "";

                } else {
                    // Nichts machen
                }
            }
        });
        button_del_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eingabe1.length() > 0) {
                    eingabe1 = eingabe1.substring(0, eingabe1.length() - 1);
                    ausgabe1.setText(eingabe1);
                }
            }
        });
        button_del_eingabe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 = "";
                ausgabe1.setText("");
            }
        });
        button_del_alles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe1 = "";
                eingabe3 = "";
                ausgabe1.setText("");
                ausgabe2.setText("");
                ausgabe3.setText("");

            }
        });
        button_vorzeichen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eingabe1.charAt(0) == '-'){
                    eingabe1 = eingabe1.substring(1);
                    ausgabe1.setText(eingabe1);
                }
                else {
                    eingabe1 = "-" + eingabe1;
                    ausgabe1.setText(eingabe1);
                }

            }
        });

    }








    private void anzeige(char operand){
        if (ausgabe2.getText().equals("")){
            ausgabe2.setText(eingabe1 + " " + operand);
            eingabe1 = "";
            ausgabe1.setText("");

            if (ausgabe3.getText().equals("")){
                eingabe3 += ausgabe2.getText() + " ";
                ausgabe3.setText(eingabe3);
            }
            else {
                eingabe3 +="\n" + ausgabe2.getText() + " ";
                ausgabe3.setText(eingabe3);
            }
        }
        else {
            // Entscheidung, ob die Rechnung noch weiter geht.
            if (operand == ' '){
                ausgabe2.setText(berechnung());
                eingabe3 += eingabe1;
                ausgabe3.setText(eingabe3);
                eingabe1 = "";
                ausgabe1.setText("");
            }
            else {
                ausgabe2.setText(berechnung() + " " + operand);
                eingabe3 += eingabe1 + " " + operand + " ";
                ausgabe3.setText(eingabe3);
                eingabe1 = "";
                ausgabe1.setText("");
            }
        }
    }

    private String berechnung(){
        // Kommas in Punkte umwandeln und anhand der Leerzeichen aufteilen
        String[] parts = ausgabe2.getText().replace(',', '.').split(" ");
        double zahl = Double.parseDouble(parts[0]);
        char operator = parts[1].charAt(0);

        // Kommas in Punkte umschreiben
        eingabe1 = eingabe1.replace(',', '.');

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
