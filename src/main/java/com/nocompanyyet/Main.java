package com.nocompanyyet;

import service.GameService;

public class Main {
    public static void main(String[] args) {
        Player first = new Bot("Paul");
        Player second = new Bot("Rob");
        GameService.createNewGame(first, second);
    }
}
