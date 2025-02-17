public class ExceptionPlanning extends Exception {
    private int chCodeErreur;
    public ExceptionPlanning(int parCodeErreur) {
        super (); //appel du constructeur de la classe
        this.chCodeErreur = parCodeErreur;
    }


    public int getExceptionPlanning (){

        return chCodeErreur;
    }
}