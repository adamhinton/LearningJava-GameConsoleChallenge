package dev.lpa.game;

public class Pirate implements Player{

    enum Weapon{
        AXE(1, 10), KNIFE(5, 20), MACHETE (10, 50), CANNON (20, 100);

        Weapon(int minLevel, int hitPoints) {
        }
    }

    private final String name;

    public Pirate(String name) {
        this.name = name;
    }



    @Override
    public String name() {
        return this.name;
    }
}
