package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import gui.GUI;
import model.Investment;

public class Controller implements ActionListener {
	private GUI gui;
	private NumberFormat nFormat;
	
	public Controller(){
		gui = new GUI();
		
		nFormat = NumberFormat.getInstance();
		nFormat.setMaximumFractionDigits(2);
		
		gui.addBtnCalcActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(gui.areTextfieldsFilled()){
			Investment investment = new Investment(
					gui.getPrincipalValue(), gui.getRateOfInterestValue(),
					gui.getYearsValue());
			
			gui.setOutputText("After " + investment.getYears() + " years at " + investment.getRateOfInterest() +
					"%, the investment will be worth $" + nFormat.format(investment.calculateAccrued()));
			
		} else {
			gui.showMessage("All fields have to be filled in.");
		}
	}
}
