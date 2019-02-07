import Connectivity.ConnectionClass;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBook extends Application {

    int i = 1;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/AddBook.fxml"));
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

    @FXML
    TextField text1;
    @FXML
    TextField text2;
    @FXML
    TextField text3;


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

    @SuppressWarnings("Duplicates")
    @FXML
    public void AddBook() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
/*
        String sql3 = "INSERT INTO ID VALUES('"+i+"')";
        Statement statement3 = connection.createStatement();
        statement3.executeUpdate(sql3);
        i++;

        String sql = "INSERT INTO TITLU VALUES('"+text1.getText()+"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        String sql1 = "INSERT INTO AUTOR VALUES('"+text2.getText()+"')";
        Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);

        String sql2 = "INSERT INTO EDITURA VALUES('"+text3.getText()+"')";
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(sql2);
*/

        String script="insert into BOOKS(ID,TITLU,AUTOR,EDITURA) VALUES (?,?,?,?)";
        PreparedStatement querry =connection.prepareStatement(script);
        querry.setInt(1,i);
        querry.setString(2,text1.getText());
        querry.setString(3,text2.getText());
        querry.setString(4,text3.getText());
        querry.executeUpdate();
    }

}
