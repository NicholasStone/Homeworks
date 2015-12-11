//在applet播放音乐文件
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;   //定义类并进行必要的变量设置
public class Ex15_5_Applet extends Applet implements ItemListener{
	AudioClip midi[]=new AudioClip[3];  // 声明AudioClip接口类型的数组
	AudioClip current;         // 声明AudioClip接口类型的变量current
	Choice chc = new Choice();  // 创建Choice组件加载三个声音文件，并把它们设置给midi数组INIT()方法，进行必要的初始化工作
	public void init(){  //加载声音文件，并把它们放入midi[]数组中
		midi[0]=getAudioClip(getCodeBase(),"flourish.midi");
		midi[1]=getAudioClip(getCodeBase(),"onestop.midi");
		midi[2]=getAudioClip(getCodeBase(),"town.midi");  //在选择控件中添加要播放的文件名称如下
		chc.add("windows自带midi1");
		chc.add("windows自带midi2");
		chc.add("windows自带midi3");
		add(chc);        //将选择控件添加到APPLET上把applet当成chc的聆听者，及监视器
		chc.addItemListener(this);
		current=midi[0];     // 设置目前播放的歌曲为midi[0]
		current.play();      // 播放歌曲
		}      //处理选择控件的选择事件
	public void itemStateChanged(ItemEvent e){
		current.stop();       // 停止播放歌曲， 取得被选取的索引值
		int index=chc.getSelectedIndex();   // 设置播放的歌曲为midi[index]
		current=midi[index];
		current.play();        // 播放歌曲
		}
	
   }
