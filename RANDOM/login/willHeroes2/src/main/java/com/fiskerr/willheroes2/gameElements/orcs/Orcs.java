package com.fiskerr.willheroes2.gameElements.orcs;

import javafx.scene.image.ImageView;

public class Orcs{

    protected ImageView orcGUI;
    protected int health;
    protected ImageView heroGUI;
    public Orcs(ImageView orcGUI, int health, ImageView heroGUI) {
        this.orcGUI = orcGUI;
        this.health = health;
        this.heroGUI = heroGUI;
    }

    public void hit(){
        health--;
        if(health<=0){
            death();
        }
        heroGUI.setLayoutX(heroGUI.getLayoutX()-250f);
    }
    private void death(){
        orcGUI.setFitHeight(0);
        orcGUI.setFitWidth(0);
        System.out.println("Death");
    }

    public ImageView getOrcGUI() {
        return orcGUI;
    }

    public void setOrcGUI(ImageView orcGUI) {
        this.orcGUI = orcGUI;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
