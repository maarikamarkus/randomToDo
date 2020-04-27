package Controllerid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class vaadeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label vaadeUusTegevusLabel;

    @FXML
    void initialize() {
        vaadeUusTegevusLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            tegevusteLisamine();
            System.out.println("tahan uut tegevust lisada");
        });

    }

    private void tegevusteLisamine() {
        vaadeUusTegevusLabel.getScene().getWindow().hide();
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(getClass().getResource("/main/resources/lisaTegevus.fxml"));

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
}
