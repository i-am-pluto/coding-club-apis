package com.fiskerr.willheroes2.gameElements;

import com.fiskerr.willheroes2.gameElements.orcs.BossOrc;
import com.fiskerr.willheroes2.gameElements.orcs.GreenOrc;
import com.fiskerr.willheroes2.gameElements.orcs.Orcs;
import com.fiskerr.willheroes2.gameElements.orcs.RedOrc;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class Map {

    // chest location
    private ArrayList<Pair<Double, Double>> chests;
    // 1. is weapon
    // 2. is coins
    private ImageView hero;
    private Pair<Double, Double> obstacle;

    private ArrayList<Pair<Double, Double>> coins;
    private ArrayList<ImageView> Orcs;

    private ArrayList<ImageView> islands;
    private ArrayList<Orcs> orcs;

    public Map(ObservableList<Node> nodes,ObservableList<Node>enemy,ImageView hero) {
        this.hero = hero;
        this.islands = new ArrayList<>();
        this.Orcs = new ArrayList<>();
        this.orcs = new ArrayList<>();
        for (Node node : nodes) {

            if (node.getStyleClass().size() > 1 && node.getStyleClass().get(1).equals("env")) {
                this.islands.add((ImageView) node);
            }


        }
        for(Node node: enemy){
            Orcs.add((ImageView) node);
        }
        islands.sort(
                new Comparator<ImageView>() {
                    @Override
                    public int compare(ImageView o1, ImageView o2) {
                        if (o1.getLayoutX() > o2.getLayoutX()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                });
        Orcs.sort(new Comparator<ImageView>() {
            @Override
            public int compare(ImageView o1, ImageView o2) {
                if (o1.getLayoutX() > o2.getLayoutX()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for(ImageView orc : this.Orcs){
            com.fiskerr.willheroes2.gameElements.orcs.Orcs orcs1;
            if(orc.getStyleClass().get(2).equals("green-orc")){
                orcs1 = new GreenOrc(orc,hero);
            }
            else if(orc.getStyleClass().get(2).equals("red-orc")){
                orcs1 = new RedOrc(orc,hero);
            }
            else{
                orcs1 = new BossOrc(orc,hero);
            }
            orcs.add(orcs1);
        }

    }

    public ImageView getClosestOrc(double x) {
        for(ImageView orc : Orcs){
            if(orc.getLayoutX()<x){
                return orc;
            }

        }
        return null;
    }

    public ImageView getClosestIsland(double x) {
        for(ImageView island : islands){
            if(island.getLayoutX()<x){
                return island;
            }

        }
        return null;
    }

    public int getClosestOrc1(double x){
        for(int i=0;i< Orcs.size()-1;i++){
            if(Orcs.get(i).getLayoutX()<x){
                return i+1;
            }
        }
        return -1;
    }



    public ArrayList<Pair<Double, Double>> getChests() {
        return chests;
    }

    public void setChests(ArrayList<Pair<Double, Double>> chests) {
        this.chests = chests;
    }

    public Pair<Double, Double> getObstacle() {
        return obstacle;
    }

    public void setObstacle(Pair<Double, Double> obstacle) {
        this.obstacle = obstacle;
    }

    public ArrayList<Pair<Double, Double>> getCoins() {
        return coins;
    }

    public void setCoins(ArrayList<Pair<Double, Double>> coins) {
        this.coins = coins;
    }

    public ArrayList<ImageView> getOrcs() {
        return Orcs;
    }

    public void setOrcs1(ArrayList<com.fiskerr.willheroes2.gameElements.orcs.Orcs> orcs) {
        this.orcs = orcs;
    }

    public void setOrcs(ArrayList<ImageView> orcs) {
        Orcs = orcs;
    }

    public ArrayList<ImageView> getIslands() {
        return islands;
    }

    public void setIslands(ArrayList<ImageView> islands) {
        this.islands = islands;
    }
    public ArrayList<com.fiskerr.willheroes2.gameElements.orcs.Orcs> getOrcs1(){
        return this.orcs;
    }
}