
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, count; 
	private ImageIcon background, Ship;
	private Player play;
	private PlayerShip ship;
	private ArrayList <AlienShip> aliens;
	private ArrayList <PlayerMissile> pMissiles;
	private ArrayList <AlienMissile> aMissiles;
	private Boolean start, win, moveRight;
	private char screen;
	private double time;
	private double currtime;
	private int score;
	private boolean playsound;
	private Sound effects;

	


	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		play=new Player();
		start=true;
		pMissiles=new ArrayList <PlayerMissile>();
		aMissiles=new ArrayList <AlienMissile>();
		win=false;
		moveRight=true;
		ship = new PlayerShip(800, 500, 100,100);
		key =-1; 
		count=0;
		screen='S';
		background=new ImageIcon("Moon_BG.png");
		Ship=new ImageIcon("Player_Ship.png");
		aliens = setAliens();
		currtime=0;
		time=System.currentTimeMillis();
		score = 0;
        playsound=true;
        effects= new Sound();


		
		
	
	}

	public void screen(Graphics g2d) {
		switch(screen) {
		case 'S':
			
			g2d.drawImage(background.getImage(),0,0,getWidth(), getHeight(), this);
			drawStartScreen(g2d);
			
			break;
		
		case 'G':
			
			g2d.drawImage(background.getImage(),0,0,getWidth(), getHeight(), this);
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("times new roman", Font.BOLD,25));
			g2d.drawString(new DecimalFormat("#0.00").format(currtime),320,30);
			drawAliens(g2d);
			moveAliens();
			drawShip(g2d);
			drawPM(g2d);
			drawAlienMissile(g2d);
			count++;
			if(count%100==0) {
				getAlienMissile(g2d);
			}
			alienhit();
		
			 if (aliens.isEmpty()) {
	                screen = 'W'; 
	                
                    if(playsound) {
        				effects.playmusic1("Winze.wav");
        				playsound=false;
                    }
	            }
	           
	            else if (playerHit() || aliensReachedBottom()) {
	                screen = 'L'; 

	                if(playsound) {
	    				effects.playmusic1("Loze.wav");
	    				playsound=false;
	                }
	            } else {
	              
	                g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	                drawAliens(g2d);
	                moveAliens();
	                drawShip(g2d);
	                drawPM(g2d);
	                drawAlienMissile(g2d);
	                count++;
	                if (count % 100 == 0) {
	                    getAlienMissile(g2d);
	                }
	                alienhit();
	                if (start)
	            		currtime=(System.currentTimeMillis()-time)/1000;
	            }
		    break;

	        case 'W':
	           
	            drawWinScreen(g2d);
	           
	          
	            break;

	        case 'L':
	          
	            drawLoseScreen(g2d);
	         
	            break;
	    }
		 g2d.setColor(Color.white);
		    g2d.setFont(new Font("Arial", Font.BOLD, 40));
		    g2d.drawString("Score: " + score, 20, 40);
	}
	
	public ArrayList <AlienShip> setAliens(){
		ArrayList <AlienShip> temp=new ArrayList <AlienShip>();
		int x=75;
		int y=100;
		for (int i=0; i<3; i++) {
		for (int j=0; j<9 ; j++) {
			temp.add(new AlienShip(i+x,y, 50, 50));
			x+=100;
			}
		y+=50;
		x=75;
		}
		return temp;
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
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		
		screen(g2d);
		
		twoDgraph.drawImage(back, null, 0, 0);

	}
public void drawStartScreen(Graphics g2d) {
	//create start screen
	g2d.setFont(new Font("Century", Font.BOLD, 50));
	g2d.setColor(Color.black);
	g2d.drawString("Welcome to Space Invaders!", 100, 200);
	g2d.drawString("Press P to Start", 100, 400);
	g2d.drawString("The mouse is move and left click is shoot", 100, 600);
	
}
	

public void drawAliens(Graphics g2d) {
		for(AlienShip a: aliens) {
		g2d.drawImage(a.getPic().getImage(), a.getX(), a.getY(), a.getW(), a.getH(),this);
		}
		}


public void moveAliens() {
		if(checkAlienWall()) {
		changeDyAlien(10);
		
		}
		for(AlienShip a:aliens) {
		if(moveRight) {
			a.setdx(2);
			changeDyAlien(0);
		}	
			else {
				a.setdx(-2);
				changeDyAlien(0);
			}
			}
		}

public boolean alienhit() {
    boolean hitDetected = false;
    for (int i = 0; i < aliens.size(); i++) {
        for (int j = 0; j < pMissiles.size(); j++) {
            if (aliens.get(i).hit(pMissiles.get(j))) {
                aliens.remove(i);
                pMissiles.remove(j);
                hitDetected = true;
                score += 10;
               effects.playmusic1("holyshot.wav");
                break;
            }
        }
        if (hitDetected) {
            break;
        }
    }
    return hitDetected;
}


public void changeDyAlien(int dy) {
		for(AlienShip a:aliens) {
		a.setdy(dy);
		}
		}

public boolean checkAlienWall() {
		for(AlienShip a:aliens) {
		if (a.getX()+a.getW()>=getWidth()||a.getX()<0) {
			moveRight=!moveRight;
			return true;
			}}
		return false;
		}
public void drawShip(Graphics g2d) {
	
		g2d.drawImage(ship.getPic().getImage(), ship.getX(), ship.getY(), ship.getW(), ship.getH(), this);
}
public void playerMissile(int x) {
		pMissiles.add(new PlayerMissile(x,ship.getY(), 30,30 ));
		}

public void drawPM(Graphics g2d) {
		for(PlayerMissile pm: pMissiles) {
		g2d.drawImage(pm.getPic().getImage(),pm.getX(), pm.getY(), pm.getH(),  pm.getW(), this);
		pm.setdy(-5);
		}
		}
public void getAlienMissile(Graphics g2d) {
		int randAlien = (int)(Math.random()*aliens.size());
		aMissiles.add(new AlienMissile(aliens.get(randAlien).getX()+(aliens.get(randAlien).getW())/2, aliens.get(randAlien).getY()+aliens.get(randAlien).getH(), 30,30));
	
	}

public boolean playerHit() {
    for (int i = 0; i < aMissiles.size(); i++) {
        AlienMissile am = aMissiles.get(i);
        if (ship.hit(am)) {
            aMissiles.remove(i);
            return true;
        }
    }
    return false;
}


public void drawAlienMissile(Graphics g2d) {
	for(AlienMissile am: aMissiles) {
		g2d.drawImage(am.getPic().getImage(), am.getX(), am.getY(), am.getW(), am.getH(), this);
		am.setdy(2);
		}
}
public void drawWinScreen(Graphics g2d) {
    g2d.setFont(new Font("Century", Font.BOLD, 50));
    g2d.setColor(Color.white);
    g2d.drawString("Congratulations! You Win! Press P to restart.", 100, 400);
   
}
public boolean aliensReachedBottom() {
    for (AlienShip alien : aliens) {
        if (alien.getY() + alien.getH() >= getHeight()) {
            return true;
        }
    }
    return false;
}
private void drawLoseScreen(Graphics g2d) {
    g2d.setFont(new Font("Century", Font.BOLD, 50));
    g2d.setColor(Color.white);
    g2d.drawString("Game Over! You've lost. Press P to restart", 100, 400);
}
public void resetGame() {
    start = true;
    pMissiles.clear();
    aMissiles.clear();
    win = false;
    moveRight = true;
    key = -1;
    count = 0;
    screen = 'S';
    aliens = setAliens();
    ship.reset();
    start=false;
	currtime=0;
	time=System.currentTimeMillis();
    score=0;
    playsound = true;
}

	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
	    key = e.getKeyCode();
	    if (key == 80) { 
	        if (screen == 'S' || screen == 'W' || screen == 'L') {
	            resetGame();
	            screen ='G';
	           
	        }
	    }
	 if (key == 8) { 
	       removeAliens();
	}
	 
	 if (key == 10) { 
	       score += 10;
	}
	 if (key == 32) { 
		 for (AlienShip alien : aliens) {
		        alien.setdx(0);
		        alien.setdy(0);
	}}}

private void removeAliens() {
		    int aliensToRemove = 3;
		    if (aliens.size() >= aliensToRemove) {
		        for (int i = 0; i < aliensToRemove; i++) {
		            aliens.remove(aliens.size() - 1); 
		        }
		    } else {
		        aliens.clear(); 
		    }
		}
 

	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		ship.setX(e.getX());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getButton()==1) {
			playerMissile(arg0.getX()+(ship.getW()/4));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
