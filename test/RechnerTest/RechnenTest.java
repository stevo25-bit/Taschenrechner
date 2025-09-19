package RechnerTest;

import Main.Rechner.RechnerLogik;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class RechnenTest {
    private RechnerLogik logik = new RechnerLogik();
    private JLabel ausgabe1 = new JLabel();
    private JLabel ausgabe2 = new JLabel();
    private JTextArea ausgabe3 = new JTextArea();
    private boolean f_durchNull = false;


    // Ausgabe Methode testen
    @Test
    void testAusgabeGanzzahl() {
        assertEquals("5", logik.ausgabe(5.0));
        assertEquals("0", logik.ausgabe(0.0));
        assertEquals("-3", logik.ausgabe(-3.0));
    }

    @Test
    void testAusgabeMitKomma() {
        assertEquals("3,5", logik.ausgabe(3.5));
        assertEquals("-2,25", logik.ausgabe(-2.25));
    }

    @Test
    void testAusgabeOhneÜberflüssigeNullen() {
        assertEquals("2,1", logik.ausgabe(2.1000000000));
        assertEquals("7,123456789", logik.ausgabe(7.1234567890));
    }

    @Test
    void testAusgabeSehrGenau() {
        assertEquals("3,1415926536", logik.ausgabe(Math.PI)); // wird auf 10 Nachkommastellen gekürzt
    }

    //Anzeige testen:
    @Test
    void testErsteEingabe() {
        logik.setEingabe1("5");
        ausgabe1.setText("");
        ausgabe2.setText("");
        ausgabe3.setText("");
        f_durchNull = false;

        logik.anzeige('+', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("5 +", ausgabe2.getText());
        assertEquals("5 + ", ausgabe3.getText());
        assertEquals("", logik.getEingabe1());
        assertFalse(f_durchNull);
    }

    @Test
    void testBerechnungMitVorherigerEingabe(){
        logik.setEingabe1("5");
        ausgabe1.setText("");
        ausgabe2.setText("5 +");
        ausgabe3.setText("5 + ");
        logik.setEingabe3("5 + ");
        f_durchNull = false;

        logik.anzeige('+', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("10 +", ausgabe2.getText());
        assertEquals("5 + 5 + ", logik.getEingabe3());
        f_durchNull = false;

    }

    @Test
    void testBerechnungMitVorherigerEingabeAlsErgebnis(){
        logik.setEingabe1("5");
        ausgabe1.setText("");
        ausgabe2.setText("5 +");
        ausgabe3.setText("5 + ");
        logik.setEingabe3("5 + ");
        f_durchNull = false;

        logik.anzeige(' ', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("5 + 5", ausgabe3.getText());
        f_durchNull = false;

    }

}
