import java.applet.*;
import java.awt.event.*;
public class Ex15_6_PlayAudio extends Applet implements MouseListener {
	AudioClip audio;
	public void init() 
	{
		audio = getAudioClip(getDocumentBase(),"flute+hrn+mrmba.au");
		addMouseListener(this);
	}

public void mousePressed(MouseEvent evt) {
	if (audio != null) audio.play();
}
public void mouseEntered (MouseEvent me) {}
public void mouseExited (MouseEvent me) {}
public void mouseClicked (MouseEvent me) {}
public void mouseReleased(MouseEvent me) {}
}
