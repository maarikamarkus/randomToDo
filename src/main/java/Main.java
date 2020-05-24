import Other.Tegevus;
import Other.ToDoList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main extends Application {

    private ToDoList toDoList = ToDoList.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("vaade.fxml"));
        primaryStage.setTitle("randomToDo");
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("randomToDo.txt")))) {
            //System.out.println("Kirjutan faili.");
            for (Tegevus t : toDoList.getToDoList()) {
                bw.write(t.getKirjeldus() + " " + t.isTehtud());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Tegevused failis.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}


