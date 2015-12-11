/**
 *在applet里移动图片
 **/
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Ex15_4_Applet extends Applet implements MouseMotionListener,
		MouseListener {
	Image img; // 声明Image类型的变量img
	int x = 70, y = 60, posX = 70, posY = 60, dx, dy;

	public void init() {
		img = getImage(getCodeBase(), "demo.gif");// 加载影像
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent e) {
		dx = e.getX() - posX; // 取得按下点与基准点x方向的距离
		dy = e.getY() - posY; // 取得按下点与基准点y方向的距离
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX() - dx; // 取得拖曳时基准点的x坐标
		y = e.getY() - dy; // 取得拖曳时基准点的y坐标
		if (dx > 0 && dx < 120 && dy > 0 && dy < 60) // 如果指针落在图形上方
		{
			Graphics g = getGraphics();
			update(g); // 清空画面为背景颜色，再调用paint()
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, x, y, 80, 100, this); // 将img画在applet上
		posX = x; // 更新基准点的x坐标
		posY = y; // 更新基准点的y坐标
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
