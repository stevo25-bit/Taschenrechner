package Main.Rechner;

import javax.swing.*;

public class RechnerLogik{

    private String eingabe1 = "";
    private String eingabe3 = "";
    private boolean f_durchNull = false;

    public String getEingabe1() {
        return eingabe1;
    }
    public void setEingabe1(String eingabe1) {
        this.eingabe1 = eingabe1;
    }

    public String getEingabe3() {
        return eingabe3;
    }
    public void setEingabe3(String eingabe3) {
        this.eingabe3 = eingabe3;
    }
    public boolean getF_durchNull() {
        return f_durchNull;
    }
    public void setF_durchNull(boolean f_durchNull) {
        this.f_durchNull = f_durchNull;
    }

    public void anzeige(char operand, JLabel ausgabe1, JLabel ausgabe2, JTextArea ausgabe3){
        if (ausgabe2.getText().isEmpty()){
            ausgabe2.setText(eingabe1 + " " + operand);
            eingabe1 = "";
            ausgabe1.setText("");

            if (ausgabe3.getText().isEmpty()){
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
            if (eingabe1.equals("0") && ausgabe2.getText().charAt(ausgabe2.getText().length() - 1) == '/'){
                JOptionPane.showMessageDialog(
                        null,   // Bezug auf das JFrame
                        "Teilen durch 0 nicht möglich!!!",
                        "Achtung!",
                        JOptionPane.INFORMATION_MESSAGE);
                //Eingabe löschen
                eingabe1 = "";
                ausgabe1.setText("");
                f_durchNull = true;
            } else {
                if (operand == ' ') {
                    ausgabe2.setText(berechnung(ausgabe2.getText()));
                    eingabe3 += eingabe1;
                    ausgabe3.setText(eingabe3);
                    eingabe1 = "";
                    ausgabe1.setText("");
                } else {
                    ausgabe2.setText(berechnung(ausgabe2.getText()) + " " + operand);
                    eingabe3 += eingabe1 + " " + operand + " ";
                    ausgabe3.setText(eingabe3);
                    eingabe1 = "";
                    ausgabe1.setText("");
                }
            }

        }
    }

    public String berechnung(String ausgabe2){
        // Kommas in Punkte umwandeln und anhand der Leerzeichen aufteilen
        String[] parts = ausgabe2.replace(',', '.').split(" ");
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

        return ausgabe(zahl);
    }

    public String ausgabe(Double eingabe){
        // gibt den String entweder mit oder ohne Nachkommerstellen raus.
        if (eingabe % 1 == 0){
            return String.format("%.0f", eingabe);
        }
        else {
            // Nullen am Ende abschneiden
            String ausgabe = String.format("%.10f", eingabe); // Auf 10 Stellen kürzen
            int laenge = ausgabe.length();
            for (int i = 0; i < laenge; i++){
                if (ausgabe.endsWith("0")) {
                    ausgabe = ausgabe.substring(0, ausgabe.length() - 1);
                }
            }
            return ausgabe;
        }
    }

    public void berechnen (JLabel ausgabe1, JLabel ausgabe2, JTextArea ausgabe3){
        if (!ausgabe1.getText().isEmpty() && !ausgabe2.getText().isEmpty()){
            anzeige(' ', ausgabe1, ausgabe2, ausgabe3);
            // Wenn durch null geteilt wird, dann nichts ausgeben
            if (f_durchNull){
                //Eingabe löschen
                eingabe1 = "";
                ausgabe1.setText("");
                f_durchNull = false;
            } else {
                eingabe3 += "\n = " + ausgabe2.getText();
                ausgabe3.setText(eingabe3);
                ausgabe2.setText("");
            }
        } else if (ausgabe1.getText().isEmpty() && !ausgabe2.getText().isEmpty()){
            // Übergibt die letzte Zahl der Eingabe
            String[] temp = ausgabe3.getText().split("\n");
            if (temp.length > 1){
                String[] temp1 = temp[temp.length - 1].split(" ");
                eingabe1 = temp1[temp1.length - 2];
            } else {
                String[] temp1 = temp[0].split(" ");
                eingabe1 = temp1[temp1.length - 2];
            }
            // Übergibt den letzten Opperanten
            anzeige(ausgabe3.getText().charAt(ausgabe3.getText().length() - 2), ausgabe1, ausgabe2, ausgabe3);
            // Wenn durch null geteilt wird, dann nichts machen
            if (f_durchNull){
                //Eingabe löschen
                eingabe1 = "";
                ausgabe1.setText("");
                f_durchNull = false;
            } else {
                // letzte drei Zeichen wieder abschneiden
                eingabe3 = eingabe3.substring(0, eingabe3.length() - 3);
                //Alles ausgeben
                eingabe3 += "\n = " + ausgabe2.getText().substring(0, ausgabe2.getText().length() - 2);
                ausgabe3.setText(eingabe3);
                ausgabe2.setText("");
                eingabe1 = "";
            }
        } else if (ausgabe1.getText().isEmpty() && ausgabe2.getText().isEmpty() && !ausgabe3.getText().isEmpty()){

            // Erstmal alle Informationen holen, die wir brauchen
            String[] temp = ausgabe3.getText().split("\n");
            String[] temp1 = temp[temp.length - 2].split(" ");
            String[] temp2 = temp[temp.length - 1].split("= ");

            //Werte zuweisen
            eingabe1 = temp1[temp1.length - 1];
            ausgabe2.setText(temp2[1] + " " + temp1[temp1.length - 2]);

            //Berechnung durchführen
            eingabe3 += "\n" + temp[temp.length -2] + " " + temp1[temp1.length - 2] + " " + temp1[temp1.length - 1];
            eingabe3 += "\n = " + berechnung(ausgabe2.getText());
            ausgabe3.setText(eingabe3);
            ausgabe2.setText("");
            eingabe1 = "";

        } else {
            // Nichts machen
        }
    }
}


