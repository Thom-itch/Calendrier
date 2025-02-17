package modele;


/**
 * Classe représentant une heure avec une précision de quart d'heure.
 */
public class Horaire {

    private int chHeure;
    private int chQuartHeure;


    /**
     * Constructeur de la classe Horaire.
     *
     * @param parHeure L'heure (0-23).
     * @param parQuartHeure Le quart d'heure (0, 15, 30, 45).
     */
    public Horaire (int parHeure, int parQuartHeure){
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }


    /**
     * Convertit l'horaire en minutes.
     *
     * @return Le nombre de minutes.
     */
    public int toMinutes (){
        return chHeure*60 + chQuartHeure;
    }

    public int getHeure () {
        return chHeure;
    }

    public int getQuartHeure () {
        return chQuartHeure;
    }

    public void setHeure (int parHeure) {
        chHeure = parHeure;
    }

    public void setQuartHeure (int parQuartHeure) {
        chQuartHeure = parQuartHeure;
    }


    /**
     * Retourne l'heure sous forme de chaîne de caractères au format "HHhMM".
     *
     * @return une chaîne de caractères représentant l'heure sous la forme "HHhMM".
     */
    public String toString () {
        // Si les minutes sont inférieures à 10, ajoute un zéro devant.
        if (chQuartHeure<10)
            return chHeure + "h0" + chQuartHeure;
        return chHeure + "h" + chQuartHeure;
    }
}
