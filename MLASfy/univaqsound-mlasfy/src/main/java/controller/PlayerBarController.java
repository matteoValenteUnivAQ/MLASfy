package controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import model.Brano;
import java.net.URL;
import java.util.ResourceBundle;
import exceptions.BranoNonTrovatoException;
public class PlayerBarController implements Initializable{
    // === Componenti FXML (I nomi devono coincidere con gli fx:id del file FXML) ===
    @FXML private ImageView albumCover;
    @FXML private Label TitoloLabel;
    @FXML private Label ArtistaLabel;

    @FXML private Button PrecedenteButton;
    @FXML private ToggleButton PlayButton;
    @FXML private Button ProssimoButton;
    @FXML private ToggleButton ShuffleButton;
    @FXML private ToggleButton RepeatButton;

    @FXML private Label CurrentLabel;
    @FXML private Slider ProgressSlider;
    @FXML private Label DurataLabel;


    private Brano branoCorrente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    //gestione degli eventi

    //carico dati del brano corrente nella PlayerBar
    public void caricaBrano(Brano brano)throws BranoNonTrovatoException{
    this.branoCorrente=brano;
    if(branoCorrente!=null){
        TitoloLabel.setText(branoCorrente.getTitolo());
        ArtistaLabel.setText(branoCorrente.getAlbum().getArtista().getNomeArte());
        DurataLabel.setText(branoCorrente.getDurataFormattata());

        ProgressSlider.setMin(0);
        ProgressSlider.setMax(branoCorrente.getDurata().toSeconds());
        ProgressSlider.setValue(0);
        


    } else{
        throw new BranoNonTrovatoException("Brano non trovato");
    }
    }

    //play del brano corrente, invocato al click del PlayButton e subito dopo il caricamento del brano
    @FXML
    public void play(ActionEvent event){
    
    }
    
}
