package Controllerid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
            try {
                vahetaVaadet("/lisaTegevus.fxml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } //*/
            System.out.println("tahan listi vaates uut tegevust lisada");
        });

        tegevusedMuudaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/muudaTegevus.fxml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("tahan mingit tegevust muuta");
        });

        tegevusedSuvalineLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/suvalineTegevus.fxml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("tahan suvalist tegevust");
        });

        tegevusedKustutaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/kustutaTegevus.fxml");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("tahan mingit tegevust kustutada");
        });
    }

    public void vahetaVaadet(String asukoht) throws IOException {
        tegevusedLisaLabel.getScene().getWindow().hide();
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(getClass().getResource(asukoht));

        try {
            laadija.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Parent root = laadija.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


    // label.getScene().getWindow().hide();
    // FXMLLoader loader = new FXMLLoader();
    // loader.setLocation(getClass().getResource(fxml));
    // try { loader.load() } catch (IOException e) { sout }
    // Parent root = loader.getRoot();
    // Stage stage = new Stage();
    // stage.setScene(new Scene(root));
    // stage.showAndWait();
    // g

}
