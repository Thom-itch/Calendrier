package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.PlageHoraire;
import modele.Reservation;

import java.util.TreeSet;


public class VBoxAffichagePlanning extends VBox {

    private Label numSem = new Label("");/** Ce champ est un label affichant le numéro de la semaine du jour selectionné*/;
    private int semaine = new DateCalendrier().getWeekOfYear();/** Ce champ est un int du numéro de la semaine du jour selectionné */;
    private TableView<Reservation> tableDesReservations;/** Ce champ est un TableView dans lequel est rentré les réservations enregistrées*/;

    private TreeSet<Reservation> reservationsDeLaSemaine;/** Ce champ est la liste des réservations faites lors d'une semaine donnée*/;


    /**
     * Cette méthode est le constructeur de la classe
     */
    public VBoxAffichagePlanning () {
        this.setNumSem(semaine);
        this.getChildren().add(numSem);
        tableDesReservations = new TableView<>();

        TableColumn <Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn <Reservation, String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("chReserv"));

        TableColumn <Reservation, String> niveauColumn = new TableColumn<>("Niveau");
        niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveau"));

        TableColumn <Reservation, PlageHoraire> horaireColumn = new TableColumn<>("Horaire");
        horaireColumn.setCellValueFactory(new PropertyValueFactory<>("Ph"));

        tableDesReservations.getColumns().addAll(dateColumn, coursColumn,niveauColumn, horaireColumn);
        this.getChildren().add(tableDesReservations);
        this.update();
    }


    /**
     * Cette méthode permet de mettre à jour le tableau contenant les réservations
     */
    public void update () {
        tableDesReservations.getItems().clear();
        reservationsDeLaSemaine = HBoxRoot.getPlanning().getReservations(String.valueOf(semaine));

        if (reservationsDeLaSemaine != null) {
            for (Reservation reservation : reservationsDeLaSemaine) {
                tableDesReservations.getItems().add(reservation);
            }
        }
    }


    /**
     * Cette méthode est un modifieur des champs numSem et semaine
     * @param parNum la semaine de la date selectionnée
     */
    public void setNumSem (int parNum) {
        numSem.setText("Numéro de semaine : "+parNum);
        semaine = parNum;
    }


    /**
     * Cette méthode est un accesseur du champ numSem
     * @return le Label affichant la semaine du jour selectionné
     */
    public Label getNumSem(){
        return numSem;
    }
}
