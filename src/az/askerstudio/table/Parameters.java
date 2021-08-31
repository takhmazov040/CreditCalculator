/*
_________________________________________
|                                       |
|   Copyright by Asker Takhmazov 2021   |
|          Salam Aleykum                |
|_______________________________________|
 */
package az.askerstudio.table;

import az.askerstudio.solver.Solver;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Parameters {
    private double loanAmount;
    private final double annualInterestRate;
    private final int loanTerm;

    private final Calendar calendar;

    private String[][] array;

    public Parameters(double loanAmount, double annualInterestRate, int loanTerm) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate / 100;
        this.loanTerm = loanTerm;
        calendar = new GregorianCalendar();
        setArray();
    }

    private void setArray() {
        array = new String[loanTerm][6];
        double annuityPayment = Solver.getAnnuityPayment(loanAmount, annualInterestRate, loanTerm);
        for (int i = 0; i < array.length; i++) {
            array[i][0] = String.valueOf(i + 1);

            if (i > 0) {
                calendar.roll(Calendar.MONTH, 1);
            }
            array[i][1] = Solver.getMonthName(calendar.get(Calendar.MONTH)) + " / " + calendar.get(Calendar.YEAR);

            double interestPayment = Solver.getInterestPayment(loanAmount, annualInterestRate);
            array[i][3] = String.format("%.2f", interestPayment);

            double principalPayment = Solver.getPrincipalPayment(annuityPayment, interestPayment);
            array[i][2] = String.format("%.2f", principalPayment);

            loanAmount -= principalPayment;
            array[i][4] = String.format("%.2f", loanAmount);

            array[i][5] = String.format("%.2f", annuityPayment);
        }
    }

    protected String[][] getArray() {
        return array;
    }
}
