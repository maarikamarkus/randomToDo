package Controllerid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class vaadeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label vaadeUusTegevusLabel;

    @FXML
    void initialize() {
        vaadeUusTegevusLabel.setOnMouseClicked(event -> {
            System.out.println("vajutasin sildile uus tegevus");
        });
    }

    private void tegevusteLisamine() {

    }
}
