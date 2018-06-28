package com.utad.factory;

import com.utad.pieces.*;

public class FactoryNormal implements FactoryPiece {

    public Piece createWizard(boolean upper) {
        return new Wizard(new PieceBasic(upper));
    }

    public Piece createElf(boolean upper) {
        return new Elf(new PieceBasic(upper));
    }

    public Piece createTitan(boolean upper) {
        return new Titan(new PieceBasic(upper));
    }

    public Piece createFighter(boolean upper) {
        return new Fighter(new PieceBasic(upper));
    }

    public Piece createDragon(boolean upper) {
        return new Dragon(new PieceBasic(upper));
    }

}
