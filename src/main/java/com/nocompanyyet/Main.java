package com.nocompanyyet;

import player.ai.BotHard;
import player.ai.BotMedium;
import player.Player;
import service.GameService;

public class Main {
    public static void main(String[] args) {
        Player first = new BotHard("Paul");
        Player second = new BotMedium("Robin");
        GameService.createNewGame(first, second);
    }
}
