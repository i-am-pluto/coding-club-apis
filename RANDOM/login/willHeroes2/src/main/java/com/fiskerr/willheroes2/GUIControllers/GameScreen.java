package com.fiskerr.willheroes2.GUIControllers;

import com.fiskerr.willheroes2.gameElements.orcs.GreenOrc;
import com.fiskerr.willheroes2.gameElements.Hero;
import com.fiskerr.willheroes2.gameElements.Map;
import com.fiskerr.willheroes2.gameElements.orcs.Orcs;
import com.fiskerr.willheroes2.gameElements.orcs.RedOrc;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameScreen implements Initializable {

    @FXML
    private ImageView hero;

    @FXML
    private AnchorPane Orcs;

    @FXML
    private AnchorPane container;

    @FXML
    private AnchorPane Environment;

    @FXML
    private Text score;

    private Hero HeroObject;
    private GreenOrc greenObject;
    private RedOrc redOrcObject;
    private Map mapObject;
    @FXML private AnchorPane ap;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Scene scene = (Scene) hero.getScene();
//        Stage stage = (Stage) ap.getScene().getWindow();

        ObservableList<Node> nodes= Environment.getChildren();
        this.mapObject = new Map(nodes,Orcs.getChildren(),hero);

        this.HeroObject = new Hero(hero,hero.getX(),hero.getY(),mapObject);
        Thread jump = new Thread(this.HeroObject);
        jump.start();

        for(ImageView orc :mapObject.getOrcs()){
            TranslateTransition jumpOrc = new TranslateTransition(Duration.millis(1200),orc);
            jumpOrc.setByY(-240f);
            jumpOrc.setAutoReverse(true);
            jumpOrc.setCycleCount(-1);
            jumpOrc.play();
;        }
    }
    @FXML
    public void handleMove() {
        int index = mapObject.getClosestOrc1(hero.getLayoutX());
        ArrayList<ImageView>orcs = mapObject.getOrcs();
        ArrayList<Orcs>orcs1 = mapObject.getOrcs1();
        hero.setLayoutX(hero.getLayoutX()+80f);
        score.setText("SCORE-0"+String.valueOf(Integer.parseInt(score.getText().substring(score.getText().length()-2))+1));
        if(hero.getLayoutX()>=900){
            hero.setLayoutX(hero.getLayoutX()-900);
            Environment.setLayoutX(Environment.getLayoutX()-900);
            for(ImageView orc: mapObject.getOrcs()){
                orc.setLayoutX(orc.getLayoutX()-900);
            }
        }

        if(index!=-1 && hero.getLayoutX()+hero.getFitWidth()-10 >= orcs.get(index).getLayoutX() && hero.getY()- hero.getFitHeight()<orcs.get(index).getY() && hero.getY() >orcs.get(index).getY()-orcs.get(index).getFitHeight()){
            System.out.println("Hit");
            orcs1.get(index).hit();
        }



    }

    public void death(){
        System.out.println("Dying");
    }
}
