package com.lld.snakenladders.strategy;

import com.lld.snakenladders.game.Game;

public class DifficultRule implements GameRule {

    @Override
    public void applyRule(Game game, int roll) {
        if (roll == 6) {
            game.incrementSixCount();
        } else {
            game.resetSixCount();
        }

        if (game.getSixCount() == 3) {
            game.setSkipTurn(true);
            game.resetSixCount();
        }
    }
}