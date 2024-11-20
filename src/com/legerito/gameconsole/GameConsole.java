package com.legerito.gameconsole;

import java.util.Scanner;

public class GameConsole <T extends Game<? extends Player>>{

    private final T game;
    public static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    public int addPlayer() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.printf("Welcome to %s. %s!n".formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean done = false;

        while (!done) {
            var gameActions = game.getGameActions(playerIndex);
            System.out.println("Select one of the following actions: ");
            for (Character c : gameActions.keySet()) {
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + " - (%s)".formatted(c));
            }
            System.out.println("Enter next action: ");
            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            if(gameAction != null) {
                System.out.println("-".repeat(10));
                done = game.executeGameAction(playerIndex, gameAction);
                if(!done) {
                    System.out.println("-".repeat(10));
                }
            }
        }
    }
}
