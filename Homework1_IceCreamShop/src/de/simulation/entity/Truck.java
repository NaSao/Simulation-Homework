package de.simulation.entity;

/**
 * Truck
 * @author Yuqi Na
 *
 */
public class Truck {
	private String brand;
	private String size;
	private int ice_cream_capacity;
	private int ice_cream_left;
	private int tank_capacity;
	private int left_oil;
	
	
	
	public Truck(String brand, String size, int ice_cream_capacity,
			int ice_cream_left, int tank_capacity, int left_oil) {
		super();
		this.brand = brand;
		this.size = size;
		this.ice_cream_capacity = ice_cream_capacity;
		this.ice_cream_left = ice_cream_left;
		this.tank_capacity = tank_capacity;
		this.left_oil = left_oil;
	}

	/**
	 * drive the truck cost oil
	 * @param distance
	 */
	public void run(int distance){
		this.left_oil = left_oil - distance;
	}
	
	/**
	 * truck has fridge to cool, cost 1L oil pro hour
	 * @param hours
	 */
	public void cooling(){
		this.left_oil = this.left_oil - 1;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getTank_capacity() {
		return tank_capacity;
	}
	public void setTank_capacity(int tank_capacity) {
		this.tank_capacity = tank_capacity;
	}
	public int getLeft_oil() {
		return left_oil;
	}
	public void setLeft_oil(int left_oil) {
		this.left_oil = left_oil;
	}
	public int getIce_cream_capacity() {
		return ice_cream_capacity;
	}
	public void setIce_cream_capacity(int ice_cream_capacity) {
		this.ice_cream_capacity = ice_cream_capacity;
	}

	public int getIce_cream_left() {
		return ice_cream_left;
	}

	public void setIce_cream_left(int ice_cream_left) {
		this.ice_cream_left = ice_cream_left;
	}
	
}
