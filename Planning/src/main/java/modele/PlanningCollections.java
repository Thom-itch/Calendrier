package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * La classe PlanningCollections représente un planning utilisant des collections pour stocker et gérer les réservations.
 *
 * Elle utilise une liste, un ensemble trié et une map pour stocker les réservations de différentes manières.
 */
public class PlanningCollections {



    /**
     * Liste de réservations.
     */
    private ArrayList<Reservation> chReservlist;


    /**
     * Ensemble de réservations triées.
     */
    private TreeSet<Reservation> chReservset;


    /**
     * Map de réservations triées par semaine.
     */
    private TreeMap<Integer, TreeSet<Reservation>> chReservmap;


    /**
     * Constructeur par défaut de la classe PlanningCollections.
     * Initialise les structures de données pour stocker les réservations.
     * Crée une liste, un ensemble et une carte pour stocker les réservations.
     */
    public PlanningCollections() {
        chReservlist = new ArrayList<Reservation>();
        chReservset = new TreeSet<Reservation>();
        chReservmap = new TreeMap<>();
    }


    /**
     * Méthode pour ajouter une réservation au planning.
     * Elle ajoute la réservation à la liste, à l'ensemble trié et à la semaine correspondante dans la map.
     */
    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        chReservlist.add(parReservation); // Ajoute la réservation à la liste.
        chReservset.add(parReservation); // Ajoute la réservation à l'ensemble trié.
        int semaine = parReservation.getDate().getWeekOfYear(); // Obtient le numéro de semaine de la réservation.

        // Vérifie si la semaine existe déjà dans la map.
        if (chReservmap.containsKey(semaine)) {
            TreeSet<Reservation> set = chReservmap.get(semaine);
            set.add(parReservation);
        }
        else {
            TreeSet<Reservation> set = new TreeSet<>();
            set.add(parReservation);
            chReservmap.put(semaine, set); // Ajoute la réservation à la semaine correspondante dans la map.
        }
    }


    /**
     * Méthode pour obtenir les réservations pour une date spécifique.
     * Elle parcourt l'ensemble trié et ajoute les réservations correspondantes à une nouvelle TreeSet.
     */
    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        TreeSet<Reservation> nouveau = new TreeSet<>();
        Iterator<Reservation> it = chReservset.iterator();

        // Parcourt toutes les réservations existantes.
        while (it.hasNext()) {
            Reservation r = it.next();

            // Vérifie si la réservation a lieu à la date spécifiée.
            if (r.getDate().compareTo(parDate) == 0) {
                nouveau.add(r);
            }
        }
        return nouveau;
    }


    /**
     * Méthode pour obtenir les réservations pour un titre spécifique.
     * Elle parcourt l'ensemble trié et ajoute les réservations correspondantes à une nouvelle TreeSet.
     */
    public TreeSet<Reservation> getReservations(String parString) {
        TreeSet<Reservation> nouveau = new TreeSet<>();
        Iterator<Reservation> it = chReservset.iterator();

        // Parcourt toutes les réservations dans l'ensemble existant.
        while (it.hasNext()) {
            Reservation r = it.next(); // Récupère la réservation suivante.

            // Vérifie si le titre de la réservation correspond au titre spécifié.
            if (r.getchTitre().equals(parString)) {
                nouveau.add(r);
            }
        }
        return nouveau;
    }


    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères du planning.
     *
     * @return la liste de réservations, la taille de l'ensemble trié et la taille de la map.
     */
    public String toString() {
        return  chReservmap.toString();
    }
}
