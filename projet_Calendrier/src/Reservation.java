public class Reservation {
    private Date chDate;
    private PlageHoraire chPlageHoraire;
    private String chTitre;

    public Reservation(Date parDate, PlageHoraire parPlageHoraire, String parTitre) {
        chDate = parDate;
        chPlageHoraire = parPlageHoraire;
        chTitre = parTitre;
    }

    public String toString() {
        return chTitre+", "+chDate.toString()+", "+chPlageHoraire.toString();
    }

    /** compare this (la réservation appelante) avec la réservation donnée en paramètre (parReservation)
     *@return un entier :
     *    négatif si this est antérieur à la réservation donnée en paramètre
     *    positif si this est postérieur à la réservation donnée en paramètre
     *    0 si non
     *@parameter la réservation comparée à this
     */
    public int compareTo (Reservation parReservation) {
        if (this.chDate.compareTo(parReservation.chDate) == 0)
            return this.chPlageHoraire.compareTo(parReservation.chPlageHoraire);
        return this.chDate.compareTo(parReservation.chDate);
    }

    public boolean estValide() {
        return chDate.estValide() && chPlageHoraire.estValide();
    }

    public Date getDate() {
        return chDate;
    }
}
