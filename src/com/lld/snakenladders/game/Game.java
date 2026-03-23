package com.lld.snakenladders.game;

import com.lld.snakenladders.model.Player;
import com.lld.snakenladders.service.Dice;
import com.lld.snakenladders.strategy.GameRule;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Dice dice;
    private int currentPlayerIndex;

    private GameRule rule;

    private boolean extraTurn;
    private boolean skipTurn;
    private int sixCount;

    public Game(Board board, List<Player> players, Dice dice, GameRule rule) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.rule = rule;
        this.currentPlayerIndex = 0;
    }

    public void makeMove() {
        Player player = players.get(currentPlayerIndex);

        System.out.println("----------------------");

        int roll = dice.roll();
        System.out.println(player.getName() + " rolled: " + roll);

        int currentPosition = player.getPosition();
        int newPosition = currentPosition + roll;

        int finalCell = board.getSize() * board.getSize();

        // ✅ Correct movement logic
        if (newPosition == finalCell) {
            player.setPosition(newPosition);
        } else if (newPosition < finalCell) {
            newPosition = board.getFinalPosition(newPosition);
            player.setPosition(newPosition);
        } else {
            System.out.println("Move exceeds board, staying at same position");
        }

        System.out.println(player.getName() + " is at position: " + player.getPosition());

        // Apply rule (easy/difficult)
        rule.applyRule(this, roll);

        // Handle skip turn
        if (skipTurn) {
            System.out.println(player.getName() + " lost turn!");
            skipTurn = false;
            nextPlayer();
            return;
        }

        // Handle extra turn
        if (!extraTurn) {
            nextPlayer();
        } else {
            System.out.println(player.getName() + " gets extra turn!");
            extraTurn = false;
        }

        if (player.getPosition() == board.getSize() * board.getSize()) {
            System.out.println("\n🏆 " + player.getName() + " WON THE GAME!");
            System.exit(0);  // 🔥 force stop
        }
    }

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    // 🔹 Winner check
    public boolean hasWinner() {
        int finalCell = board.getSize() * board.getSize();

        for (Player player : players) {
            if (player.getPosition() == finalCell) {
                System.out.println("\n🏆 " + player.getName() + " WON THE GAME!");
                return true;
            }
        }
        return false;
    }

    // 🔹 Rule helpers
    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    public void incrementSixCount() {
        sixCount++;
    }

    public void resetSixCount() {
        sixCount = 0;
    }

    public int getSixCount() {
        return sixCount;
    }
}