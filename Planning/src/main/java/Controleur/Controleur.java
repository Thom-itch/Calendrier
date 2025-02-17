package Controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;


/**
 * Classe Controleur qui gère les événements de l'interface utilisateur.
 * EventHandler pour gérer les événements.
 */
public class Controleur implements EventHandler {


    /**
     * Méthode qui gère les événements déclenchés par l'utilisateur.
     *
     * @param event l'événement déclenché
     */
    @Override
    public void handle(Event event) {
         // Récupération du planning et du formulaire de réservation depuis la vue.
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        // Si la source de l'événement est un ToggleButton du calendrier.
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton toggle= (ToggleButton) event.getSource();
            DateCalendrier date = (DateCalendrier) toggle.getUserData(); // Récupère la date associée au bouton bascule.
            reservationPane.setDate(date); // Met à jour la date dans le formulaire de réservation.
        }

        // Si l'événement est "Enregistrer" du formulaire de réservation.
        if (event.getSource() instanceof Button) {
            // Récupération des données saisies dans le formulaire de réservation.
            DateCalendrier date = reservationPane.getDateReservation(); // Obtient la date sélectionnée dans le formulaire.
            String texte = reservationPane.getTexte(); // Obtient le texte saisi dans le formulaire.
            RadioButton button = reservationPane.getButton(); // Obtient le bouton radio sélectionné dans le formulaire.
            int[] heure = reservationPane.getHeure(); // Obtient l'heure sélectionnée dans le formulaire.
            PlageHoraire ph = null; // Initialise la plage horaire à null.

            // Vérification si l'action est une annulation.
            if(((Button) event.getSource()).getUserData() == "Annuler") {
                System.out.println("Annulation de la reservation"); // Affiche un message d'annulation dans la console.
                reservationPane.restart(); // Réinitialise le formulaire de réservation.
            }
            else {
                try {
                    // Création des plages horaires et de la réservation.
                    Horaire horaire1 = new Horaire(heure[0], heure[1]); // Crée le premier horaire de la plage.
                    Horaire horaire2 = new Horaire(heure[2], heure[3]); // Crée le deuxième horaire de la plage.
                    ph = new PlageHoraire(horaire1, horaire2); // Crée la plage horaire avec les horaires spécifiés.
                    Reservation reservation = new Reservation(texte, date, ph); // Crée une nouvelle réservation.
                    planning.ajout(reservation); // Ajoute la réservation au planning.
                    // Affiche un message confirmant l'ajout de la réservation dans la console.
                    System.out.println(planning.toString());
                }
                catch (ExceptionPlanning e) {
                    // Gestion des exceptions liées à la planification.
                    System.out.println(e.getCodeErreur()); // Affiche le code d'erreur dans la console.
                }
            }
        }
    }
}
