package Controllerid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class lisaTegevusController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lisaTegevusUusTegevusField;

    @FXML
    private Button lisaTegevusLisaNupp;

    @FXML
    void initialize() {
        lisaTegevusLisaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Other.Tegevus uusTegevus = new Other.Tegevus(lisaTegevusUusTegevusField.getText(), false);

        });
    }


}
