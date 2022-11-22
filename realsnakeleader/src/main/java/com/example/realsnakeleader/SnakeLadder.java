package com.example.realsnakeleader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public final int tileSize=40;
    int height=10;
    int width=10;

    int diceValue;

    int yLine = 410;
    Group tileGroup = new Group();

    Player playerOne, playerTwo;

    Label randResult;

    boolean gameStart = true, turnOnePlayer = true, turnTwoPlayer = false;

    public Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+80);
        root.getChildren().addAll(tileGroup);


        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                Tile tile=new Tile(tileSize,tileSize);
                tile.setTranslateX(i*tileSize);
                tile.setTranslateY(j*tileSize);
                tileGroup.getChildren().addAll(tile);

            }
        }

       // playerOne = new Player(tileSize, Color.BLACK);
        //playerTwo = new Player(tileSize-10,Color.WHITE);


        // add lable

        randResult = new Label("Start the Game");
        randResult.setTranslateX(150);
        randResult.setTranslateY(yLine);


       //add 3 button
        Button playerOneButton = new Button("Player one");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(yLine);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               if(gameStart == true){
                   if(turnOnePlayer == true){
                       getDiceValue();
                       playerOne.movePlayer(diceValue);
                      playerOne.playerAtSnakeOrLadder();
                       turnOnePlayer = false;
                       turnTwoPlayer = true;
                   }
               }

            }
        });

        Button gamebutton = new Button("Game Button");
        gamebutton.setTranslateX(160);
        gamebutton.setTranslateY(430);

        Button playertwoButton = new Button("Player Two");
        playertwoButton.setTranslateX(300);
        playertwoButton.setTranslateY(yLine);
        playertwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart == true){
                    if(turnTwoPlayer == true){
                        getDiceValue();
                        playerTwo.movePlayer(diceValue);
                        playerTwo.playerAtSnakeOrLadder();
                        turnOnePlayer = true;
                        turnTwoPlayer = false;
                    }
                }
            }
        });


        playerOne = new Player(tileSize, Color.BLACK);
        playerTwo = new Player(tileSize-10,Color.WHITE);




        Image img=new Image("C:\\Users\\Sweta\\IdeaProjects\\realsnakeleader\\src\\SNACK.jpg");
        ImageView boardImage=new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tileSize*width);
        boardImage.setFitHeight(tileSize*height);
        tileGroup.getChildren().addAll(boardImage,
                playerOneButton,
                gamebutton,
                playertwoButton,
                randResult,
                playerOne.getGamePiece(),
                playerTwo.getGamePiece()
                );
        return root;
    }

    private void getDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        randResult.setText(Integer.toString(diceValue));


    }

    public Pane createContent2() {
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, height * tileSize + 80);
        root.getChildren().addAll(tileGroup);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException{
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }
     public static void main(String[] args) {
        launch();
    }
}

