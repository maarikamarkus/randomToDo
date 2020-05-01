package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class kustutaTegevusController extends Controller {

    @FXML
    ListView<String> kustutaTegevusList;

    @FXML
    private Button kustutaTegevusNäitaTegevusiNupp;
    @FXML
    private Button OKButton;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {

        for (Tegevus tegevus : toDoList.getToDoList()) {
            kustutaTegevusList.getItems().add(tegevus.getKirjeldus());
        }

        OKButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int valitud = kustutaTegevusList.getSelectionModel().getSelectedIndex();
            if (valitud != -1) {
                toDoList.getToDoList().remove(valitud);
                kustutaTegevusList.getItems().remove(valitud);
            }
        });

        kustutaTegevusNäitaTegevusiNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            vahetaVaadet("/tegevused.fxml", kustutaTegevusNäitaTegevusiNupp);
        });
    }
}
