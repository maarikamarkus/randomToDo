package Controllerid;

import Other.ToDoList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class lisaTegevusController extends Controller {
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

    private ToDoList toDoList = ToDoList.getInstance();

    @FXML
    void initialize() {
        lisaTegevusLisaNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            String tegevuseKirjeldus = lisaTegevusUusTegevusField.getText();
            if (!tegevuseKirjeldus.equals("")) {
                Other.Tegevus uusTegevus = new Other.Tegevus(lisaTegevusUusTegevusField.getText(), false);
                toDoList.lisaToDoListi(uusTegevus);
            }
            //vahetaVaadet("/tegevused.fxml", lisaTegevusLisaNupp);
            vahetaVaadet("/toDoList.fxml", lisaTegevusLisaNupp);
        });

        lisaTegevusVaataTegevusiNupp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //vahetaVaadet("/tegevused.fxml", lisaTegevusVaataTegevusiNupp);
            vahetaVaadet("/toDoList.fxml", lisaTegevusVaataTegevusiNupp);

        });
    }
}
