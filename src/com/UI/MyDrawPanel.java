package com.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyDrawPanel extends JPanel {
    public static final int OFFSET = 0;
    public static final int SPACE = 50;

    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;

    int x = 0;
    int y = 0;

    private ArrayList allPieces = new ArrayList();

    private String level =
            "#####&&&#####\n"
                    + "#$$##&#&##$$#\n"
                    + "#$$##&#&##$$#\n"
                    + "#####&#&#####\n"
                    + "#####&#&#####\n"
                    + "&&&&&&#&&&&&&\n"
                    + "&###########&\n"
                    + "&&&&&&#&&&&&&\n"
                    + "#####&#&#####\n"
                    + "#####&#&#####\n"
                    + "#$$##&#&##$$#\n"
                    + "#$$##&#&##$$#\n"
                    + "#####&&&#####\n";

    public MyDrawPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initWorld();
    }

    public final void initWorld() {

        int x = OFFSET;
        int y = OFFSET;

        BoardPiece boardPiece;
        MovePiece movePiece;
        BasePiece basePiece;

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += SPACE;
                x = OFFSET;
            } else if (item == '#') {
                boardPiece = new BoardPiece(x, y);
                allPieces.add(boardPiece);
                x += SPACE;
            } else if (item == '&') {
                movePiece = new MovePiece(x, y);
                allPieces.add(movePiece);
                x += SPACE;
            } else if (item == '$') {
                basePiece = new BasePiece(x, y);
                allPieces.add(basePiece);
                x += SPACE;
            }

        }
    }

    public void buildWorld(Graphics g) {

        for (int i = 0; i < allPieces.size(); i++) {

            Pieces item = (Pieces) allPieces.get(i);

            g.drawImage(item.getImage(), item.x(), item.y(), this);

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    public void move(int diceNumber) {
        while (diceNumber != 0) {
            x += 100;
            if (x >= WIDTH) {
                y += 100;
                x = 0;
            }
            diceNumber--;
        }
    }

    public void restart() {
        x = 0;
        y = 0;
    }
}