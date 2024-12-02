public class AdresseIP {
    protected int[] octets = new int[4];  // Tableau d'octets pour l'adresse IP

    // Constructeur qui initialise l'adresse IP et vérifie sa validité
    public AdresseIP(String ip) throws InvalidIPException {
        if (ip == null || ip.isEmpty()) throw new InvalidIPException("Adresse IP invalide.");
        String[] parts = ip.split("\\.");
        if (parts.length != 4) throw new InvalidIPException("Adresse IP invalide.");
        for (int i = 0; i < 4; i++) {
            try {
                octets[i] = Integer.parseInt(parts[i]);
                if (octets[i] < 0 || octets[i] > 255) {
                    throw new InvalidIPException("Adresse IP invalide.");
                }
            } catch (NumberFormatException e) {
                throw new InvalidIPException("Adresse IP invalide.");
            }
        }
    }

    // Méthode pour obtenir la classe de l'adresse IP
    public String getClasse() {
        if (octets[0] >= 1 && octets[0] <= 127) return "Classe A";
        if (octets[0] >= 128 && octets[0] <= 191) return "Classe B";
        if (octets[0] >= 192 && octets[0] <= 223) return "Classe C";
        return "Adresse spéciale ou non allouée";
    }
}
