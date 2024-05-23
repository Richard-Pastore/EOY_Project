import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Game extends JPanel implements Runnable, KeyListener {

    private BufferedImage back;
    private int key, lives;
    private Pictures h1;
    private Pictures h2;
    private Pictures h3;
    private Pictures h4;
    private Pictures h5;
    private Pictures bg;
    private Words word;
    private Sound p;
    private String guesses;
    private String wrongguess;
    private boolean start;
    private boolean loser;

    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.setFocusable(true);
        key = -1;
        start = true;
        loser = false;
        lives = 5;
        wrongguess = "";
        word = new Words();
        guesses = "";
        h1 = new Pictures("H1.png", 850, 100, 250, 250);
        h2 = new Pictures("H2.png", 850, 100, 250, 250);
        h3 = new Pictures("H3.png", 850, 100, 250, 250);
        h4 = new Pictures("H4.png", 850, 100, 250, 250);
        h5 = new Pictures("H5.png", 850, 100, 250, 250);
        bg = new Pictures("Chalk.png", 0, 0, 1400, 700); // Assuming Pictures class is designed to take x, y, width, height.
        p = new Sound();
        p.playmusic("Think.wav");
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(5);
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if (back == null) {
            back = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);

        // Adjust background to fit the panel size
        g2d.drawImage(new ImageIcon(bg.getPic()).getImage(), 0, 0, getWidth(), getHeight(), this);

        if (start) {
            g2d.setFont(new Font("Century", Font.BOLD, 50));
            g2d.drawString("Press the SPACE key to start", 250, 350);
            lives = 5;
        } else {
            g2d.setFont(new Font("Century", Font.BOLD, 60));

            if (loser) {
                g2d.drawString("You just lost!", 150, 350);
                g2d.drawString("Press Space To Restart", 100, 650);
                wrongguess = "";
            }

            g2d.setFont(new Font("Impact", Font.PLAIN, 50));
            drawLives(g2d);

            if (!word.getDisplayWord().contains("-")) {
                g2d.setFont(new Font("Century", Font.PLAIN, 70));

                g2d.clearRect(0, 0, getSize().width, getSize().height);
                g2d.drawImage(new ImageIcon(bg.getPic()).getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.drawString("You Win", 450, 350);
                g2d.drawString("Press Space To Restart", 300, 550);
                
                wrongguess = "";
            }
        }
        g.drawImage(back, 0, 0, null);
    }

    private void drawLives(Graphics g2d) {
        if (!loser) {
            g2d.setColor(Color.white);
            switch (lives) {
                case 5:
                    g2d.drawString("All words are sea animals", 200, 500);
                    g2d.drawImage(new ImageIcon(h1.getPic()).getImage(), h1.getX(), h1.getY(), h1.getW(), h1.getH(), this);
                    break;
                case 4:
                    g2d.drawImage(new ImageIcon(h2.getPic()).getImage(), h2.getX(), h2.getY(), h2.getW(), h2.getH(), this);
                    break;
                case 3:
                    g2d.drawImage(new ImageIcon(h3.getPic()).getImage(), h3.getX(), h3.getY(), h3.getW(), h3.getH(), this);
                    break;
                case 2:
                    g2d.drawImage(new ImageIcon(h4.getPic()).getImage(), h4.getX(), h4.getY(), h4.getW(), h4.getH(), this);
                    break;
                case 1:
                    g2d.drawImage(new ImageIcon(h5.getPic()).getImage(), h5.getX(), h5.getY(), h5.getW(), h5.getH(), this);
                    break;
                case 0:
                    loser = true;
                    break;
                default:
                    break;
            }
            g2d.drawString("Your Lives Left:" + lives, 20, 80);
            g2d.drawString(word.getDisplayWord(), 150, 300);
            g2d.drawString("Your Wrong Guesses:" + wrongguess, 205, 400);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println(key);
        char c = e.getKeyChar();
        System.out.println(c);

        if (key == 32 && start) {
            start = false;
        } else {
            if (!word.checkGuess(c)) {
                guesses(c);
                wrongguess += guesses + "";
            }
            if (32 == e.getKeyCode()) {
                reset();
            }
        }
    }

    private void reset() {
        word.reset();
        loser = false;
        guesses = "";
        lives = 5;
    }

    public void guesses(char c) {
        boolean contains = true;
        for (int i = 0; i < guesses.length(); i++) {
            if (c == guesses.charAt(i)) {
                contains = false;
            }
        }
        if (contains) {
            guesses += c + " ";
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
