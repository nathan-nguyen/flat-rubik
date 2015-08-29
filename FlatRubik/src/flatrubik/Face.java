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
public class Face {

    public static int FACE_SIZE = 3;

    private Square[][] squares = new Square[FACE_SIZE][FACE_SIZE];

    public Face(int colorIndex) {
        for (int i = 0; i < FACE_SIZE; i++) {
            for (int j = 0; j < FACE_SIZE; j++) {
                squares[i][j] = new Square(colorIndex);
                //Debug
                squares[i][j].debugNumber = i + j * FACE_SIZE;
            }
        }
    }

    public Square getSquare(int locationX, int locationY) {
        return squares[locationX][locationY];
    }

    public void setSquare(int locationX, int locationY, Square square) {
        squares[locationX][locationY] = square;
    }
    
    public void rotateRight(){
        Square mTempSquare;
        mTempSquare = squares[0][0];
        squares[0][0] = squares[0][2];
        squares[0][2] = squares[2][2];
        squares[2][2] = squares[2][0];
        squares[2][0] = mTempSquare;
        
        mTempSquare = squares[1][0];
        squares[1][0] = squares[0][1];
        squares[0][1] = squares[1][2];
        squares[1][2] = squares[2][1];
        squares[2][1] = mTempSquare;
    }
    
    public void rotateLeft(){
        Square mTempSquare;
        mTempSquare = squares[0][0];
        squares[0][0] = squares[2][0];
        squares[02][0] = squares[2][2];
        squares[2][2] = squares[0][2];
        squares[0][2] = mTempSquare;
        
        mTempSquare = squares[1][0];
        squares[1][0] = squares[2][1];
        squares[2][1] = squares[1][2];
        squares[1][2] = squares[0][1];
        squares[0][1] = mTempSquare;
    }
        
}
