package dev.lpa.game;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Pirate implements Player{

    enum Weapon{
        AXE(0, 10),
        KNIFE(0, 30),
        MACHETE (1, 40),
        PISTOL (1, 50);

        private final int minLevel;
        private final int hitPoints;


        Weapon(int minLevel, int hitPoints) {
            this.minLevel = minLevel;
            this.hitPoints = hitPoints;
        }

        public int getMinLevel() {
            return minLevel;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public static Weapon getWeaponByChar(char firstInitial){
            for (Weapon w : values()){
                if (w.name().charAt(0) == firstInitial){
                    return w;
                }
            }
            return values()[0];
        }

        public static List<Weapon> getWeaponsByLevel (int levelOfPlay){
            List<Weapon> weapons = new ArrayList<>(EnumSet.allOf(Weapon.class));
            weapons.removeIf(w -> w.minLevel > levelOfPlay);
            // return remaining weapons
            return weapons;
        }
    }

//    private final Map<String, Integer> gameData;
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
