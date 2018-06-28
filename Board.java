package com.utad;

import com.utad.factory.FactoryNormal;
import com.utad.factory.FactoryPiece;
import com.utad.factory.FactoryPro;
import com.utad.pieces.Piece;
import com.utad.pieces.Wizard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    private FactoryPiece factory;

    public Board() {

    }

    public boolean initializePieces(String pro) {
        List<String> normalList = new ArrayList<>();//This will contain the normal pieces
        normalList.addAll(Arrays.asList("W", "E", "T", "F", "D"));
        List<String> proList = Arrays.asList(pro.toUpperCase().split("-"));

        //Check for errors
        if (!pro.contains("-") || pro.length() != 3 || pro.charAt(0) == pro.charAt(2) || !normalList.containsAll(proList)) {
            System.out.println("Error! Las piezas pro no se han introducido adecuadamente. Ejemplo: W-E");
            return false;
        }

        normalList.removeAll(proList);//Removing pro pieces from normal list

        //Creating pro pieces
        factory = new FactoryPro();
        generatePieces(proList);

        //Creating normal pieces
        factory = new FactoryNormal();
        generatePieces(normalList);

        this.turn = !turn;
        return true;
    }

    private void generatePieces(List<String> pieceList) {
        //Setting team according to the 'turn'
        List<Piece> team = (turn) ? upperTeam : lowerTeam;

        for (int i = 0; i < pieceList.size(); i++) {
            if (pieceList.get(i).toUpperCase().equals("W")) {
                team.add(factory.createWizard(turn));
            } else if (pieceList.get(i).toUpperCase().equals("E")) {
                team.add(factory.createElf(turn));
            } else if (pieceList.get(i).toUpperCase().equals("T")) {
                team.add(factory.createTitan(turn));
            } else if (pieceList.get(i).toUpperCase().equals("F")) {
                team.add(factory.createFighter(turn));
            } else if (pieceList.get(i).toUpperCase().equals("D")) {
                team.add(factory.createDragon(turn));
            }
        }
    }


    public void initializeBoard() {
        //Initialize the matrix board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] = new Square();
            }
        }

        //Assign a position to the pieces
        for (int i = 0; i < board.length; i++) {
            board[upperTeam.get(i).getX()][upperTeam.get(i).getY()].setPiece(upperTeam.get(i));
            board[lowerTeam.get(i).getX()][lowerTeam.get(i).getY()].setPiece(lowerTeam.get(i));
        }

    }

    //If the action is successful returns 'true' else 'false'
    public boolean selectAction(String actionPiece, Board boardGame) {
        boolean result = false;
        int action;
        String piece;

        //Split String and checking for errors
        try {
            String[] parts = actionPiece.split("-");
            action = Integer.parseInt(parts[0]);
            piece = parts[1];

            //Setting piece (return false if already played or doesn't exist)
            if (!setPieceTurn(piece)) return result;

        } catch (Exception e) {
            System.out.println("Error! La acción no se ha introducido adecuadamente. Ejemplo: 1-W");
            return  false;
        }

        //Execute action
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
            case 6:
                //result = this.pieceTurn.ChangeBoots
                result = true;
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

    public int getRound() {
        return this.round;
    }


    public void setTurn() {
        if (turn) {//Turn Upper
            if (isRoundUpper() && isRoundLower()) {//If they move all pieces in this round
                this.round++;
                System.out.println("\n··· RONDA: " + this.round + " ···");
                resetUsed();
                this.turn = false;
            } else if (!isRoundLower()) {//If 'Lower' can move pieces then we give it the turn
                this.turn = false;
            }

            //else 'Upper' continues with the turn

        } else {//Turn Lower
            if (isRoundUpper() && isRoundLower()) {//If they move  all piecers in this round
                this.round++;
                System.out.println("\n··· RONDA: " + this.round + " ···");
                resetUsed();
                this.turn = true;
            } else if (!isRoundUpper()) {//If 'Upper' can move pieces then we give it the turn
                this.turn = true;
            }

            //else 'Lower' continues with the turn
        }
    }

    public String printUsed() {
        String result = "";
        if (turn) {//Upper turn
            for (int i = 0; i < upperUsed.size(); i++) {
                result += upperUsed.get(i).getName() + " ";
            }
        } else {//Lower turn
            for (int i = 0; i < lowerUsed.size(); i++) {
                result += lowerUsed.get(i).getName() + " ";
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
                String type = " ";

                if (board[i][j].isOccupied()) { //If there is a piece
                    String name = board[i][j].getPiece().getName();
                    if (name.length() == 2) {
                        piece = String.valueOf(name.charAt(0));
                        type = String.valueOf(name.charAt(1));
                    } else {
                        piece = name;
                    }
                }

                System.out.print("| " + piece + type);
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("  ---------------------");
    }
}
