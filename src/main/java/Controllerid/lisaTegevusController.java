package Controllerid;

import Other.ToDoList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Button lisaTegevusVaataTegevusiNupp;

    private ToDoList toDoList;

    @FXML
    void initialize() {
        lisaTegevusLisaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            String tegevuseKirjeldus = lisaTegevusUusTegevusField.getText();
            if (!tegevuseKirjeldus.equals("")) {
                Other.Tegevus uusTegevus = new Other.Tegevus(lisaTegevusUusTegevusField.getText(), false);

            }

            try {
                liiguTegevusteVaatesse();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }



        });

        lisaTegevusVaataTegevusiNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                liiguTegevusteVaatesse();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void liiguTegevusteVaatesse() throws IOException {
        lisaTegevusLisaNupp.getScene().getWindow().hide();
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


}
