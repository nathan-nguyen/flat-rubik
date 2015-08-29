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
public class Game {

    private Face mUpFace, mDownFace, mFrontFace, mBackFace, mLeftFace, mRightFace;

    public Game() {
        //Initialize faces
        mUpFace = new Face(Square.WHITE);
        mDownFace = new Face(Square.YELLOW);
        mFrontFace = new Face(Square.RED);
        mBackFace = new Face(Square.ORANGE);
        mLeftFace = new Face(Square.GREEN);
        mRightFace = new Face(Square.BLUE);
    }

    public Face getUpFace() {
        return mUpFace;
    }

    public void moveUpperRight() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(2, i);
            mUpFace.setSquare(2, i, mFrontFace.getSquare(2, i));
            mFrontFace.setSquare(2, i, mDownFace.getSquare(2, i));
            mDownFace.setSquare(2, i, mBackFace.getSquare(2, i));
            mBackFace.setSquare(2, i, mTempColumn[i]);
        }

        mRightFace.rotateRight();
    }

    public void moveUpperRightComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(2, i);
            mUpFace.setSquare(2, i, mBackFace.getSquare(2, i));
            mBackFace.setSquare(2, i, mDownFace.getSquare(2, i));
            mDownFace.setSquare(2, i, mFrontFace.getSquare(2, i));
            mFrontFace.setSquare(2, i, mTempColumn[i]);
        }

        mRightFace.rotateLeft();
    }

    public void moveUpperLeft() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(0, i);
            mUpFace.setSquare(0, i, mBackFace.getSquare(0, i));
            mBackFace.setSquare(0, i, mDownFace.getSquare(0, i));
            mDownFace.setSquare(0, i, mFrontFace.getSquare(0, i));
            mFrontFace.setSquare(0, i, mTempColumn[i]);
        }

        mLeftFace.rotateRight();
    }

    public void moveUpperLeftComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(0, i);
            mUpFace.setSquare(0, i, mFrontFace.getSquare(0, i));
            mFrontFace.setSquare(0, i, mDownFace.getSquare(0, i));
            mDownFace.setSquare(0, i, mBackFace.getSquare(0, i));
            mBackFace.setSquare(0, i, mTempColumn[i]);
        }

        mLeftFace.rotateLeft();
    }

    public void moveMiddleRight() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(1, i);
            mUpFace.setSquare(1, i, mFrontFace.getSquare(1, i));
            mFrontFace.setSquare(1, i, mDownFace.getSquare(1, i));
            mDownFace.setSquare(1, i, mBackFace.getSquare(1, i));
            mBackFace.setSquare(1, i, mTempColumn[i]);
        }
    }

    public void moveMiddleRightComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(1, i);
            mUpFace.setSquare(1, i, mBackFace.getSquare(1, i));
            mBackFace.setSquare(1, i, mDownFace.getSquare(1, i));
            mDownFace.setSquare(1, i, mFrontFace.getSquare(1, i));
            mFrontFace.setSquare(1, i, mTempColumn[i]);
        }
    }

    public void moveUpperFront() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 2);
            mUpFace.setSquare(i, 2, mLeftFace.getSquare(i, 2));
            mLeftFace.setSquare(i, 2, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 2));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 2, mRightFace.getSquare(i, 2));
            mRightFace.setSquare(i, 2, mTempColumn[i]);
        }

        mFrontFace.rotateRight();
    }
    
    public void moveUpperFrontComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 2);
            mUpFace.setSquare(i, 2, mRightFace.getSquare(i, 2));
            mRightFace.setSquare(i, 2, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 2));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 2, mLeftFace.getSquare(i, 2));
            mLeftFace.setSquare(i, 2, mTempColumn[i]);
        }

        mFrontFace.rotateLeft();
    }
    
    public void moveUpperBack() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 0);
            mUpFace.setSquare(i, 0, mRightFace.getSquare(i, 0));
            mRightFace.setSquare(i, 0, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 0));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 0, mLeftFace.getSquare(i, 0));
            mLeftFace.setSquare(i, 0, mTempColumn[i]);
        }

        mBackFace.rotateRight();
    }
    
    public void moveUpperBackComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 0);
            mUpFace.setSquare(i, 0, mLeftFace.getSquare(i, 0));
            mLeftFace.setSquare(i, 0, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 0));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 0, mRightFace.getSquare(i, 0));
            mRightFace.setSquare(i, 0, mTempColumn[i]);
        }

        mBackFace.rotateLeft();
    }
    
    public void moveMiddleFront() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 1);
            mUpFace.setSquare(i, 1, mLeftFace.getSquare(i, 1));
            mLeftFace.setSquare(i, 1, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 1));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 1, mRightFace.getSquare(i, 1));
            mRightFace.setSquare(i, 1, mTempColumn[i]);
        }
    }
    
    public void moveMiddleFrontComma() {
        Square[] mTempColumn = new Square[3];

        for (int i = 0; i < Face.FACE_SIZE; i++) {
            mTempColumn[i] = mUpFace.getSquare(i, 1);
            mUpFace.setSquare(i, 1, mRightFace.getSquare(i, 1));
            mRightFace.setSquare(i, 1, mDownFace.getSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 1));
            mDownFace.setSquare(Face.FACE_SIZE - 1 - i, Face.FACE_SIZE - 1 - 1, mLeftFace.getSquare(i, 1));
            mLeftFace.setSquare(i, 1, mTempColumn[i]);
        }
    }
}
