import java.awt.*;
import java.applet.*;

public class Ex15_1_FlowLayoutTest extends Applet{
    Button b1,b2,b3;
    TextField tf;
	Label lab;
    public void init(){
           b1 = new Button("ok");
           b2 = new Button("open");
           b3 = new Button("close");
           tf = new TextField("test");
           lab = new Label("Test FlowLayout");
           setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
           add(b1);
           add(b2);
           add(b3);
           add(tf);
           add(lab);
      }
  } 
