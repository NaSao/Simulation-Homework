package de.simulation.tool;

import java.util.Random;

import de.simulation.init.InitialValues;

/**
 * Simulation Methods
 * @author Yuqi Na
 *
 */
public class BuyRandom {

	/**
	 * Get the Random number of buyer depending on time
	 * @param time
	 * @return minutes: how long comes one buyer
	 */
	public int customerComePossibility(int time){
		int minutes = 0;
		if(InitialValues.TIME_1PM > time){
			//1 to 3 minutes till 1PM
			minutes = (int)(Math.random()*3)+1;
		}else if(InitialValues.TIME_1PM < time && time < InitialValues.TIME_5PM){
			//2 to 10 minutes till 1PM
			minutes = (int)(Math.random()*9)+2;
		}else if(InitialValues.TIME_5PM < time && time < InitialValues.TIME_7PM){
			//1 to 2 minutes till 1PM
			minutes = (int)(Math.random()*2)+1;
		}else if(InitialValues.TIME_7PM < time && time < InitialValues.TIME_9PM){
			//2 to 5 minutes till 1PM
			minutes = (int)(Math.random()*4)+2;
		}
		return minutes;
	}
	
	/**
	 * Get the Random number of scoop depending on time
	 * @param time
	 * @return scoop: the number of scoop that a buyer bought
	 */
	public int scoopNumPossibility(int time){
		int scoop = 0;
		if(InitialValues.TIME_1PM > time){
			//1 to 3 minutes till 1PM
			scoop = (int)(Math.random()*5)+1;
		}else if(InitialValues.TIME_1PM <= time && time < InitialValues.TIME_3PM){
			//2 to 10 minutes till 1PM
			scoop = (int)(Math.random()*4)+3;
		}else if(InitialValues.TIME_3PM <= time && time < InitialValues.TIME_9PM){
			//2 to 5 minutes till 1PM
			scoop = (int)(Math.random()*4)+1;
		}
		return scoop;
	}
}
