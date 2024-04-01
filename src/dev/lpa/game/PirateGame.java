package dev.lpa.game;

import java.util.Map;

public class PirateGame extends Game<Pirate>{

//    static List<List<String>> levelMap =

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name) {
        return new Pirate(name, Pirate.Weapon.AXE);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        return null;
    }
}
