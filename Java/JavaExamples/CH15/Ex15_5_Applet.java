//��applet���������ļ�
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;   //�����ಢ���б�Ҫ�ı�������
public class Ex15_5_Applet extends Applet implements ItemListener{
	AudioClip midi[]=new AudioClip[3];  // ����AudioClip�ӿ����͵�����
	AudioClip current;         // ����AudioClip�ӿ����͵ı���current
	Choice chc = new Choice();  // ����Choice����������������ļ��������������ø�midi����INIT()���������б�Ҫ�ĳ�ʼ������
	public void init(){  //���������ļ����������Ƿ���midi[]������
		midi[0]=getAudioClip(getCodeBase(),"flourish.midi");
		midi[1]=getAudioClip(getCodeBase(),"onestop.midi");
		midi[2]=getAudioClip(getCodeBase(),"town.midi");  //��ѡ��ؼ������Ҫ���ŵ��ļ���������
		chc.add("windows�Դ�midi1");
		chc.add("windows�Դ�midi2");
		chc.add("windows�Դ�midi3");
		add(chc);        //��ѡ��ؼ���ӵ�APPLET�ϰ�applet����chc�������ߣ���������
		chc.addItemListener(this);
		current=midi[0];     // ����Ŀǰ���ŵĸ���Ϊmidi[0]
		current.play();      // ���Ÿ���
		}      //����ѡ��ؼ���ѡ���¼�
	public void itemStateChanged(ItemEvent e){
		current.stop();       // ֹͣ���Ÿ����� ȡ�ñ�ѡȡ������ֵ
		int index=chc.getSelectedIndex();   // ���ò��ŵĸ���Ϊmidi[index]
		current=midi[index];
		current.play();        // ���Ÿ���
		}
	
   }
