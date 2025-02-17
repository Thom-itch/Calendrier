package vue;

import Controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.PlanningCollections;


public class HBoxRoot extends HBox {
    private static PlanningCollections planning; // Le modèle de l'application.
    private static Controleur controleur; // Le contrôleur de l'application.
    private static VBoxCalendrier calendrierPane; // La vue du calendrier.
    private static GridPaneFormulaireReservation reservationPane;  // La vue du formulaire de réservation.


    /**
     * Constructeur de la classe HBoxRoot.
     * Initialise le modèle, le contrôleur et les vues de l'application.
     */
    public HBoxRoot(){
        //Initialise le modele.
        planning = new PlanningCollections();
        //Initialise le controleur.
        controleur = new Controleur();
        // Initialise les vues.
        calendrierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();
        // Ajout des vues à la racine de l'interface utilisateur.
        this.getChildren().add(calendrierPane);
        this.getChildren().add(reservationPane);
    }


    /**
     * Retourne l'objet PlanningCollections qui est actuellement utilisé.
     *
     * @return l'objet PlanningCollections qui est actuellement utilisé.
     */
    public static PlanningCollections getPlanning(){
        return planning;
    }


    /**
     * Retourne le panneau de formulaire de réservation qui est actuellement utilisé.
     *
     * @return le panneau de formulaire de réservation qui est actuellement utilisé.
     */
    public static GridPaneFormulaireReservation getReservationPane(){
        return reservationPane;
    }


    /**
     * Retourne le panneau de calendrier qui est actuellement utilisé.
     *
     * @return le panneau de calendrier qui est actuellement utilisé.
     */
    public static VBoxCalendrier getCalendrierPane(){
        return calendrierPane;
    }



    /**
     * Retourne l'objet Controleur qui est actuellement utilisé.
     *
     * @return l'objet Controleur qui est actuellement utilisé.
     */
    public static Controleur getControleur(){
        return controleur;
    }
}
