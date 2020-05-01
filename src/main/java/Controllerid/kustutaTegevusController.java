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

public class kustutaTegevusController {

    //private static List<Tegevus> tegevused = ToDoList.toDoList;

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
            toDoList.getToDoList().remove(valitud);
            kustutaTegevusList.getItems().remove(valitud);
        });

        kustutaTegevusNäitaTegevusiNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                näitaTegevusi();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void näitaTegevusi() throws IOException {
        kustutaTegevusNäitaTegevusiNupp.getScene().getWindow().hide();
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(getClass().getResource("/tegevused.fxml"));

        try {
            laadija.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Parent root = laadija.getRoot();
        Stage stage = new Stage();
        stage.setTitle("randomToDo");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
