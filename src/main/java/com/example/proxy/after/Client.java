package com.example.proxy.after;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.GameStart();
    }
}
