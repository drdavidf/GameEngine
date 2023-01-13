
import java.awt.*;
import javax.swing.JFrame;

import screens.OpeningScreen;

public class Game extends JFrame {

  static final int WIDTH = 640;
  static final int HEIGHT = 480;
  
  GameStateMachine stateMachine;
  
  public Game() {
  
    setIgnoreRepaint( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    Canvas canvas = new Canvas();
    canvas.setIgnoreRepaint( true );
    canvas.setSize( WIDTH, HEIGHT );

    add( canvas );
    pack();

    canvas.createBufferStrategy( 2 );
    
    GameFrameBuffer aGameFrameBuffer = new GameFrameBuffer(canvas);
    
	stateMachine = new GameStateMachine(aGameFrameBuffer);

    // Hookup keyboard polling
    
    addKeyListener( GameInput.instance() );
    canvas.addKeyListener(  GameInput.instance() );
    
  }
        
  public void run() {
	  stateMachine.gameLoop();
  }
        
  public static void main( String[] args ) {
    Game app = new Game();
    new OpeningScreen();
    app.run();
  }
}