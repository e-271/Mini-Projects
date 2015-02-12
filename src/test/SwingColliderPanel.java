package collider;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SwingColliderPanel extends JPanel {
	
	
	int attackX, attackY; 
	int x, y, width, height;
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g.fillRect(x, y, width, height);
		g.setColor(Color.MAGENTA);
		g.fillRect(attackX, attackY, 4, 4);
		
	}

}
