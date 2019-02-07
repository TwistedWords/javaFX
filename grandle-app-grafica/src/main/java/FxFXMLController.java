import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FxFXMLController implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setRotate( c1, true, 360, 10);
        setRotate( c2, true, 180, 18);
        setRotate( c3, true, 145, 24);



    }

    int rotate = 0;

    private void setRotate(Circle c, boolean b, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration),c);

        rotateTransition.setAutoReverse(b);

        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(18);
        rotateTransition.play();

    }




}
