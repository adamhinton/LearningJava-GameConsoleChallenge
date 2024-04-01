package dev.lpa.pirate;

import dev.lpa.game.Game;
import dev.lpa.game.GameAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PirateGame extends Game<Pirate> {

    // 2d list
    private static final List<List<String>> levelMap;

    //    --------------------------------------------
    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading Data...");
        loadData();

        if(levelMap.size() == 0){
            throw new RuntimeException("Could not load data, try later");
        }

        System.out.println("Finished loading data.");
    }
    // -------------------------------------------------


    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        return null;
    }


    private static void loadData(){
        // Level 1 towns
        levelMap.add(new ArrayList<>(List.of(
            "Bridgetown, Barbados",
                "Fitts Village, Barbados",
                "Holetown, Barbados"
        )));

        // Level 2 towns
        levelMap.add(new ArrayList<>(List.of(
                "Fort-de-France, Martinique",
                "Sainte-Anne, Martinique",
                "Le Vauclin, Martinique"
        )));
    }

    public static List<String> getTowns(int level){
        if (level <= (levelMap.size() -1)){
            return levelMap.get(level);
        }

        // If player level greater than game level
        return null;
    }
}
