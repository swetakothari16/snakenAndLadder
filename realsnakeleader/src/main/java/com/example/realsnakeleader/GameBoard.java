package com.example.realsnakeleader;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    static int tilesize = 40;
    static int height = 10;
    static int width = 10;

    static ArrayList<Pair<Integer,Integer>>positionCoordinates;

    static ArrayList<Integer>snakeLadderPosition;
    public GameBoard()
    {
        populatePositionCoordinates();
        setPositionCoordinates();
    }
    public int getXValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getKey();
    }
    public int getYValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getValue();
    }

    public int playPostionAtSnakeOrLedder(int piecePosition) {
        if (piecePosition != snakeLadderPosition.get(piecePosition)) {
            return snakeLadderPosition.get(piecePosition);
        }
        return -1;
    }
    //private static void populatePositionCoordinates(){...}

    private void setPositionCoordinates(){
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
           snakeLadderPosition.add(i);
        }

        snakeLadderPosition.set(2,23);
        snakeLadderPosition.set(6,45);
        snakeLadderPosition.set(20,59);
        snakeLadderPosition.set(43,17);
        snakeLadderPosition.set(50,5);
        snakeLadderPosition.set(52,72);
        snakeLadderPosition.set(56,8);
        snakeLadderPosition.set(57,96);
        snakeLadderPosition.set(71,92);
        snakeLadderPosition.set(73,15);
        snakeLadderPosition.set(84,63);
        snakeLadderPosition.set(87,49);
        snakeLadderPosition.set(98,40);


        }

    private static void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(20,380));
        // 20,380
        int xTilePos, yTilePos;
        for(int i= height-1;i>=0;i--){
            for(int j = width-1;j>=0;j--){
                if(i%2 != 0)
                {
                    xTilePos = tilesize*width - (tilesize/2 + j*tilesize);
                }
                else {
                    xTilePos = tilesize/2 + j*tilesize;
                }

                yTilePos = tilesize/2 + i*tilesize;
                positionCoordinates.add(new Pair<Integer,Integer>(xTilePos,yTilePos));
            }
        }
        for (int i=0;i< positionCoordinates.size();i++)
        {
            System.out.println(i + "x: " + positionCoordinates.get(i).getKey() + "y:" + positionCoordinates.get(i).getValue());


        }
    }

    public static void main(String[] args) {
        populatePositionCoordinates();
    }
}

