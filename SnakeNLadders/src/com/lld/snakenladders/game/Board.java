package com.lld.snakenladders.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void initializeBoard(int numberOfSnakes, int numberOfLadders) {
        Random random = new Random();
        int max = size * size;

        // Add snakes
        while (snakes.size() < numberOfSnakes) {
            int head = random.nextInt(max - 1) + 1;
            int tail = random.nextInt(head);

            if (head > tail && head != max) {
                snakes.put(head, tail);
            }
        }

        // Add ladders
        while (ladders.size() < numberOfLadders) {
            int start = random.nextInt(max - 1) + 1;
            int end = random.nextInt(max - start) + start + 1;

            if (end <= max && start != max && !snakes.containsKey(start)) {
                ladders.put(start, end);
            }
        }
    }

    public int getFinalPosition(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }

    public int getSize() {
        return size;
    }
}