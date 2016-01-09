package MouseAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nicholas on 16-1-8.
 * Class MouseAction
 */
public class MouseAction extends JFrame {

    private JLabel jLabel;

    private Calendar calendar;

    public MouseAction() {
        setLayout(new BorderLayout());
        setBounds(300, 300, 200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());


        jLabel = new JLabel(getTime());
        JButton jButton = new JButton("Click");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!actionEvent.getActionCommand().isEmpty()) {
                    calendar.setTime(new Date());
                    jLabel.setText(getTime());
                }
            }
        });

        add(jLabel, BorderLayout.CENTER);
        add(jButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String getTime() {
        return calendar.get(Calendar.YEAR) + "/" +
                (calendar.get(Calendar.MONTH) + 1) + "/" +
                calendar.get(Calendar.DATE) + "  " +
                calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND) + " " +
                calendar.get(Calendar.MILLISECOND);
    }

    public static void main(String args[]) {
        new MouseAction();
    }
}
