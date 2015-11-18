package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.NumberFormatter;

import model.Investment;

public class GUI extends JFrame{
	
	private JLabel lblPrincipal = new JLabel("Principal: ");
	private JLabel lblRateOfInterest = new JLabel("Rate of interest: ");
	private JLabel lblYears = new JLabel("Years: ");
	private JLabel lblOutput = new JLabel();
	
	private JFormattedTextField txtPrincipal;
	private JFormattedTextField txtRateOfInterest;
	private JFormattedTextField txtYears;
	
	private JPanel pnlWrapper = new JPanel();
	private JPanel pnlInputColoumn = new JPanel();
	private JPanel pnlLabelColoumn = new JPanel();
	private JPanel pnlOutput = new JPanel();
	
	private JButton btnCalc = new JButton("Calculate");
	
	public GUI(){
		this.setSize(500, 200);
		this.setVisible(true);
		this.setTitle("Investment Calculator");
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
		df.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(df);

		DecimalFormatSymbols custom = new DecimalFormatSymbols();
		custom.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(custom);
		
		Dimension dimTxt = new Dimension(150, 20);
		Dimension dimBtn = new Dimension(50, 60);
		
		txtPrincipal = new JFormattedTextField(formatter);
		txtPrincipal.setMaximumSize(dimTxt);
		txtRateOfInterest = new JFormattedTextField(formatter);
		txtRateOfInterest.setMaximumSize(dimTxt);
		txtYears = new JFormattedTextField(formatter);
		txtYears.setMaximumSize(dimTxt);
		
		pnlOutput.setLayout(new BoxLayout(pnlOutput, BoxLayout.X_AXIS));
		pnlWrapper.setLayout(new BoxLayout(pnlWrapper, BoxLayout.X_AXIS));
		pnlInputColoumn.setLayout(new BoxLayout(pnlInputColoumn, BoxLayout.Y_AXIS));
		pnlLabelColoumn.setLayout(new BoxLayout(pnlLabelColoumn, BoxLayout.Y_AXIS));
		
		btnCalc.setMinimumSize(dimBtn);
		
		this.add(pnlWrapper);
		this.add(pnlOutput);
		pnlWrapper.add(pnlLabelColoumn);
		pnlWrapper.add(pnlInputColoumn);
		pnlWrapper.add(btnCalc);
		
		pnlLabelColoumn.add(lblPrincipal);
		pnlLabelColoumn.add(lblRateOfInterest);
		pnlLabelColoumn.add(lblYears);
		
		pnlInputColoumn.add(txtPrincipal);
		pnlInputColoumn.add(txtRateOfInterest);
		pnlInputColoumn.add(txtYears);
		
		pnlOutput.add(lblOutput);
		validate();
	}
	
	public void setOutputText(String text){
		lblOutput.setText(text);
	}
	
	public boolean areTextfieldsFilled(){
		return !txtPrincipal.getText().isEmpty() && !txtRateOfInterest.getText().isEmpty() && !txtYears.getText().isEmpty();
	}
	
	public double getPrincipalValue(){
		return Double.parseDouble(txtPrincipal.getText());
	}
	
	public double getRateOfInterestValue(){
		return Double.parseDouble(txtRateOfInterest.getText());
	}
	
	public int getYearsValue(){
		return Integer.parseInt(txtYears.getText());
	}
	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(getContentPane(), msg);
	}
	
	public void addBtnCalcActionListener(ActionListener act){
		btnCalc.addActionListener(act);
	}
}
