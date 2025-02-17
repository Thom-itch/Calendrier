package modele;

import java.util.Calendar;


/**
 * Classe représentant une date spécifique avec des informations supplémentaires comme le jour de la semaine
 * et le numéro de la semaine de l'année.
 */
public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date> {

    private int jourSemaine; // Le jour de la semaine de la date.

    private int weekOfYear; // Le numéro de la semaine de l'année de la date.


    /**
     * Constructeur par défaut qui initialise la date avec la date actuelle.
     */
    public DateCalendrier() {
        Calendar dateAuj = Calendar.getInstance();
        chAnnee = dateAuj.get(Calendar.YEAR); // L'année actuelle.
        chMois = dateAuj.get(Calendar.MONTH) + 1; // Le mois actuelle (mais comme ça commence à 0 on ajoute 1).
        chJour = dateAuj.get(Calendar.DAY_OF_MONTH); // Le jour actuelle.
        jourSemaine = dateAuj.get(Calendar.DAY_OF_WEEK); // Obtient le jour de la semaine.

        // Pour que le Lundi soit 1 et le Dimanche 7.
        if (jourSemaine == 1)
            jourSemaine = 7;
        // Pour les autres jours.
        else
            jourSemaine -= 1;
        weekOfYear = dateAuj.get(Calendar.WEEK_OF_YEAR); // Obtient le numéro de la semaine de l'année.
    }


    /**
     * Constructeur qui initialise la date avec les paramètres spécifiés.
     *
     * @param parJour  Le jour de la date.
     * @param parMois  Le mois de la date.
     * @param parAnnee L'année de la date.
     */
    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee); // Appel du constructeur de la classe parente Date (mais avec les paramètres spécifiés).
        Calendar date = Calendar.getInstance(); // Obtient une instance de Calendar et la configure avec la date spécifiée.
        date.set(chAnnee, chMois - 1, chJour);
        jourSemaine = date.get(Calendar.DAY_OF_WEEK); // Obtient le jour de la semaine.
        if (jourSemaine == 1)
            jourSemaine = 7; // Conversion du dimanche (valeur 1) en 7 pour être compatible avec le système.
        else
            jourSemaine -= 1; // Réduction de 1 pour correspondre à l'index de l'array JOURS_SEMAINE.
        weekOfYear = date.get(Calendar.WEEK_OF_YEAR); // Obtient le numéro de la semaine de l'année.
    }


    /**
     * Retourne la date sous forme de chaîne de caractères.
     *
     * @return String sous forme jj/mm/aaaa.
     */
    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }

    public int getJourSemaine() {
        return jourSemaine;
    }


    /**
     * Vérifie si cette date correspond à la date actuelle.
     *
     * @return true si cette date est la date actuelle, false sinon.
     */
    public boolean isToday() {
        return this.compareTo(new DateCalendrier()) == 0;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }


    /**
     * Retourne la date du lendemain.
     *
     * @return la date du lendemain.
     */
    public DateCalendrier dateDuLendemain() {
        Date dateLendemain = super.dateDuLendemain();
        return new DateCalendrier(dateLendemain.chJour, dateLendemain.chMois, dateLendemain.chAnnee);
    }


    /**
     * Retourne la date de la veille.
     *
     * @return la date de la veille.
     */
    public DateCalendrier dateDeLaVeille() {
        Date dateVeille = super.dateDeLaVeille(); // Appel de la méthode `dateDeLaVeille` de la classe parente `Date` pour avoir la date de la veille.
        return new DateCalendrier(dateVeille.chJour, dateVeille.chMois, dateVeille.chAnnee);
    }
}
