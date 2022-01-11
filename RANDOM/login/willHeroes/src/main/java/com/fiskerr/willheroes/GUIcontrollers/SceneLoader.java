package com.fiskerr.willheroes.GUIcontrollers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SceneLoader {

    private Scene currentScene;

    public SceneLoader() throws IOException {
        File newFile = new File("/Home.fxml");
        System.out.println(newFile.getAbsolutePath());
        this.currentScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/fiskerr/willheroes/GUI/Home.fxml")));
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }
}
