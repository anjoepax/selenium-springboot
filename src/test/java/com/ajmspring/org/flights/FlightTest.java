package com.ajmspring.org.flights;

import com.ajmspring.org.page.flights.FlightPage;
import com.ajmspring.org.test.SpringBaseTestNgTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNgTest {

    @Autowired
    private FlightAppDetails appDetails;

    @Autowired
    private FlightPage flightPage;

    @Test
    public void flightTest() {
        this.flightPage.goTo(appDetails.getUrl());
        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
        this.flightPage.closeFlightPage();
    }
}
