package com.fiskerr.willheroes2.gameElements;

import com.fiskerr.willheroes2.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Hero implements Runnable {

    private ImageView heroGUI;

    private double x;
    private double y;
    private Map map;
    private Stage primarystage;
    public Hero(ImageView heroGUI, double x, double y, Map map) {
//        this.primarystage = (Stage)heroGUI.getScene().getWindow();
        this.heroGUI = heroGUI;
        this.x = x;
        this.y = y;
        this.map = map;

    }


    @Override
    public void run() {
//        jump up -> check for death by impact with orc while jumping up
        while (true) {
            try {
                jump();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageView orc = map.getClosestOrc(heroGUI.getX());
            if (orc != null && orc.getX() < heroGUI.getX() && heroGUI.getX() < orc.getX() + orc.getFitWidth() && heroGUI.getY() + heroGUI.getFitHeight() >= orc.getY() + orc.getFitHeight()) {
                try {
                    death();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                gravity();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void jump() throws IOException {
        double height = heroGUI.getY();
        for (int i = 0; i <= 240; i+=60) {
            int x;
            heroGUI.setY(height - i);
            ImageView orc = map.getClosestOrc(heroGUI.getLayoutX());
            if (orc != null && orc.getLayoutX() < heroGUI.getLayoutX() && heroGUI.getLayoutX() < orc.getLayoutX() + orc.getFitWidth() && heroGUI.getY() <= orc.getY()) {
                System.out.println("Under orc");
                death();
            }
                try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void gravity() throws IOException {

        double height = heroGUI.getY();
        for (int i = 0; i < 20000; i+=60) {
            heroGUI.setY(height + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ImageView orc = map.getClosestOrc(heroGUI.getLayoutX());
            if (orc != null && orc.getLayoutX() < heroGUI.getLayoutX() && heroGUI.getLayoutX() < orc.getLayoutX() + orc.getFitWidth() && heroGUI.getY() >= orc.getY() - orc.getFitHeight()-20) {
                System.out.println("On orc");
                jump();
                gravity();
            }

            ImageView island = map.getClosestIsland(heroGUI.getLayoutX());
            if (island != null && heroGUI.getY() >= 0 && heroGUI.getLayoutX() < island.getLayoutX() + island.getFitWidth() && heroGUI.getLayoutX() > island.getLayoutX()-30) {
//                System.out.println("heroGUI.getLayoutX() "+heroGUI.getLayoutX()+ "\n island.getLayoutX()"+island.getLayoutX()+"\nisland.getFitWidth() "+island.getFitWidth());

                return;
            }
            if (island == null) {
                System.out.println("Island is null");
            }
            if (heroGUI.getY() > 20) {
                death();
                return;
            }
        }
    }

    private boolean death() throws IOException {
//        replace hero with boom sound and stop the game with the score
        System.out.println("Dying");
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("GUI/Death.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        this.primarystage.setScene(scene);
        return false;
    }


    public ImageView getHeroGUI() {
        return heroGUI;
    }

    public void setHeroGUI(ImageView heroGUI) {
        this.heroGUI = heroGUI;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
