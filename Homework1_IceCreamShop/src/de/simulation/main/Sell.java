package de.simulation.main;

import de.simulation.entity.Seller;
import de.simulation.entity.Truck;
import de.simulation.init.InitialValues;
import de.simulation.tool.BuyRandom;

/**
 * Sell 
 * @author Yuqi Na
 *
 */
public class Sell {
	public Truck truck;
	public Seller seller;
	//If you want to sell, you must have a seller and a truck
	public Sell(Truck truck, Seller seller){
		this.truck = truck;
		this.seller = seller;
	}
	/**
	 * Go for selling ,there must be a seller and a truck
	 * @return earned money
	 */
	public void goForSelling(){
		int earnMoney = 0;
		BuyRandom br = new BuyRandom();
		int clockHour =  InitialValues.TIME_OPEN;
		int costMinutes = 0;
		while(clockHour<InitialValues.TIME_CLOSE 
				&& this.truck.getIce_cream_left() > 0 
				&& this.truck.getLeft_oil() > 0){
			costMinutes += br.customerComePossibility(clockHour);
			costMinutes += InitialValues.TIME_PRO_CUSTOMER;
			int scoop = br.scoopNumPossibility(clockHour);
			seller.sell(truck, scoop);
			
			System.out.println("Sell "+scoop+" Scoop at "+clockHour+":"+costMinutes);
			
			if(costMinutes>=60){
				clockHour++;
				costMinutes = costMinutes - InitialValues.TIME_MINUTES_PRO_HOUR;
				this.truck.cooling();
			}
		}
	}
}
