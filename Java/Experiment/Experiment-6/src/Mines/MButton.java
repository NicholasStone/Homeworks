package Mines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by nicholas on 16-1-6.
 * Default mine field button
 */
public class MButton extends JButton {
    //3 different States;
    public static final int EMPTY = 0;
    public static final int FLAGGED = 1;
    public static final int DOUBTED = 2;
    //layout settings.length of side & margin
    public static final int SIDE_LENGTH = 35;
    public static final int MARGIN_LENGTH = 3;
    //total number of mines
    private static int TOTAL_MINES_NUM;
    //How many mines remaining
    private static int MINES_REMAINING;
    //mines
    private static MButton[] mines;
    //is game over
    private static boolean GameOver = false;
    //mine counter
    private static JLabel mineCounter;
    private static int BtnRemain;
    //is this button a mine?
    private boolean isMine;
    //state of this button
    private int flag;
    //Details
    private int detail;
    private boolean isShowed;
    //coordinates
    private int locationX;
    private int locationY;

    public MButton(int x, int y) {
        locationX = x;
        locationY = y;
    }

    {
        BtnRemain = MFrame.getRowNumber() * MFrame.getRowNumber();
        detail = 0;
        setBackground(Color.lightGray);
        flag = MButton.EMPTY;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (!GameOver) {
                    if (mouseEvent.getButton() == 1) {
                        if (!isMine) {
                            showDetail();
                        } else {
                            GameOver();
                        }
                    } else {
                        changeFlag();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    public static void ResetGame() {
        GameOver = false;
    }

    public static void reduceTotalBtnRemain() {
        BtnRemain--;
        if (BtnRemain == TOTAL_MINES_NUM) {
            Win();
        }
    }

    public static void Win() {
        GameOver = true;
        for (MButton m : mines) {
            m.setFlag();
        }
        GameOver();
        JOptionPane.showMessageDialog(null, "你获胜了，干的漂亮！");
    }

    public static void setMineCounter(JLabel mineCounter) {
        MButton.mineCounter = mineCounter;
    }

    public static void setMines(MButton[] mines) {
        MButton.mines = mines;
    }

    public static void setMines(int n) {
        MButton[][] mButtons = MFrame.getmButtons();
        mines = new MButton[n];
        for (int i = 0; i < n;) {
            int x = (int) (Math.random() * (MFrame.getRowNumber()));
            int y = (int) (Math.random() * (MFrame.getRowNumber()));

            if (mButtons[x][y] != null) {
                continue;
            }
            mButtons[x][y] = new MButton(x, y);
            mines[i] = mButtons[x][y];
            mines[i].isMine = true;
            i++;

            for (int j = -1; j <= 1; j++) {//x
                if (j + x < mButtons.length && j + x >= 0) {
                    for (int k = -1; k <= 1; k++) {//y
                        if (k + y < mButtons.length && k + y >= 0) {
                            try {
                                mButtons[x + j][y + k].setDetail();
                            } catch (NullPointerException e) {
                                mButtons[x + j][y + k] = new MButton(x + j, y + k).setDetail();
                            }
                        }
                    }
                }
            }
        }
        setTotalMinesNum(n);
        setMines(mines);
    }

    public static void setTotalMinesNum(int totalMinesNum) {
        TOTAL_MINES_NUM = totalMinesNum;
        MINES_REMAINING = totalMinesNum;
    }

    public static int getMinesRemaining() {
        return MINES_REMAINING;
    }

    private static void GameOver() {
        GameOver = true;
        for (MButton m : mines) {
            m.explode();
        }
    }

    /**
     * Reduce the remaining number of mines
     * If true then successfully reduce the remaining number of mines
     * If false then number of mines has already been reduced into 0 and no mines can be set flag.
     * If so,set doubt in that button
     *
     * @return boolean
     */
    public static boolean reduceMinesRemaining() {
        if (MINES_REMAINING > 0) {
            MINES_REMAINING--;
            mineCounter.setText(" 还剩余" + MButton.getMinesRemaining() + "个");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase the number of mines remaining
     *
     * @return boolean
     */
    public static boolean increaseMinesRemaining() {
        if (MINES_REMAINING < TOTAL_MINES_NUM) {
            MINES_REMAINING++;
            mineCounter.setText(" 还剩余" + MButton.getMinesRemaining() + "个");
            return true;
        } else {
            return false;
        }
    }

    private void explode() {
        if (flag == MButton.FLAGGED) {
            setBackground(Color.green);
        } else {
            setBackground(Color.red);
        }
    }

    private void setFlag() {
        if (reduceMinesRemaining()) {
            flag = MButton.FLAGGED;
            changeStyle(MButton.FLAGGED);
        } else {
            setDoubt();
        }
    }

    private void setDoubt() {
        if (flag == MButton.FLAGGED) {
            increaseMinesRemaining();
        }
        flag = MButton.DOUBTED;
        changeStyle(MButton.DOUBTED);
    }

    private void setEmpty() {
        flag = MButton.EMPTY;
        changeStyle(MButton.EMPTY);
    }

    private void changeStyle(int flag) {
        switch (flag) {
            case MButton.EMPTY:
                setBackground(Color.lightGray);
                setText("");
                break;
            case MButton.FLAGGED:
                setBackground(Color.blue);
                break;
            case MButton.DOUBTED:
                setBackground(Color.white);
                setMargin(new Insets(0, 0, 0, 0));
                setText("?");
                break;
        }
    }

    private void changeFlag() {
        switch (flag) {
            case MButton.EMPTY:
                setFlag();
                break;
            case MButton.FLAGGED:
                setDoubt();
                break;
            case MButton.DOUBTED:
                setEmpty();
                break;
        }
    }

    private void showDetail() {
        isShowed = true;
        setMargin(new Insets(0, 0, 0, 0));
        setBackground(Color.white);
        setEnabled(false);

        if (detail != 0) {
            setText(Integer.toString(detail));
        } else {
            for (int offsetX = -1; offsetX <= 1; offsetX++) {//x
                if (offsetX + locationX < MFrame.getRowNumber() && offsetX + locationX >= 0) {
                    for (int offsetY = -1; offsetY <= 1; offsetY++) {//y
                        if (offsetY + locationY < MFrame.getRowNumber() && offsetY + locationY >= 0) {
                            MButton mButton = MFrame.getmButtons()[offsetX + locationX][offsetY + locationY];
                            if (!mButton.isShowed) {
                                mButton.showDetail();
                            }
                        }//if
                    }//for
                }//if
            }//for
        }//else
        reduceTotalBtnRemain();
    }//showDetail

    public final MButton setDetail() {
        detail++;
        return this;
    }
}
