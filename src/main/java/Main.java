import Other.SceneName;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    private static Map<SceneName, Scene> vaated = new HashMap<>(); // mõtle korraks läbi, kuidas fxml failidega teha

    @Override
    public void start(Stage primaryStage) throws Exception{

        // proovida kasutada sõnastikku

        Parent root = FXMLLoader.load(getClass().getResource("vaade.fxml"));
        primaryStage.setTitle("randomToDo");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    // mõtle korraks läbi, kuidas fxml failidega teha
    public static Map<SceneName, Scene> getVaated() {
        return vaated;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


