package com.norrang.mortgageplan;

public class Utils {

    /**
     * As java.Math is disallowed, a function to calculate the exponent of a number using a for-loop.
     *
     * @param base     The base number
     * @param exponent The exponent number
     * @return Answer
     */
    public static double powerOf(double base, int exponent) {
        var result = 1.0;

        // Checks if the exponent is negative, if true apply rules for negative exponents
        if (exponent < 0) {
            exponent = -exponent;
            base = 1/base;
        }

        // Calculating exponent using a for-loop
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }

        return result;
    }

    /**
     * As java.Math is disallowed, a function to round a double
     * @param number The number to round
     * @return
     */
    public static double round(double number) {
        if ((number + .5) >= ((int) number + 1)) {
            return ((int) number + 1);
        } else {
            return (int)number;
        }
    }

    /**
     * Function that calculates a fixed monthly mortgage payment according to the formula given in the task
     * E = U [b (1 + b)^p] / [(1 + b)^p - 1]
     *
     * @param loan           Loan amount
     * @param yearlyInterest The yearly interest in decimal
     * @param years          Loan lengths in years
     * @return Fixed monthly payment
     */
    public static double calculateMortgage(double loan, double yearlyInterest, int years) {
        // Todo: add potential exceptions, the loan and duration can of course not be negative
        var months = years * 12;
        var monthlyInterest = yearlyInterest / 12;
        var a = powerOf((1 + monthlyInterest), months); // Save the result to save
        return loan * (monthlyInterest * a) / (a - 1);
    }

}
