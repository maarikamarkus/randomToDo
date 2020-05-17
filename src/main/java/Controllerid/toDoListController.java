package Controllerid;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import Other.Tegevus;
import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class toDoListController extends Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button toDoListTehtudNupp;

    @FXML
    private Button toDoListMuudaNupp;

    @FXML
    private TextField toDoListMuudaTextfield;

    @FXML
    private Button toDoListKustutaNupp;

    @FXML
    private Button toDoListLisaUusNupp;

    @FXML
    private TextField toDoListUusTegevusTextfield;

    @FXML
    private Button toDoListLisaNupp;

    @FXML
    private Label randomToDoSuvalineLabel;

    @FXML
    private Label toDoListRandomToDoLabel;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {
        toDoListRandomToDoLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            annaSuvalineTegevus();
        });

    }

    public void annaSuvalineTegevus() {
        int tegevusi = toDoList.tegevusiListis();
        if (tegevusi == 0) {
            randomToDoSuvalineLabel.setText("Sisesta enne listi mõned tegevused.");
        } else {
            ArrayList<Tegevus> tegemata = new ArrayList<>();
            for (Tegevus tegevus : toDoList.getToDoList()) {
                if (!tegevus.isTehtud()) {
                    tegemata.add(tegevus);
                }
            }
            if (tegemata.size() == 0) {
                randomToDoSuvalineLabel.setText("Sul on kõik tehtud! Puhka või lisa uus tegevus.");
            } else {
                Tegevus suvaline = tegemata.get(new Random().nextInt(tegemata.size()));
                randomToDoSuvalineLabel.setText("Järgmisena tee: " + suvaline.getKirjeldus());
            }
        }
    }
}
