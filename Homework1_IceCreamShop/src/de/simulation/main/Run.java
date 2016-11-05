package de.simulation.main;

import de.simulation.entity.Seller;
import de.simulation.entity.Truck;
import de.simulation.init.InitialValues;

/**
 * Run
 * @author Yuqi Na
 *
 */
public class Run {
	
	public static void main(String[] args){
		Seller Jack = new Seller("Jack",21,
				InitialValues.HEALTH_STATE_GOOD,
				InitialValues.DRIVE_SKILL_NORMAL,
				"German", "Deutsch", 0);
		Truck Benz = new Truck(InitialValues.BRAND_GOOD,
				InitialValues.TRUCK_SIZE_BIG,
				InitialValues.ICE_CREAM_CAPACITY_BIG,
				InitialValues.ICE_CREAM_CAPACITY_BIG,
				InitialValues.TANK_CAPACITY_BIG,
				InitialValues.TANK_CAPACITY_BIG);
		Sell goForSell = new Sell(Benz, Jack);
		//Drive to sell
		Jack.drive(Benz, InitialValues.DRIVE_DISTANCE);
		
		//Sell
		goForSell.goForSelling();
		
		//Drive home
		Jack.drive(Benz, InitialValues.DRIVE_DISTANCE);
		
		System.out.println("Left oil " + 
		Benz.getLeft_oil() + " L");
		System.out.println("Left Ice cream " + 
		Benz.getIce_cream_left() + " Scoop");
		System.out.println("Earned money " + 
		Jack.getMoney() + " Euro");
	}
	
}
