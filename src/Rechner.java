import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechner extends JFrame{
    private JPanel panel;
    private JButton button1;

    public Rechner() {

        setContentPane(panel);
        setVisible(true);
        pack();



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
