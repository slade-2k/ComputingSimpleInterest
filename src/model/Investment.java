package model;

public class Investment {
	private double principal;
	private double rateOfInterest;
	private int years;
	
	public Investment(double principal, double rateOfInterest, int years){
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.years = years;
	}	
	
	public int getYears(){
		return this.years;
	}
	
	public double getRateOfInterest(){
		return this.rateOfInterest;
	}
	
	public double getPrincipal(){
		return this.principal;
	}
	
	public double calculateAccrued(){
		return this.principal * (1+ (this.rateOfInterest/100) * this.years);		
	}
}
