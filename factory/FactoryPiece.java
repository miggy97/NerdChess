package com.utad.factory;

import com.utad.pieces.Piece;

public interface FactoryPiece {

    //The boolean 'upper' indicates the team: true/flase == Upper/Lower

    public Piece createWizard(boolean upper);

    public Piece createElf(boolean upper);

    public Piece createTitan(boolean upper);

    public Piece createFighter(boolean upper);

    public Piece createDragon(boolean upper);
}
