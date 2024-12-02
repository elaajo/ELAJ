import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateurReseauSwingApp {
    private JTextField champAdresseIP;
    private JTextField champMasque;
    private JButton boutonCalculer;
    private JTextArea zoneResultats;

    public CalculateurReseauSwingApp() {
        initialiserUI();
    }

    private void initialiserUI() {
        JFrame frame = new JFrame("Calculateur d'Adresse Réseau");
        frame.setLayout(new FlowLayout());

        champAdresseIP = new JTextField(15);
        champMasque = new JTextField(15);
        boutonCalculer = new JButton("Calculer");
        zoneResultats = new JTextArea(10, 30);

        boutonCalculer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Récupération des entrées utilisateur
                    String ip = champAdresseIP.getText();
                    String masque = champMasque.getText();
                    Reseau reseau = new Reseau(ip, masque);

                    // Calcul des résultats et affichage
                    String resultat = "Classe: " + reseau.getClasse() + "\nPlage d'adresses: " + reseau.getPlageAdresse();
                    zoneResultats.setText(resultat);

                    // Sauvegarde dans l'historique
                    HistoriqueCalculs historique = new HistoriqueCalculs();
                    historique.ajouterCalcul(reseau);
                    historique.sauvegarderHistorique();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage());
                }
            }
        });

        frame.add(new JLabel("Adresse IP:"));
        frame.add(champAdresseIP);
        frame.add(new JLabel("Masque de sous-réseau:"));
        frame.add(champMasque);
        frame.add(boutonCalculer);
        frame.add(new JScrollPane(zoneResultats));

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculateurReseauSwingApp();
    }
}
