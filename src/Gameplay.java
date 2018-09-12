import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8325372649891574490L;
	private boolean play = false;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballxdir = -1;
	private int ballYdir = -2;
	private Timer timer;
	
	private MapGenerator map;
	public Gameplay() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer  = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		// drawing map
		map.draw((Graphics2D)g);
		
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
			
			A: for(int i = 0; i<map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX = j * map.brickwidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickwidth = map.brickwidth;
						int brickHeigth = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickHeigth);
						Rectangle ballRect = new Rectangle(ballposY, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickvalue(0, i, j);
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballxdir = -ballxdir;
							} else {
								ballYdir = -ballYdir;
							}
							
							break A;
						}
					}
				}
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
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
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