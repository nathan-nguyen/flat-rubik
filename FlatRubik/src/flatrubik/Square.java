/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatrubik;

/**
 *
 * @author nam4_000
 */
public class Square {

    //Color Index Constants
    public static final int WHITE = 0;
    public static final int RED = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int BLUE = 4;
    public static final int ORANGE = 5;

    public static final String color[] = {"-fx-base: #ffffff;", "-fx-base: #ff0000;", "-fx-base: #ffff00;", "-fx-base: #008000;", "-fx-base: #0000ff;", "-fx-base: #ffa500;"};

    private int colorIndex = 0;
    public int debugNumber = -1;

    public Square(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public int getColorIndex() {
        return colorIndex;
    }
}
