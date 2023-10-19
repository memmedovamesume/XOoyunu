package com.mesume.memmedova.xooyunu.core;

public class Gamer {
    private String symbol;
    public Gamer(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return this.symbol;
    }
    public boolean attack(XOGame game, byte x, byte y){
        return  game.attack(this.symbol, x, y);
    }
}
