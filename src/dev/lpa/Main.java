package dev.lpa;

import dev.lpa.pirate.Pirate;
import dev.lpa.pirate.Weapon;

public class Main {
    public static void main(String[] args) {


        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitpoints=" + weapon.getHitPoints() + ", minlevel=" + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);


        Pirate tim = new Pirate("Tim");
        System.out.println(tim);



    }
}