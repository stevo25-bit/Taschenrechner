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
        logik.setF_durchNull(false);

        logik.anzeige('+', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("5 +", ausgabe2.getText());
        assertEquals("5 + ", ausgabe3.getText());
        assertEquals("", logik.getEingabe1());
        assertFalse(logik.getF_durchNull());
    }

    @Test
    void testBerechnungMitVorherigerEingabe(){
        logik.setEingabe1("5");
        ausgabe1.setText("");
        ausgabe2.setText("5 +");
        ausgabe3.setText("5 + ");
        logik.setEingabe3("5 + ");
        logik.setF_durchNull(false);

        logik.anzeige('+', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("10 +", ausgabe2.getText());
        assertEquals("5 + 5 + ", logik.getEingabe3());
        logik.setF_durchNull(false);

    }

    @Test
    void testBerechnungMitVorherigerEingabeAlsErgebnis(){
        logik.setEingabe1("5");
        ausgabe1.setText("");
        ausgabe2.setText("5 +");
        ausgabe3.setText("5 + ");
        logik.setEingabe3("5 + ");
        logik.setF_durchNull(false);

        logik.anzeige(' ', ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("5 + 5", ausgabe3.getText());
        logik.setF_durchNull(false);

    }

    //berechnung testen:
    @Test
    void testAddition() {
        logik.setEingabe1("3");
        String result = logik.berechnung("5 +");
        assertEquals("8", result);
    }

    @Test
    void testSubtraktion() {
        logik.setEingabe1("2.5");
        String result = logik.berechnung("7,5 -"); // mit Komma
        assertEquals("5", result);
    }

    @Test
    void testMultiplikation() {
        logik.setEingabe1("4");
        String result = logik.berechnung("3 *");
        assertEquals("12", result);
    }

    @Test
    void testDivision() {
        logik.setEingabe1("2");
        String result = logik.berechnung("8 /");
        assertEquals("4", result);
    }

    @Test
    void testDivisionMitKomma() {
        logik.setEingabe1("0,5");
        String result = logik.berechnung("2 /");
        assertEquals("4", result);
    }

    @Test
    void testNegativeZahlen() {
        logik.setEingabe1("-3");
        String result = logik.berechnung("-2 +");
        assertEquals("-5", result);
    }

    //berechnen testen
    @Test
    void testBerechnenMitBeidenEingaben() {
        logik.setEingabe1("3");
        ausgabe1.setText("3");
        ausgabe2.setText("5 +");
        logik.setEingabe3("");
        logik.setF_durchNull(false);

        logik.berechnen(ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("", ausgabe2.getText());
        assertTrue(ausgabe3.getText().contains("= 8"));
        assertEquals("", logik.getEingabe1());
        assertFalse(logik.getF_durchNull());
    }

    @Test
    void testBerechnenMitLetzterEingabe() {
        ausgabe1.setText("");
        ausgabe2.setText("");
        ausgabe3.setText("5 + 2\n= 7");
        logik.setEingabe1("2");
        logik.setF_durchNull(false);

        logik.berechnen(ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", ausgabe1.getText());
        assertEquals("", ausgabe2.getText());
        assertTrue(ausgabe3.getText().contains("= 9"));
    }

    @Test
    void testBerechnenAllesLeer() {
        ausgabe1.setText("");
        ausgabe2.setText("");
        ausgabe3.setText("");
        logik.setEingabe1("3");

        logik.berechnen(ausgabe1, ausgabe2, ausgabe3);

        // Nichts passiert
        assertEquals("", ausgabe1.getText());
        assertEquals("", ausgabe2.getText());
        assertEquals("", ausgabe3.getText());
    }

    @Test
    void testDivisionDurchNull() {
        logik.setEingabe1("0");
        ausgabe1.setText("0");
        ausgabe2.setText("5 /");
        logik.setF_durchNull(false);

        logik.berechnen(ausgabe1, ausgabe2, ausgabe3);

        assertEquals("", logik.getEingabe1());
        assertEquals("", ausgabe1.getText());
        assertFalse(logik.getF_durchNull()); // wird nach Berechnung zurückgesetzt
    }

}
