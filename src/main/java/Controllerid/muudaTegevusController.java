package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.Scanner;

public class muudaTegevusController {

    private static List<Tegevus> tegevused = ToDoList.toDoList;

    @FXML
    ListView<String> muudaTegevusList;

    public void muudaTegevuseNime() {
        String valitud = muudaTegevusList.getSelectionModel().getSelectedItem();
        Scanner sc = new Scanner(System.in);
        String uus = sc.nextLine();
        for (Tegevus tegevus : tegevused) {
            if (tegevus.getKirjeldus().equals(valitud))
                tegevus.setKirjeldus(uus);
        }
    }

    @FXML
    void initialize() {
        for (Tegevus tegevus : tegevused) {
            muudaTegevusList.getItems().add(tegevus.getKirjeldus());
        }
        muudaTegevuseNime();
    }

}
