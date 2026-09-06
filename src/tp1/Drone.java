package tp1;

public class Drone {
    private final String identifiant;
    private final double capaciteBatterie;  // capacité totale de la batterie en watt
    private final double consommationHeure; //en watt /heure
    private final double vitesseMoyenne; //en km/h
    private int nbreHeuresVol; // nb d'heures total que le drone a volé


    public Drone(String identifiant, double capaciteBatterie, double consommationHeure, double vitesseMoyenne, int nbreHeuresVol) {
        this.identifiant = identifiant;
        this.capaciteBatterie = capaciteBatterie;
        this.consommationHeure = consommationHeure;
        this.vitesseMoyenne = vitesseMoyenne;
        this.nbreHeuresVol = nbreHeuresVol;
    }

    // Partie A

    // 3.
    public double energieConsomme() {
        return nbreHeuresVol * consommationHeure;
    }

    // 4.
    public double energieRestante() {
        double energie = capaciteBatterie - energieConsomme();
        if (energie < 0) return 0; else return energie;
    }

    // 5.
    public double pourcentageBatterieRestante() {
        double ratio = energieRestante() / capaciteBatterie;
        return Math.round(ratio * 100);
    }

    // 6.
    public double autonomieRestante() {
        return energieRestante() / consommationHeure;
    }

    // 6. (deuxième)
    public double calculateDistance() {
        return nbreHeuresVol * vitesseMoyenne;
    }

    // 7.
    public double distancePossible() {
        return autonomieRestante() * vitesseMoyenne;
    }

    // 8.
    public String categorie() throws Exception {
        char firstLetter = identifiant.charAt(0);
        return switch (firstLetter) {
            case '1' -> "Loisir";
            case '2' -> "Photographie";
            case '3' -> "Professionnel";
            case '4' -> "Industriel";
            default -> throw new Exception("Identifiant must start with char 1, 2, 3 or 4.");
        };
    }

    // 9.
    public int prochainEntretien() {
        try {
            String categ = categorie();
            int joursEntreEntretiens = switch (categ) {
                case "Loisir" -> 100;
                case "Photographie" -> 75;
                case "Professionnel" -> 50;
                case "Industriel" -> 25;
                default -> throw new Exception("Catégorie inconnue");
            };
            int joursPasses = nbreHeuresVol / 24;
            int joursPassesDepuisDernier = joursPasses % joursEntreEntretiens;
            if (joursPassesDepuisDernier == 0)
                return 0; // entretien immédiat
            else
                return joursEntreEntretiens - joursPassesDepuisDernier;
        } catch (Exception e) {
            return 0;
        }
    }

    // 9. (deuxième)
    public void ajouterHeuresVol(int heures) {
        if (heures > 0)
            nbreHeuresVol += heures;
    }

}
