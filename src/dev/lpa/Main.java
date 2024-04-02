package dev.lpa;

import dev.lpa.pirate.Pirate;
import dev.lpa.pirate.PirateGame;
import dev.lpa.pirate.Weapon;

public class Main {
    public static void main(String[] args) {


        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitpoints=" + weapon.getHitPoints() + ", minlevel=" + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);


        Pirate tim = new Pirate("Tim");
        System.out.println(tim);


        PirateGame.getTowns(0).forEach(System.out::println);
        System.out.println("-------------------------------");
        PirateGame.getTowns(1).forEach(System.out::println);


//        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
//        int playerIndex = console.addPlayer();
//
//        console.playGame(playerIndex);

    }
}