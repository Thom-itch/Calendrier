package modele;


public interface ConstanteErreur {

    /**
     * Tableau des messages d'erreur possibles.
     */
    public final String [] ERREURS_PLANNING = {
            "Planning complet",
            "Reservation invalide",
            "Reservation incompatible",
            "Plage horaire trop courte",
            "Horaire invalide",
            "Intitule manquant"
    };
}
