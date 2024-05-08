package com.design.pattern.structural.flyweight.piece;

/**
 * 享元(FlyWeight)模式主要用于减少创建对象的数量，以降低内存占用，提高性能。
 * 先要开发一个网络围棋程序，允许多个玩家联机下棋。由于只有一台服务器，为节省内存空间，采用向元模式实现该程序。
 */

import java.util.ArrayList;

/**
 *  棋子颜色
 */
enum PieceColor {
    BLACK, WHITE
}

/**
 * 棋子位置
 */
class PiecePos {
    private int x;
    private int y;
    public PiecePos(int a, int b) {
        x = a;
        y = b;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
/**
 * 棋子定义
 */
abstract class Piece {
    // 颜色
    protected PieceColor mColor;
    // 位置
    protected PiecePos mPos;
    public Piece(PieceColor color, PiecePos pos) {
        mColor = color;
        mPos = pos;
    }
    public abstract void draw();
}

class BlackPiece extends Piece {
    public BlackPiece(PieceColor color, PiecePos pos) {
        super(color, pos);
    }
    @Override
    public void draw() {
        System.out.println("draw a blackpiece");
    }
}

class WhitePiece extends Piece {
    public WhitePiece(PieceColor color, PiecePos pos) {
            super(color, pos);
    }
    @Override
    public void draw() {
        System.out.println("draw a whitepiece");
    }
}

// 棋盘上已有的棋子
class PieceBoard {
    private static final ArrayList<Piece> mArrayPiece = new ArrayList<>();
    // 黑方名称
    private String mBlackName;
    // 白方名称
    private String mWhiteName;
    public PieceBoard(String black, String white) {
        mBlackName = black;
        mWhiteName = white;
    }

    // 一步棋，在棋盘上放一颗棋子
    public void setPiece(PieceColor color, PiecePos pos) {
        Piece piece = null;
        // 放黑子
        if (color == PieceColor.BLACK) {
            // 获取一颗黑子
            piece = new BlackPiece(color, pos);
            System.out.println(mBlackName + "在位置(" + pos.getX() + "," + pos.getY() + ")");
            piece.draw();
        } else {
            // 放白子
            // 获取一颗白子
            piece = new WhitePiece(color, pos);
            System.out.println(mWhiteName + "在位置(" + pos.getX() + "," + pos.getY() + ")");
            piece.draw();
        }
        mArrayPiece.add(piece);
    }
}

public class PieceBoardFlyWeightDemo {
    public static void main(String[] args) {
        PieceBoard board = new PieceBoard("黑棋", "白棋");
        board.setPiece(PieceColor.BLACK, new PiecePos(1,2));
        board.setPiece(PieceColor.WHITE, new PiecePos(2,3));

    }

}