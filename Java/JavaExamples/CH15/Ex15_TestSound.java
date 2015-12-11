/*
 * �������Գ���
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


public class Ex15_TestSound implements Runnable{
    private Sequencer midi;
    private String[] names={"1.mid","2.mid","3.mid","4.mid","5.mid"};
    private int i;
    private Map<String,Sequence> map;
    public Ex15_TestSound(){
        initMap();
        new Thread(this).start();
    }
    private void initMap(){
        try {
            map = new Hashtable<String, Sequence>();
            midi = MidiSystem.getSequencer(false);
            midi.open();
            for (String s : names) {
                try {
                    Sequence s1 = MidiSystem.getSequence(new File(s));
                    map.put(s, s1);
                } catch (InvalidMidiDataException ex) {
                    Logger.getLogger(Ex15_TestSound.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Ex15_TestSound.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Ex15_TestSound.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void createPlayer(String name){
        try {
            Sequence se=map.get(name);
            midi.setSequence(se);
            midi.start();
            
        }catch (InvalidMidiDataException ex) {
            Logger.getLogger(Ex15_TestSound.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void run(){
        while(true){
            try {
                System.out.println("���ļ���."+(++i));
                String name=names[(int)(Math.random()*names.length)];
                createPlayer(name);
                Thread.sleep(10000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex15_TestSound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        new Ex15_TestSound();
    }
}