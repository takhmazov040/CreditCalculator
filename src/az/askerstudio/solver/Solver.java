/*
_________________________________________
|                                       |
|   Copyright by Asker Takhmazov 2021   |
|          Salam Aleykum                |
|_______________________________________|
 */
package az.askerstudio.solver;

public class Solver {
    public static double getAnnuityPayment(double loanAmount, double annualInterestRate, int loanTerm) {
        return loanAmount * (annualInterestRate / 12) / (1 - Math.pow(1 + (annualInterestRate / 12), -loanTerm));
    }

    public static double getInterestPayment(double loanAmount, double annualInterestRate) {
        return loanAmount * annualInterestRate / 12;
    }

    public static double getPrincipalPayment(double annuityPayment, double interestPayment) {
        return annuityPayment - interestPayment;
    }

    public static String getMonthName(int month) {
        return switch (month) {
            case 0 -> "Январь";
            case 1 -> "Февраль";
            case 2 -> "Март";
            case 3 -> "Апрель";
            case 4 -> "Май";
            case 5 -> "Июнь";
            case 6 -> "Июль";
            case 7 -> "Август";
            case 8 -> "Сентябрь";
            case 9 -> "Октябрь";
            case 10 -> "Ноябрь";
            case 11 -> "Декабрь";
            default -> null;
        };
    }
}
