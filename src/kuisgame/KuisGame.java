package kuisgame;


/**
 *
 * @author Rosyid Iz
 */

public class KuisGame {
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        FrameWelcome welcome = new FrameWelcome();
        PlayMusic play = new PlayMusic();
        
        welcome.setVisible(true);
        play.testEnter();
        
    }
    
}