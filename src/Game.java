import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*;

 
public class Game  extends JPanel implements Runnable, KeyListener{

 

    
    private BufferedImage back; 
    private int key, lives;
    private ImageIcon background;
    private Words word;
    private String guesses;
    private String wrongguess;
    private boolean start;
    private boolean loser;

    
    public Game() {
        new Thread(this).start();    
        this.addKeyListener(this);
        key =-1; 
        start=true;
        loser = false;
        lives = 5;
        wrongguess = "";
        background = new ImageIcon("cfabackground.png");  
        word = new Words();
        guesses = "";

    }
    public void run()
       {
           try
           {
               while(true)
               {
                  Thread.currentThread().sleep(5);
                repaint();
             }
          }
               catch(Exception e)
          {
          }
          }
    public void paint(Graphics g){

        Graphics2D twoDgraph = (Graphics2D) g; 
        if( back ==null)
            back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 

 

        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        
        g2d.setColor(Color.white);
        g2d.drawImage(background.getImage(),0,0, getWidth(),getHeight(), this);
    
        if(start) {
    	g2d.setFont(new Font ("century", Font.BOLD,50));
    	g2d.drawString("Press the SPACE key to start", 60, 300);
    	lives=6;}
        else {
        g2d.setFont(new Font ("Century", Font.BOLD, 60));
        
        if(loser) {
        	
    		g2d.drawString("You just lost!", 150, 350);
    	g2d.drawString("Press Space To Restart", 100,650);
    		wrongguess="";
    		
        }
      
	
    g2d.setFont( new Font("Impact", Font.PLAIN, 50));
        drawLives(g2d);
        if(!word.getDisplayWord().contains("-")) {
			g2d.clearRect(0, 0, getSize().width, getSize().height);
			g2d.drawString("You Win", 150, 350);
			g2d.drawString("Press Space To Restart", 100,650);
			wrongguess="";
		}
        }
        twoDgraph.drawImage(back, null, 0, 0);
     

    }
 
 

    

    private void drawLives(Graphics g2d) {

       g2d.setColor(Color.white);
        switch(lives) {

        case 5:
        	g2d.drawString("All words are capitals of countries.", 200,500);
        case 4:

        case 3:


        case 2:


        case 1:
        	 g2d.drawString("Your Lives Left:"+lives, 20, 80);
          g2d.drawString(word.getDisplayWord(), 150, 300);
            g2d.drawString("Your Wrong Guesses:"+wrongguess, 205, 400);
            break;
                
        case 0:
        	 loser=true;
            break;
            
        default:	
        }
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
    	key= e.getKeyCode();
		System.out.println(key);
		char c= e.getKeyChar();
		System.out.println(c);
		
		if(key==32 && start) {
			start=false;
		}
		else {
		if(!word.checkGuess(c)) {	
			guesses(c);
			wrongguess+= guesses+"";
			//lives--;
			
		}
		if(32==e.getKeyCode()) {
		reset();
		
		}}
	}
	private void reset() {
		word.reset();
		loser=false;
		guesses="";
		lives=5;
}
	public void guesses (char c) {
		boolean contains = true;
		for (int i=0; i<guesses.length(); i++) {
			if (c==guesses.charAt(i)) {
				contains = false;
			}
		}
		if(contains) {
			guesses+= c + " ";
			lives--;
			
		}
	}
	
public void Lose(Graphics g2d) {
		
}	

	public void Win(Graphics g2d) {
		
	
}






   
    public void keyReleased(KeyEvent e) {




    }



 

    
}