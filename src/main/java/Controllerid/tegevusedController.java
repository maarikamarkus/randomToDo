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

public class tegevusedController {
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

        for (Tegevus tegevus : toDoList.getToDoList()) {
            tegevusedListView.getItems().add(tegevus.toString());
        } //*/

        tegevusedTehtudNupp.setDisable(true);

        tegevusedListView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            tegevusedTehtudTegemata();
        }); //*/

        tegevusedTehtudNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            märgiTehtuksTegemata();
        });

        tegevusedLisaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/lisaTegevus.fxml", tegevusedLisaLabel);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        tegevusedMuudaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/muudaTegevus.fxml", tegevusedMuudaLabel);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        tegevusedSuvalineLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/suvalineTegevus.fxml", tegevusedSuvalineLabel);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        tegevusedKustutaLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                vahetaVaadet("/kustutaTegevus.fxml", tegevusedKustutaLabel);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private void märgiTehtuksTegemata() {
        int valitudTegevus = tegevusedListView.getSelectionModel().getSelectedIndex();
        if (valitudTegevus == -1) {
            return;
        }
        Tegevus tegevus = toDoList.getToDoList().get(valitudTegevus);
        if (tegevus.isTehtud()) {
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

    public void vahetaVaadet(String asukoht, Label label) throws IOException {
        label.getScene().getWindow().hide();
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(getClass().getResource(asukoht));

        try {
            laadija.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Parent root = laadija.getRoot();
        Stage stage = new Stage();
        stage.setTitle(asukoht.substring(1, asukoht.length()-5));
        stage.setScene(new Scene(root)); //*/
        //stage.showAndWait();
        stage.show();

    }

    // label.getScene().getWindow().hide();
    // FXMLLoader loader = new FXMLLoader();
    // loader.setLocation(getClass().getResource(fxml));
    // try { loader.load() } catch (IOException e) { sout }
    // Parent root = loader.getRoot();
    // Stage stage = new Stage();
    // stage.setScene(new Scene(root));
    // stage.showAndWait();
    // g

}
