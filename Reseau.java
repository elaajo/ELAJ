public class Reseau extends AdresseIP {
    private String masque;  // Masque de sous-réseau en format décimal

    private String adresseDebut;
    private String adresseFin;

    // Constructeur
    public Reseau(String ip, String masque) throws InvalidIPException {
        super(ip);
        this.masque = masque;
        calculerPlageAdresse();
    }

    // Méthode pour calculer la plage d'adresses en fonction de l'IP et du masque
    private void calculerPlageAdresse() {
        // Implémentation simplifiée pour calculer la plage
        // Exemple, cela serait basé sur les octets de l'adresse IP et du masque
        adresseDebut = "192.168.0.1";  // Calculer la première adresse disponible
        adresseFin = "192.168.0.254";  // Calculer la dernière adresse disponible
    }

    // Méthode pour récupérer le masque en notation binaire
    public String getMasqueEnBits() {
        StringBuilder masqueBinaire = new StringBuilder();
        String[] partiesMasque = masque.split("\\.");
        for (String part : partiesMasque) {
            int val = Integer.parseInt(part);
            masqueBinaire.append(String.format("%8s", Integer.toBinaryString(val)).replace(' ', '0'));
        }
        return masqueBinaire.toString();
    }

    // Méthodes pour récupérer les plages d'adresses
    public String getPlageAdresse() {
        return adresseDebut + " - " + adresseFin;
    }
}
