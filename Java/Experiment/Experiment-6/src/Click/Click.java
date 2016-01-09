package Click;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nicholas on 16-1-8.
 * Class Click
 */
public class Click extends JFrame {

    private JButton jButton;

    public Click(){
        jButton = new JButton("Click Me");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getActionCommand().equals("Click Me")){
                    jButton.setText("Click Me Again");
                }else {
                    jButton.setText("Click Me");
                }
            }
        });

        add(jButton);
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        new Click();
    }
}
