package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class muudaTegevusController {

    private static List<Tegevus> tegevused = ToDoList.toDoList;

    @FXML
    private TextField muudaTegevustText;
    @FXML
    private ListView<String> muudaTegevusList;
    @FXML
    private Button vaataTegevusi;

    public void muudaTegevuseNime() {
        String valitud = muudaTegevusList.getSelectionModel().getSelectedItem();
        String uus = muudaTegevustText.getText();
        for (Tegevus tegevus : tegevused) {
            if (tegevus.getKirjeldus().equals(valitud))
                tegevus.setKirjeldus(uus);
        }
    }

    private void liiguTegevusteVaatesse() throws IOException {
        vaataTegevusi.getScene().getWindow().hide();
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(getClass().getResource("/tegevused.fxml"));
        //laadija.setLocation(getClass().getResource());

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

    @FXML
    void initialize() {
        for (Tegevus tegevus : tegevused) {
            muudaTegevusList.getItems().add(tegevus.getKirjeldus());
        }
        muudaTegevuseNime();

        vaataTegevusi.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                liiguTegevusteVaatesse();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

}
