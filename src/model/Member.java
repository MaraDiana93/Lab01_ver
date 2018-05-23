package model;

public class Member {
	private String name;
	private int income;
	private int costs;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public void setCosts(int costs) {
		this.costs = costs;
	}
	public String getName() {
		return name;
	}
	public int getIncome() {
		return costs;
	}
	public int getCosts() {
		return income;
	}
	
	public String toString() {
		return "(" + this.name + " " + this.income + " " + this.costs + ")";
	}
}
