package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;



/**
 * Cette classe représente un formulaire de réservation affiché dans un GridPane.
 */
public class GridPaneFormulaireReservation extends GridPane {

    DateCalendrier dateReservation = new DateCalendrier();

    // Label affichant la date de la réservation.
    Label labelDate = new Label(dateReservation.toString());

    // Groupe de boutons basculants pour le niveau de réservation.
    ToggleGroup toggleGroup;

    // Tableau pour stocker les heures et minutes sélectionnées.
    int [] listebouton = new int[4];

    // Éléments de formulaire.
    Label Cours = new Label("Cours"); // Label pour le champ "Cours".
    TextField cours = new TextField(); // Champ de saisie pour le nom du cours.
    Label Niveau = new Label("Niveau   "); // Label pour le niveau de cours.
    RadioButton Debutant = new RadioButton("debutant"); // Bouton radio pour le niveau débutant.
    RadioButton Moyen = new RadioButton("moyen"); // Bouton radio pour le niveau moyen.
    RadioButton Avance = new RadioButton("avance"); // Bouton radio pour le niveau avancé.
    RadioButton Expert = new RadioButton("expert"); // Bouton radio pour le niveau expert.
    Label Horaire = new Label("Horaire"); // Label pour la sélection de l'horaire.
    Label De = new Label("de");
    Label hd = new Label("h");
    Label hf = new Label("h");
    Label mind = new Label("min");
    Label minf = new Label("min");
    Label A = new Label("à");
    ComboBox <Integer> heuredebut = new ComboBox<Integer>(); // Liste déroulante pour les heures de début.
    ComboBox <Integer> heurefin = new ComboBox<Integer>(); // Liste déroulante pour les heures de fin.
    ComboBox <Integer> mindebut = new ComboBox<Integer>(); // Liste déroulante pour les minutes de début.
    ComboBox <Integer> minfin = new ComboBox<Integer>(); // Liste déroulante pour les minutes de fin.
    Button annuler = new Button("Annuler");
    Button enregistrer = new Button("Enregistrer");


    /**
     * Constructeur de la classe GridPaneFormulaireReservation.
     * Initialise les éléments du formulaire et leur disposition dans le GridPane.
     */
    public GridPaneFormulaireReservation(){
        // Configuration du GridPane
        this.setGridLinesVisible(false); // Cache les lignes de grille.
        this.setPadding(new Insets(9)); // Définit les marges intérieures.
        this.setHgap(5); // Définit l'espace horizontal entre les éléments
        this.setVgap(7); // Définit l'espace vertical entre les éléments
        labelDate = new Label(dateReservation.toString()); // Affiche la date actuelle.
        this.add(labelDate,3,0); // Ajoute le label à la grille.

        // Configuration de la date de réservation.
        for(int i = 8; i < 19; i++){
            heuredebut.getItems().add(i);
            heurefin.getItems().add(i);
        }

        // Configuration des listes déroulantes pour les heures et minutes.
        for(int i = 0; i < 60; i+=15){
            mindebut.getItems().add(i); // Ajoute les minutes à la liste de début.
            minfin.getItems().add(i); // Ajoute les minutes à la liste de fin.
        }
        heuredebut.getSelectionModel().selectFirst(); // Sélectionne la première heure de début par défaut.
        mindebut.getSelectionModel().selectFirst();// Sélectionne la première minute de début par défaut.
        heurefin.setValue(10); // Définit la valeur par défaut de l'heure de fin.
        minfin.getSelectionModel().selectFirst(); // Sélectionne la première minute de fin par défaut.

        // Configuration des éléments de formulaire
        cours.setPromptText("nom du cours"); // Affiche un texte d'exemple dans le champ de saisie.
        annuler.setMnemonicParsing(true);
        enregistrer.setMnemonicParsing(true);

        // Ajout des éléments au GridPane
        this.add(Cours,1,1); // Ajoute le label "Cours".
        this.add(cours,2,1,5,2); // Ajoute le champ de saisie du nom du cours.
        this.add(Niveau,1,3); // Ajoute le label "Niveau".
        this.add(Debutant,2,3,2,1); // Ajoute le bouton radio pour le niveau débutant.
        this.add(Moyen,5,3); // Ajoute le bouton radio pour le niveau moyen.
        this.add(Avance,2,4,2,1); // Ajoute le bouton radio pour le niveau avance.
        this.add(Expert,5,4); // Ajoute le bouton radio pour le niveau expert.

        toggleGroup = new ToggleGroup(); // Crée un groupe de bascule.
        Debutant.setToggleGroup(toggleGroup);
        Moyen.setToggleGroup(toggleGroup);
        Avance.setToggleGroup(toggleGroup);
        Expert.setToggleGroup(toggleGroup);
        Debutant.setSelected(true);

        this.add(Horaire,1,5);
        this.add(De,2,5);
        this.add(heuredebut,3,5);
        this.add(hd,4,5);
        this.add(mindebut,5,5);
        this.add(mind,6,5);
        this.add(A,2,6);
        this.add(heurefin,3,6);
        this.add(hf,4,6);
        this.add(minfin,5,6);
        this.add(minf,6,6);

        this.add(annuler, 3, 7);
        this.add(enregistrer, 5, 7);
        enregistrer.setOnAction(HBoxRoot.getControleur());
        annuler.setUserData("Annuler");

        // Met le focus sur le champ de saisie du cours lors du démarrage de l'application.
        Platform.runLater(() -> cours.requestFocus());
    }


    /**
     * Met à jour la date de réservation affichée dans le formulaire.
     *
     * @param parDate La nouvelle date de réservation.
     */
    public void setDate(DateCalendrier parDate) {
        dateReservation = parDate;
        labelDate.setText(dateReservation.toString());
    }

    public DateCalendrier getDateReservation (){
        return dateReservation;
    }


    /**
     * Récupère le texte saisi dans le champ de saisie du cours.
     *
     * @return Le texte du champ de saisie du cours.
     */
    public String getTexte(){
        return cours.getText();
    }


    /**
     * Récupère le bouton radio sélectionné pour le niveau.
     *
     * @return Le bouton radio sélectionné pour le niveau.
     */
    public RadioButton getButton(){
        return (RadioButton) toggleGroup.getSelectedToggle();
    }


    /**
     * Récupère les valeurs sélectionnées pour l'heure de début, les minutes de début,
     * l'heure de fin et les minutes de fin depuis les combobox du formulaire.
     *
     * @return un tableau d'entiers contenant les valeurs sélectionnées dans l'ordre suivant :
     *         [heure de début, minutes de début, heure de fin, minutes de fin]
     */
    public int[] getHeure(){
        listebouton[0] = heuredebut.getValue(); // Récupère l'heure de début sélectionnée.
        listebouton[1] = mindebut.getValue(); // Récupère les minutes de début sélectionnées.
        listebouton[2] = heurefin.getValue(); // Récupère l'heure de fin sélectionnée.
        listebouton[3] = minfin.getValue(); // Récupère les minutes de fin sélectionnées.
        return listebouton;
    }


    /**
     * Récupère les heures et minutes sélectionnées dans les listes déroulantes.
     *
     * @return Un tableau contenant les heures et minutes sélectionnées.
     */
    public void restart(){
        cours.setText(new String()); // Efface le texte du champ de saisie du cours.
        toggleGroup.getToggles().get(0).setSelected(true); // Sélectionne le bouton radio débutant par défaut.
        heuredebut.setValue(listebouton[0]); // Restaure la valeur de l'heure de début.
        mindebut.setValue(listebouton[1]); // Restaure la valeur de la minute de début.
        heurefin.setValue(listebouton[0]); // Restaure la valeur de l'heure de fin.
        minfin.setValue(listebouton[1]); // Restaure la valeur de la minute de fin.
        Platform.runLater(() -> cours.requestFocus()); // Met le focus sur le champ de saisie du cours.
    }
}
