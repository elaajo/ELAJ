import java.io.*;
import java.util.ArrayList;

public class HistoriqueCalculs {
    private ArrayList<String> historique = new ArrayList<>();

    // Méthode pour ajouter un calcul à l'historique
    public void ajouterCalcul(Reseau reseau) {
        historique.add("IP: " + reseau + ", Plage: " + reseau.getPlageAdresse());
    }

    // Méthode pour sauvegarder l'historique dans un fichier
    public void sauvegarderHistorique() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("historique.txt", true))) {
            for (String calcul : historique) {
                writer.write(calcul);
                writer.newLine();
            }
        }
    }
}
