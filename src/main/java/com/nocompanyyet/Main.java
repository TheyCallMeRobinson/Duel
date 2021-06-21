package com.nocompanyyet;

import service.GameService;

public class Main {
    public static void main(String[] args) {
        Player first = new BotHard("Paul");
        Player second = new BotEasy("Robin");
        GameService.createNewGame(first, second);
    }
}
