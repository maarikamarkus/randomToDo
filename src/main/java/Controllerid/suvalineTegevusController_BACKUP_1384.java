package Controllerid;

import Other.Tegevus;
import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class suvalineTegevusController {

    private static List<Tegevus> tegevused = ToDoList.toDoList;

    @FXML
    private Button suvalineTegevusNupp;
    @FXML
    private Button vaataTegevusi;
    @FXML
    private TextField näitaTegevustText;

<<<<<<< HEAD
    public void annaSuvalineTegevus() {
=======
    private void annaSuvalineTegevus() {
>>>>>>> 37fb2b0cb78b7bb54b70af0838e325bcaefd838b
        int tegevusi = tegevused.size();
        if (tegevusi == 0) {
            näitaTegevustText.setText("Sisesta enne listi mõned tegevused.");
        } else {
            ArrayList<Tegevus> tegemata = new ArrayList<>();
            for (Tegevus tegevus : tegevused) {
                if (!tegevus.isTehtud()) {
                    tegemata.add(tegevus);
                }
            }
            if (tegemata.size() == 0) {
                näitaTegevustText.setText("Sul on kõik tehtud! Puhka või lisa uus tegevus.");
            } else {
                Tegevus suvaline = tegemata.get((int) (Math.random()*tegevusi));
                näitaTegevustText.setText("Järgmisena tee: " + suvaline.getKirjeldus());
            }
        }
    }

<<<<<<< HEAD
=======
    @FXML
>>>>>>> 37fb2b0cb78b7bb54b70af0838e325bcaefd838b
    void initialize() {

        suvalineTegevusNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            annaSuvalineTegevus();
        });

        vaataTegevusi.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                liiguTegevusteVaatesse();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

    }

<<<<<<< HEAD
    public void liiguTegevusteVaatesse() throws IOException {
=======
    private void liiguTegevusteVaatesse() throws IOException {
>>>>>>> 37fb2b0cb78b7bb54b70af0838e325bcaefd838b
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

}
