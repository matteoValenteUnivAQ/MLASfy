package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Brano;
import model.Genere;
import model.ArtistaSolista;
import model.Album;
import controller.PlayerBarController;

import java.time.LocalDate;

public class TestPlayerApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Carica il file FXML del Player
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/viste/player_bar.fxml"));
        Parent root = loader.load();

        // 2. Recupera il Controller associato al FXML
        PlayerBarController controller = loader.getController();

        // 3. Crea un brano di test "Mock"
        ArtistaSolista Queen = new ArtistaSolista("Freddy Mercury", "cantante inglese", Genere.ROCK, "Freddy Mercury");
        Album ANightAtTheOpera = new Album("A Night at the Opera", Queen, LocalDate.of(1970, 1, 3), Genere.ROCK, "/path/to/cover.jpg");
        Brano branoDiTest = new Brano("Bohemian Rhapsody", 355, "testo", Genere.ROCK, ANightAtTheOpera);

        // 4. Passa il brano al controller per caricarlo nell'interfaccia
        controller.caricaBrano(branoDiTest);

        // 5. Mostra la finestra
        Scene scene = new Scene(root);
        primaryStage.setTitle("Test Caricamento Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}