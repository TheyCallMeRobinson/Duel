package com.nocompanyyet;

import service.GameService;

public class Main {
    public static void main(String[] args) {
        Player first = new Human();
        Player second = new Bot();
        GameService.createNewGame(first, second);
    }
}
