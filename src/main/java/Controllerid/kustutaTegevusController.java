package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class kustutaTegevusController {

    private static List<Tegevus> tegevused = ToDoList.toDoList;

    @FXML
    ListView<String> kustutaTegevusList;

    @FXML
    void initialize() {
        for (Tegevus tegevus : tegevused) {
            kustutaTegevusList.getItems().add(tegevus.getKirjeldus());
        }
        kustutaTegevus();
    }

    public void kustutaTegevus() {
        String valitud = kustutaTegevusList.getSelectionModel().getSelectedItem();
        tegevused.removeIf(tegevus -> tegevus.getKirjeldus().equals(valitud));
    }

}
