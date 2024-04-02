package dev.lpa.pirate;

import dev.lpa.game.Player;

import java.util.*;

public class Pirate implements Player {

    private final String name;
    private final Map<String, Integer> gameData;
    // In insertion order to track order of towns visited
    private final List<String> townsVisited = new LinkedList<>();
    private Weapon currentWeapon;


    public Pirate(String name) {
        this.name = name;
    }

    // ---------------------------------------------
    // Instance initializer
    // Executed rgdls of which ctr is used
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0,
                "level", 0,
                "townIndex", 0
        ));
        visitTown();
    }
    // ---------------------------------------------


    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    // removed `public` modifier so only classes in this package can call setCurrentWeapon
    void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    // String is key to pirate data on gameData
    int value(String name){
        return gameData.get(name);
    }

    // Only Pirate class can use this
    private void setValue(String name, int value){
        gameData.put(name, value);
    }

    // Adjust an item in gameData by amount `adj`
    private void adjustValue(String name, int adj){
        gameData.compute(name, (k, v) -> v += adj);
    }

    private void adjustHealth(int adj){
        int health = value ("health");
        health +=adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }


    boolean useWeapon(){
        System.out.println("Used the " + currentWeapon);
        return visitNextTown();
    }

    boolean visitTown(){
        List<String> levelTowns = PirateGame.getTowns(value("level"));

        if(levelTowns == null) return true;

        String town = levelTowns.get(value("townIndex"));

        if(town != null){
            townsVisited.add(town);
            // Town retrieved, don't end game
            return false;
        }
        // Town couldn't be retrieved, return true to end game
        return true;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        var current = ((LinkedList<String>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];

        Arrays.setAll(simpleNames, i-> townsVisited.get(i).split(",")[0]);

        return "---> " + current +
                "\nPirate " + name + " " + gameData +
                "\n\ttownsVisited=" + Arrays.toString(simpleNames);
    }


    private boolean visitNextTown(){
        int townIndex = value("townIndex");
        var towns = PirateGame.getTowns(value("level"));
        if (towns == null) return true;
        if(townIndex >= (towns.size()-1)){
            System.out.println("Leveling up! Bonus: 500 points");
            adjustValue("score", 500);
            adjustValue("level", 1);
            setValue("townIndex", 0);
        }
        else{
            System.out.println("Sailing to next town! Bonus: 50 points");
            adjustValue("townIndex", 1);
            adjustValue("score", 50);
        }
        return visitTown();
    }
}
