package collider;

import javax.swing.JFrame;


public class ArcMotionCollider {
	
	public static void main(String[] args)
		throws InterruptedException {
		
		ArcMotionCollider panel = new ArcMotionColliderPanel();
		JFrame frame = new JFrame();
		
		int attackRange = 20;
		float attackVelocity = 75; // pixels / sec, clockwise rotation
		float v = attackVelocity / attackRange; // v / r
		float r = attackRange;
		
		

		//Set initial position based on direction
		double[] attackPos = new double[2];
		int[] initialPos = {100 , 100};
		panel.x = 118; panel.y = 100; panel.width = 20; panel.height = 20; 
		panel.attackX = (int)attackPos[0]; panel.attackY = (int)attackPos[1];
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(400 , 400);
		frame.setVisible(true);

		Thread.sleep(500);
		long t1 = System.currentTimeMillis(); //t1 in sec
		boolean collisionDetected = false;
		int detectionTime=0;
		long impactCount = 0;
		
		while(System.currentTimeMillis() - t1 < 1000){
			//Parametric eqn for a circle: r*cos(vt / r) , r*sin(vt / r) 
			//Switching cos to y and sin to x. It should work on the same principle as an x-axis transformation but simpler to deal with.
			attackPos[0] = (float)(r * Math.sin(v * (System.currentTimeMillis() - t1) / 1000) + initialPos[0]); 
			attackPos[1] = (float)(r * Math.cos(v * (System.currentTimeMillis() - t1) / 1000) + initialPos[1]);
			
			
			float x1 = 110, x2 = 138;
			float y1 =  100, y2 = 120;
			
			panel.x = (int)x1; panel.y = (int)y1; panel.width = (int)(x2 - x1); panel.height = (int)(y2 - y1); 
			panel.attackX = (int)attackPos[0]; panel.attackY = (int)attackPos[1];
			
			panel.repaint();
			
			if(attackPos[0] >  x1 && attackPos[0] < x2 && attackPos[1] > y1 && attackPos[1] < y2 && ((System.currentTimeMillis() - t1) - detectionTime) > 20){
				impactCount++;
				collisionDetected = true; detectionTime = (int) (System.currentTimeMillis() - t1); 
			}
			
		}
		System.out.printf("Collision detected: %b Time: %d ms Impact Count: %d", collisionDetected, detectionTime, impactCount);
	}
}
