package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


/**
 * Cette classe représente l'application principale du planning.
 */
public class ApplicationPlanning extends Application{


    /**
     * Méthode principale pour démarrer l'application.
     *
     * @param stage La fenêtre principale de l'application.
     */
    public void start(Stage stage) {
        // Création de la racine de la scène.
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 800, 400);
        // Pour appliquer le css à la scene
        File [] filecss = new File("css").listFiles();
        for (File fichier : filecss){
            scene.getStylesheets().add(fichier.toURI().toString());

        }
        // Configuration de la fenêtre principale.
        stage.setResizable(false);
        stage.setTitle("Calendrier 2024");
        stage.centerOnScreen();
        stage.show();
        stage.setScene(scene);
    }


    /**
     * Méthode principale pour lancer l'application.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Application.launch();
    }
}



















