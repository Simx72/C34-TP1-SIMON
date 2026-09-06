package tp1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TestDrone1 {

    private JPanel panel1;
    private JTextField champIdent;
    private JTextField champCapacite;
    private JTextField champConsommation;
    private JTextField champVitesse;
    private JTextField champNbreHresVol;
    private JSpinner spinnerHeuresSup;
    private JPanel panelHaut;
    private JPanel panelBas;
    private JButton bouton;
    private JTextField champPourcentage;
    private JTextField champEntretien;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Statistiques Drone");
        frame.setContentPane(new TestDrone1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(520, 500);  // taille de la fenêtre
        frame.setLocationRelativeTo(null);  // la fenêtre est centrée par rapport à l'écran
        frame.setVisible(true);
    }

    public TestDrone1()
    {
        SpinnerNumberModel snm = new SpinnerNumberModel(0,0,10,1);
        spinnerHeuresSup.setModel(snm);
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Drone unDrone = new Drone ( champIdent.getText(), Double.parseDouble(champCapacite.getText()), Double.parseDouble(champConsommation.getText()),
                        Double.parseDouble(champVitesse.getText()), Integer.parseInt(champNbreHresVol.getText()));
                unDrone.ajouterHeuresVol((int)spinnerHeuresSup.getValue());
                champPourcentage.setText(unDrone.pourcentageBatterieRestante() + " %");
                champEntretien.setText(unDrone.prochainEntretien() + " jours");
            }
        });
    }


}
