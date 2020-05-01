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

    @FXML
    private TextField muudaTegevustText;
    @FXML
    private ListView<String> muudaTegevusList;
    @FXML
    private Button vaataTegevusi;
    @FXML
    private Button OKButton;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {

        for (Tegevus tegevus : toDoList.getToDoList()) {
            muudaTegevusList.getItems().add(tegevus.getKirjeldus());
        }

        OKButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int valitud = muudaTegevusList.getSelectionModel().getSelectedIndex();
            String uus = muudaTegevustText.getText();
            Tegevus tegevus = toDoList.getToDoList().get(valitud);
            tegevus.setKirjeldus(uus);
            muudaTegevusList.getItems().set(valitud, uus);
            muudaTegevustText.setText("");
        });

        vaataTegevusi.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                liiguTegevusteVaatesse();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
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
        stage.show();
    }

}
