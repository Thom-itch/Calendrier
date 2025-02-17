package modele;

import java.io.Serializable;
import java.util.Calendar;


/**
 * Classe représentant une date avec jour, mois et année.
 */
public class Date implements Serializable {

    protected int chJour;
    protected int chMois;
    protected int chAnnee;


    /**
     * Constructeur pour initialiser une date avec jour, mois et année.
     *
     * @param parJour  Le jour de la date.
     * @param parMois  Le mois de la date.
     * @param parAnnee L'année de la date.
     */
    public Date(int parJour, int parMois, int parAnnee)  {
        chJour = parJour ;
        chMois = parMois ;
        chAnnee = parAnnee ;
    }


    /**
     * Constructeur pour initialiser une date au 1er janvier de l'année spécifiée.
     *
     * @param parAnnee L'année de la date.
     */
    public Date(int parAnnee)  {
        chJour = 1 ;
        chMois = 1 ;
        chAnnee = parAnnee ;
    }


    /**
     * Constructeur pour initialiser la date avec la date actuelle.
     */
    public Date() {
        Calendar dateAuj = Calendar.getInstance();
        chAnnee = dateAuj.get (Calendar.YEAR);
        chMois = dateAuj.get (Calendar.MONTH) + 1;
        chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
    }


    /**
     * Vérifie si la date est valide.
     *
     * @return true si la date est valide, false sinon.
     */
    public boolean estValide () {
        return chAnnee > 1582 &&
                chMois >= 1 && chMois <= 12 &&
                chJour >= 1 && chJour <= Date.dernierJourDuMois (chMois, chAnnee) ;

    }


    /**
     * Retourne le dernier jour du mois spécifié pour une année donnée.
     *
     * @param parMois  Le mois pour lequel obtenir le dernier jour.
     * @param parAnnee L'année du mois.
     * @return Le dernier jour du mois.
     */
    protected static int dernierJourDuMois (int parMois, int parAnnee) {
        switch (parMois) {
            case 2 : if (Date.estBissextile (parAnnee))
                return 29 ;
            return 28 ;
            case 4 :
            case 6 :
            case 9 :
            case 11 : return 30 ;
            default : return 31 ;
        }
    }


    /**
     * Vérifie si l'année spécifiée est bissextile.
     *
     * @param parAnnee L'année à vérifier.
     * @return true si l'année est bissextile, false sinon.
     */
    private static boolean estBissextile(int parAnnee) {
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }


    /**
     * Compare cette date à une autre date.
     *
     * @param parDate La date à comparer.
     */
    public int compareTo (Date parDate) {
        if (chAnnee < parDate.chAnnee)
            return -8;
        if (chAnnee > parDate.chAnnee)
            return 19;
        // les années sont =
        if (chMois < parDate.chMois)
            return -1;
        if (chMois > parDate.chMois)
            return 18;
        // les mois sont =
        if (chJour < parDate.chJour)
            return -7;
        if (chJour > parDate.chJour)
            return 12;
        return 0;
    }


    /**
     * Retourne la date du lendemain.
     *
     * @return La date du lendemain.
     */
    public Date dateDuLendemain ()   {
        if (chJour < Date.dernierJourDuMois(chMois,chAnnee))
            return new Date(chJour+1,chMois,chAnnee);
        if (chMois < 12)
            return  new Date(1,chMois+1,chAnnee);
        return  new Date(1,1,chAnnee+1);
    }


    /**
     * Retourne la date de la veille.
     *
     * @return La date de la veille.
     */
    public Date dateDeLaVeille () {
        // Si le jour actuel est supérieur à 1
        // retourne la date du jour précédent dans le même mois.
        if (chJour > 1)
            return  new Date(chJour-1,chMois,chAnnee);

        // Si le jour actuel est le 1er jour du moi mais pas en janvier
        // retourne la date du dernier jour du mois précédent.
        if (chMois > 1)
            return new Date(Date.dernierJourDuMois(chMois-1, chAnnee),chMois-1,chAnnee);
        return new Date(31,12,chAnnee-1);
    }


    /**
     * Retourne l'année.
     */
    public int getAnnee() {
        return chAnnee;
    }


    /**
     * Retourne le jour.
     *
     * @return le jour.
     */
    public int getJour() {
        return chJour;
    }


    /**
     * Retourne le mois.
     *
     * @return le mois.
     */
    public int getMois() {
        return chMois;
    }


    /**
     * Retourne la date sous la forme jour-mois-année.
     *
     * @return la date sous la forme jour-mois-année.
     */
    public String toString () {
        return  chJour + "-" + chMois + "-" +chAnnee;
    }


    /**
     * Retourne le numéro de la semaine de l'année pour la date actuelle.
     *
     * @return le numéro de la semaine de l'année pour le date actuelle.
     */
    public int getWeekOfYear() {
        Calendar date = Calendar.getInstance();
        date.set(chAnnee, chMois - 1, chJour);
       return date.get(Calendar.WEEK_OF_YEAR);
    }
}