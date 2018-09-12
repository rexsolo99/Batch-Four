import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	public int map[][];
	public int brickwidth;
	public int brickHeight;
	public 	MapGenerator(int row, int col) {
		map = new int [row][col];
		for(int i = 0; i < map.length; i++) {
			for(int j=0; j< map[0].length; j++) {
				map[i][j] = 1;
			}
		}
		
		brickwidth = 540/col;
		brickHeight = 150/row;
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i < map.length; i++) {
			for(int j=0; j< map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.yellow);
					g.fillRect(i * brickwidth + 80, i * brickHeight + 50, brickwidth, brickHeight);
					
					g.setStroke(new BasicStroke(7));
					g.setColor(Color.black);
					g.drawRect(i * brickwidth + 80, i * brickHeight + 50, brickwidth, brickHeight);
					
				}
				
				
			}
		}
	}
	public void setBrickvalue(int i, int i2, int j) {
		// TODO Auto-generated method stub
		
	}

}
