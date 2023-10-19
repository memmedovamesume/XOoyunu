package com.mesume.memmedova.xooyunu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mesume.memmedova.xooyunu.core.XOGame;

public class MainActivity extends AppCompatActivity {
    TextView box1, box2, box3, box4, box5, box6, box7, box8, box9, infoBox;
    XOGame game;
    Button restartGame;
    boolean gameOver = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new XOGame();
        infoBox = (TextView)findViewById(R.id.priority_textView);
        restartGame = (Button) findViewById(R.id.new_game);
        restartGame.setVisibility(View.INVISIBLE);
        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game = new XOGame();
                redrawBoard();
                gameOver = false;
                changePriority(game.getCurrentGamer().getSymbol());
                restartGame.setVisibility(View.INVISIBLE);
            }
        });
        box1 = (TextView) findViewById(R.id.box1);
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,1,1)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box2 =(TextView) findViewById(R.id.box2);
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,2,1)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box3 =(TextView) findViewById(R.id.box3);
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,3,1)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box4 =(TextView) findViewById(R.id.box4);
        box4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,1,2)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box5 =(TextView)  findViewById(R.id.box5);
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,2,2)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box6 =(TextView)  findViewById(R.id.box6);
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,3,2)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box7 =(TextView) findViewById(R.id.box7);
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,1,3)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box8 =(TextView) findViewById(R.id.box8);
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,2,3)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
        box9 =(TextView) findViewById(R.id.box9);
        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOver) return;
                String oldSymbol = game.getCurrentGamer().getSymbol();
                if( game.attack(oldSymbol,3,3)){
                    changePriority(game.getCurrentGamer().getSymbol());
                    redrawBoard();
                    if( game.isVine(oldSymbol)){
                        showViner(oldSymbol);
                    }
                }
            }
        });
    }
    void changePriority(String symbol){
        infoBox.setText(String.format("%s növbəsi", symbol));
    }
    void showViner(String symbol){
        infoBox.setText(String.format("%s qazandi", symbol));
        gameOver = true;
        restartGame.setVisibility(View.VISIBLE);
    }
    void redrawBoard(){
        box1.setText(game.getBoard()[0][0]);
        box2.setText(game.getBoard()[0][1]);
        box3.setText(game.getBoard()[0][2]);
        box4.setText(game.getBoard()[1][0]);
        box5.setText(game.getBoard()[1][1]);
        box6.setText(game.getBoard()[1][2]);
        box7.setText(game.getBoard()[2][0]);
        box8.setText(game.getBoard()[2][1]);
        box9.setText(game.getBoard()[2][2]);
        if(game.gameEnd()){
            infoBox.setText("Oyun bitdi");
            restartGame.setVisibility(View.VISIBLE);
        }
    }
}