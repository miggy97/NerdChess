package com.utad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board {
    private Square[][] board = new Square[5][5];
    private List<Piece> upperTeam = new ArrayList<Piece>();
    private List<Piece> lowerTeam = new ArrayList<Piece>();
    private List<Piece> upperUsed = new ArrayList<Piece>();
    private List<Piece> lowerUsed = new ArrayList<Piece>();
    private boolean turn = true; //'true' is Upper turn and 'false' is 'Lower' turn
    private Piece pieceTurn; //Piece that is playing in that turn
    private int round = 0;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        //Initialize the matrix board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] = new Square();
            }
        }

        //Initialize pieces 'Upper' team
        upperTeam.add(new Piece(true, "W", 0, 0));
        upperTeam.add(new Piece(true, "E", 0, 1));
        upperTeam.add(new Piece(true, "T", 0, 2));
        upperTeam.add(new Piece(true, "F", 0, 3));
        upperTeam.add(new Piece(true, "D", 0, 4));

        //Initialize pieces 'Lower' team
        lowerTeam.add(new Piece(true, "w", 4, 0));
        lowerTeam.add(new Piece(true, "e", 4, 1));
        lowerTeam.add(new Piece(true, "t", 4, 2));
        lowerTeam.add(new Piece(true, "f", 4, 3));
        lowerTeam.add(new Piece(true, "d", 4, 4));

        //Assign a position to the pieces
        for (int i = 0; i < board.length; i++) {
            board[upperTeam.get(i).getX()][upperTeam.get(i).getY()].setPiece(upperTeam.get(i));
            board[lowerTeam.get(i).getX()][lowerTeam.get(i).getY()].setPiece(lowerTeam.get(i));
        }

    }

    //If the action is successful returns 'true' else 'false'
    public boolean selectAction(int action, String pieceName, Board boardGame) {
        boolean result = false;


        if (!setPieceTurn(pieceName)) return result;

        switch (action) {
            case 1://Move
                result = true;
                //result = this.pieceTurn.Move(boardGame);
                break;
            case 2://Attack
                result = true;
                //result = this.pieceTurn.Attack(boardGame);
                break;
            case 3://Heal
                result = true;
                //result = this.pieceTurn.Heal(boardGame);
                break;
            case 4://Merge
                result = true;
                //result = this.pieceTurn.Merge(boardGame);
                break;
            case 5://Reproduce
                result = true;
                //result = this.pieceTurn.Reproduce(boardGame);
                break;
            default://Error
                System.out.println("Error! No existe la acción: " + action);
                result = false;
                break;
        }
        return result;
    }

    //If the piece exists sets the piece and returns 'true' else returns 'false'
    public boolean setPieceTurn(String pieceName) {
        if (turn) {//Upper turn
            for (int i = 0; i < upperTeam.size(); i++) {
                if (upperTeam.get(i).getName().equals(pieceName.toUpperCase()) && !upperUsed.contains(upperTeam.get(i))) {
                    this.pieceTurn = upperTeam.get(i);
                    return true;
                }
            }
            System.out.println("Error! La ficha que has elegido no existe o ya la has utilizado en esta ronda");
            return false;
        } else {//Lower turn
            for (int i = 0; i < lowerTeam.size(); i++) {
                if (lowerTeam.get(i).getName().equals(pieceName.toLowerCase()) && !lowerUsed.contains(lowerTeam.get(i))) {
                    this.pieceTurn = lowerTeam.get(i);
                    return true;
                }
            }
            System.out.println("Error! La ficha que has elegido no existe o ya la has utilizado en esta ronda");
            return false;
        }
    }

    public void addToUsed() {
        if (turn) {//Upper turn
            upperUsed.add(this.pieceTurn);
        } else {//Lower turn
            lowerUsed.add(this.pieceTurn);
        }
    }

    public void resetUsed() {//When the round ends Used Lists resets
        upperUsed.clear();
        lowerUsed.clear();
    }

    public boolean isRoundUpper() {//Checks if Upper used all the pieces
        return new HashSet<>(upperTeam).equals(new HashSet<>(upperUsed));
    }

    public boolean isRoundLower() {//Checks if Lower used all the pieces
        return new HashSet<>(lowerTeam).equals(new HashSet<>(lowerUsed));
    }


    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    public boolean isTurn() {
        return turn;
    }

    public int getRound(){
        return this.round;
    }


    public void setTurn() {
        if(turn){//Turn Upper
            if(isRoundUpper() && isRoundLower()){//If they move all pieces in this round
                this.round ++;
                System.out.println("\n··· RONDA: " + this.round + " ···");
                resetUsed();
                this.turn = false;
            }
            else if(!isRoundLower()){//If 'Lower' can move pieces then we give it the turn
                this.turn = false;
            }

            //else 'Upper' continues with the turn

        }
        else{//Turn Lower
            if(isRoundUpper() && isRoundLower()){//If they move  all piecers in this round
                this.round ++;
                System.out.println("\n··· RONDA: " + this.round + " ···");
                resetUsed();
                this.turn = true;
            }
            else if(!isRoundUpper()){//If 'Upper' can move pieces then we give it the turn
                this.turn = true;
            }

            //else 'Lower' continues with the turn
        }
    }

    public String printUsed() {
        String result ="";
        if (turn) {//Upper turn
            for (int i = 0; i < upperUsed.size(); i++) {
                result += upperUsed.get(i).getName() + " ";
            }
        } else {//Lower turn
            for (int i = 0; i < lowerUsed.size(); i++) {
                result+=lowerUsed.get(i).getName() + " ";
            }
        }
        return result;
    }

    public void printHP() {//Prints the health points of the teams
        for (int i = 0; i < upperTeam.size(); i++) {
            System.out.print(upperTeam.get(i).getName() + ":" + upperTeam.get(i).getHp() + " ");
        }
        System.out.println("");
        for (int i = 0; i < lowerTeam.size(); i++) {
            System.out.print(lowerTeam.get(i).getName() + ":" + lowerTeam.get(i).getHp() + " ");
        }
        System.out.println("");
    }

    public void printBoard() {
        boolean flag = true; //To place leters
        for (int i = 0; i < board.length; i++) {
            System.out.println("");
            if (flag) {
                printHP();
                System.out.println("    A   B   C   D   E");
                flag = false;
            }
            System.out.println("  ---------------------");
            System.out.print(i + 1 + " ");
            for (int j = 0; j < board.length; j++) {
                String piece = " ";

                if (board[i][j].isOccupied()) { //If there is a piece
                    piece = board[i][j].getPiece().getName();
                }

                System.out.print("| " + piece + " ");
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("  ---------------------");
    }
}
