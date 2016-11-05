package de.simulation.entity;

import java.util.List;

import de.simulation.init.InitialValues;


/**
 * Seller is a Person
 * @author Yuqi Na
 *
 */
public class Seller {
	private String name;
	private int age;
	private String health_state;
	private String drive_skill;
	private String nationality;
	private String mother_language;
	private int money;
	
	

	public Seller(String name, int age, String health_state,
			String drive_skill, String nationality, String mother_language,
			 int money) {
		this.name = name;
		this.age = age;
		this.health_state = health_state;
		this.drive_skill = drive_skill;
		this.nationality = nationality;
		this.mother_language = mother_language;
		this.money = money;
	}

	/**
	 * seller can sell ice, earn money, pro scoop costs 3 Euro
	 * @param truck
	 */
	public void sell(Truck truck, int scoop){
		truck.setIce_cream_left(truck.getIce_cream_left()-scoop);
		money+=scoop*3;
	}
	
	/**
	 * the seller can drive a truck, cost oil, and oil costs depending on the drive skill,  
	 * @param truck
	 * @param distance
	 */
	public void drive(Truck truck, int distance){
		if((InitialValues.DRIVE_SKILL_GOOD).equals(this.drive_skill)){
			truck.run(distance);
		}else if((InitialValues.DRIVE_SKILL_NORMAL).equals(this.drive_skill)){
			truck.run(distance+2);
		}else if((InitialValues.DRIVE_SKILL_BAD).equals(this.drive_skill)){
			truck.run(distance+3);
		}
		truck.run(distance);
	}
	
	public String getName() {
		return name;
	}
	public String getHealth_state() {
		return health_state;
	}
	public void setHealth_state(String health_state) {
		this.health_state = health_state;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDrive_skill() {
		return drive_skill;
	}
	public void setDrive_skill(String drive_skill) {
		this.drive_skill = drive_skill;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMother_language() {
		return mother_language;
	}
	public void setMother_language(String mother_language) {
		this.mother_language = mother_language;
	}

	
}
