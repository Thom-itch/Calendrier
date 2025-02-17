package modele;


/**
 * Classe représentant une exception spécifique pour les erreurs de planning.
 */
public class ExceptionPlanning extends Exception {

    private int chCodeErreur;


    /**
     * Constructeur de la classe ExceptionPlanning.
     *
     * @param parCodeErreur Le code d'erreur associé à cette exception.
     */
    public ExceptionPlanning(int parCodeErreur) {
        super();
        this.chCodeErreur = parCodeErreur;
    }

    public String getCodeErreur(){
        return "Erreur " + chCodeErreur + " : " + ConstanteErreur.ERREURS_PLANNING[chCodeErreur] ;
    }
}
