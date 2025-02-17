package modele;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * La classe Reservation représente une réservation avec une date, une plage horaire et un titre.
 */
public class Reservation implements Comparable <Reservation>{


    /**
     * Date de la réservation.
     */
    private Date chDate;


    /**
     * Plage horaire de la réservation..
     */
    private PlageHoraire chPlageHoraire;


    /**
     * Titre de la réservation.
     */
    private String chTitre;


    /**
     * Getter pour obtenir le titre de la réservation.
     */
    public String getchTitre(){
        return chTitre;
    }


    /**
     * Getter pour obtenir la date de la réservation..
     */
    public Date getDate(){
        return chDate;
    }


    /**
     * Constructeur de la classe Reservation.
     *
     * @param parTitre Le titre de la réservation.
     * @param parDate La date de la réservation.
     * @param parPlageHoraire La plage horaire de la réservation.
     * @throws ExceptionPlanning Si le titre de la réservation est invalide.
     */
    public Reservation(String parTitre, Date parDate, PlageHoraire parPlageHoraire) throws ExceptionPlanning {
        // Vérifie si le titre de la réservation est valide.
        if(parTitre == null || parTitre.length()==0){
            throw new ExceptionPlanning(5);
        }
        // Initialise les attributs de la réservation.
        this.chDate = parDate;
        this.chPlageHoraire = parPlageHoraire;
        this.chTitre = parTitre;
    }

    public String toString(){
        return chTitre + ", " + chDate.toString() + ", " + chPlageHoraire.toString();
    }


    /**
     * Méthode pour comparer deux réservations.
     *
     * @param parReservation La réservation à comparer.
     * @return Un entier négatif si cette réservation est antérieure à l'autre, un entier positif si elle est postérieure, zéro si elles sont égales.
     */
    public int compareTo(Reservation parReservation){
        // Compare les dates des réservations.
        if(this.chDate.compareTo(parReservation.chDate) != 0)
            return this.chDate.compareTo(parReservation.chDate);
        // Si les dates sont égales, compare les plages horaires des réservations.
        return this.chPlageHoraire.compareTo(parReservation.chPlageHoraire);
    }

    // Méthode pour vérifier si la réservation est valide.
    boolean estValide(){
        return chDate.estValide() && chPlageHoraire.estValide();
    }


    /**
     * Classe interne pour tester la classe Reservation.
     */
    public static class ClientPlanningCollections {
        public static void main(String[] args) {
            // Test de la class Reservation.
            try {
                // Création d'une liste et d'un ensemble de réservations.
                ArrayList<Reservation> reservations = new ArrayList<Reservation>();
                TreeSet<Reservation> reservationsSet = new TreeSet<Reservation>();

                // Création d'une date et d'une plage horaire.
                DateCalendrier date = new DateCalendrier(1, 1, 2020);
                Horaire h1 = new Horaire(8, 0);
                Horaire h2 = new Horaire(12, 0);
                PlageHoraire plage = new PlageHoraire(h1, h2);
                String titre = "Sport";

                // Création d'une réservation et affichage de ses détails.
                Reservation r1 = new Reservation(titre, date, plage);
                System.out.println(r1.toString());

                // Création de deux autres plages horaires et réservations.
                PlageHoraire plage2 = new PlageHoraire(new Horaire(16,0), new Horaire(18, 0));
                PlageHoraire plage3 = new PlageHoraire(new Horaire(14,0), new Horaire(15, 0));
                Reservation r2 = new Reservation("Cours", new DateCalendrier(2, 1, 2020), plage2);
                Reservation r3 = new Reservation("Cours", new DateCalendrier(2, 1, 2020), plage3);
                DateCalendrier date2 = new DateCalendrier(12, 3, 2024);
                //System.out.println(date2.getchNmSem());
            }
            // Gestion des exceptions.
            catch (ExceptionPlanning e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
