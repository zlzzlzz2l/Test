package com.example.proxy.after;

public class GameServiceProxy implements GameService {

    private GameService gameService;

    public GameServiceProxy(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void GameStart() {
        long before = System.currentTimeMillis();
        gameService.GameStart();
        System.out.println(System.currentTimeMillis() - before);
    }
}
