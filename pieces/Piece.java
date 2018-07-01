package com.utad.pieces;


import com.utad.Board;
import com.utad.Square;
import com.utad.move.MoveBehavior;
import com.utad.move.MovePro;
import com.utad.move.MoveSimple;
import com.utad.state.Exhausted;
import com.utad.state.Furious;
import com.utad.state.Sane;
import com.utad.state.State;

//Decorator, Strategy, Template, State, Factory
public abstract class Piece {
    protected boolean upper; //This identifies the team ('Upper' or 'Lower')
    protected String name = "";
    protected int hp = 0; //Health Points
    protected int damageTaken = 0;
    protected int attackDmg = 0; //Attack Damage
    protected int magicDmg = 0; //Magic Damage
    //Position
    protected int x;
    protected int y;
    //Possible states
    protected State sane;
    protected State furious;
    protected State exhausted;
    protected State state;
    //Movement
    MoveBehavior moveBehavior = new MoveSimple();


    public Piece() {
        this.sane = new Sane(this);
        this.furious = new Furious(this);
        this.exhausted = new Exhausted(this);
        this.state = sane;//Initial state
    }

    public final boolean ExecuteAttack(Piece enemyPiece) {
        int damage = getAttackDmg();
        damage += specificAttack(damage);
        return this.state.attack(damage, enemyPiece);
    }

    public final void ExecuteDefense() {
        int magic = getMagicDmg();
        specificDefense(magic);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean changeBoots() {
        if (moveBehavior instanceof MoveSimple) {
            moveBehavior = new MovePro();
            System.out.println("Cambiando botas a pro!");
            return true;
        } else {
            System.out.println("Error! Ya tienes botas pro");
            return false;
        }
    }

    public void calculateMovement(Board board) {
        moveBehavior.calculateMove(this.x, this.y, board);
    }

    public boolean heal(Piece allyPiece) {
        return this.state.heal(allyPiece);
    }

    public boolean merge(Square square, Board board) {
        return this.state.merge(square, board);
    }

    public boolean reproduce(int x, int y, Board board) {
        return this.state.reproduce(x, y, board);
    }

    public void takeDamage(int damage) {
        state.takeDamage(damage);
    }

    public void takeHeal(int heal) {
        state.takeHeal(heal);
    }

    public abstract int specificAttack(int attackDmg);

    public abstract void specificDefense(int magicDmg);

    public int getAttackDmg() {
        return attackDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }

    public void setDamageTaken(int damage) {
        this.damageTaken += damage;
    }

    public void setHealTaken(int heal) {
        this.damageTaken -= heal;
        if (damageTaken < 0) damageTaken = 0;
    }

    public void tellState() {
        if (state instanceof Sane) {
            System.out.println("Estoy sano!");
        } else if (state instanceof Furious) {
            System.out.println("Estoy furioso!");
        } else {
            System.out.println("Estoy cansado!");
        }
    }

    public State getSane() {
        return sane;
    }

    public State getFurious() {
        return furious;
    }

    public State getExhausted() {
        return exhausted;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isUpper() {
        return upper;
    }

    public abstract void setPiece(Piece piece);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
