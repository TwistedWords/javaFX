

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class load extends Application {


    @FXML
    private HBox box1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/load.fxml"));

        stage.setTitle("");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 366 , 366));
        stage.show();


        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    stage.hide();
                }
                return null;
            }
        };

        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                stage.hide();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Parent root = null;

                        try {
                            root = FXMLLoader.load(getClass().getResource("/StartScreen.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        scene.setFill(Color.TRANSPARENT);
                        stage.show();


                        //box1.getScene().getWindow().hide();

                    }
                });
            }
        });
        new Thread(sleeper).start();




    }



}
