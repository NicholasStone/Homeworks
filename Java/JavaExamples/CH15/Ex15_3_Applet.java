import java.awt.*;
import java.applet.*;

public class Ex15_3_Applet extends Applet{
	private String paramName; //���淵�ض�Ӧ����ֵ���ַ���
	public void init() {
		paramName=getParameter("who");
		if (paramName==null)
		{
			paramName="world";
			}
		}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Hello"+paramName+"!",50,50);
		}
}
