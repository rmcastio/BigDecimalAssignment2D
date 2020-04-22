package edu.whccd.rcastillo;

/* This assignment is to test out BigDecimal Applications
    Author: Richard Castillo
 */

import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
	final BigDecimal SALES_TAX_PCT = new BigDecimal(".05");

	Scanner sc = new Scanner(System.in);
	String choice = "y";
	while (choice.equalsIgnoreCase("y")) {
	    System.out.print("Enter Subtotal: ");
	    String subtotalString = sc.next();

	    // creating the bigdecimal object for subtotal
        BigDecimal subtotal = new BigDecimal(subtotalString);
        BigDecimal discountPercent;
        if (subtotal.doubleValue() >= 100) {
            discountPercent = new BigDecimal(".1");
        } else {
            discountPercent = new BigDecimal("0.0");
        }

        // calc result
        BigDecimal discountAmount = subtotal.multiply(discountPercent)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalBeforeTax = subtotal.subtract(discountAmount);
        BigDecimal salesTax = SALES_TAX_PCT.multiply(totalBeforeTax)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = totalBeforeTax.add(salesTax);
    }
    }
}
