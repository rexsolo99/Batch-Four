import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class solobricks extends JPanel implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7053295937887075702L;
	
	private boolean play = false;
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballxdir = -1;
	private int ballYdir = -2;
	private Graphics2D map;
	
	public solobricks() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		// drawing map
		map.draw((Shape)g);
		
		// borders
		g.setColor(Color.red);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		// the ball
		g.setColor(Color.blue);
		g.fillOval(playerX, ballposY, 20, 20);
		
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			if(new Rectangle(ballposX,  ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}
			
			ballposX += ballxdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballxdir = -ballxdir;
			}
			if(ballposY < 0) {
				ballxdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballxdir = -ballxdir;
			}
		}
		
		repaint();
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

    
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
		        playerX = 600;
			} else {
				moveRight();
			}
		
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX <10) {
		        playerX = 10;
			} else {
				moveLeft();
			}
		}
		
		
	}	
	public void moveRight() {
		play = true;
		playerX+=20;
	}
	public void moveLeft() {
		play = true;
		playerX-=20;
	}	

}