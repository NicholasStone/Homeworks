//package SocketCommunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SendButtonHandler implements ActionListener {

	private ServerThread st =null;
	SendButtonHandler(ServerThread st)
	{
		this.st=st;
		
	}@Override
	public void actionPerformed(ActionEvent e) {
	//	System.out.println("dfdfdfdfdfdx");

		// TODO �Զ����ɵķ������
		
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
		// TODO �Զ����ɵķ������	
	}

}
