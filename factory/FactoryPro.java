package com.utad.factory;

import com.utad.pieces.*;

public class FactoryPro implements FactoryPiece {

    public Piece createWizard(boolean upper) {
        return new Pro(new Wizard(new PieceBasic(upper)));
    }

    public Piece createElf(boolean upper) {
        return new Pro(new Elf(new PieceBasic(upper)));
    }

    public Piece createTitan(boolean upper) {
        return new Pro(new Titan(new PieceBasic(upper)));
    }

    public Piece createFighter(boolean upper) {
        return new Pro(new Fighter(new PieceBasic(upper)));
    }

    public Piece createDragon(boolean upper) {
        return new Pro(new Dragon(new PieceBasic(upper)));
    }


}
