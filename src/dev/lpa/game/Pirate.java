package dev.lpa.game;

import java.util.Map;
import java.util.Set;

public class Pirate implements Player{

    enum Weapon{
        AXE(1, 10), KNIFE(5, 20), MACHETE (10, 50), CANNON (20, 100);

        Weapon(int minLevel, int hitPoints) {
        }
    }

    private final Map<String, Integer> gameData;
    private Set<String> townsVisited;
    private final String name;
    private Weapon currentWeapon;

    public Pirate(String name, Weapon currentWeapon) {
        this.name = name;
        this.currentWeapon = currentWeapon;
    }

    @Override
    public String name() {
        return this.name;
    }
}
