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
import javax.swing.text.NumberFormatter;

import main.Investment;

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
		
		NumberFormat nFormat = NumberFormat.getInstance();
		nFormat.setMaximumFractionDigits(2);
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
		df.setGroupingUsed(false);
		DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
		NumberFormatter formatter = new NumberFormatter(df);

		DecimalFormatSymbols custom=new DecimalFormatSymbols();
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
		btnCalc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!txtPrincipal.getText().isEmpty() && !txtRateOfInterest.getText().isEmpty() && !txtYears.getText().isEmpty()){
					Investment investment = new Investment(
							Double.parseDouble(txtPrincipal.getText()), Double.parseDouble(txtRateOfInterest.getText()),
							Integer.parseInt(txtYears.getText()));
					
					lblOutput.setText("After " + investment.getYears() + " years at " + investment.getRateOfInterest() +
							"%, the investment will be worth $" + nFormat.format(investment.getAccrued()));
					
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "All fields have to be filled in.");
				}
			}
		});
		
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
}
