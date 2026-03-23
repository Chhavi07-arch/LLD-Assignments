package com.lld.snakenladders.strategy;

import com.lld.snakenladders.game.Game;

public class EasyRule implements GameRule {

    @Override
    public void applyRule(Game game, int roll) {
        if (roll == 6) {
            game.setExtraTurn(true);
        }
    }
}