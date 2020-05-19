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
import javafx.scene.control.ListView;
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
    private ListView<String> toDoListTegevusedListview;

    @FXML
    private Label randomToDoSuvalineLabel;

    @FXML
    private Label toDoListRandomToDoLabel;

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {

        for (Tegevus tegevus : toDoList.getToDoList()) {
            toDoListTegevusedListview.getItems().add(tegevus.toString());
        }

        toDoListRandomToDoLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            annaSuvalineTegevus();
        });

        toDoListTehtudNupp.setDisable(true);
        toDoListMuudaNupp.setVisible(false);
        toDoListMuudaTextfield.setVisible(false);
        toDoListKustutaNupp.setVisible(false);
        toDoListUusTegevusTextfield.setVisible(false);
        toDoListLisaNupp.setVisible(false);//*/

        toDoListTegevusedListview.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            valitudTegevus();
        });

        toDoListTehtudNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            märgiTehtuksTegemata();
        });

        toDoListMuudaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int valitud = toDoListTegevusedListview.getSelectionModel().getSelectedIndex();
            if (valitud != -1) {
                String uus = toDoListMuudaTextfield.getText();
                Tegevus tegevus = toDoList.getToDoList().get(valitud);
                tegevus.setKirjeldus(uus);
                toDoListTegevusedListview.getItems().set(valitud, tegevus.toString());
                toDoListMuudaTextfield.setText("");
            }
        });

        toDoListKustutaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int valitud = toDoListTegevusedListview.getSelectionModel().getSelectedIndex();
            if (valitud != -1) {
                toDoList.getToDoList().remove(valitud);
                toDoListTegevusedListview.getItems().remove(valitud);
            }
        });

        toDoListLisaUusNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            toDoListUusTegevusTextfield.setVisible(true);
            toDoListLisaNupp.setVisible(true);
        });

        toDoListLisaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            String tegevuseKirjeldus = toDoListUusTegevusTextfield.getText();
            if (!tegevuseKirjeldus.equals("")) {
                Other.Tegevus uusTegevus = new Other.Tegevus(tegevuseKirjeldus, false);
                toDoList.lisaToDoListi(uusTegevus);
                toDoListTegevusedListview.getItems().add(uusTegevus.toString());
                toDoListUusTegevusTextfield.setText("");
            }
        });
    }

    private void valitudTegevus() {
        int valitudTegevus = toDoListTegevusedListview.getSelectionModel().getSelectedIndex();
        if (valitudTegevus == -1) {
            return;
        }

        toDoListTehtudNupp.setDisable(false);
        toDoListMuudaNupp.setVisible(true);
        toDoListMuudaTextfield.setVisible(true);
        toDoListKustutaNupp.setVisible(true);

        if (toDoList.getToDoList().get(valitudTegevus).isTehtud()) {
            toDoListTehtudNupp.setText("Tegemata..");
        } else {
            toDoListTehtudNupp.setText("Tehtud!");
        }
    }

    private void märgiTehtuksTegemata() {
        int valitudTegevus = toDoListTegevusedListview.getSelectionModel().getSelectedIndex();
        if (valitudTegevus == -1) { // ehk ei valitud mingit tegevust
            return;
        }

        Tegevus tegevus = toDoList.getToDoList().get(valitudTegevus);
        if (tegevus.isTehtud()) { // nupu kiri sõltub sellest, kas tegevus on tehtud või mitte
            toDoListTehtudNupp.setText("Tehtud!");
        } else {
            toDoListTehtudNupp.setText("Tegemata..");
        }
        tegevus.setTehtud(!tegevus.isTehtud());
        toDoListTegevusedListview.getItems().set(valitudTegevus, tegevus.toString());
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
                randomToDoSuvalineLabel.setText("Järgmisena tee: " + suvaline.getKirjeldus() +
                        "\n(kui soovid uut suvalist tegevust, vajuta randomToDo peale)");
            }
        }
    }
}
