package com.example.proxy.before;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }
}
