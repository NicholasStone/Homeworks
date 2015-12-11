/**
 *��applet���ƶ�ͼƬ
 **/
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Ex15_4_Applet extends Applet implements MouseMotionListener,
		MouseListener {
	Image img; // ����Image���͵ı���img
	int x = 70, y = 60, posX = 70, posY = 60, dx, dy;

	public void init() {
		img = getImage(getCodeBase(), "demo.gif");// ����Ӱ��
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent e) {
		dx = e.getX() - posX; // ȡ�ð��µ����׼��x����ľ���
		dy = e.getY() - posY; // ȡ�ð��µ����׼��y����ľ���
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX() - dx; // ȡ����ҷʱ��׼���x����
		y = e.getY() - dy; // ȡ����ҷʱ��׼���y����
		if (dx > 0 && dx < 120 && dy > 0 && dy < 60) // ���ָ������ͼ���Ϸ�
		{
			Graphics g = getGraphics();
			update(g); // ��ջ���Ϊ������ɫ���ٵ���paint()
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, x, y, 80, 100, this); // ��img����applet��
		posX = x; // ���»�׼���x����
		posY = y; // ���»�׼���y����
	}

	public void mouseMoved(MouseEvent e) {
	};

	public void mouseReleased(MouseEvent e) {
	};

	public void mouseEntered(MouseEvent e) {
	};

	public void mouseExited(MouseEvent e) {
	};

	public void mouseClicked(MouseEvent e) {
	};
}