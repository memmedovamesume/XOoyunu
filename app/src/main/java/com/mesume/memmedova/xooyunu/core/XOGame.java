package com.mesume.memmedova.xooyunu.core;

import java.util.Objects;


 enum Order{
    ORDER_X,
    ORDER_O;
}

public class XOGame {

    Order order = Order.ORDER_X;
Order or;
    Gamer x = new Gamer("X");
    Gamer o = new Gamer("O");

    private String[][] board = {{" ", " ", " "},
                                {" ", " ", " "},
                                {" ", " ", " "}};
    public String[][] getBoard(){
        return  this.board;
    }
    public Gamer getCurrentGamer(){
        if (this.order == Order.ORDER_O){
            return this.o;
        }
        return this.x;
    }
    public boolean attack(String symbol, int x, int y){
        if ((symbol == this.x.getSymbol() && order==Order.ORDER_X)||(symbol==this.o.getSymbol() && order == Order.ORDER_O)) {
            if (!Objects.equals(this.board[y - 1][x - 1], " "))
                return false;
            this.board[y - 1][x - 1] = symbol;
            if(order == Order.ORDER_X){
                order = Order.ORDER_O;
            }
            else{
                order = Order.ORDER_X;
            }
            return true;
        }
        return  false;
    }

    public boolean isVine(String symbol){
        for(int i = 0; i < 3; i++){
            if(board[i][0] == symbol && board[i][1]==symbol&&board[i][2]==symbol){
                return  true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[0][i] == symbol && board[1][i]==symbol&&board[2][i]==symbol){
                return  true;
            }
        }
        if(board[0][0] == symbol && board[1][1]==symbol&&board[2][2]==symbol){
            return  true;
        }
        if(board[0][2] == symbol && board[1][1]==symbol&&board[2][0]==symbol){
            return  true;
        }
        return false;

    }
    public boolean gameEnd(){
        int filled = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.board[i][j] != " "){
                    filled ++;
                }
            }
        }
        return filled == 9;
    }
}
