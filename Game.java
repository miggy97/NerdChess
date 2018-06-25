package com.utad;

import java.util.Scanner;

public class Game {
    private Board boardGame = new Board();
    private Scanner sc = new Scanner(System.in);
    private int round = 0;

    public Game() {
        System.out.println("RONDA: " + round);
        gameCicle();
    }

    private void gameCicle() {
        boardGame.printBoard();//Prints the info about the game
        System.out.println("1.Mover  2.Atacar  3.Curar  4.Combinarse   5.Reproducirse  6.CambiarBotas");
        turn();//Whose turn
        System.out.println("Acción:");

        //Get the input
        String actionPiece = sc.nextLine();
        if (!actionPiece.contains("-")) {
            System.out.println("Error! La acción no se ha introducido adecuadamente");
            gameCicle();
        }
        String[] parts = actionPiece.split("-");
        int action = Integer.parseInt(parts[0]);
        String piece = parts[1];

        if (boardGame.selectAction(action, piece, boardGame)) {
            boardGame.addToUsed();
            boardGame.setTurn(!boardGame.isTurn());
            gameCicle();
        } else {
            gameCicle();
        }
    }

    private void turn() {
        if (boardGame.isTurn()) {
            System.out.println("Turno de Upper\t Usadas: " + boardGame.printUsed());
        } else {
            System.out.println("Turno de Lower\t Usadas: " + boardGame.printUsed());
        }
    }
}
