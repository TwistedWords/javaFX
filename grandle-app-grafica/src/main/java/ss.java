
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ss {

    public static Object loadWindow(URL url, String title, Stage parentStage) {

        Object controller = null;

        try {
            FXMLLoader loader = new FXMLLoader(url);
            Parent parent = loader.load();
            Stage stage = null;
            controller = loader.getController();

            if (parentStage != null) {
                stage = parentStage;
            }
            else {
                if(title.isEmpty() || title == null)
                    stage = new Stage(StageStyle.UNDECORATED);
                else
                    stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            //setStageIcon(stage);
        } catch (IOException ex) {
            Logger.getLogger(ss.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controller;
    }
}