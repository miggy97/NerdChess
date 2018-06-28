package com.utad;

import java.util.Scanner;

public class Game {
    private Board boardGame = new Board();
    private Scanner sc = new Scanner(System.in);

    public Game() {
        start();
    }

    private void start(){
        //Choose pro pieces (the game doesn't start until you complete this step correctly)
        while (true) if(choosePro()) break;
        while (true) if (choosePro()) break;

        //Initialize Board with pieces
        boardGame.initializeBoard();

        System.out.println("\n··· RONDA: " + boardGame.getRound() + " ···");

        //Choose max rounds ??
        gameCicle();
    }
    private boolean choosePro(){
        turn();
        System.out.println("Elige 2 piezas pro (Ejemplo: F-D):");
        String pro = sc.nextLine();
        return boardGame.initializePieces(pro);
    }
    private void gameCicle() {
        boardGame.printBoard();//Prints the info about the game
        System.out.println("1.Mover  2.Atacar  3.Curar  4.Combinarse   5.Reproducirse  6.CambiarBotas");
        turn();//Whose turn
        System.out.println("Acción:");

        //Get action and piece (1-W)
        String actionPiece = sc.nextLine();

        if (boardGame.selectAction(actionPiece, boardGame)) {
            boardGame.addToUsed();
            boardGame.setTurn();
        }

        gameCicle();
    }

    private void turn() {
        if (boardGame.isTurn()) {
            System.out.println("Turno de Upper\t Usadas: " + boardGame.printUsed());
        } else {
            System.out.println("Turno de Lower\t Usadas: " + boardGame.printUsed());
        }
    }
}
