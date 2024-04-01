package dev.lpa.game;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends Player>>{

    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer(){
        System.out.print("Enter your playing name: ");
        String name = scanner.nextLine();

        System.out.println("Welcome to %s, %s!%n".formatted(game.getGameName(), name));

        return game.addPlayer(name);
    }


}
