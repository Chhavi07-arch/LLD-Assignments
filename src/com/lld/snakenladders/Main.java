package com.lld.snakenladders;

import com.lld.snakenladders.game.Board;
import com.lld.snakenladders.game.Game;
import com.lld.snakenladders.model.Player;
import com.lld.snakenladders.service.Dice;
import com.lld.snakenladders.strategy.EasyRule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(10);
        board.initializeBoard(5, 5);

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "P1"));
        players.add(new Player(2, "P2"));

        Dice dice = new Dice();

        Game game = new Game(board, players, dice, new EasyRule());

        while (true) {
            game.makeMove();
        }
    }
}