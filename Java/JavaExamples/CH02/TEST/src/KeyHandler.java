//package SocketCommunication;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class KeyHandler implements KeyListener {
	private ServerThread st =null;
	KeyHandler(ServerThread st)
	{
		this.st=st;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
if(e.getKeyCode()==KeyEvent.VK_ENTER)
		if(this.st.getfrm().input.getText()!=null&&! this.st.getfrm().input.getText().equals("quit"))
		    {
			this.st.getos().println( this.st.getfrm().input.getText());
			this.st.getos().flush();
			this.st.getfrm().input.setText("");
			
		  //  	frm.input.setText(sin.readLine());
		    } 
		else{
			this.st.getos().close();
		    try {
		    	this.st.getis().close();
			} catch (IOException e2) {
				// TODO �Զ����ɵ� catch ��
				System.out.println("4");
			}try {
				this.st.getclient().close();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				System.out.println("3");
			}
		    System.out.println("�������.");
		    System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
