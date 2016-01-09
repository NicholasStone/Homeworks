package Mines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by nicholas on 16-1-6.
 * Class MFrame
 */
public class MFrame extends JFrame {

    private static MButton[][] mButtons;

    private static int RowNumber;

    private Container container;

    private int fieldMargin = 30;

    private static int MineNumber;

    public MFrame(int rows, int mine,int x,int y) {
        setLocation(x,y-30);
        MineNumber = mine;
        RowNumber = rows;
        mButtons = new MButton[RowNumber][RowNumber];
        MButton.setMines(MineNumber);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMineField();
        setMenu();
        setSize(570, 470);
        setResizable(false);
        setVisible(true);
    }


    public static int getRowNumber() {
        return RowNumber;
    }

    public static MButton[][] getmButtons() {
        return mButtons;
    }

    private void setMineField() {
        int sideLength = MButton.SIDE_LENGTH;
        int margin = MButton.MARGIN_LENGTH;
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);
        container.setBounds(0, 0, (sideLength + margin) * RowNumber + margin, (sideLength + margin) * RowNumber + margin);
        for (int i = 0; i < RowNumber; i++) {
            for (int j = 0; j < RowNumber; j++) {
                if (mButtons[i][j] == null) {
                    mButtons[i][j] = new MButton(i, j);
                }
                mButtons[i][j].setBounds(fieldMargin + i * (sideLength + margin), fieldMargin + j * (sideLength + margin), sideLength, sideLength);
                container.add(mButtons[i][j]);
            }
        }
    }

    private void Reset(){
        Point point = container.getLocationOnScreen();
        dispose();
        new MFrame(RowNumber,MineNumber,(int)point.getX(),(int)point.getY());
        MButton.ResetGame();
    }

    private void setMenu() {
        JButton reset = new JButton("重置");
        reset.setFont(new Font("STXihei", Font.BOLD, 20));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!actionEvent.getActionCommand().isEmpty()) {
                    Reset();
                }
            }
        });
        reset.setBackground(Color.white);
        reset.setBounds((MButton.SIDE_LENGTH + MButton.MARGIN_LENGTH) * RowNumber + 50, fieldMargin + 250, 120, 70);

        JLabel mineCounter = new JLabel(" 还剩余" + MButton.getMinesRemaining() + "个");
        mineCounter.setFont(new Font("STXihei", Font.BOLD, 20));
        mineCounter.setBackground(Color.white);
        mineCounter.setBounds((MButton.SIDE_LENGTH + MButton.MARGIN_LENGTH) * RowNumber + 50, fieldMargin + 50, 120, 70);
        mineCounter.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        MButton.setMineCounter(mineCounter);

        container.add(reset);
        container.add(mineCounter);
    }

    public static void main(String[] args) {
        new MFrame(10, 10, 80, 80);
    }
}
