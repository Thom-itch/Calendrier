package modele;


/**
 * Classe représentant une plage horaire avec une heure de début et une heure de fin.
 */
public class PlageHoraire {


    /**
     * Durée minimale de la plage horaire en minutes.
     */
    private static final int DUREE_MIN = 30;


    /**
     * Heure de début de la plage horaire.
     */
    private Horaire chhoraireDebut;


    /**
     * Heure de fin de la plage horaire.
     */
    private Horaire chhoraireFin;


    /**
     * Constructeur de la classe PlageHoraire.
     *
     * @param parDebut Heure de début de la plage horaire.
     * @param parFin Heure de fin de la plage horaire.
     * @throws ExceptionPlanning Si la plage horaire est invalide.
     */
    public PlageHoraire(Horaire parDebut, Horaire parFin) throws ExceptionPlanning {
        int debutMin = parDebut.toMinutes();
        int finMin = parFin.toMinutes();

        // Vérifie si l'heure de début est après l'heure de fin.
        if (debutMin > finMin)
            throw new ExceptionPlanning(4);

        // Vérifie si la durée de la plage horaire est inférieure à la durée minimale.
        if (debutMin + DUREE_MIN > finMin)
            throw new ExceptionPlanning(3);

        // Initialisation de l'heure de début et de fin de la plage horaire.
        chhoraireDebut = parDebut;
        chhoraireFin = parFin;
    }

    public String toString() {
        return "La plage horaire va de " + chhoraireDebut.toString() + " a " + chhoraireFin.toString() + ". La duree de la plage horaire est de : " + this.duree() + " min";
    }


    /**
     * Vérifie si la plage horaire est valide.
     *
     * @return true ou false.
     */
    public boolean estValide() {
        int debutMin = chhoraireDebut.toMinutes();
        int finMin = chhoraireFin.toMinutes();

        // Vérifie si la durée de la plage horaire est supérieure ou égale à la durée minimale.
        if (debutMin + DUREE_MIN <= finMin)
            return true;
        return false;
    }


    /**
     * Calcule la durée de la plage horaire en minutes.
     *
     * @return La durée de la plage horaire en minutes.
     */
    public int duree() {
        int debutMin = chhoraireDebut.toMinutes();
        int finMin = chhoraireFin.toMinutes();
        return finMin - debutMin;
    }


    /**
     * Compare deux plages horaires.
     *
     * @param parPlageHoraire La plage horaire à comparer.
     * @return -1 si la plage horaire se termine avant que l'autre commence,
     *         1 si l'autre plage horaire se termine avant que celle-ci commence,
     *         0 si les plages horaires sont en même temps.
     */
    public int compareTo(PlageHoraire parPlageHoraire) {
        // Vérifie si cette plage horaire se termine avant que l'autre ne commence.
        if (this.chhoraireFin.toMinutes() <= parPlageHoraire.chhoraireDebut.toMinutes())
            return -1; // Retourne -1 si cette plage horaire se termine avant l'autre.

        // Vérifie si l'autre plage horaire se termine avant que celle-ci ne commence.
        if (parPlageHoraire.chhoraireFin.toMinutes() <= this.chhoraireDebut.toMinutes())
            return 1; // Retourne 1 si l'autre plage horaire se termine avant celle-ci.
        return 0;
    }
}
