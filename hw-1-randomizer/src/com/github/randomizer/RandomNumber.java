package com.github.randomizer;

import java.util.Random;

public class RandomNumber {
    static int getRandomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }
}
