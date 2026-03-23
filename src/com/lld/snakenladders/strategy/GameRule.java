package com.lld.snakenladders.strategy;

import com.lld.snakenladders.game.Game;

public interface GameRule {
    void applyRule(Game game, int roll);
}