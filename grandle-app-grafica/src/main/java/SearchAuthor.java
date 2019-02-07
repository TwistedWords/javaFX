import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SearchAuthor extends Application {
    @SuppressWarnings("Duplicates")
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/SearchID.fxml"));
        stage.initStyle(StageStyle.UTILITY);
        stage.setOpacity(0);
        stage.setHeight(0);
        stage.setWidth(0);
        stage.show();

        stage.setTitle("FXML Welcome");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 366, 366));
        stage.show();

    }

    @FXML
    AnchorPane pane1;

    @SuppressWarnings("Duplicates")
    @FXML
    public void Back(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                try{
                    root = FXMLLoader.load(getClass().getResource("/StartScreen.fxml"));
                }
                catch (IOException error)
                {}
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                pane1.getScene().getWindow().hide();

            }
        });
    }



}
