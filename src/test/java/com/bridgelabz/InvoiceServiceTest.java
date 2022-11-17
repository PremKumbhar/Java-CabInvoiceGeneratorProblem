package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;

        /**
         * Calculating the fair
         */
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.0, fare,0.0);
    }
    /*
   Step 2 Test Case for minimum fare should give 5
   */
    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.0, fare,0.0);
    }
    /*
   Step 3 Test Case For Mutiple rides
    */
    @Test
    public void givenMultipleRidees_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1)};
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30.0,fare,0.0);
    }
    /*
    Step 4 - Enhanced Invoice
    calculating total number of rides
    total fare
    Avrage fare per Ride
     */
    @Test
    public void givenMultipleRidesShouldReturnRideSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};

        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary expectedInvoicesummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoicesummary, summary);
    }
}
