package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tegevusedController extends Controller {
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
    private Button tegevusedTehtudNupp;

    @FXML
    private ListView<String> tegevusedListView;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {

        // Kuvame tegevused listina vaates
        for (Tegevus tegevus : toDoList.getToDoList()) {
            tegevusedListView.getItems().add(tegevus.toString());
        }

        tegevusedTehtudNupp.setDisable(true);

        tegevusedListView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            tegevusedTehtudTegemata();
        });

        tegevusedTehtudNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            märgiTehtuksTegemata();
        });

        tegevusedLisaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            vahetaVaadet("/lisaTegevus.fxml", tegevusedLisaLabel);
        });

        tegevusedMuudaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            vahetaVaadet("/muudaTegevus.fxml", tegevusedMuudaLabel);
        });

        tegevusedSuvalineLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            vahetaVaadet("/suvalineTegevus.fxml", tegevusedSuvalineLabel);
        });

        tegevusedKustutaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            vahetaVaadet("/kustutaTegevus.fxml", tegevusedKustutaLabel);
        });
    }

    private void märgiTehtuksTegemata() {
        int valitudTegevus = tegevusedListView.getSelectionModel().getSelectedIndex();
        if (valitudTegevus == -1) { // ehk ei valitud mingit tegevust
            return;
        }
        Tegevus tegevus = toDoList.getToDoList().get(valitudTegevus);
        if (tegevus.isTehtud()) { // nupu kiri sõltub sellest, kas tegevus on tehtud või mitte
            tegevusedTehtudNupp.setText("Tehtud!");
        } else {
            tegevusedTehtudNupp.setText("Tegemata..");
        }
        tegevus.setTehtud(!tegevus.isTehtud());
        tegevusedListView.getItems().set(valitudTegevus, tegevus.toString());
        tegevusedTehtudNupp.setDisable(true);
    }

    private void tegevusedTehtudTegemata() {
        int valitudTegevus = tegevusedListView.getSelectionModel().getSelectedIndex();
        if (valitudTegevus == -1) {
            return;
        }
        tegevusedTehtudNupp.setDisable(false);
        if (toDoList.getToDoList().get(valitudTegevus).isTehtud()) {
            tegevusedTehtudNupp.setText("Tegemata..");
        } else {
            tegevusedTehtudNupp.setText("Tehtud!");
        }
    }
}
