package Controllerid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tegevusedController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label tegevusedLisaLabel;

    @FXML
    private Label tegevusedMuudaLabel;

    @FXML
    private Label tegevusedSuvalineLabel;

    @FXML
    private Label tegevusedKustutaLabel;

    @FXML
    void initialize() {
        tegevusedLisaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("tahan listi vaates uut tegevust lisada");
        });

        tegevusedMuudaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("tahan mingit tegevust muuta");
        });

        tegevusedSuvalineLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("tahan suvalist tegevust");
        });

        tegevusedKustutaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("tahan mingit tegevust kustutada");
        });
    }

    public void vahetaVaadet(String vaade) throws IOException {
        FXMLLoader laadija = new FXMLLoader(getClass().getResource(vaade));
        Parent root = laadija.load();


    }
}
