
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * FormattedTextFieldDemo.java is a 1.4 example that
 * requires no other files.
 *
 * It implements a mortgage calculator that uses four
 * JFormattedTextFields.
 */
public class TextFieldDemo extends JPanel
                                    implements PropertyChangeListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Values for the fields
    private double amount = 100000;
    private double rate = 7.5;  //7.5%
    private int numPeriods = 30;

    //Labels to identify the fields
    private JLabel amountLabel;
    private JLabel rateLabel;
    private JLabel numPeriodsLabel;
    private JLabel paymentLabel;

    //Strings for the labels
    private static String amountString = "Loan Amount: ";
    private static String rateString = "APR (%): ";
    private static String numPeriodsString = "Years: ";
    private static String paymentString = "Monthly Payment: ";

    //Fields for data entry
    private JFormattedTextField amountField;
    private JFormattedTextField rateField;
    private JFormattedTextField numPeriodsField;
    private JFormattedTextField paymentField;

    //Formats to format and parse numbers
    private NumberFormat amountFormat;
    private NumberFormat percentFormat;
    private NumberFormat paymentFormat;

    public TextFieldDemo() {
        super(new BorderLayout());
        setUpFormats();
        double payment = computePayment(amount,
                                        rate,
                                        numPeriods);

        //Create the labels.
        amountLabel = new JLabel(amountString);
        rateLabel = new JLabel(rateString);
        numPeriodsLabel = new JLabel(numPeriodsString);
        paymentLabel = new JLabel(paymentString);

        //Create the text fields and set them up.
        amountField = new JFormattedTextField(amountFormat);
        amountField.setValue(new Double(amount));
        amountField.setColumns(10);
        amountField.addPropertyChangeListener("value", this);

        rateField = new JFormattedTextField(percentFormat);
        rateField.setValue(new Double(rate));
        rateField.setColumns(10);
        rateField.addPropertyChangeListener("value", this);

        numPeriodsField = new JFormattedTextField();
        numPeriodsField.setValue(new Integer(numPeriods));
        numPeriodsField.setColumns(10);
        numPeriodsField.addPropertyChangeListener("value", this);

        paymentField = new JFormattedTextField(paymentFormat);
        paymentField.setValue(new Double(payment));
        paymentField.setColumns(10);
        paymentField.setEditable(false);
        paymentField.setForeground(Color.red);

        //Tell accessibility tools about label/textfield pairs.
        amountLabel.setLabelFor(amountField);
        rateLabel.setLabelFor(rateField);
        numPeriodsLabel.setLabelFor(numPeriodsField);
        paymentLabel.setLabelFor(paymentField);

        //Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(amountLabel);
        labelPane.add(rateLabel);
        labelPane.add(numPeriodsLabel);
        labelPane.add(paymentLabel);

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(amountField);
        fieldPane.add(rateField);
        fieldPane.add(numPeriodsField);
        fieldPane.add(paymentField);

        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
    }

    /** Called when a field's "value" property changes. */
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == amountField) {
            amount = ((Number)amountField.getValue()).doubleValue();
        } else if (source == rateField) {
            rate = ((Number)rateField.getValue()).doubleValue();
        } else if (source == numPeriodsField) {
            numPeriods = ((Number)numPeriodsField.getValue()).intValue();
        }

        double payment = computePayment(amount, rate, numPeriods);
        paymentField.setValue(new Double(payment));
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("FormattedTextFieldDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TextFieldDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    //Compute the monthly payment based on the loan amount,
    //APR, and length of loan.
    double computePayment(double loanAmt, double rate, int numPeriods) {
        double I, partial1, denominator, answer;

        numPeriods *= 12;        //get number of months
        if (rate > 0.01) {
            I = rate / 100.0 / 12.0;         //get monthly rate from annual
            partial1 = Math.pow((1 + I), (0.0 - numPeriods));
            denominator = (1 - partial1) / I;
        } else { //rate ~= 0
            denominator = numPeriods;
        }

        answer = (-1 * loanAmt) / denominator;
        return answer;
    }

    //Create and set up number formats. These objects also
    //parse numbers input by user.
    private void setUpFormats() {
        amountFormat = NumberFormat.getNumberInstance();

        percentFormat = NumberFormat.getNumberInstance();
        percentFormat.setMinimumFractionDigits(3);

        paymentFormat = NumberFormat.getCurrencyInstance();
    }
}
