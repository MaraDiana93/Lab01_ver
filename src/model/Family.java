package model;

public class Family {
	private String name;
	private int cost;
	private int income;
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getCost() {
		return cost;
	}

	public int getIncome() {
		return income;
	}
	
	public void addEntry(String type, int value) {
		if (type.equals("cost")) {
			addCost(value);
		}
		if (type.equals("income")) {
			addIncome(value);
		}
	}
	
	public void addCost(int value) {
		cost = value; 
	}

	public void addIncome(int value) {
		income += value;
	}
	
	public void eraseAll() {
		cost = 0;
		income = 0;
	}
}
