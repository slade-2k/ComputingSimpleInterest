package main;

public class Investment {
	private double principal;
	private double rateOfInterest;
	private int years;
	private double accrued;
	
	public Investment(double principal, double rateOfInterest, int years){
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.years = years;
		this.accrued = this.principal * (1+ (this.rateOfInterest/100) * this.years);
	}	
	
	public double getAccrued(){
		return this.accrued;
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
}
