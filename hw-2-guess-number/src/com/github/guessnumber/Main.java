package com.github.guessnumber;

public class Main {

    public static void main(String[] args) {

        StartParametrs startParametrs = new StartParametrs();

        StartGame.game(StartParametrs.getMinConstr(), StartParametrs.getMaxConstr(), StartParametrs.getAttemptConstr());

    }
}
