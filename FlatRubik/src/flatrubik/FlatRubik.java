/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatrubik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nam4_000
 */
public class FlatRubik extends Application {

    //TODO:
    public static final int UI_SIZE = 5;
    public static final int SQUARE_SIZE = 100;
    private Button[][] face = new Button[UI_SIZE][UI_SIZE];
    private Game mGame;

    @Override
    public void start(Stage primaryStage) {
        VBox mainVBox = new VBox();
        HBox gameUIHBox = new HBox();
        
        GridPane grid = new GridPane();
        gameUIHBox.getChildren().add(grid);
        
        
        MenuBar menuBar = new MenuBar();
        menuBar.setPadding(new Insets(0, 10, 0, 0));
        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("Alt+F4"));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().addAll(newGame, exit);
                
        // --- Menu View
        Menu menuView = new Menu("View");
        CheckMenuItem roundColorCheckMenuItem = new CheckMenuItem("Round Color");
        roundColorCheckMenuItem.setSelected(false);
        CheckMenuItem pictureBackgroundCheckMenuItem = new CheckMenuItem("Picture Background");
        pictureBackgroundCheckMenuItem.setSelected(false);
        CheckMenuItem model3DCheckMenuItem = new CheckMenuItem("3D Model");
        model3DCheckMenuItem.setSelected(false);
        menuView.getItems().addAll(roundColorCheckMenuItem, pictureBackgroundCheckMenuItem, model3DCheckMenuItem);
        
        // --- Menu Help
        Menu menuHelp = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About");
        menuHelp.getItems().add(aboutGame);
        menuBar.getMenus().addAll(menuFile, menuView, menuHelp);

        mainVBox.getChildren().addAll(menuBar, gameUIHBox);

        Scene scene = new Scene(mainVBox, SQUARE_SIZE * (UI_SIZE + 2), SQUARE_SIZE * UI_SIZE);
        primaryStage.getIcons().add(new Image("file:icon.png"));
        //primaryStage.setResizable(false);
        primaryStage.setTitle("Flat Rubik");        
        primaryStage.setScene(scene);
        primaryStage.show();

        VBox controlBoard = new VBox(); 
        gameUIHBox.getChildren().add(controlBoard);
        controlBoard.setPadding(new Insets(50,5,10,5));
        controlBoard.setSpacing(20);
        Button startButton = new Button("Start");
        startButton.setFont(Font.font("Amble CN", FontWeight.BOLD, 20));
        startButton.setPrefSize(200, 100);
        
        Button currentTime = new Button("Current Time  00 : 00");
        currentTime.setFont(Font.font("Amble CN", FontWeight.BOLD, 17.2));
        currentTime.setDisable(true);
        Button moveNumberLabel = new Button("Moves Number     00");
        moveNumberLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 17.2));
        moveNumberLabel.setDisable(true);
        controlBoard.getChildren().addAll(startButton, currentTime, moveNumberLabel);
        
        
        /*  Start Game UI    */
        mGame = new Game();
        mGame.suffle();

        for (int i = 0; i < UI_SIZE; i++) {
            for (int j = 0; j < UI_SIZE; j++) {
                face[i][j] = new Button();
                grid.add(face[i][j], i, j);
                face[i][j].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
            }
        }

        updateUI();
        setupGameUI();

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

    public void setupGameUI() {
        face[0][UI_SIZE - 1].setDisable(true);
        face[UI_SIZE - 1][UI_SIZE - 1].setDisable(true);
        face[UI_SIZE - 1][0].setDisable(true);
        face[0][0].setDisable(true);

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
