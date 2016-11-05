package de.simulation.realTime;

import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * This is a Trapezer Class
 * 
 * @author Yuqi Na
 *
 */
public class Trapezer extends Frame {
	public static final int TRAPEZER_PIC_DIAMETER = 300;
	public static final int DIRECTION_IS_RIGHT = 1;
	public static final int DIRECTION_IS_LEFT = -1;

	public static final String TRAPEZER_PICTURE = "Tranpeze.png";

	// Trapezer picture's Position
	public int trapezerPositionX;
	public int trapezerPositionY;
	// Trapezer's direction is left(-1) or right(1)
	private int direction;
	// The height of Trapezer (Trapezer's Y vector)
	private int height;
	private FlyRealTime fly;
	private boolean reverseOk = true;
	private double velocity;
	private double fastestSpeed;

	Trapezer(FlyRealTime fly) {
		direction = 0;
		velocity = 0.0;
		fastestSpeed = 0.0;
		trapezerPositionX = Cord.CORD_PIVOT_POSITION_X;
		trapezerPositionY = Cord.CORD_PIVOT_POSITION_Y + 150;
		height = trapezerPositionY;
		this.fly = fly;
	}

	/**
	 * The picture moves in a period time.
	 */
	public void swing() {
		double delta;
		double divisions;
		double theta;

		// Change the angle to move 
		divisions = fly.cord.getCordMinLength();
		delta = velocity * (Math.PI / divisions) * (double) direction;

		theta = fly.cord.angle + delta;
		
		//real time
		//theta=theta-1;
		
		
		trapezerPositionX = (int) (Math.sin(theta) * (double) fly.cord.cordLength)
				+ Cord.CORD_PIVOT_POSITION_X;
		trapezerPositionY = (int) (Math.cos(theta) * (double) fly.cord.cordLength)
				+ Cord.CORD_PIVOT_POSITION_Y;

		// Is it okay to possibly reverse direction?
		if (sign(theta) != sign(fly.cord.angle))
			reverseOk = true;

		// Set the cord's new angle with the vertical.
		fly.cord.angle = theta;

		// Change the swing's direction if necessary.
		if (trapezerPositionY < height && reverseOk) {
			direction = -direction;
			reverseOk = false;
		}

		// Adjust the weight's speed to match the height in its swing.
		velocity = newSpeed();
	}
	
	/**
	 * Calculate the new speed
	 */
	private double newSpeed() {
		double ratio;
		ratio = ((double) (trapezerPositionY - height))
				/ ((double) ((fly.cord.cordLength + Cord.CORD_PIVOT_POSITION_Y) - height));

		if (ratio < 0.0)
			ratio = 0.0;
		return ((ratio + .1) * fastestSpeed);
	}

	/**
	 * Set the new place of Trapezer
	 * @param x
	 * @param y
	 */
	public void newPosition(int x, int y) {
		this.trapezerPositionX = x;
		this.trapezerPositionY = y;

		// Prepare to swing the in the appropriate direction.
		velocity = 0.1;

		if (x < Cord.CORD_PIVOT_POSITION_X){
			//swing to right.
			direction = DIRECTION_IS_RIGHT;
		}
		else{
			//swing to left.
			direction = DIRECTION_IS_LEFT;
		}
			
		
		//give the Cord new length
		fly.cord.newLength(trapezerPositionX, trapezerPositionY);

		//Set the height.
		height = trapezerPositionY;

		// Don't try to reverse the direction of the pendulum's swing
		// until it has swung back through the center.
		reverseOk = false;

		// Acquire a new speed.
		// SQRT(2 * Gravity in m/s/s) length in meters (1 pixel = 1 dm) *
		// (1 - cos(initial angle)) )
		fastestSpeed = Math.sqrt(2.0 * 10.0 * (double) fly.cord.cordLength
				/ 10.0 * (1.0 - Math.cos(fly.cord.angle)));

	}

	/**
	 * preset the Pic on Graphics
	 * @param g
	 */
	public void draw(Graphics g) {
		ImageIcon a = new ImageIcon(TRAPEZER_PICTURE);
		g.drawImage(a.getImage(), trapezerPositionX, trapezerPositionY, this);
	}

	
	private int sign(double value) {
		if (value > 0)
			return 1;
		else
			return -1;
	}

}
