import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechner extends JFrame{
    private JPanel panel;
    private JButton button1;

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
        setResizable(false);


        //die Standardaktion setzen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
