package modele;

import java.util.Collection;
import java.util.TreeSet;


/**
 * Classe représentant un calendrier pour un mois donné d'une année donnée.
 */
public class CalendrierDuMois {


    /**
     * Le mois du calendrier.
     */
    private int mois;


    /**
     * L'année du calendrier.
     */
    private int annee;


    /**
     * Collections de dates du calendrier (dans un TreeSet pour les garder trié).
     */
    private Collection<DateCalendrier> treeSetDate;


    /**
     * Constructeur prenant le mois et l'année comme paramètres.
     *
     * @param mois  Le mois du calendrier.
     * @param annee L'année du calendrier.
     */
    public CalendrierDuMois(int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet<DateCalendrier>(); // Initialisation de la collection avec un TreeSet.
        DateCalendrier date = new DateCalendrier(1, mois, annee); // Création de la premier date du mois.
        int indiceJour = date.getJourSemaine(); // Obtention de l'indice du jour de la semaine.

        // Ajout des jours précédents du mois précédent.
        for (int x = indiceJour; x != 0; x--) {
            treeSetDate.add(date);
            date = date.dateDeLaVeille(); // Obtention de la date précédent.
        }

        date = new DateCalendrier(2, mois, annee); // Réinitialisation de la date au 2ème jour du mois.
        indiceJour = indiceJour % 7; // Réinitialisation de l'indice du jour de la semaine.

        // Pour ajouter les jours du mois actuel.
        while (date.getMois() == mois) {
            // Pour ajouter les dates semaine par semaine.
            while (indiceJour < 7) {
                treeSetDate.add(date); // Ajoute la date actuelle au TreeSet.
                date = date.dateDuLendemain(); // Obtention de la date suivante (du lendemain).
                indiceJour++;
            }
            indiceJour = 0;
        }
    }


    /**
     * Retourne les dates du calendrier.
     *
     * @return les dates du calendrier.
     */
    public Collection<DateCalendrier> getDates() {
        return treeSetDate;
    }


    /**
     * Retourne une représentation sous forme de chaîne de caractères du calendrier.
     *
     * @return une représentation sous forme de chaîne de caractères du calendrier.
     */
    public String toString() {
        return treeSetDate.size() + " " + treeSetDate.toString();
    }


    /**
     * Retourne le mois.
     *
     * @return le mois.
     */
    public int getMois() {
        return mois;
    }


    /**
     * Retourne l'année.
     *
     * @return l'année.
     */
    public int getAnnee() {
        return annee;
    }
}

