package com.fiskerr.willheroes2.GUIControllers;

import com.fiskerr.willheroes2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class Setting {
    @FXML
    public void closeSettings(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    public void saveName(ActionEvent event) {

    }
    @FXML
    public void muteUnmute(ActionEvent event){

        ToggleButton button = ((ToggleButton)event.getSource());
        String name = button.getText();
        if(name.equals("Mute")){
            button.setText("Unmute");
            button.setStyle("-fx-background-color: green");

        }
        else{
            button.setText("Mute");
            button.setStyle("-fx-background-color: red");
        }
        /*
        * Logic*/

    }
}