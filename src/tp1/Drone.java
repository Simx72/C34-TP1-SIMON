package tp1;

public class Drone {
    private String identifiant;
    private double capaciteBatterie;  // capacité totale de la batterie en watt
    private double consommationHeure; //en watt /heure
    private double vitesseMoyenne; //en km/h
    private int nbreHeuresVol; // nb d'heures total que le drone a volé


    public Drone(String identifiant, double capaciteBatterie, double consommationHeure, double vitesseMoyenne, int nbreHeuresVol) {
        this.identifiant = identifiant;
        this.capaciteBatterie = capaciteBatterie;
        this.consommationHeure = consommationHeure;
        this.vitesseMoyenne = vitesseMoyenne;
        this.nbreHeuresVol = nbreHeuresVol;
    }


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
        double ratio = energieConsomme() / capaciteBatterie;
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





}
