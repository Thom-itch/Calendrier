package vue;

import Controleur.Controleur;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Node;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.StackPane;
    import javafx.scene.layout.TilePane;
    import javafx.scene.layout.VBox;
    import modele.CalendrierDuMois;
    import modele.ConstantesCalendrier;
    import modele.DateCalendrier;

    import java.io.File;
    import java.util.List;


/**
 * Cette classe représente un panneau de calendrier dans l'interface utilisateur.
 * Elle affiche un calendrier mensuel pour chaque mois de l'année.
 */
public class VBoxCalendrier extends VBox implements ConstantesCalendrier {


    /**
     * Constructeur de la classe VBoxCalendrier.
     * Crée un panneau de calendrier avec les calendriers mensuels pour chaque mois de l'année.
     */
    public VBoxCalendrier() {
        super(20); // Espacement vertical entre les éléments.
        DateCalendrier today = new DateCalendrier();
        StackPane monthCalendarStack = new StackPane();
        Controleur controleur = new Controleur();
        ToggleGroup buttonGroup = new ToggleGroup();

        // Crée un calendrier pour chaque mois de l'année
        for (int i = 1; i <= 12; i++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i, today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() % 7 + 1);
            tilePane.setVgap(4);
            tilePane.setId("opaque");
            tilePane.setPadding(new Insets(4));

            // Ajoute les libellés pour les jours de la semaine.
            for (String jourAb : JOURS_SEMAINE) {
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }

            // Ajoute les boutons pour chaque jour du mois.
            for (DateCalendrier date : monthCalendar.getDates()) {
                int jour = date.getJour();
                ToggleButton boutonDate = new ToggleButton(Integer.toString(jour));
                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);
                boutonDate.setUserData(date);
                boutonDate.setOnAction(HBoxRoot.getControleur());

                if (date.getMois() != monthCalendar.getMois())
                    boutonDate.setId("dateHorsMois");

                if (date.isToday()) {
                    boutonDate.setId("today");
                }
            }
            tilePane.setAccessibleText(MOIS[i - 1]);
            monthCalendarStack.getChildren().add(tilePane);
        }

        // Libellé pour afficher le titre du calendrier.
        Label labelTitle = new Label(MOIS[today.getMois() - 1] + " " + today.getAnnee());
        VBox.setMargin(labelTitle, new Insets(14));
        this.getChildren().addAll(labelTitle);
        // Liste des calendriers mensuels empilés.
        List<Node> listMonthCalendars = monthCalendarStack.getChildren();
        final int lastIndice = listMonthCalendars.size() - 1;
        Node premierMois = listMonthCalendars.get(0);
        Node dernierMois = listMonthCalendars.get(listMonthCalendars.size() - 1);

        // Réorganisation des calendriers pour afficher le mois actuel en premier.
        while (!listMonthCalendars.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois() - 1])) {
            listMonthCalendars.get(lastIndice).toBack();
        }

        // Conteneur pour les boutons de navigation.
        HBox boxNavigation = new HBox(8);
        boxNavigation.setAlignment(Pos.CENTER_LEFT);
        Button[] navigationBoutons = new Button[4];
        HBox boiteLabel = new HBox(4);

        // Crée les boutons de navigation.
        for (int i = 0; i < 4; i++) {
            File[] iconesBoutons = new File("icones" + File.separator).listFiles(); // Récupération des icônes des boutons depuis le répertoire ICONES.
            ImageView image = new ImageView(iconesBoutons[i].toURI().toString()); // Création d'une image à partir de l'icône correspondante;
            // Création d'un bouton avec l'image.
            navigationBoutons[i] = new Button();
            navigationBoutons[i].setGraphic(image);
            // Ajout du bouton au conteneur de navigation.
            boxNavigation.getChildren().add(navigationBoutons[i]);
            navigationBoutons[i].setAccessibleText("nav_" + i);
            int finalI = i;
            navigationBoutons[i].setOnAction(event -> { // Définition de l'action à effectuer quand on clic sur le bouton.
                switch (navigationBoutons[finalI].getAccessibleText()) {
                    // Si le bouton est "nav_0", revenir au premier mois.
                    case "nav_0":
                        while (listMonthCalendars.get(lastIndice) != premierMois) {
                            listMonthCalendars.get(lastIndice).toBack();
                        }
                        break;
                    // Si le bouton est "nav_1", afficher le mois précédent.
                    case "nav_1":
                        listMonthCalendars.get(lastIndice).toBack();
                        labelTitle.setText(listMonthCalendars.get(lastIndice).getAccessibleText());
                        break;
                    // Si le bouton est "nav_2", afficher le mois suivant.
                    case "nav_2":
                        listMonthCalendars.get(0).toFront();
                        labelTitle.setText(listMonthCalendars.get(lastIndice).getAccessibleText());
                        break;
                    // Si le bouton est "nav_3", afficher le dernier mois.
                    case "nav_3":
                        while (listMonthCalendars.get(lastIndice) != dernierMois) {
                            listMonthCalendars.get(0).toFront();
                        }
                        break;
                }
            });
        }
        this.getChildren().addAll(monthCalendarStack, boxNavigation);
    }
}
