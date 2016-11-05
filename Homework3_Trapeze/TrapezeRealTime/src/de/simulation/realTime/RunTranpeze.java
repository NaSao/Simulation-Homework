package de.simulation.realTime;

import java.awt.Frame;

public class RunTranpeze {


	public static void main(String args[]) {
		FlyRealTime p = new FlyRealTime();
		p.init();

		// Create a window hierarchy and hook it up.
		Frame f = new Frame("Trapezer");
		f.add(p);
		f.resize(1000, 1000);
		f.show();

		// Start the app (this is done by the appletviewer or Web browser
		// for us automatically, but it's not done if we're running the app
		// from the command line).
		p.start();
	}
}
