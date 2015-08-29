/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatrubik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author nam4_000
 */
public class FlatRubik extends Application {

    //TODO:
    public static final int UI_SIZE = 5;
    public static final int SQUARE_SIZE = 100;
    Button[][] face = new Button[UI_SIZE][UI_SIZE];
    Game mGame;

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();

        mGame = new Game();

        for (int i = 0; i < UI_SIZE; i++) {
            for (int j = 0; j < UI_SIZE; j++) {
                face[i][j] = new Button();
                grid.add(face[i][j], i, j);
                face[i][j].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        face[0][UI_SIZE - 1].setDisable(true);
        face[UI_SIZE - 1][UI_SIZE - 1].setDisable(true);
        face[UI_SIZE - 1][0].setDisable(true);
        face[0][0].setDisable(true);

        updateUI();

        setupUI();

        Scene scene = new Scene(grid, SQUARE_SIZE * UI_SIZE, SQUARE_SIZE * UI_SIZE);

        primaryStage.setTitle("Flat Rubik");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void updateUI() {
        for (int i = 1; i < UI_SIZE - 1; i++) {
            for (int j = 1; j < UI_SIZE - 1; j++) {
                //Debug
                //face[i][j].setText(mGame.getUpFace().getSquare(i - 1, j - 1).debugNumber + "");
                face[i][j].setStyle("-fx-font: 22 arial; " + Square.color[mGame.getUpFace().getSquare(i - 1, j - 1).getColorIndex()]);
            }
        }
    }
    
    public void setupUI(){
        face[1][0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperLeftComma();
                updateUI();
            }
        });
        
        face[1][4].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperLeft();
                updateUI();
            }
        });
        
        face[2][0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveMiddleRight();
                updateUI();
            }
        });
        
        face[2][4].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveMiddleRightComma();
                updateUI();
            }
        });                
              
        face[3][0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperRight();
                updateUI();
            }
        });
        
        face[3][4].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperRightComma();
                updateUI();
            }
        });
        
        face[0][1].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperBack();
                updateUI();
            }
        });
                
        face[4][1].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperBackComma();
                updateUI();
            }
        });
        
        face[0][2].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveMiddleFrontComma();
                updateUI();
            }
        });
        
        face[4][2].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveMiddleFront();
                updateUI();
            }
        });                
              
        face[0][3].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperFrontComma();
                updateUI();
            }
        });
        
        face[4][3].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mGame.moveUpperFront();
                updateUI();
            }
        });
        
    }
}
