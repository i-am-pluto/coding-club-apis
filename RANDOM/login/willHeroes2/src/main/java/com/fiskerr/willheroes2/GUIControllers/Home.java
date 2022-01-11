package com.fiskerr.willheroes2.GUIControllers;

import com.fiskerr.willheroes2.App;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private ImageView myHero;
    @FXML
    private ImageView orc;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//         breathing effect
        ScaleTransition breathing = new ScaleTransition();
        breathing.setNode(myHero);
        breathing.setDuration(Duration.millis(1000));
        breathing.setByX(0.09);
        breathing.setAutoReverse(true);
        breathing.setCycleCount(500);
        breathing.play();
        ScaleTransition breathing2 = new ScaleTransition();
        breathing2.setNode(orc);
        breathing2.setDuration(Duration.millis(1000));
        breathing2.setByX(0.09);
        breathing2.setAutoReverse(true);
        breathing2.setCycleCount(500);
        breathing2.play();


    }
    @FXML
    public void openSettings(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/Setting.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    public void openLeaderBoard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/LeaderBoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    public void openGameScene(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/GameStartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(App.class.getResource("GUI/style.css").toString());
        stage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setMinHeight(900);
        stage.setMaxHeight(1200);
        stage.setMinWidth(1100);
        stage.setMaxWidth(1100);
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

    }
}
