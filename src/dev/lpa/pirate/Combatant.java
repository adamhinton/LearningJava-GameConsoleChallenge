package dev.lpa.pirate;

import dev.lpa.game.Player;

import java.util.*;

public abstract class Combatant implements Player {

    private final String name;
    private final Map<String, Integer> gameData;
    // In insertion order to track order of towns visited
    private Weapon currentWeapon;


    public Combatant(String name) {
        this.name = name;
    }

    public Combatant(String name, Map<String, Integer> gameData) {
        this.name = name;
        if(gameData != null){
            this.gameData.putAll(gameData);
        }
    }

    // ---------------------------------------------
    // Instance initializer
    // Executed rgdls of which ctr is used
    {
        gameData = new HashMap<>(Map.of(
                "health", 100,
                "score", 0
        ));
    }
    // ---------------------------------------------


    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    // removed `public` modifier so only classes in this package can call setCurrentWeapon
    protected void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    // String is key to pirate data on gameData
    int value(String name){
        return gameData.get(name);
    }

    // Only Pirate class can use this
    protected void setValue(String name, int value){
        gameData.put(name, value);
    }

    // Adjust an item in gameData by amount `adj`
    protected void adjustValue(String name, int adj){
        gameData.compute(name, (k, v) -> v += adj);
    }

    protected void adjustHealth(int adj){
        int health = value ("health");
        health +=adj;
        health = (health < 0) ? 0 : ((health > 100) ? 100 : health);
        setValue("health", health);
    }



    @Override
    public String name() {
        return this.name;
    }


    @Override
    public String toString() {
        return name;
    }


    // Fancy toString with more info
    public String information(){
        return name + " " + gameData;
    }
}
