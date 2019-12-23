/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import static kuisgame.PlayMusic.music;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Rosyid Iz
 */
public class PlayMusic {
    private final AL app ;
    private static AudioStream BGM = null;
    
    public static void setBGM(String path){
        stopMusic();
        
        try {
            BGM = new AudioStream(new FileInputStream(path));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        
        playMusic();
    }

    public PlayMusic() {
        app = new AL();
    }
    
    
    void testEnter() {
        app.getEnterButton().doClick();
    }
    
    public static void music() {
        AudioData MD;
        
        try {
            BGM = new AudioStream(new FileInputStream("src/tetris.wav"));
            AudioPlayer.player.start(BGM);
//            if(!AudioPlayer.player.isAlive()){
                AudioPlayer.player.start(BGM);
//            }
//            MD = BGM.getData();
//            loop = new ContinuousAudioDataStream(MD);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
    public static void stopMusic(){
        AudioPlayer.player.stop(BGM);
    }
    
    public static void playMusic() {
        AudioPlayer.player.start(BGM);
    }
}

class AL implements ActionListener {
        private final JButton enterButton;
        AL() {
            enterButton = new JButton("Enter");
            enterButton.addActionListener(this);
        }
        
        JButton getEnterButton() {
            return enterButton;
        }
        
        @Override
        public final void actionPerformed(ActionEvent ae) {
            String btntext = ((JButton) ae.getSource()).getText();
            if (btntext.equals("Enter")) {
                music();
            }
        }
    }

