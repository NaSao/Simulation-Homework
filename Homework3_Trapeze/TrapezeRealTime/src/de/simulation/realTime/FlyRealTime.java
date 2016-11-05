package de.simulation.realTime;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class FlyRealTime extends Applet implements Runnable{
	
	public Cord cord;
	public Trapezer trapezer;
	
	
	private boolean freeze = true;

	@Override
	public void init() {
		cord = new Cord(this);
		trapezer = new Trapezer(this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Timer uploadCheckerTimer = new Timer(true);
		uploadCheckerTimer.scheduleAtFixedRate(
		    new TimerTask() {
		      public void run() { 
		    	  if (!freeze)
					trapezer.swing();
				myRepaint(); }
		    }, 0, 100);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		this.run();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	/**
	 * Draw the pieces of the pendulum
	 */
	public void paint(Graphics g) {
		cord.draw(g);
		trapezer.draw(g);

		// Draw a little red spot where the pivot is.
		g.setColor(Color.red);
		g.fillOval(Cord.CORD_PIVOT_POSITION_X - 3, Cord.CORD_PIVOT_POSITION_Y - 3, 20, 20);
	}

	/**
	 *  Reset the weight to this position as the user drags it around
	 */
	public boolean mouseDrag(Event e, int x, int y) {
		trapezer.newPosition(x, y);
		return false; 
	}

	/** 
	 * Called when the mouse goes down. Stop swinging. 
	 */
	public boolean mouseDown(Event e, int x, int y) {
		freeze = true;
		return false; 
	}

	/** 
	 * Called when the mouse goes up. Start swinging again. 
	 */
	public boolean mouseUp(Event e, int x, int y) {
		freeze = false;

		repaint();

		return false; 
	}

	/** 
	 * Focus the repaint to the pendulum.
	 */
	private void myRepaint() {
		int x;
		int y;
		int w;
		int h;
		int border = Trapezer.TRAPEZER_PIC_DIAMETER * 2;

		y = Cord.CORD_PIVOT_POSITION_Y;
		h = trapezer.trapezerPositionY + Trapezer.TRAPEZER_PIC_DIAMETER;
		x = (trapezer.trapezerPositionX > Cord.CORD_PIVOT_POSITION_X) ? Cord.CORD_PIVOT_POSITION_X - border
				: trapezer.trapezerPositionX - border;
		w = Math.abs(Cord.CORD_PIVOT_POSITION_X - trapezer.trapezerPositionX) + (border * 2);

		repaint(x, y, w, h);
	}



	
}
