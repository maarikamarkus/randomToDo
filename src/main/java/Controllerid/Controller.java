package Controllerid;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    public static void vahetaVaadet(String asukoht, Node node) {
        // Peidame praegu kuvatava akna
        node.getScene().getWindow().hide();

        // Saame vajaliku info uue akna kuvamiseks
        FXMLLoader laadija = new FXMLLoader();
        laadija.setLocation(Controller.class.getResource(asukoht));
        // Uue akna kuvamine
        try {
            laadija.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Parent root = laadija.getRoot();
        Stage stage = new Stage();
        stage.setTitle(asukoht.substring(1, asukoht.length()-5));
        stage.setScene(new Scene(root)); //*/
        stage.show();

    }
}
