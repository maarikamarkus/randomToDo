package Controllerid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class vaadeController extends Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label vaadeUusTegevusLabel;

    @FXML
    void initialize() {
        vaadeUusTegevusLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            vahetaVaadet("/lisaTegevus.fxml", vaadeUusTegevusLabel);
        });

    }
}
