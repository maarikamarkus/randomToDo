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
import java.util.Random;

public class suvalineTegevusController {

    @FXML
    private Button suvalineTegevusNupp;
    @FXML
    private Button vaataTegevusi;
    @FXML
    private TextField näitaTegevustText;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
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
        }); //*/

    }

    public void liiguTegevusteVaatesse() throws IOException {
        vaataTegevusi.getScene().getWindow().hide();
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
        stage.show();//*/
    }

    public void annaSuvalineTegevus() {
        int tegevusi = toDoList.tegevusiListis();
        if (tegevusi == 0) {
            näitaTegevustText.setText("Sisesta enne listi mõned tegevused.");
        } else {
            ArrayList<Tegevus> tegemata = new ArrayList<>();
            for (Tegevus tegevus : toDoList.getToDoList()) {
                if (!tegevus.isTehtud()) {
                    tegemata.add(tegevus);
                }
            }
            if (tegemata.size() == 0) {
                näitaTegevustText.setText("Sul on kõik tehtud! Puhka või lisa uus tegevus.");
            } else {
                Tegevus suvaline = tegemata.get(new Random().nextInt(tegemata.size()));
                näitaTegevustText.setText("Järgmisena tee: " + suvaline.getKirjeldus());
            }
        }
    }

}
