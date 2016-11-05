package de.simulation.realTime;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This is a Cord Class
 * @author Yuqi Na
 * 
 */
class Cord {

	public static final Color CORD_COLOR = Color.black;
	public static final int CORD_PIVOT_POSITION_X = 500;
	public static final int CORD_PIVOT_POSITION_Y = 20;
	public static final double MIN_LENGTH = 60.0;

	public int cordLength;
	public double angle;
	public double fastestSpeed;

	public FlyRealTime fly;

	Cord(FlyRealTime fly) {
		cordLength = 10;
		angle = 0.0;
		this.fly = fly;
		fastestSpeed = 20.0;
	}
	
	/**
	 * Calculate the new length of the Cord
	 * @param newX new X coordinate
	 * @param newY new Y coordinate
	 */
	public void newLength(int newX, int newY) {
		double newLength;
		double sqx;
		double sqy;
		sqx = (double) (CORD_PIVOT_POSITION_X - newX) * (double) (CORD_PIVOT_POSITION_X - newX);
		sqy = (double) (CORD_PIVOT_POSITION_Y - newY) * (double) (CORD_PIVOT_POSITION_Y - newY);
		newLength = Math.sqrt(sqx + sqy);
		cordLength = (int) newLength;
		newAngle(newX);
	}
	
	/**
	 * Calculate the angle between the cord 
	 * and The angle will be the arcsin of the opposite side
	 * @param distance distance over the hypotenuse
	 */
	public void newAngle(int distance) {
		double opp;
		opp = (double) (distance - CORD_PIVOT_POSITION_X); // note this can be negative.
		if (Math.abs(opp) < 1.0)
			angle = 0.0;
		else
			angle = Math.asin(opp / cordLength);
	}

	/**
	 * Make sure the cord is longer than its minimum 
	 * @return the length of cord
	 */
	public double getCordMinLength() {
		if ((double) cordLength < MIN_LENGTH)
			return MIN_LENGTH;
		else
			return (double) cordLength;
	}

	/**
	 * Draw the cord
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(CORD_COLOR);
		g.drawLine(CORD_PIVOT_POSITION_X, CORD_PIVOT_POSITION_Y, fly.trapezer.trapezerPositionX, fly.trapezer.trapezerPositionY);
	}

}
